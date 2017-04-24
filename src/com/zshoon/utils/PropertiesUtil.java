package com.zshoon.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @name PropertiesUtil
 * @title 操作属性文件工具类
 * @desc
 * @author qiu.pengfei
 * @version 两定支付系统-V5.0 2008-06-16
 */
public class PropertiesUtil {

	private File file;

	private Properties objProperties; // 属性对象

	/**
	 * @name PropertiesUtil
	 * @title 构造函数
	 * @desc 加载属性资源文件
	 * @param String,boolean
	 * @return
	 * @throws Exception
	 */
	public PropertiesUtil(File file) {
		this.file = file;
		FileInputStream inStream = null;
		objProperties = new Properties();
		if (file.exists()) {
			try {
				inStream = new FileInputStream(file);
				objProperties.load(inStream);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (inStream != null) {
					try {
						inStream.close();
					} catch (java.io.IOException ie) {
						// Ignore
					}
				}
			}
		}
	}

	/**
	 * @name savefile
	 * @title 持久化属性文件
	 * @desc 使用setValue()方法后，必须调用此方法才能将属性持久化到存储文件中
	 * @param String,
	 *            String
	 * @return
	 * @throws Exception
	 */
	public void savefile(String desc) {
		FileOutputStream outStream = null;
		try {
			outStream = new FileOutputStream(file);
			if (desc != null) {
				objProperties.store(outStream, desc);// 保存属性文件
			} else {
				objProperties.store(outStream, "");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outStream.close();
			} catch (IOException ie) {
				// Ignore
			}
		}

	}

	/**
	 * @name getVlue
	 * @title 获取属性值
	 * @desc 指定Key值，获取value
	 * @param String
	 * @return String
	 */
	public String getValue(String key) {
		return objProperties.getProperty(key);
	}

	/**
	 * @name getVlue
	 * @title 获取属性值,支持缺省设置
	 * @desc 重载getValue()方法；指定Key值，获取value并支持缺省值
	 * @param String
	 * @return String
	 */
	public String getValue(String key, String defaultValue) {
		return objProperties.getProperty(key, defaultValue);
	}

	/**
	 * @name removeVlue
	 * @title 删除属性
	 * @desc 根据Key,删除属性
	 * @param String
	 * @return
	 */
	public void removeValue(String key) {
		objProperties.remove(key);
	}

	/**
	 * @name setValue
	 * @title 设置属性
	 * @desc
	 * @param String,String
	 * @return
	 */
	public void setValue(String key, String value) {
		objProperties.setProperty(key, value);
	}

	/**
	 * @name printAllVlue
	 * @title 打印所有属性值
	 * @desc
	 * @param
	 * @return
	 */
	public void printAllVlue() {
		objProperties.list(System.out);
	}
}
