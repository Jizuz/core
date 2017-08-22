package com.zshoon.utils;

import java.util.Collection;
import java.util.Map;

import org.w3c.dom.NodeList;

/**
 * <Description> <br> 
 * @author Jizuz<br>
 * @version 1.0<br>
 * @CreateDate 2017年8月23日 <br>
 * @since V1.0<br>
 * @see com.zshoon.utils <br>
 */
public final class CommonUtil {

    /**
     * CommonUtil
     */
    private CommonUtil() {
    }

    /**
     * Description: 是否为真<br> 
     * @author Jizuz<br>
     * @param b Boolean<br>
     * @return boolean<br>
     */
    public static boolean isTrue(Boolean b) {
        return b != null && b.booleanValue();
    }

    /**
     * Description: 是否为假<br> 
     * @author Jizuz<br>
     * @param b Boolean<br>
     * @return boolean<br>
     */
    public static boolean isFalse(Boolean b) {
        return b != null && !b.booleanValue();
    }

    /**
     * Description: 数组不为空<br> 
     * @author Jizuz<br>
     * @param array long[]<br>
     * @return boolean<br>
     */
    public static boolean isNotEmpty(long[] array) {
        return (array != null && array.length > 0);
    }

    /**
     * Description: 数组为空<br> 
     * @author Jizuz<br>
     * @param array long[]<br>
     * @return boolean<br>
     */
    public static boolean isEmpty(long[] array) {
        return (array == null || array.length == 0);
    }

    /**
     * Description: 数组是否不为空<br> 
     * @author Jizuz<br>
     * @param array T[]<br>
     * @return T<br>
     */
    public static <T> boolean isNotEmpty(T[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        return true;
    }

    /**
     * Description: 数组是否为空<br> 
     * @author Jizuz<br>
     * @param array T[]<br>
     * @return T<br>
     */
    public static <T> boolean isEmpty(T[] array) {
        if (array == null || array.length == 0) {
            return true;
        }
        return false;
    }

    /**
     * Description: 数组是否只有一个元素<br> 
     * @author Jizuz<br>
     * @param array T[]<br>
     * @return T<br>
     */
    public static <T> boolean isSingle(T[] array) {
        return (array != null && array.length == 1);
    }

    /**
     * Description: 判断集合是否非空<br> 
     * @author Jizuz<br>
     * @param c Collection<T>
     * @return T<br>
     */
    public static <T> boolean isNotEmpty(Collection<T> c) {
        return (c != null && !c.isEmpty());
    }

    /**
     * Description: 判断集合是否为空<br> 
     * @author Jizuz<br>
     * @param c
     * @return <br>
     */
    public static <T> boolean isEmpty(Collection<T> c) {
        return (c == null || c.isEmpty());
    }

    /**
     * Description: 判断集合是否只有一个元素<br> 
     * @author Jizuz<br>
     * @param c
     * @return <br>
     */
    public static <T> boolean isSingle(Collection<T> c) {
        return (c != null && c.size() == 1);
    }

    /**
     * Description: 判断Map是否非空 <br> 
     * @author Jizuz<br>
     * @param m
     * @return <br>
     */
    public static <K, V> boolean isNotEmpty(Map<K, V> m) {
        return (m != null && !m.isEmpty());
    }

    /**
     * Description: 判断Map是否为空<br> 
     * @author Jizuz<br>
     * @param m
     * @return <br>
     */
    public static <K, V> boolean isEmpty(Map<K, V> m) {
        return (m == null || m.isEmpty());
    }

    /**
     * Description: 判断节点列表是否非空<br> 
     * @author Jizuz<br>
     * @param nodes
     * @return <br>
     */
    public static boolean isNotEmpty(NodeList nodes) {
        return (nodes != null && nodes.getLength() > 0);
    }

    /**
     * Description: 判断节点列表是否为空<br> 
     * @author Jizuz<br>
     * @param nodes
     * @return <br>
     */
    public static boolean isEmpty(NodeList nodes) {
        return (nodes == null || nodes.getLength() == 0);
    }

    /**
     * Description: 判断节点列表是否只有一个元素<br> 
     * @author Jizuz<br>
     * @param nodes
     * @return <br>
     */
    public static boolean isSingle(NodeList nodes) {
        return (nodes != null && nodes.getLength() == 1);
    }

    /**
     * Description: 至少有一个值不存在<br> 
     * @author Jizuz<br>
     * @param first
     * @param second
     * @return <br>
     */
    public static boolean eitherNull(Object first, Object second) {
        return (first == null || second == null);
    }

    /**
     * Description: 至少有一个值存在<br> 
     * @author Jizuz<br>
     * @param first
     * @param second
     * @return <br>
     */
    public static boolean eitherNotNull(Object first, Object second) {
        return (first != null || second != null);
    }

    /**
     * Description: 两个值都存在<br> 
     * @author Jizuz<br>
     * @param first
     * @param second
     * @return <br>
     */
    public static boolean isBothNotNull(Object first, Object second) {
        return !eitherNull(first, second);
    }

    /**
     * Description: 两个值都不存在<br> 
     * @author Jizuz<br>
     * @param first
     * @param second
     * @return <br>
     */
    public static boolean isBothNull(Object first, Object second) {
        return !eitherNotNull(first, second);
    }

    /**
     * Description: 第一个值存在，第二个值不存在<br> 
     * @author Jizuz<br>
     * @param first
     * @param second
     * @return <br>
     */
    public static boolean isFirstNotNull(Object first, Object second) {
        return (first != null && second == null);
    }

    /**
     * Description: 第一个值不存在，第二个值存在<br> 
     * @author Jizuz<br>
     * @param first
     * @param second
     * @return <br>
     */
    public static boolean isSecondNotNull(Object first, Object second) {
        return (first == null && second != null);
    }

    /**
     * Description: 至少有一个值为空<br> 
     * @author Jizuz<br>
     * @param values
     * @return <br>
     */
    public static boolean hasNull(Object... values) {
        if (values == null || values.length == 0) {
            return false;
        }
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Description: 至少有一个值非空 <br> 
     * @author Jizuz<br>
     * @param values
     * @return <br>
     */
    public static boolean hasNotNull(Object... values) {
        if (values == null || values.length == 0) {
            return false;
        }
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Description: 全部为空<br> 
     * @author Jizuz<br>
     * @param values
     * @return <br>
     */
    public static boolean isAllNull(Object... values) {
        return !hasNotNull(values);
    }

    /**
     * Description: 全部非空<br> 
     * @author Jizuz<br>
     * @param values
     * @return <br>
     */
    public static boolean isAllNotNull(Object... values) {
        return !hasNull(values);
    }

    /**
     * Description: 至少有一个值为空<br> 
     * @author Jizuz<br>
     * @param first
     * @param second
     * @return <br>
     */
    public static boolean eitherEmpty(String first, String second) {
        return (StringUtil.isEmpty(first) || StringUtil.isEmpty(second));
    }

    /**
     * Description: 至少有一个值非空<br> 
     * @author Jizuz<br>
     * @param first
     * @param second
     * @return <br>
     */
    public static boolean eitherNotEmpty(String first, String second) {
        return (StringUtil.isNotEmpty(first) || StringUtil.isNotEmpty(second));
    }

    /**
     * Description: 两个值都非空<br> 
     * @author Jizuz<br>
     * @param first
     * @param second
     * @return <br>
     */
    public static boolean isBothNotEmpty(String first, String second) {
        return !eitherEmpty(first, second);
    }

    /**
     * Description: 两个值都为空<br> 
     * @author Jizuz<br>
     * @param first
     * @param second
     * @return <br>
     */
    public static boolean isBothEmpty(String first, String second) {
        return !eitherNotEmpty(first, second);
    }

    /**
     * Description: 第一个值非空，第二个值为空<br> 
     * @author Jizuz<br>
     * @param first
     * @param second
     * @return <br>
     */
    public static boolean isFirstNotEmpty(String first, String second) {
        return (StringUtil.isNotEmpty(first) && StringUtil.isEmpty(second));
    }

    /**
     * Description: 第一个值为空，第二个值非空<br> 
     * @author Jizuz<br>
     * @param first
     * @param second
     * @return <br>
     */
    public static boolean isSecondNotEmpty(String first, String second) {
        return (StringUtil.isEmpty(first) && StringUtil.isNotEmpty(second));
    }

    /**
     * Description: 至少有一个值为空<br> 
     * @author Jizuz<br>
     * @param values
     * @return <br>
     */
    public static boolean hasEmpty(String... values) {
        if (values == null || values.length == 0) {
            return false;
        }
        for (int i = 0; i < values.length; i++) {
            if (StringUtil.isEmpty(values[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Description: 至少有一个值非空<br> 
     * @author Jizuz<br>
     * @param values
     * @return <br>
     */
    public static boolean hasNotEmpty(String... values) {
        if (values == null || values.length == 0) {
            return false;
        }
        for (int i = 0; i < values.length; i++) {
            if (StringUtil.isNotEmpty(values[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Description: 全部为空<br> 
     * @author Jizuz<br>
     * @param values
     * @return <br>
     */
    public static boolean isAllEmpty(String... values) {
        return !hasNotEmpty(values);
    }

    /**
     * Description: 全部非空<br> 
     * @author Jizuz<br>
     * @param values
     * @return <br>
     */
    public static boolean isAllNotEmpty(String... values) {
        return !hasEmpty(values);
    }

    /**
     * Description: 源字符串与比较的值都不相同<br> 
     * @author Jizuz<br>
     * @param srcValue
     * @param values
     * @return <br>
     */
    public static boolean notEqualsAll(String srcValue, String... values) {
        if (values == null || values.length == 0) {
            return true;
        }
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(srcValue)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Description: 源字符串与比较的值都相同<br> 
     * @author Jizuz<br>
     * @param srcValue
     * @param values
     * @return <br>
     */
    public static boolean equalsAll(String srcValue, String... values) {
        if (values == null || values.length == 0) {
            return true;
        }
        for (int i = 0; i < values.length; i++) {
            if (!values[i].equals(srcValue)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Description: 源字符串与比较的值至少有一个相同<br> 
     * @author Jizuz<br>
     * @param srcValue
     * @param values
     * @return <br>
     */
    public static boolean eitherEquals(String srcValue, String... values) {
        if (values == null || values.length == 0) {
            return true;
        }
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(srcValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Description: 是否为正数<br> 
     * @author Jizuz<br>
     * @param number
     * @return <br>
     */
    public static boolean isPositiveNumber(Long number) {
        if (number != null && number > 0) {
            return true;
        }
        return false;
    }

    /**
     * Description: 两者皆为true<br> 
     * @author Jizuz<br>
     * @param b1
     * @param b2
     * @return <br>
     */
    public static boolean bothTrue(boolean b1, boolean b2) {
        if (b1 && b2) {
            return true;
        }
        return false;
    }

    /**
     * Description: 两者皆为false<br> 
     * @author Jizuz<br>
     * @param b1
     * @param b2
     * @return <br>
     */
    public static boolean bothFalse(boolean b1, boolean b2) {
        if (!b1 && !b2) {
            return true;
        }
        return false;
    }

    /**
     * Description: 两者同时为true或false<br> 
     * @author Jizuz<br>
     * @param b1
     * @param b2
     * @return <br>
     */
    public static boolean bothTrueOrFalse(boolean b1, boolean b2) {
        if ((b1 && b2) || (!b1 && !b2)) {
            return true;
        }
        return false;
    }
    
    /**
     * Description: 模拟Oracle的NVL函数，如果传入的值为空，则返回defaultVal，不为空则返回原值<br> 
     * @author Jizuz<br>
     * @param val
     * @param defaultVal
     * @return <br>
     */
    public static <T> T nvl(T val, T defaultVal) {
        if (val == null) {
            return defaultVal;
        }
        return val;
    }

}
