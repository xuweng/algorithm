package com.algorithm.study.algorithm.array;

/**
 * 滑动窗口最大值
 */
public class SlidingWindow {
    /**
     * 滑动窗口最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] getMax(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            result[i] = max(nums, i, i + k - 1);
        }

        return result;
    }

    /**
     * 获取最大值
     *
     * @param a
     * @param i 数组下标
     * @param j 数组下标
     * @return
     */
    private static int max(int[] a, int i, int j) {
        int max = -1;
        for (int k = i; k <= j; k++) {
            max = Math.max(max, a[k]);
        }

        return max;
    }
}
