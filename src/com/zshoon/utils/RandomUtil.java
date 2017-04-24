package com.zshoon.utils;

/**
 *
 * <p>Title: RandomUtil </p>
 * <p>Description: 随机字符串生成工具 </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: </p>
 * @author qiu.pengfei
 * @version 1.0
 */
public class RandomUtil {
  /**
   *
   */
  private RandomUtil() {

  }

  /**
   * 生成随机字符串
   *
   * @param genSource
   *            生成字符来源，如1~9，如A~Z
   * @param genLen
   *            生成随机串长度。
   * @return
   * @throws Exception
   */
  public static String getRandomString(String genSource, int genLength) throws
      Exception {
    if (genSource == null || genSource.length() <= 0 || genLength <= 0) {
      throw new Exception("getRandomString method, genSource is empty.");
    }

    int srclen = genSource.length();
    int nPos = 0;
    StringBuffer result = new StringBuffer("");
    for (int i = 0; i < genLength; i++) {
      nPos = (int) (Math.random() * srclen) % srclen;
      if (nPos < 0) {
        nPos = -nPos;
      }
      result.append(genSource.charAt(nPos));
    }

    return result.toString();
  }

  /**
   * 获取随机整数，不大于rand，0～rand
   * @param rand int
   * @return int
   */
  public static int getRandomNum(int rand) {
    if (rand <= 0) {
      rand = 1;
    }
    return (int) (Math.random() * rand) % rand;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    for (int i = 0; i < 26; i++) {
      try {
        //System.out.println(getRandomString("1234567890", 4));
        System.out.println(getRandomNum(5));
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
    System.exit(0);
  }

}
