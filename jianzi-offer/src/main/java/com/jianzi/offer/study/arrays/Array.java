package com.jianzi.offer.study.arrays;

import java.util.Objects;

/**
 * 数组
 * <p>
 * 对于排序、递增的数组,一定要考虑重复数据、相同数据
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
     * 旋转数组：两个递增子数组
     * <p>
     * 学到什么
     * <p>
     * 二分查找思想
     * 大神分析过程
     * 多种情况
     * 注意条件表达式
     * 只完成最基本的功能?
     * 算法太考验思维
     *
     * @param array
     */
    public static int rotateBinarySearch(int[] array) {
        Objects.requireNonNull(array);

        int index1 = 0;
        int index2 = array.length - 1;
        int indexMid = index1;//初始化
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            if (array[index1] == array[index2] && array[index1] == array[indexMid]) {
                return rotateInOrder(array, index1, index2);
            }
            if (array[indexMid] >= array[index1]) {
                index1 = indexMid;
            } else if (array[indexMid] <= array[index2]) {
                index2 = indexMid;
            }

        }
        return array[indexMid];
    }

    /**
     * 顺序查找最小值
     *
     * @param array
     * @param index1
     * @param index2
     * @return
     */
    private static int rotateInOrder(int[] array, int index1, int index2) {
        int result = array[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (result > array[i]) {
                result = array[i];
            }
        }
        return result;
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
