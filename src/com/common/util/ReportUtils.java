package com.common.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;

/**
 * ʹ��jasperReport������ʱ�Ĺ���֧����.��������;,����jasperPrint����,�����õ���ʱ��session
 */
public class ReportUtils {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;

	/**
	 * ������web�����¹���˹��������
	 * 
	 * @param request
	 *            request�������
	 */
	public ReportUtils(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}

	public ReportUtils(HttpServletResponse response) {
		this.response = response;
	}

	public ReportUtils(HttpServletRequest request, HttpServletResponse response) {
		this(request);
		this.response = response;
	}

	/**
	 * ���JasperPrint����;�Զ�����䱨��ʱ��parameter��dataSource. ����˵���Ͷ�̬��ͷ���÷��ο���һ����
	 * 
	 * @param filePath
	 * @param parameter
	 * @param dataSource
	 * @param sizeGroup
	 * @return
	 */
	public JasperPrint getJasperPrint(String filePath, Map parameter,
			JRDataSource dataSource) throws JRException {
		JasperReport jasperReport = null;
		try {
			jasperReport = (JasperReport) JRLoader.loadObject(filePath);
			return JasperFillManager.fillReport(jasperReport, parameter,
					dataSource);
		} catch (JRException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ͨ������List��������Դ��ȡJasperPrintʵ��
	 * 
	 * @param filePath
	 *            jasper·��
	 * @param parameter
	 * @param list
	 * @return
	 * @throws JRException
	 */
	public JasperPrint getPrintWithBeanList(String filePath, Map parameter,
			List list) throws JRException {
		JRDataSource dataSource = new JRBeanCollectionDataSource(list);
		return getJasperPrint(filePath, parameter, dataSource);
	}

	/**
	 * �������ͣ���ȡ�����
	 * 
	 * @param docType
	 * @return
	 */
	public JRAbstractExporter getJRExporter(DocType docType) {
		JRAbstractExporter exporter = null;
		switch (docType) {
		case PDF:
			exporter = new JRPdfExporter();
			break;
		case HTML:
			exporter = new JRHtmlExporter();
			break;
		case XLS:
			exporter = new JExcelApiExporter();
			break;
		case XML:
			exporter = new JRXmlExporter();
			break;
		case RTF:
			exporter = new JRRtfExporter();
			break;
		}
		return exporter;
	}

	public void setAttrToPage(JasperPrint jasperPrint, String report_fileName,
			String report_type) {
		session.setAttribute("REPORT_JASPERPRINT", jasperPrint);
		session.setAttribute("REPORT_FILENAME", report_fileName);
		session.setAttribute("REPORT_TYPE", report_type);
	}

	/**
	 * �����˱���������ͣ��̶��˿��������
	 * 
	 * @author Administrator
	 * 
	 */
	public static enum DocType {
		PDF, HTML, XLS, XML, RTF
	}

	/**
	 * ���뱨��ģ���ļ�jaxml������jasper�������ļ�
	 * 
	 * @param jaxmlPath
	 * @param jasperPath
	 * @throws JRException
	 */
	public void complieJaxml(String jaxmlPath, String jasperPath)
			throws JRException {
		JasperCompileManager.compileReportToFile(jaxmlPath, jasperPath);
	}

	/**
	 * ���PDF ʹ�ô˷���������Ԥ��ע��response
	 * 
	 * @param jasperPath
	 * @param params
	 * @param sourceList
	 * @param fileName
	 * @throws JRException
	 * @throws IOException
	 * @throws ServletException
	 */
	public void servletExportPDF(String jasperPath, Map params,
			List sourceList, String fileName) throws JRException, IOException,
			ServletException {
		servletExportDocument(DocType.PDF, jasperPath, params, sourceList,
				fileName);
	}

	/**
	 * ���html��̬ҳ�棬����ע��request��response
	 * 
	 * @param jasperPath
	 * @param params
	 * @param sourceList
	 * @param imageUrl
	 *            �����ļ�ʹ�õ�ͼƬ·�������� ../servlets/image?image=
	 * @throws JRException
	 * @throws IOException
	 * @throws ServletException
	 */
	public void servletExportHTML(String jasperPath, Map params,
			List sourceList, String imageUrl) throws JRException, IOException,
			ServletException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		JRAbstractExporter exporter = getJRExporter(DocType.HTML);

		JasperPrint jasperPrint = getPrintWithBeanList(jasperPath, params,
				sourceList);

		session.setAttribute(
				ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE,
				jasperPrint);

		PrintWriter out = response.getWriter();

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
		exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, imageUrl);
		exporter.exportReport();
	}

	/**
	 * ���Excel�����ļ�
	 * 
	 * @param jasperPath
	 * @param params
	 * @param sourceList
	 * @param fileName
	 * @throws JRException
	 * @throws IOException
	 * @throws ServletException
	 */
	public void servletExportExcel(String jasperPath, Map params,
			List sourceList, String fileName) throws JRException, IOException,
			ServletException {
		servletExportDocument(DocType.XLS, jasperPath, params, sourceList,
				fileName);
		// Ҫ���ø��õ��Ӿ�Ч��������������´���
		// // exporter.setParameter(
		// // JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
		// // Boolean.TRUE); // ɾ����¼������Ŀ���
		// //
		// exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
		// // Boolean.FALSE);// ɾ�������ColumnHeader
		// //
		// exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND
		// ,
		// // Boolean.FALSE);// ��ʾ�߿�
	}

	/**
	 * ���ɲ�ͬ��ʽ�����ĵ�
	 * 
	 * @param docType
	 *            �ĵ�����
	 * @param jasperPath
	 * @param params
	 * @param sourceList
	 * @param fileName
	 * @throws JRException
	 * @throws IOException
	 * @throws ServletException
	 */
	public void servletExportDocument(DocType docType, String jasperPath,
			Map params, List sourceList, String fileName) throws JRException,
			IOException, ServletException {

		if (docType == DocType.HTML) {
			servletExportHTML(jasperPath, params, sourceList, fileName);
			return;
		}

		JRAbstractExporter exporter = getJRExporter(docType);
		// ��ȡ��׺
		String ext = docType.toString().toLowerCase();

		if (!fileName.toLowerCase().endsWith(ext)) {
			fileName += "." + ext;
		}
		// �ж���Դ����
		String contentType = "application/";
		if (ext.equals("xls")) {
			ext = "excel";
		} else if (ext.equals("xml")) {
			contentType = "text/";
		}
		contentType += ext;

		response.setContentType(contentType);
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ URLEncoder.encode(fileName, "UTF-8") + "\"");

		exporter.setParameter(JRExporterParameter.JASPER_PRINT,
				getPrintWithBeanList(jasperPath, params, sourceList));

		OutputStream ouputStream = response.getOutputStream();

		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
		try {
			exporter.exportReport();
		} catch (JRException e) {
			throw new ServletException(e);
		} finally {
			if (ouputStream != null) {
				try {
					ouputStream.close();
				} catch (IOException ex) {
				}
			}
		}
	}
}