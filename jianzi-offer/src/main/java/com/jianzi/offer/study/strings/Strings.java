package com.jianzi.offer.study.strings;

import java.util.Objects;

/**
 * 字符串
 */
public class Strings {
    /**
     * 边界
     * 范围
     * 最小整数到最大整数
     *
     * @param string
     * @return
     */
    public static Integer[] stringToInt(String string) {
        Objects.requireNonNull(string);

        char[] chars = string.toCharArray();
        Integer[] toInt = new Integer[chars.length];

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            //非数字字符报错
            if (!isDigit(c)) {
                throw new IllegalArgumentException("非数字字符报错");
            }
            toInt[i] = Integer.parseInt(String.valueOf(c));
        }

        return toInt;
    }

    /**
     * 判断c是否是数字字符，如'1'，'2‘，是返回true。否则返回false
     *
     * @param c
     * @return
     */
    public static boolean isDigit(char c) {
        return Character.isDigit(c);
    }
}
