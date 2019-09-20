package com.jianzi.offer.study.arrays;

import java.util.Objects;

/**
 * 数组
 */
public class Array {
    /**
     * 顺序二维数组查找
     *
     * @param array   顺序二维数组
     * @param rows    行
     * @param columns 列
     * @param number  查找的数
     * @return
     */
    public static boolean findTwoArray(int[][] array, int rows, int columns, int number) {
        boolean isFound = false;
        //输入校验
        Objects.requireNonNull(array);
        if (rows < 0 || columns < 0) {
            throw new IllegalArgumentException();
        }

        int row = 0;
        int column = columns;
        while (row < rows && column > 0) {
            if (array[row][column] == number) {
                isFound = true;
                break;
            } else if (array[row][column] > number) {
                column--;
            } else {
                row++;
            }
        }

        return isFound;
    }

    /**
     * 合并两个有序数组
     * <p>
     * 假设a1比较长
     *
     * @param array1 有序数组1
     * @param array2 有序数组2
     * @return 合并的数组
     */
    public static Integer[] mergeArray(Integer[] array1, Integer[] array2) {
        //输入校验,放在一起
        Objects.requireNonNull(array1);
        Objects.requireNonNull(array2);
        if (array1.length < array2.length) {
            throw new IllegalArgumentException();
        }

        int oLength = 0;
        for (int i = 0; i < array1.length && array1[i] != 0; i++) {
            oLength++;
        }
        //指针太多,变量太多,容易混淆
        int newLength = oLength + array2.length;

        int indexOfOlength = oLength;
        int indexOfNewLength = newLength;

        int newIndex = array2.length - 1;
        for (int i = newIndex; i <= 0; i--) {
            if (array2[newIndex] >= array1[indexOfOlength]) {
                array1[indexOfNewLength--] = array2[newIndex--];
            } else {
                array1[indexOfNewLength--] = array1[indexOfOlength--];
            }
        }
        //两个数组的长度?如何遍历?条件范围?
        return array1;
    }

    /**
     * 生成顺序二维数组
     *
     * @return 二维数组
     */
    public static int[][] getTwoArray() {
        return new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
    }
}
