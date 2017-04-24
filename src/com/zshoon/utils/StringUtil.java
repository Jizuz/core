package com.zshoon.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description: 字符串帮助类
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
public class StringUtil {
	
	private StringUtil() {
		
	}
	/**
	 * 
	 * Description: 判空<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param str
	 * @return <br>
	 */
	public static boolean isEmpty(String str) {
		if (null == str || "".equals(str) || str.length() == 0)
			return true;
		else 
			return false;
	}
	
	/**
	 * 
	 * Description: 判非空<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param str
	 * @return <br>
	 */
	public static boolean isNotEmpty(String str) {
		if (null == str || "".equals(str) || str.length() == 0)
			return false;
		return true;
	}
	
	/**
	 * 
	 * Description: 将对象转换成字符串<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param val
	 * @return <br>
	 */
	public static String toString(Object val) {
		if (val == null)
			return "";
		
		return val.toString();
	}
	
	/**
	 * 
	 * Description: 将对象数组转换成String<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param objs
	 * @return <br>
	 */
	public static String toString(Object[] objs) {
		if (objs != null && objs.length > 0) {
			StringBuffer buff = new StringBuffer();
			for (int i = 0; i < objs.length; i++) {
				buff.append("\nItem[").append(i).append("]\n").append(objs[i]);
			}
			return buff.toString();
		} else {
			return "";
		}
	}
	
	/**
	 * 
	 * Description: 将int型转换成String型<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param val
	 * @return <br>
	 */
	public static String toString(int val) {
		return Integer.toString(val);
	}
	
	/**
	 * 
	 * Description: 将float值转换成String<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param val
	 * @return <br>
	 */
	public static String toString(float val) {
		return Float.toString(val);
	}
	
	/**
	 * 
	 * Description: 将double值转换成String<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param val
	 * @return <br>
	 */
	public static String toString(double val) {
		return Double.toString(val);
	}
	
//	/**
//	 * 
//	 * Description: 将double值转换成String,兼容了1111111111E10这种类型<br> 
//	 *  
//	 * @author qiu.pengfei<br>
//	 * @param val
//	 * @return <br>
//	 */
//	public static String fromDouble(double val) {
//		String str = Double.toString(val);
//		if (str.indexOf('E') >= 0) {
//			String tail = str.substring(str.indexOf('E') + 1);
//			String killtail = str.substring(0, str.indexOf('E'));
//			int point = str.indexOf('.');
//			int itail = Integer.valueOf(tail).intValue();
//			int zreonum = itail;
//			if (itail > 0) {
//				if (point >= 0) {
//					int behindpoint = killtail.length() - (point + 1);
//					killtail = killtail.replace(".", "");
//					zreonum = itail - behindpoint;
//				}
//				for (int i = 0; i < zreonum; i++) {
//					killtail = killtail + "0";
//				}
//				if (zreonum < 0) {
//					killtail = killtail.substring(0, killtail.length() + zreonum) + "."
//							+ killtail.substring(killtail.length() + zreonum);
//				}
//				str = killtail;
//			} else {
//				str = "0";
//			}
//		}
//		return str;
//	}
	
	/**
	 * 
	 * Description: 将long值转换成String<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param val
	 * @return <br>
	 */
	public static String toString(long val) {
		return Long.toString(val);
	}

	/**
	 * 
	 * Description: 将short值转换成String<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param val
	 * @return <br>
	 */
	public static String toString(short val) {
		return Short.toString(val);
	}

	/**
	 * 
	 * Description: 将boolean值转换成String<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param val
	 * @return <br>
	 */
	public static String toString(boolean val) {
		return Boolean.toString(val);
	}
	
	/**
	 * 
	 * Description: 将Long数组转换成逗号分隔的字串<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param longArray
	 * @return <br>
	 */
	public static String toCommaString(Long[] longArray) 
	{
		if (longArray == null || longArray.length <= 0)
		{
			return "";
		}
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < longArray.length; i++) 
		{
			buff.append(longArray[i]);
			if (i != longArray.length - 1)
			{
				buff.append(",");
			}
		}
		return buff.toString();
	}
	
	/**
	 * 
	 * Description: 将List列表转换成字符串,取得列表里的每个对象调用其toString()方法<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param list
	 * @param itemName
	 * @return <br>
	 */
	public static String listToString(List list, String itemName) {
		if (!ValidateUtil.validateNotEmpty(list)) {
			return "";
		} else {
			int size = list.size();
			StringBuffer buff = new StringBuffer();
			for (int i = 0; i < size; i++) {
				buff.append(list.get(i).toString()).append("\n");
			}
			return buff.toString();
		}
	}
	
	/**
	 * 
	 * Description: 将重复的数据从ArrayList去除<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param al
	 * @return <br>
	 */
	public static String[] delRepeatData(ArrayList al) {
		Set set = new HashSet(al);
		Object objs[] = set.toArray(new String[0]);
		return (String[]) objs;
	}
	
	/**
	 * 
	 * Description: 将重复的数据从String去除<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param str
	 * @return <br>
	 */
	public static String delRepeatData(String str) {
		ArrayList al = new ArrayList();
		StringBuffer dataBuf = new StringBuffer();
		if (str != null && str.length() >= 1) {
			StringTokenizer st = new StringTokenizer(str, ",");
			while (st.hasMoreTokens()) {
				al.add(st.nextToken());
			}
			String singleDateArr[] = delRepeatData(al);
			if (singleDateArr != null) {
				for (int i = 0; i < singleDateArr.length; i++) {
					dataBuf.append(singleDateArr[i]);
					if (i != singleDateArr.length - 1) {
						dataBuf.append(",");
					}
				}
			}

		}
		return dataBuf.toString();
	}
	
	/**
	 * 
	 * Description: 将重复的数据从String[]去除<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param strArr
	 * @return <br>
	 */
	public static String[] delRepeatData(String[] strArr) {
		ArrayList al = new ArrayList();

		if (strArr != null) {
			for (int i = 0; i < strArr.length; i++) {
				al.add(strArr[i]);

			}
		}
		String singleDateArr[] = delRepeatData(al);

		return singleDateArr;
	}

	/**
	 * 
	 * Description: 将重复的数据从Integer[]去除<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param intArr
	 * @return <br>
	 */
	public static Integer[] delRepeatData(Integer[] intArr) {
		ArrayList al = new ArrayList();

		if (intArr != null) {
			for (int i = 0; i < intArr.length; i++) {
				al.add(intArr[i]);
			}
		}
		Set set = new HashSet(al);
		Object objs[] = set.toArray(new Integer[0]);
		return (Integer[]) objs;
	}

	/**
	 * 
	 * Description: 将重复的数据从Long[]去除<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param intArr
	 * @return <br>
	 */
	public static Long[] delRepeatData(Long[] intArr) {
		ArrayList al = new ArrayList();

		if (intArr != null) {
			for (int i = 0; i < intArr.length; i++) {
				al.add(intArr[i]);
			}
		}
		Set set = new HashSet(al);
		Object objs[] = set.toArray(new Long[0]);
		return (Long[]) objs;
	}
	
	/**
	 * 
	 * Description: 返回某字符串中所有符合正则表达式的子字符串，以字符串数组形式返回<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param src
	 * @param pattern
	 * @return <br>
	 */
	public static String[] findAll(String src, String pattern) {
		if (src == null) {
			return new String[0];
		}
		if (pattern == null) {
			return new String[0];
		}

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(src);
		Collection l = new ArrayList();
		while (m.find()) {
			l.add(m.group());
		}

		return (String[]) l.toArray(new String[] {});
	}

	/**
	 * 
	 * Description: 替换符合正则表达式的所有子字符串为新字符串<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param src
	 * @param pattern
	 * @param to
	 * @return <br>
	 */
	public static String replaceAll(String src, String pattern, String to) {
		if (src == null) {
			return null;
		}
		if (pattern == null) {
			return src;
		}

		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(src);

		int i = 1;
		while (m.find()) {
			// System.out.println("找到第" + i + "个匹配:" + m.group() +
			// " 位置为:" + m.start() + "-" + (m.end() - 1));
			m.appendReplacement(sb, to);
			i++;
		}
		m.appendTail(sb);
		// System.out.println("替换后的结果字符串为:" + sb);
		return sb.toString();
	}

	/**
	 * 
	 * Description: 从TEXT FILE 加载资源, 对英文资源<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException <br>
	 */
	public static String loadFromFile(String filename)
			throws FileNotFoundException, IOException {
		StringBuffer sb = new StringBuffer();
		FileInputStream in = new FileInputStream(filename);
		byte[] buf = new byte[1024];

		try {
			while (true) {
				int n = in.read(buf);
				sb.append(new String(buf, 0, n));
				if (n < 1024) {
					break;
				}
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			in.close();
		}

		return sb.toString();
	}

	/**
	 * 
	 * Description: 从TEXT FILE 加载资源，根据文件的具体编码方式<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param filename
	 * @param encoding
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException <br>
	 */
	public static String loadFromFile(String filename, String encoding)
			throws FileNotFoundException, IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader b = new BufferedReader(new InputStreamReader(
				new FileInputStream(filename), encoding));

		try {
			while (true) {
				String s = b.readLine();
				if (s != null) {
					sb.append(s + "\r\n");
				} else {
					break;
				}
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			b.close();
		}

		return sb.toString();
	}

	/**
	 * 
	 * Description: 从URL 加载资源<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException <br>
	 */
	public static String loadFromUrl(String url) throws MalformedURLException,
			IOException {
		StringBuffer sb = new StringBuffer();
		URL u = new URL(url);
		InputStream in = u.openStream();
		byte[] buf = new byte[1024];

		try {
			while (true) {
				int n = in.read(buf);
				sb.append(new String(buf, 0, n));
				if (n < 1024) {
					break;
				}
			}
		} catch (IOException ex) {
			in.close();
			throw ex;
		} finally {
			in.close();
		}

		return sb.toString();
	}
	
	/**
	 * return String basename
	 * 
	 * @param name
	 *            String
	 * @param split
	 *            String
	 * @return String com.ztesoft.ispp.ne --> ne
	 */
	public static String pathname(String name, String split) {
		if (name == null || name.equals("")) {
			return "";
		}
		if (split == null || split.equals("")) {
			split = ".";
		}

		int index = name.lastIndexOf(split);
		if (index >= 0) {
			return name.substring(0, index);
		}

		return name;
	}

	/**
	 * return String basename
	 * 
	 * @param name
	 *            String
	 * @param split
	 *            String
	 * @return String com.ztesoft.ispp.ne --> ne
	 */
	public static String basename(String name, String split) {
		if (name == null || name.equals("")) {
			return "";
		}
		if (split == null || split.equals("")) {
			split = ".";
		}

		int index = name.lastIndexOf(split);
		if (index >= 0) {
			return name.substring(index + split.length());
		}

		return name;
	}

	/**
	 * 
	 * @param src String
	 * @return String
	 */
	public static String firstCharToUpperCase(String src) {
		if (src == null) {
			return null;
		}

		if (src.length() > 0) {
			src = src.substring(0, 1).toUpperCase() + src.substring(1);
		}

		return src;
	}

	/**
	 * 
	 * @param t
	 * @return
	 */
	public static String throwableToString(Throwable t) {
		StringBuffer sb = new StringBuffer();
		sb.append(t.getClass().getName());
		if (t.getMessage() != null) {
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			t.printStackTrace(new PrintStream(bo));
			sb.append(":\r\n\t" + bo.toString());
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * Description: long转换成字符串，如果位数不足str长度，把str多余的值补齐<br>
	 * 如 long2StringForLen(30,"000000")<br>
	 * 返回 000030<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param num
	 * @param str
	 * @return <br>
	 */
	public static String long2StringForLen(long num,String str){
		int len=String.valueOf(num).length();
		if(len>str.length()){
			return String.valueOf(num).substring(len-str.length(),len);
		}else{
			
			return str.substring(0,str.length()-len)+String.valueOf(num);
		}
	}
	
	/**
	 * 将为null的object toString()为空字符串
	 * @param obj
	 * @return
	 */
	public static String objToString(Object obj)
	{
		return obj == null?"":obj.toString();
	}
	
	/**
     * split操作。
     * @param line String
     * @param separator String
     * @return String[]
     */
    public static final String[] split(String line, String separator) {
        LinkedList list = new LinkedList();
        if (line != null) {
            int start = 0;
            int end = 0;
            int separatorLen = separator.length();
            while ((end = line.indexOf(separator, start)) >= 0) {
                list.add(line.substring(start, end));
                start = end + separatorLen;
            }
            if (start < line.length()) {
                list.add(line.substring(start, line.length()));
            }
        }
        return (String[]) list.toArray(new String[list.size()]);
    }
    
    /**
     * 字符串按字节截取
     * @param str 原字符

     * @param len 截取长度
     * @param elide 省略符

     * @return String
     */
     public static String splitString(String str, int len, String elide) {
		if (str == null) {
			return "";
		}
		byte[] strByte = str.getBytes();
		int strLen = strByte.length;
		int elideLen = (elide.trim().length() == 0) ? 0
				: elide.getBytes().length;
		if (len >= strLen || len < 1) {
			return str;
		}
		if (len - elideLen > 0) {
			len = len - elideLen;
		}
		int count = 0;
		for (int i = 0; i < len; i++) {
			int value = (int) strByte[i];
			if (value < 0) {
				count++;
			}
		}
		if (count % 2 != 0) {
			len = (len == 1) ? len + 1 : len - 1;

		}
		return new String(strByte, 0, len) + elide.trim();
	}
     
     /**
 	 * 去掉Null
 	 * @param str
 	 * @return
 	 */
 	public static String killNull(String str) {
 		return (str == null) ? "" : str;
 	}
}
