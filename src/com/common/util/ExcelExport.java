package com.common.util;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.common.util.assistant.ExcelAnnotation;
import com.common.util.assistant.ExcelStyle;
import com.common.util.assistant.Loginfo;

public class ExcelExport<T> {
	/**
	 * 
	 * @param title ����
	 * @param dataset ����
	 * @param out  �����
	 */
	public void exportExcel(String title, Collection<T> dataset,String path,HttpServletResponse response) {
		// ����һ��������
		try {
			OutputStream out = null;
			
			response.reset(); // ��������
			out = response.getOutputStream(); // ȡ�������
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String(title.getBytes(), "UTF-8") + CommonContexts.FILENAME_EXCEL2003); // �趨����ļ�ͷ
			response.setContentType("application/msexcel"); // �����������
			
			//���ȼ�����ݿ��Ƿ�����ȷ��
			Iterator<T> its = dataset.iterator();
			if(dataset==null||!its.hasNext()||title==null||out==null)
			{
				throw new Exception("��������ݲ��ԣ�");
			}
			
			T ts = (T) its.next();
			
			HSSFWorkbook workbook = new HSSFWorkbook();
			// ����һ�����
			HSSFSheet sheet = workbook.createSheet(title);
			// ���ñ��Ĭ���п��Ϊ15���ֽ�
			sheet.setDefaultColumnWidth(15);
			// ����һ����ʽ
			HSSFCellStyle style = workbook.createCellStyle();
			// ���ñ�����ʽ
			style = ExcelStyle.setHeadStyle(workbook, style);
			// ���ɲ�����������ʽ
			HSSFCellStyle style2 = workbook.createCellStyle();
			style2 = ExcelStyle.setbodyStyle(workbook, style2);
			// �õ������ֶ�
		
			Field filed[] = ts.getClass().getDeclaredFields();
			// ����
			List<String> exportfieldtile = new ArrayList<String>();
			// �������ֶ�
			List<String> fiedName = new ArrayList<String>();
			// ��������filed
			for (int i = 0; i < filed.length; i++) {
				Field f = filed[i];
				ExcelAnnotation exa = f.getAnnotation(ExcelAnnotation.class);
				// ���������annottion
				if (exa != null) {
					String exprot = exa.exportName();
					// ��ӵ�����
					exportfieldtile.add(exprot);
					// ��ӵ���Ҫ�������ֶ�
					fiedName.add(f.getName());
				}
			}
			// ������������
			HSSFRow row = sheet.createRow(0);
			for (int i = 0; i < exportfieldtile.size(); i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style);
				HSSFRichTextString text = new HSSFRichTextString(
						exportfieldtile.get(i));
				cell.setCellValue(text);
			}

			Iterator<T> it = dataset.iterator();
			int index = 0;
			// ѭ����������
			while (it.hasNext()) {
				index++;
				row = sheet.createRow(index);
				T t = (T) it.next();
				for (int k = 0; k < fiedName.size(); k++) {
					HSSFCell cell = row.createCell(k);
					String fieldname = fiedName.get(k);
					String getMethodName = "get"
							+ fieldname.substring(0, 1).toUpperCase()
							+ fieldname.substring(1);
					Class tCls = t.getClass();
					Method getMethod = tCls.getMethod(getMethodName,
							new Class[] {});
					Object value = getMethod.invoke(t, new Object[] {});

					String textValue = getValue(value);

					HSSFRichTextString richString = new HSSFRichTextString(
							textValue);
					cell.setCellValue(richString);
				}
			}
			
			out.flush();
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getValue(Object value) {
		String textValue = "";
		if (value == null)
			return textValue;

		if (value instanceof Boolean) {
			boolean bValue = (Boolean) value;
			textValue = "��";
			if (!bValue) {
				textValue = "��";
			}
		} else if (value instanceof Date) {
			Date date = (Date) value;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			textValue = sdf.format(date);
		} else
			textValue = value.toString();

		return textValue;
	}

	public static void main(String[] args) throws Exception {
		List list = new ArrayList();
		for (int i = 0; i < 5000; i++) {
			Loginfo log = new Loginfo();
			log.setLogInfo("����һ��");
			log.setUserip("127.0.1.1");
			log.setUsername("����");
			list.add(log);
		}
		Long l = System.currentTimeMillis();
		ExcelExport<Loginfo> ex = new ExcelExport<Loginfo>();
		//ex.exportExcel("����", list, "C:\\testOne.xls");
		Long s = System.currentTimeMillis();
		System.out.println("�ܹ���ʱ��" + (s - l));

	}
}