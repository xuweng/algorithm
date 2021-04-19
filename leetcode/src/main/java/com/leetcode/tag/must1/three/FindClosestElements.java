package com.leetcode.tag.must1.three;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 658. 找到 K 个最接近的元素
 */
public class FindClosestElements {
    /**
     * 方法 1： 使用 Collection.sort()
     * <p>
     * 可以将数组中的元素按照与目标 x 的差的绝对值排序，排好序后前 k 个元素就是我们需要的答案
     */
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            // 可以将数组中的元素按照与目标 x 的差的绝对值排序
            List<Integer> ret = Arrays.stream(arr).boxed()
                    .sorted((a, b) -> a.equals(b) ? 0 : Math.abs(a - x) - Math.abs(b - x))
                    .collect(Collectors.toList());

            // 排好序后前 k 个元素就是我们需要的答案
            ret = ret.subList(0, k);

            Collections.sort(ret);
            return ret;
        }
    }

    /**
     * 方法 2：二叉查找和双指针
     */
    public class Solution1 {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
            if (x <= ret.get(0)) {
                // 如果目标 x 小于等于有序数组的第一个元素，那么前 k 个元素就是答案。
                return ret.subList(0, k);
            }
            int n = ret.size();
            if (ret.get(n - 1) <= x) {
                // 如果目标 x 大于等于有序数组的最后一个元素，那么最后 k 个元素就是答案
                return ret.subList(n - k, n);
            }
            // 其他情况，我们可以使用二分查找来找到恰好大于 x 一点点的元素的索引 index
            int index = Collections.binarySearch(ret, x);
            if (index < 0) {
                index = -index - 1;
            }
            int low = Math.max(0, index - k - 1);
            int high = Math.min(ret.size() - 1, index + k - 1);

            while (high - low > k - 1) {
                if ((x - ret.get(low)) <= (ret.get(high) - x)) {
                    high--;
                } else if ((x - ret.get(low)) > (ret.get(high) - x)) {
                    low++;
                } else {
                    System.out.println("unhandled case: " + low + " " + high);
                }
            }
            return ret.subList(low, high + 1);
        }
    }
}
