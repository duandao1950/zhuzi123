package com.common.util.assistant;

import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtil {

	/**
	 * Excel文件导出
	 * 
	 * @param list 数据集
	 * @param sheetname 工作表名
	 * @return
	 */
	public synchronized HSSFWorkbook getWorkbook(List list,String sheetname){
		HSSFWorkbook hwb = new HSSFWorkbook();// 建立新HSSFWorkbook对象
		HSSFSheet hs = hwb.createSheet();// 建立新的sheet对象
		//hwb.setSheetName(0, sheetname, (short) 1);// 建立新sheet对象的名称
		hwb.setSheetName(0, sheetname);// 建立新sheet对象的名称

		List excellist=list;
		HSSFFont font = hwb.createFont();
		font.setColor((short) 12);
		HSSFCellStyle style = hwb.createCellStyle();
        style.setFont(font);

		HSSFRow hr = hs.createRow((short) 3);// 建立新行(设置表头)
		List headerlist=(List)excellist.get(0);
		for (int i = 0; i < headerlist.size(); i++) {
			HSSFCell cell = hr.createCell((short) i);// 建立新cell
			//cell.setEncoding(HSSFCell.ENCODING_UTF_16);// 设置cell编码解决中文高位字节截断
			cell.setCellValue((String)headerlist.get(i));// 设置cell字符类型的值
			cell.setCellStyle(style);
		}
		
		for(int i = 1; i < excellist.size(); i++){
			List valuelist=(List)excellist.get(i);
			hr = hs.createRow((short) i);// 建立新行(填充表数据)
			for (int ii = 0; ii < valuelist.size(); ii++) {
				HSSFCell cell = hr.createCell((short) ii);// 建立新cell
				//cell.setEncoding(HSSFCell.ENCODING_UTF_16);// 设置cell编码解决中文高位字节截断
				cell.setCellValue((String)valuelist.get(ii));// 设置cell字符类型的值
			}
		}
		
		return hwb;
	}
	
	/**
	 * Excel文件导出
	 * 
	 * @param lists 数据集
	 * @param names 工作表名
	 * @return
	 */
	public synchronized HSSFWorkbook getWorkbook(List[] lists, String[] names){

		HSSFWorkbook hwb = new HSSFWorkbook();// 建立新HSSFWorkbook对象
		
		//添加SHEET到WORKBOOK
		for(int j=0; j<lists.length; j++){
			HSSFSheet hs1 = hwb.createSheet();// 建立新的sheet对象
			//建立新sheet    序号 名称       
			//hwb.setSheetName(j, names[j], (short) (1));
			hwb.setSheetName(j, names[j]);

			List excellist=lists[j];
			HSSFFont font = hwb.createFont();
			font.setColor((short) 12);
			HSSFCellStyle style = hwb.createCellStyle();
	        style.setFont(font);

			HSSFRow hr = hs1.createRow((short) 0);// 建立新行(设置表头)
			List headerlist=(List)excellist.get(0);
			for (int i = 0; i < headerlist.size(); i++) {
				HSSFCell cell = hr.createCell((short) i);// 建立新cell
				//cell.setEncoding(HSSFCell.ENCODING_UTF_16);// 设置cell编码解决中文高位字节截断
				cell.setCellValue((String)headerlist.get(i));// 设置cell字符类型的值
				cell.setCellStyle(style);
			}
			
			for(int i = 1; i < excellist.size(); i++){
				List valuelist=(List)excellist.get(i);
				hr = hs1.createRow((short) i);// 建立新行(填充表数据)
				for (int ii = 0; ii < valuelist.size(); ii++) {
					HSSFCell cell = hr.createCell((short) ii);// 建立新cell
					//cell.setEncoding(HSSFCell.ENCODING_UTF_16);// 设置cell编码解决中文高位字节截断
					cell.setCellValue((String)valuelist.get(ii));// 设置cell字符类型的值
				}
			}	
		}		
		return hwb;
	}
	
	public static void main(String[] args) throws Exception {

	}
}
