package com.zshoon.utils;

import java.io.*;

/**
 * Description: 文件帮助类
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 * 
 * <p>
 * Company: MyDecoration
 * </p>
 * 
 * @author qiu.pengfei
 * @version 1.0
 */
public final class FileUtil {

	private FileUtil() {

	}

	/**
	 * 读文件
	 * 
	 * @param fileName
	 *            String
	 * @return byte[]
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static byte[] loadFile(String fileName)
			throws FileNotFoundException, IOException {
		byte[] retBytes = new byte[0];
		File file = new File(fileName);

		FileInputStream fs = new FileInputStream(fileName);
		int fileLen = (int) file.length();
		retBytes = new byte[fileLen];
		fs.read(retBytes);
		fs.close();

		return retBytes;
	}

	/**
	 * 写文件
	 * 
	 * @param fileName
	 *            String
	 * @param data
	 *            byte[]
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	public static void writeFile(String fileName, byte[] data)
			throws FileNotFoundException, IOException {
		File file = new File(fileName);
		FileOutputStream fs = new FileOutputStream(fileName);
		fs.write(data);
		fs.close();
	}

	/**
	 * 读文本文件
	 * 
	 * @param fileName
	 *            String
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String loadTxtFile(String fileName)
			throws FileNotFoundException, IOException {
		byte[] bfs = loadFile(fileName);
		String ret = new String(bfs, "UTF-8");
		return ret;
	}

	/**
	 * 写文本文件
	 * 
	 * @param fileName String
	 * @param data String
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void writeTxtFile(String fileName, String data)
			throws FileNotFoundException, IOException {
		byte[] ofs = data.getBytes("UTF-8");
		writeFile(fileName, ofs);
	}

	/**
	 * 向指定文件写入指定的内容
	 * 
	 * @param filename
	 * @param data
	 * @throws Exception
	 */
	public static void writeTxtFile(String filename, String data, boolean mode)
			throws FileNotFoundException, IOException {
		if (null == filename || 0 == filename.length()) {
			return;
		}

		if (null == data || 0 == data.length()) {
			return;
		}

		File file = new File(filename);

		DataOutputStream out = null;
		try {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}

			// 设置追加模式
			out = new DataOutputStream(new FileOutputStream(file, mode));

			out.writeBytes(data);
			out.flush();
		} finally {
			try {
				if (null != out) {
					out.close();
				}
			} catch (Exception e) {
				return;
			}
		}
	}

	public static int FILE_TYPE = 1;

	public static int FOLDER_TYPE = 2;

	public static int NULL_TYPE = -1;

	/**
	 * 
	 * 获取传入的文件类型。
	 * 
	 * @param fileName
	 */
	public static int getFileType(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {

			if (file.isDirectory()) {
				return FileUtil.FOLDER_TYPE;
			}
			return FileUtil.FILE_TYPE;
		} else {
			try {
				file = ResourceUtil.getResourceAsFile(fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				file = null;
			}
			if (file != null && file.exists()) {
				if (file.isDirectory()) {
					return FileUtil.FOLDER_TYPE;
				}
				return FileUtil.FILE_TYPE;
			}
		}
		return FileUtil.NULL_TYPE;
	}
}
