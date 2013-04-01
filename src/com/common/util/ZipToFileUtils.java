package com.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.time.DateUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

public class ZipToFileUtils {

	public static final String ZIP_FILENAME = "C:\\XJPDA.zip";// ��Ҫ��ѹ�����ļ���
	public static final String ZIP_DIR = "C:\\XJPDA\\";// ��Ҫѹ�����ļ���
	public static final String UN_ZIP_DIR = "C:\\";// Ҫ��ѹ���ļ�Ŀ¼
	public static final int BUFFER = 1024;// �����С
	public static final String zipFileType = ".zip";// �����С

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String baseDir = "C:\\Documents and Settings\\zkf23634\\����\\tttt";
		String fileName = DateUtil.formatDate(new Date(), "yyyyMMddss")
				+ ".zip";
		ZipToFileUtils.zipFile(baseDir, fileName);
		System.out.println(fileName);
	}

	public static String getZipFilePath() {
		StringBuffer sbf = new StringBuffer();
		sbf.append(CommonContexts.DOWNLOADFILEPATH).append(
				DateUtil.formatDate(new Date(), "yyyyMMddss")).append(
				zipFileType);
		return sbf.toString();
	}

	public static String getZipFileName() {
		StringBuffer sbf = new StringBuffer();
		sbf.append(DateUtil.formatDate(new Date(), "yyyyMMddss")).append(
				zipFileType);
		return sbf.toString();
	}

	/**
	 * zipѹ������. ѹ��baseDir(�ļ���Ŀ¼)�������ļ���������Ŀ¼
	 * 
	 * @throws Exception
	 */
	public static void zipBaseActionFile(String baseDir,String rootDir, String fileName)
			throws Exception {
		ZipOutputStream zos = null;
		ZipEntry ze = null;
		InputStream is = null;
		try {
			List fileList = getSubFiles(new File(baseDir));
			zos = new ZipOutputStream(new FileOutputStream(rootDir +"\\"+fileName));
			ze = null;
			byte[] buf = new byte[BUFFER];
			int readLen = 0;
			for (int i = 0; i < fileList.size(); i++) {
				File f = (File) fileList.get(i);
				ze = new ZipEntry(getAbsFileName(baseDir, f));
				ze.setSize(f.length());
				ze.setTime(f.lastModified());
				zos.putNextEntry(ze);
				is = new BufferedInputStream(new FileInputStream(f));
				while ((readLen = is.read(buf, 0, BUFFER)) != -1) {
					zos.write(buf, 0, readLen);
				}
				is.close();
			}
		} finally {
			if (is != null) {
				is.close();
			}
			if (zos != null) {
				zos.close();
			}
		}
	}

	/**
	 * zipѹ������. ѹ��baseDir(�ļ���Ŀ¼)�������ļ���������Ŀ¼
	 * 
	 * @throws Exception
	 */
	public static void zipFile(String baseDir, String fileName)
			throws Exception {
		List fileList = getSubFiles(new File(baseDir));
		ZipOutputStream zos = new ZipOutputStream(
				new FileOutputStream(fileName));
		ZipEntry ze = null;
		byte[] buf = new byte[BUFFER];
		int readLen = 0;
		for (int i = 0; i < fileList.size(); i++) {
			File f = (File) fileList.get(i);
			ze = new ZipEntry(getAbsFileName(baseDir, f));
			ze.setSize(f.length());
			ze.setTime(f.lastModified());
			zos.putNextEntry(ze);
			InputStream is = new BufferedInputStream(new FileInputStream(f));
			while ((readLen = is.read(buf, 0, BUFFER)) != -1) {
				zos.write(buf, 0, readLen);
			}
			is.close();
		}
		zos.close();
	}

	/**
	 * ������Ŀ¼��������һ���ļ��������·��������zip�ļ��е�·��.
	 * 
	 * @param baseDir
	 *            java.lang.String ��Ŀ¼
	 * @param realFileName
	 *            java.io.File ʵ�ʵ��ļ���
	 * @return ����ļ���
	 */
	private static String getAbsFileName(String baseDir, File realFileName) {
		File real = realFileName;
		File base = new File(baseDir);
		String ret = real.getName();
		while (true) {
			real = real.getParentFile();
			if (real == null)
				break;
			if (real.equals(base))
				break;
			else
				ret = real.getName() + "/" + ret;
		}
		return ret;
	}

	/**
	 * ȡ��ָ��Ŀ¼�µ������ļ��б�������Ŀ¼.
	 * 
	 * @param baseDir
	 *            File ָ����Ŀ¼
	 * @return ����java.io.File��List
	 */
	private static List getSubFiles(File baseDir) {
		List ret = new ArrayList();
		File[] tmp = baseDir.listFiles();
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i].isFile())
				ret.add(tmp[i]);
			if (tmp[i].isDirectory())
				ret.addAll(getSubFiles(tmp[i]));
		}
		return ret;
	}

	/**
	 * ��ѹ������. ��ZIP_FILENAME�ļ���ѹ��ZIP_DIRĿ¼��.
	 * 
	 * @throws Exception
	 */
	/*
	 * public static void upZipFile() throws Exception{ ZipFile zfile=new
	 * ZipFile(ZIP_FILENAME); Enumeration zList= zfile.entries(); ZipEntry
	 * ze=null; byte[] buf=new byte[1024]; while(zList.hasMoreElements()){
	 * ze=(ZipEntry)zList.nextElement(); if(ze.isDirectory()){ File f=new
	 * File(ZIP_DIR+ze.getName()); f.mkdir(); continue; } OutputStream os=new
	 * BufferedOutputStream(new FileOutputStream(getRealFileName(ZIP_DIR,
	 * ze.getName()))); InputStream is=new
	 * BufferedInputStream(zfile.getInputStream(ze)); int readLen=0; while
	 * ((readLen=is.read(buf, 0, 1024))!=-1) { os.write(buf, 0, readLen); }
	 * is.close(); os.close(); } zfile.close(); }
	 */

	/**
	 * ������Ŀ¼������һ�����·������Ӧ��ʵ���ļ���.
	 * 
	 * @param baseDir
	 *            ָ����Ŀ¼
	 * @param absFileName
	 *            ���·������������ZipEntry�е�name
	 * @return java.io.File ʵ�ʵ��ļ�
	 */
	public static File getRealFileName(String baseDir, String absFileName) {
		String[] dirs = absFileName.split("/");
		File ret = new File(baseDir);
		if (dirs.length > 1) {
			for (int i = 0; i < dirs.length - 1; i++) {
				ret = new File(ret, dirs[i]);
			}
			if (!ret.exists())
				ret.mkdirs();
			ret = new File(ret, dirs[dirs.length - 1]);
			return ret;
		}
		return ret;
	}

}