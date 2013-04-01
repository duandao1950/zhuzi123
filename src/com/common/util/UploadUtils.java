package com.common.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

public class UploadUtils {

	public static final int BUFFER = 1024;// 缓存大小
	public static final String zipFileType = ".zip";// 缓存大小

	public static String getZipFileName(String filePathName) {
		StringBuffer sbf = new StringBuffer();
		sbf.append(filePathName).append(zipFileType);
		return sbf.toString();
	}

	public static String getFilePathName() {
		return DateUtil.formatDate(new Date(), "yyyyMMddss");
	}

	/**
	 * 多附件上传
	 * 将附件打包上传
	 * @return
	 * @throws Exception
	 */
	public static String uploadFile(List<File> file, List<String> fileFileName,
			String rootDir) throws Exception {
		if (file == null || file.size() == 0 || fileFileName == null || fileFileName.size() ==0){
			return "";
		}
		
		File destRoot = new File(rootDir);
		if (!destRoot.exists()) {
			destRoot.mkdirs();
		}

		String zipFileName = "";
		if (file != null && file.size() > 0) {
			String filePathName = UploadUtils.getFilePathName();
			String filePathExt = rootDir + "\\" + filePathName;
			File filePath = new File(filePathExt);
			if (!filePath.exists()) {
				filePath.mkdirs();
			}

			for (int i = 0; i < file.size(); i++) {
				File destFile = new File(filePath, fileFileName.get(i));
				FileUtils.copyFile(file.get(i), destFile);
			}

			zipFileName = getZipFileName(filePathName);
			ZipToFileUtils.zipBaseActionFile(filePathExt, rootDir, zipFileName);

			if (filePath.exists()) {
				deleteDirectory(filePath);
			}
		}

		return zipFileName;
	}

	/**
	 * 多附件上传
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static String uploadFile1(List<File> file,
			List<String> fileFileName, String[] saveDestFile,
			HttpServletRequest request) throws Exception {
		String rootDir = request.getRealPath(CommonContexts.DOWNLOADFILEPATH);
		File destRoot = new File(rootDir);
		if (!destRoot.exists()) {
			destRoot.mkdirs();
		}

		String zipFileName = "";
		if (file != null && file.size() > 0) {
			String filePathName = UploadUtils.getFilePathName();
			String filePathExt = rootDir + "\\" + filePathName;
			File filePath = new File(filePathExt);
			if (!filePath.exists()) {
				filePath.mkdirs();
			}

			saveDestFile = new String[file.size() + 1];
			for (int i = 0; i < file.size(); i++) {
				File destFile = new File(filePath, fileFileName.get(i));
				FileUtils.copyFile(file.get(i), destFile);
				saveDestFile[i] = fileFileName.get(i);
			}

			zipFileName = getZipFileName(filePathName);
			ZipToFileUtils.zipBaseActionFile(filePathExt, rootDir, zipFileName);

			if (filePath.exists()) {
				deleteDirectory(filePath);
			}
		}

		saveDestFile[saveDestFile.length - 1] = zipFileName;

		String destFileName = (saveDestFile != null && saveDestFile.length > 0) ? StringUtils
				.join(saveDestFile, CommonContexts.ARRAYCOMMASEPARATOR)
				: "";
		return zipFileName;
	}

	public static String uploadFile2(List<File> file,
			List<String> fileFileName, String[] saveDestFile,
			HttpServletRequest request) {
		if (file != null && file.size() > 0) {
			String datastr = DateUtil.formatDate(new Date(), "yyyy@MM@dd");
			String uploadPath = request
					.getRealPath(CommonContexts.DOWNLOADFILEPATH
							+ File.separator
							+ CommonUtils.pathSplit(datastr, "@",
									File.separator));
			File path = new File(uploadPath);
			if (!path.exists()) {
				path.mkdirs();
			}
			for (int i = 0; i < file.size(); i++) {
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				String ext = fileFileName.get(i).substring(
						fileFileName.get(i).lastIndexOf("."));
				String newName = uuid + ext;
				String newPath = uploadPath + File.separator + newName;
				file.get(i).renameTo(new File(newPath));
				System.out.println(uploadPath);
				System.out.println("fileFileName:" + fileFileName.get(i));
			}
		}
		return null;
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
	 * 提供删除目录和文件
	 * 
	 * @param dir
	 * @throws IOException
	 */
	public static void deleteDirectory(File dir) throws IOException {
		if ((dir == null) || !dir.isDirectory()) {
			throw new IllegalArgumentException("Argument " + dir
					+ " is not a directory. ");
		}
		File[] entries = dir.listFiles();
		int sz = entries.length;
		for (int i = 0; i < sz; i++) {
			if (entries[i].isDirectory()) {
				deleteDirectory(entries[i]);
			} else {
				entries[i].delete();
			}
		}
		dir.delete();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
