package com.zshoon.utils;

/**
 * Description: 数字帮助类
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
public abstract class NumberUtil {
	
   private NumberUtil(){
	   
   }
    /**
     * 除数
     */
    public static long DIV = 10000;

    /**
     * 得到float数据
     * @param value long
     * @return float
     */
    public static float divLongToFloat(long value) {
        float ret = ((float) value) / DIV;
        return ret;
    }

    public static double divLongToDouble(long value) {
        double ret = ((double) value) / DIV;
        return ret;
    }

    /**
     * 换成字符串插入数据库
     * @param value long
     * @return String
     */
    public static String divLongToString(long value) {
        String ret = Double.toString(((double) value) / DIV);
        return ret;
    }

    /**
     * 小数点处理

     * @param ll long
     * @param deciLen int
     * @return String
     */
    public static String fomartLong(long ll, int deciLen) {
        //小数点后位数
        String strMoney = Long.toString(ll);
        StringBuffer retSb = new StringBuffer();
        
        //如果为负
        if (strMoney.substring(0, 1).equals("-")) {
            //第一个为负号
            retSb.append("-");
            //实际数字长度，去掉负号的
            strMoney = strMoney.substring(1);
        }
        
        //字符串长度
        int len = strMoney.length();
        //验证长度，不满或等于4位数前补
        if (len <= deciLen) {
            //补零的位
            int iRex = deciLen - len;
            retSb.append("0").append(".");
            for (int i = 0; i < iRex; i++) {
                retSb.append("0");
            }
            retSb.append(strMoney.substring(0));
        } else {
            //超过4位的，移小数点
            int offset = len - deciLen;
            retSb.append(strMoney.substring(0, offset)).append(".")
                    .append(strMoney.substring(offset));
        }
        
        //去掉小数点后几位
        String ret = retSb.toString();
        for (int i = 0; i < 4; i++) {
            if (!ret.substring(ret.length() - 1).equals("0")) {
                break;
            }
            ret = ret.substring(0, ret.length() - 1);
            if (i == 3) {
                ret = ret.substring(0, ret.length() - 1);
            }
        }
        return ret;
    }

    /**
     * 得到long数据
     * @param value long
     * @return float
     */
    public static long mulFloatToLong(float value) {
        return (long) (value * 10000);
    }
}
