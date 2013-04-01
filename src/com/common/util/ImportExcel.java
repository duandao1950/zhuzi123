package com.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import com.common.util.assistant.ExcelAnnotation;
import com.common.util.assistant.Loginfo;

public class ImportExcel<T> {
	Class<T> clazz;

	public ImportExcel(Class<T> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	public Collection<T> importExcel(File file, String... pattern) {
		Collection<T> dist = new ArrayList();
		try {
			/**
			 * �෴��õ����÷���
			 */
			// �õ�Ŀ��Ŀ��������е��ֶ��б�
			Field filed[] = clazz.getDeclaredFields();
			// �����б���Annotation���ֶΣ�Ҳ�������������ݵ��ֶ�,���뵽һ��map��
			Map fieldmap = new HashMap();
			// ѭ����ȡ�����ֶ�
			for (int i = 0; i < filed.length; i++) {
				Field f = filed[i];
				// �õ������ֶ��ϵ�Annotation
				ExcelAnnotation exa = f.getAnnotation(ExcelAnnotation.class);
				// �����ʶ��Annotationd�Ļ�
				if (exa != null) {
					// ����������Annotation���ֶε�Setter����
					String fieldname = f.getName();
					String setMethodName = "set"
							+ fieldname.substring(0, 1).toUpperCase()
							+ fieldname.substring(1);
					// ������õ�method��
					Method setMethod = clazz.getMethod(setMethodName,
							new Class[] { f.getType() });
					// �����method��Annotaion������Ϊkey�����롣
					fieldmap.put(exa.exportName(), setMethod);
				}
			}
			/**
			 * excel�Ľ�����ʼ
			 */
			// �������File����ΪFileInputStream;
			FileInputStream in = new FileInputStream(file);
			// // �õ�������
			HSSFWorkbook book = new HSSFWorkbook(in);
			// // �õ���һҳ
			HSSFSheet sheet = book.getSheetAt(0);
			// // �õ���һ���������
			Iterator<Row> row = sheet.rowIterator();

			/**
			 * �������
			 */
			// �õ���һ�У�Ҳ���Ǳ�����
			Row title = row.next();
			// �õ���һ�е�������
			Iterator<Cell> cellTitle = title.cellIterator();
			// ��������������ݷ��뵽һ��map�С�
			Map titlemap = new HashMap();
			// �ӱ����һ�п�ʼ
			int i = 0;
			// ѭ���������е���
			while (cellTitle.hasNext()) {
				Cell cell = cellTitle.next();
				String value = cell.getStringCellValue();
				titlemap.put(i, value);
				i = i + 1;
			}
			/**
			 * ����������
			 */
			// ������ʽ�����ڵ�DateFormat
			SimpleDateFormat sf;
			if (pattern.length < 1) {
				sf = new SimpleDateFormat("yyyy-MM-dd");
			} else
				sf = new SimpleDateFormat(pattern[0]);
			while (row.hasNext()) {
				// �����µĵ�һ��
				Row rown = row.next();

				// �е�������
				Iterator<Cell> cellbody = rown.cellIterator();
				// �õ��������ʵ��
				T tObject = clazz.newInstance();
				int k = 0;
				// ����һ�е���
				while (cellbody.hasNext()) {
					Cell cell = cellbody.next();
					// ����õ����еĶ�Ӧ�ı���
					String titleString = (String) titlemap.get(k);
					// �����һ�еı�������е�ĳһ�е�Annotation��ͬ����ô����ô���ĵ�set������������ֵ
					if (fieldmap.containsKey(titleString)) {
						Method setMethod = (Method) fieldmap.get(titleString);
						// �õ�setter�����Ĳ���
						Type[] ts = setMethod.getGenericParameterTypes();
						// ֻҪһ������
						String xclass = ts[0].toString();
						// �жϲ�������

						if (xclass.equals("class java.lang.String")) {
							setMethod
									.invoke(tObject, cell.getStringCellValue());
						} else if (xclass.equals("class java.util.Date")) {
							setMethod.invoke(tObject, sf.parse(cell
									.getStringCellValue()));
						} else if (xclass.equals("class java.lang.Boolean")) {
							Boolean boolname = true;
							if (cell.getStringCellValue().equals("��")) {
								boolname = false;
							}
							setMethod.invoke(tObject, boolname);
						} else if (xclass.equals("class java.lang.Integer")) {
							setMethod.invoke(tObject, new Integer(cell
									.getStringCellValue()));
						}

						else if (xclass.equals("class java.lang.Long")) {
							setMethod.invoke(tObject, new Long(cell
									.getStringCellValue()));
						}
					}
					// ��һ��
					k = k + 1;
				}
				dist.add(tObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return dist;
	}

	public static void main(String[] args) {
		ImportExcel<Loginfo> test = new ImportExcel(Loginfo.class);
		File file = new File("C:\\testOne.xls");
		Long befor = System.currentTimeMillis();
		List<Loginfo> result = (ArrayList) test.importExcel(file);

		Long after = System.currentTimeMillis();
		System.out.println("�˴β�������ʱ��" + (after - befor) + "����");
		for (int i = 0; i < result.size(); i++) {
			Loginfo testpojo = result.get(i);
			System.out.println("�������ϢΪ��" + testpojo.getUsername());
		}

		System.out.println("��ת��ΪList������Ϊ��" + result.size());
	}
}
