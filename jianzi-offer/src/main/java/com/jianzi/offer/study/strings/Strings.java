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
     * 替换字符串数组空格
     *
     * @param array  数组
     * @param length 数组的总容量,不是大小
     */
    public static void replaceBlank(char[] array, int length) {
        //输入校验永远是第一步
        //控制好条件范围,不要越界
        Objects.requireNonNull(array);
        if (length <= 0) {
            throw new IllegalArgumentException();
        }

        int originallength = 0;
        int numberofBlank = 0;

        for (int i = 0; i < array.length && !"#".equals(String.valueOf(array[i])); i++) {
            originallength++;
            if (" ".equals(String.valueOf(array[i]))) {
                numberofBlank++;
            }
        }
        int newLength = originallength + numberofBlank * 2;
        //两个索引,两个指针
        int indexOfOriginal = originallength;
        int indexOfNew = newLength;
        //控制好条件范围,不要越界
        while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
            if (" ".equals(String.valueOf(array[indexOfOriginal]))) {
                array[indexOfNew--] = '0';
                array[indexOfNew--] = '2';
                array[indexOfNew--] = '%';
            } else {
                array[indexOfNew--] = array[indexOfOriginal];
            }
            indexOfOriginal--;
        }

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
