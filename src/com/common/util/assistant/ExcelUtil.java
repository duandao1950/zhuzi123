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
	 * Excel�ļ�����
	 * 
	 * @param list ���ݼ�
	 * @param sheetname ��������
	 * @return
	 */
	public synchronized HSSFWorkbook getWorkbook(List list,String sheetname){
		HSSFWorkbook hwb = new HSSFWorkbook();// ������HSSFWorkbook����
		HSSFSheet hs = hwb.createSheet();// �����µ�sheet����
		//hwb.setSheetName(0, sheetname, (short) 1);// ������sheet���������
		hwb.setSheetName(0, sheetname);// ������sheet���������

		List excellist=list;
		HSSFFont font = hwb.createFont();
		font.setColor((short) 12);
		HSSFCellStyle style = hwb.createCellStyle();
        style.setFont(font);

		HSSFRow hr = hs.createRow((short) 3);// ��������(���ñ�ͷ)
		List headerlist=(List)excellist.get(0);
		for (int i = 0; i < headerlist.size(); i++) {
			HSSFCell cell = hr.createCell((short) i);// ������cell
			//cell.setEncoding(HSSFCell.ENCODING_UTF_16);// ����cell���������ĸ�λ�ֽڽض�
			cell.setCellValue((String)headerlist.get(i));// ����cell�ַ����͵�ֵ
			cell.setCellStyle(style);
		}
		
		for(int i = 1; i < excellist.size(); i++){
			List valuelist=(List)excellist.get(i);
			hr = hs.createRow((short) i);// ��������(��������)
			for (int ii = 0; ii < valuelist.size(); ii++) {
				HSSFCell cell = hr.createCell((short) ii);// ������cell
				//cell.setEncoding(HSSFCell.ENCODING_UTF_16);// ����cell���������ĸ�λ�ֽڽض�
				cell.setCellValue((String)valuelist.get(ii));// ����cell�ַ����͵�ֵ
			}
		}
		
		return hwb;
	}
	
	/**
	 * Excel�ļ�����
	 * 
	 * @param lists ���ݼ�
	 * @param names ��������
	 * @return
	 */
	public synchronized HSSFWorkbook getWorkbook(List[] lists, String[] names){

		HSSFWorkbook hwb = new HSSFWorkbook();// ������HSSFWorkbook����
		
		//���SHEET��WORKBOOK
		for(int j=0; j<lists.length; j++){
			HSSFSheet hs1 = hwb.createSheet();// �����µ�sheet����
			//������sheet    ��� ����       
			//hwb.setSheetName(j, names[j], (short) (1));
			hwb.setSheetName(j, names[j]);

			List excellist=lists[j];
			HSSFFont font = hwb.createFont();
			font.setColor((short) 12);
			HSSFCellStyle style = hwb.createCellStyle();
	        style.setFont(font);

			HSSFRow hr = hs1.createRow((short) 0);// ��������(���ñ�ͷ)
			List headerlist=(List)excellist.get(0);
			for (int i = 0; i < headerlist.size(); i++) {
				HSSFCell cell = hr.createCell((short) i);// ������cell
				//cell.setEncoding(HSSFCell.ENCODING_UTF_16);// ����cell���������ĸ�λ�ֽڽض�
				cell.setCellValue((String)headerlist.get(i));// ����cell�ַ����͵�ֵ
				cell.setCellStyle(style);
			}
			
			for(int i = 1; i < excellist.size(); i++){
				List valuelist=(List)excellist.get(i);
				hr = hs1.createRow((short) i);// ��������(��������)
				for (int ii = 0; ii < valuelist.size(); ii++) {
					HSSFCell cell = hr.createCell((short) ii);// ������cell
					//cell.setEncoding(HSSFCell.ENCODING_UTF_16);// ����cell���������ĸ�λ�ֽڽض�
					cell.setCellValue((String)valuelist.get(ii));// ����cell�ַ����͵�ֵ
				}
			}	
		}		
		return hwb;
	}
	
	public static void main(String[] args) throws Exception {

	}
}
