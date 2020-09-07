package com.leetcode.tag.daily.two;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 347. 前 K 个高频元素
 */
public class TopKFrequent {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            Map<Integer, Integer> map = new HashMap<>(64);
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            //最简单的做法是给「出现次数数组」排序
            List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());

            int[] result = new int[k];
            int index = 0;
            int count = 0;
            for (int i = collect.size() - 1; count < k; i--, count++) {
                result[index++] = collect.get(i).getKey();
            }

            return result;
        }
    }

    /**
     * 方法一：堆
     * <p>
     * 最简单的做法是给「出现次数数组」排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> occurrences = new HashMap<>();
            for (int num : nums) {
                occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
            }

            // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(m -> m[1]));

            for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
                int num = entry.getKey(), count = entry.getValue();
                if (queue.size() == k) {
                    if (queue.peek()[1] < count) {
                        queue.poll();
                        queue.offer(new int[]{num, count});
                    }
                } else {
                    queue.offer(new int[]{num, count});
                }
            }
            int[] ret = new int[k];
            for (int i = 0; i < k; ++i) {
                ret[i] = Objects.requireNonNull(queue.poll())[0];
            }
            return ret;
        }
    }

}
