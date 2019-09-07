package com.algorithm.study.common;

import java.util.*;

public class ArrayUtils {
    /**
     * 随机指定范围内N个不重复的数
     *
     * @param min  指定范围最小值
     * @param max  指定范围最大值
     * @param size 随机数个数
     * @return
     */
    public static Integer[] randomArrayWithoutRepetition(int min, int max, int size) {
        return randomArray(min, max, size, new HashSet<Integer>());
    }

    /**
     * 随机指定范围内N个可能重复的数
     *
     * @param min  指定范围最小值
     * @param max  指定范围最大值
     * @param size 随机数个数
     * @return
     */
    public static Integer[] randomArrayHasRepetition(int min, int max, int size) {
        return randomArray(min, max, size, new ArrayList<Integer>());
    }

    /**
     * 随机指定范围内N个数
     *
     * @param min  指定范围最小值
     * @param max  指定范围最大值
     * @param size 随机数个数
     * @param list 集合
     * @return
     */
    public static Integer[] randomArray(int min, int max, int size, Collection<Integer> list) {
        Objects.requireNonNull(list);

        if (size > (max - min + 1) || max < min) {
            return null;
        }
        for (int i = 0; i < size; i++) {
            int num = (int) (Math.random() * (max - min)) + min;
            list.add(num);
        }
        while (list.size() < size) {
            int num = (int) (Math.random() * (max - min)) + min;
            list.add(num);
        }

        return list.toArray(new Integer[0]);

    }

}
