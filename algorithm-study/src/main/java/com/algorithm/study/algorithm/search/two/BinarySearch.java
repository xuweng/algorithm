package com.algorithm.study.algorithm.search.two;

/**
 * 二分查找变形
 * <p>
 * 很多人都觉得变形的二分查找很难写，主要原因是太追求第一种那样完美、简洁的写法。
 * 而对于我们做工程开发的人来说，代码易读懂、没 Bug，其实更重要
 */
public class BinarySearch {
    /**
     * 变体一：查找第一个值等于给定值的元素
     * <p>
     * 当 a[mid] 等于要查找的值时，a[mid] 就是我们要找的元素。
     * 但是，如果我们求解的是第一个值等于给定值的元素，当 a[mid] 等于要查找的值时，
     * 我们就需要确认一下这个 a[mid] 是不是第一个值等于给定值的元素。
     * <p>
     * 如果 mid 等于 0，那这个元素已经是数组的第一个元素，那它肯定是我们要找的；
     * 如果 mid 不等于 0，但 a[mid] 的前一个元素 a[mid-1] 不等于 value，
     * 那也说明 a[mid] 就是我们要找的第一个值等于给定值的元素。
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                //注意下标越界
                if ((mid == 0) || (a[mid - 1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
