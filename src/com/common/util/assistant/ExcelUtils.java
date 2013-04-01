package com.common.util.assistant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * ��װ��excel�Ĳ������������ض�дexcel���������excel<br/> ����jar poi-3.5-beta5-20090219.jar<br/>
 * �вι��캯������Ϊexcel��ȫ·��<br/>
 * 
 * @author ɳ����
 * 
 */
public class ExcelUtils {

	// excel�ļ�·��
	private String path = "";

	/**
	 * �޲ι��캯�� Ĭ��
	 */
	public ExcelUtils() {

	}

	/**
	 * �вι��캯��
	 * 
	 * @param path
	 *            excel·��
	 */
	public ExcelUtils(String path,String fileName) {
		this.path = path + fileName + ".xls";
	}

	/**
	 * �ڴ�������һ���������ݵ�excel,·��Ϊpath����
	 * 
	 * @param sheetName
	 *            ������sheet����
	 * @param fieldName
	 *            ��������
	 * @param data
	 *            ������
	 * @throws IOException
	 */
	public void makeExcel(String sheetName, String[] fieldName,
			List<String[]> data) throws IOException {
		// ���ڴ������ɹ�����
		HSSFWorkbook workbook = makeWorkBook(sheetName, fieldName, data);
		// ��ȡ�ļ���·��
		String filePath = path.substring(0, path.lastIndexOf("\\"));
		// ���·�������ڣ�����·��
		File file = new File(filePath);
		// System.out.println(path+"-----------"+file.exists());
		if (!file.exists())
			file.mkdirs();
		FileOutputStream fileOut = new FileOutputStream(path);
		workbook.write(fileOut);
		fileOut.close();
	}

	/**
	 * ��������е���excel
	 * 
	 * @param excelName
	 *            ������excel���� ������չ��
	 * @param sheetName
	 *            ������sheet����
	 * @param fieldName
	 *            ��������
	 * @param data
	 *            ������
	 * @param response
	 *            response
	 */
	public void makeStreamExcel(String excelName, String sheetName,
			String[] fieldName, List<String[]> data,
			HttpServletResponse response) {
		OutputStream os = null;
		try {
			response.reset(); // ��������
			os = response.getOutputStream(); // ȡ�������
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String(excelName.getBytes(), "ISO-8859-1")); // �趨����ļ�ͷ
			response.setContentType("application/msexcel"); // �����������
		} catch (IOException ex) {// ��׽�쳣
			System.out.println("����������:" + ex.getMessage());
		}
		// ���ڴ������ɹ�����
		HSSFWorkbook workbook = makeWorkBook(sheetName, fieldName, data);
		try {
			os.flush();
			workbook.write(os);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Output is closed");
		}
	}

	/**
	 * �������������ɹ����������ڴ�
	 * 
	 * @param sheetName
	 *            �������������
	 * @param fieldName
	 *            ����������
	 * @param data
	 *            ����
	 * @return HSSFWorkbook
	 */
	private HSSFWorkbook makeWorkBook(String sheetName, String[] fieldName,
			List<String[]> data) {
		// ��������������
		HSSFWorkbook workbook = new HSSFWorkbook();
		// �������������
		HSSFSheet sheet = workbook.createSheet();
		// Ϊ�˹�������֧������,�����ַ���ΪUTF_16
		workbook.setSheetName(0, sheetName);
		// ����һ��
		HSSFRow row = sheet.createRow(0);
		// ������Ԫ��
		HSSFCell cell;
		// д������ֶε�����
		for (int i = 0; i < fieldName.length; i++) {
			// ������һ�и����ֶ����Ƶĵ�Ԫ��
			cell = row.createCell((short) i);
			// ���õ�Ԫ������Ϊ�ַ�����
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			// Ϊ�����ڵ�Ԫ������������,�����ַ���ΪUTF_16
			// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			// ����Ԫ�����ݸ�ֵ
			cell.setCellValue(new HSSFRichTextString(fieldName[i]));
		}
		// д�������¼,ÿ����¼��Ӧexcel���е�һ��
		for (int i = 0; i < data.size(); i++) {
			String[] tmp = data.get(i);
			// ����һ��
			row = sheet.createRow(i + 1);
			for (int j = 0; j < tmp.length; j++) {
				cell = row.createCell((short) j);
				// ���õ�Ԫ���ַ�����ΪString
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(new HSSFRichTextString((tmp[j] == null) ? ""
						: tmp[j]));
			}
		}
		return workbook;
	}

	public void write(int sheetOrder, int colum, int row, String content)
			throws Exception {
		Workbook workbook = new HSSFWorkbook(new POIFSFileSystem(
				new FileInputStream(path)));
		Sheet sheet = workbook.getSheetAt(sheetOrder);
		Row rows = sheet.createRow(row);
		Cell cell = rows.createCell(colum);
		cell.setCellValue(content);
		FileOutputStream fileOut = new FileOutputStream(path);
		workbook.write(fileOut);
		fileOut.close();

	}

	/**
	 * �õ�һ�����������һ����¼�����
	 * 
	 * @param sheetOrder
	 *            ���������
	 * @return int
	 * @throws IOException
	 */
	public int getSheetLastRowNum(int sheetOrder) throws IOException {
		Workbook workbook = new HSSFWorkbook(new POIFSFileSystem(
				new FileInputStream(path)));
		Sheet sheet = workbook.getSheetAt(sheetOrder);
		return sheet.getLastRowNum();
	}

	public String read(int sheetOrder, int colum, int row) throws Exception {
		Workbook workbook = new HSSFWorkbook(new POIFSFileSystem(
				new FileInputStream(path)));
		Sheet sheet = workbook.getSheetAt(sheetOrder);
		Row rows = sheet.getRow(row);
		Cell cell = rows.getCell(colum);
		String content = cell.getStringCellValue();
		return content;
	}

	/**
	 * ����path���ԣ��ڴ�������һ���µ�excel
	 * 
	 * @throws IOException
	 */
	public void makeEmptyExcel() throws IOException {
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("new sheet");
		// ��ȡ�ļ���·��
		String filePath = path.substring(0, path.lastIndexOf("\\"));
		// ���·�������ڣ�����·��
		File file = new File(filePath);
		if (!file.exists())
			file.mkdirs();
		FileOutputStream fileOut = new FileOutputStream(filePath + "\\"
				+ path.substring(path.lastIndexOf("\\") + 1));
		wb.write(fileOut);
		fileOut.close();
	}

	/**
	 * ���ݹ�������ţ���ȡ�ù���ȥ�µ����м�¼��ÿһ����¼��һ��String[]<br/> ע�������Ԫ���е�����Ϊ���ֽ��ᱻ�Զ�ת��Ϊ�ַ���<br/>
	 * �����Ԫ���д��ڳ����֣��ַ�������������������ݣ������������
	 * 
	 * @param sheetOrder
	 *            ���������
	 * @return
	 * @throws IOException
	 * @throws
	 */
	public List<String[]> getDataFromSheet(int sheetOrder) throws IOException {
		Workbook workbook = new HSSFWorkbook(new POIFSFileSystem(
				new FileInputStream(path)));
		Sheet sheet = workbook.getSheetAt(sheetOrder);
		List<String[]> strs = new ArrayList<String[]>();
		// ע��õ��������ǻ���0������ �������е���
		// System.out.println(sheet.getLastRowNum());
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			Row rows = sheet.getRow(i);
			String[] str = new String[rows.getLastCellNum()];
			// ����ÿһ��
			for (int k = 0; k < rows.getLastCellNum(); k++) {
				Cell cell = rows.getCell(k);
				// ��������ʱ
				if (0 == cell.getCellType()) {
					// ���ڸ�ʽ�����֣�ֻ�������ֵ���������
					DecimalFormat df = new DecimalFormat("########");
					str[k] = df.format(cell.getNumericCellValue());
				} else
					str[k] = cell.getStringCellValue();
				// System.out.println(cell.getCellType()+"-------------"+str[k]);
			}
			strs.add(str);
		}
		return strs;
	}

	public static void main(String[] args) throws Exception {
		ExcelUtils eu = new ExcelUtils("C:\\","CMG���ݱ��Сͳ��");
		List<String[]> ss = new ArrayList<String[]>();
		ss.add(new String[] { "�����ط�", "sdfds" });
		ss.add(new String[] { "�߶�", "���ط�" });
		eu.makeExcel("smsLog", new String[] { "ɫ��", "���Ƿ�" }, ss);
		List<String[]> strs = eu.getDataFromSheet(0);
		for (String[] str : strs) {
			for (String s : str) {
				System.out.println(s);
			}
		}
//		String content = "Hello Worlds";
//		eu.write(1,2, 3, content);
//		String newContent = eu.read(0, 1, 1);
//		System.out.println(newContent);
//		eu.makeEmptyExcel();
	}
}