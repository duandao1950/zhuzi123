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
	 * @param title 标题
	 * @param dataset 集合
	 * @param out  输出流
	 */
	public void exportExcel(String title, Collection<T> dataset,String path,HttpServletResponse response) {
		// 声明一个工作薄
		try {
			OutputStream out = null;
			
			response.reset(); // 清空输出流
			out = response.getOutputStream(); // 取得输出流
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String(title.getBytes(), "UTF-8") + CommonContexts.FILENAME_EXCEL2003); // 设定输出文件头
			response.setContentType("application/msexcel"); // 定义输出类型
			
			//首先检查数据看是否是正确的
			Iterator<T> its = dataset.iterator();
			if(dataset==null||!its.hasNext()||title==null||out==null)
			{
				throw new Exception("传入的数据不对！");
			}
			
			T ts = (T) its.next();
			
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 生成一个表格
			HSSFSheet sheet = workbook.createSheet(title);
			// 设置表格默认列宽度为15个字节
			sheet.setDefaultColumnWidth(15);
			// 生成一个样式
			HSSFCellStyle style = workbook.createCellStyle();
			// 设置标题样式
			style = ExcelStyle.setHeadStyle(workbook, style);
			// 生成并设置主体样式
			HSSFCellStyle style2 = workbook.createCellStyle();
			style2 = ExcelStyle.setbodyStyle(workbook, style2);
			// 得到所有字段
		
			Field filed[] = ts.getClass().getDeclaredFields();
			// 标题
			List<String> exportfieldtile = new ArrayList<String>();
			// 导出的字段
			List<String> fiedName = new ArrayList<String>();
			// 遍历整个filed
			for (int i = 0; i < filed.length; i++) {
				Field f = filed[i];
				ExcelAnnotation exa = f.getAnnotation(ExcelAnnotation.class);
				// 如果设置了annottion
				if (exa != null) {
					String exprot = exa.exportName();
					// 添加到标题
					exportfieldtile.add(exprot);
					// 添加到需要导出的字段
					fiedName.add(f.getName());
				}
			}
			// 产生表格标题行
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
			// 循环整个集合
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
			textValue = "是";
			if (!bValue) {
				textValue = "否";
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
			log.setLogInfo("测试一下");
			log.setUserip("127.0.1.1");
			log.setUsername("测试");
			list.add(log);
		}
		Long l = System.currentTimeMillis();
		ExcelExport<Loginfo> ex = new ExcelExport<Loginfo>();
		//ex.exportExcel("测试", list, "C:\\testOne.xls");
		Long s = System.currentTimeMillis();
		System.out.println("总共耗时：" + (s - l));

	}
}