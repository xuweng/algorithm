package com.algorithm.study.sort;

import com.algorithm.study.common.ArrayUtils;

public class Sort {
    /**
     * 选择排序
     * 复杂度：O(lgn2)
     *
     * @param array 待排序数组
     */
    public static void selectSort(Integer[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            int minIndex = ArrayUtils.findMinValueIndex(array, i, array.length);

            ArrayUtils.swapValue(array, i, minIndex);
        }
    }

}
