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

	public static final String ZIP_FILENAME = "C:\\XJPDA.zip";// 需要解压缩的文件名
	public static final String ZIP_DIR = "C:\\XJPDA\\";// 需要压缩的文件夹
	public static final String UN_ZIP_DIR = "C:\\";// 要解压的文件目录
	public static final int BUFFER = 1024;// 缓存大小
	public static final String zipFileType = ".zip";// 缓存大小

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String baseDir = "C:\\Documents and Settings\\zkf23634\\桌面\\tttt";
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
	 * zip压缩功能. 压缩baseDir(文件夹目录)下所有文件，包括子目录
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
	 * zip压缩功能. 压缩baseDir(文件夹目录)下所有文件，包括子目录
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
	 * 给定根目录，返回另一个文件名的相对路径，用于zip文件中的路径.
	 * 
	 * @param baseDir
	 *            java.lang.String 根目录
	 * @param realFileName
	 *            java.io.File 实际的文件名
	 * @return 相对文件名
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
	 * 取得指定目录下的所有文件列表，包括子目录.
	 * 
	 * @param baseDir
	 *            File 指定的目录
	 * @return 包含java.io.File的List
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
	 * 解压缩功能. 将ZIP_FILENAME文件解压到ZIP_DIR目录下.
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
	 * 给定根目录，返回一个相对路径所对应的实际文件名.
	 * 
	 * @param baseDir
	 *            指定根目录
	 * @param absFileName
	 *            相对路径名，来自于ZipEntry中的name
	 * @return java.io.File 实际的文件
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