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
     * 可以将数组中的元素按照与目标 x 的差的绝对值排序，排好序后前 k 个元素就是我们需要的答案
     */
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> ret = Arrays.stream(arr).boxed()
                    .sorted((a, b) -> a.equals(b) ? 0 : Math.abs(a - x) - Math.abs(b - x))
                    .collect(Collectors.toList());

            ret = ret.subList(0, k);
            Collections.sort(ret);
            return ret;
        }
    }
}
