package com.algorithm.study.common;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayUtils {
    /**
     * 打乱一个顺序的数组
     *
     * @param array 顺序的数组
     */
    public static void shuffle(Integer[] array) {
        Objects.requireNonNull(array);

        //这种方法已经排好序
//        Collections.shuffle(Arrays.stream(array).collect(Collectors.toList()));
        Collections.shuffle(Arrays.asList(array));
    }

    /**
     * 顺序生成不重复的数组
     *
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @return
     */
    public static Integer[] generateSortArray(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException();
        }
        Integer[] array = new Integer[max - min + 1];
        int index = 0;
        while (min <= max) {
            array[index] = min;
            min++;
            index++;
        }

        return array;
    }

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

    public static void println(Integer[] array) {
        Objects.requireNonNull(array);

        Arrays.stream(array).forEach(System.out::println);
    }

    public static void print(Integer[] array) {
        Objects.requireNonNull(array);

        Arrays.stream(array).forEach(System.out::print);
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
    private static Integer[] randomArray(int min, int max, int size, Collection<Integer> list) {
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
