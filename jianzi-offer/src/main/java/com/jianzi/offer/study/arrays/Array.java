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
