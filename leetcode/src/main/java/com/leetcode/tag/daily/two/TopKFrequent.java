package com.leetcode.tag.daily.two;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 347. 前 K 个高频元素
 */
public class TopKFrequent {
    /**
     * 复杂度会达到 O(NlogN)
     */
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
     * 利用堆的思想：建立一个小顶堆，然后遍历「出现次数数组」：
     * <p>
     * 如果堆的元素个数小于 k，就可以直接插入堆中。
     * <p>
     * 如果堆的元素个数等于 k，则检查堆顶与当前出现次数的大小。如果堆顶更大，说明至少有 k 个数字的出现次数比当前值大，
     * <p>
     * 故舍弃当前值；否则，就弹出堆顶，并将当前值插入堆中。
     * <p>
     * 遍历完成后，堆中的元素就代表了「出现次数数组」中前 k 大的值。
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

            //遍历一次
            for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
                int num = entry.getKey(), count = entry.getValue();
                if (queue.size() == k) {
                    if (Objects.requireNonNull(queue.peek())[1] < count) {
                        queue.poll();
                        queue.offer(new int[]{num, count});
                    }
                } else {
                    queue.offer(new int[]{num, count});
                }
            }
            //堆中的元素就代表了「出现次数数组」中前 k 大的值
            int[] ret = new int[k];
            for (int i = 0; i < k; ++i) {
                ret[i] = Objects.requireNonNull(queue.poll())[0];
            }
            return ret;
        }
    }

    /**
     * 方法二：基于快速排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> occurrences = new HashMap<>();
            for (int num : nums) {
                occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
            }

            List<int[]> values = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
                int num = entry.getKey(), count = entry.getValue();
                values.add(new int[]{num, count});
            }
            int[] ret = new int[k];
            qsort(values, 0, values.size() - 1, ret, 0, k);
            return ret;
        }

        public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
            int picked = (int) (Math.random() * (end - start + 1)) + start;
            Collections.swap(values, picked, start);

            int pivot = values.get(start)[1];
            int index = start;
            for (int i = start + 1; i <= end; i++) {
                if (values.get(i)[1] >= pivot) {
                    Collections.swap(values, index + 1, i);
                    index++;
                }
            }
            Collections.swap(values, start, index);

            if (k <= index - start) {
                qsort(values, start, index - 1, ret, retIndex, k);
            } else {
                for (int i = start; i <= index; i++) {
                    ret[retIndex++] = values.get(i)[0];
                }
                if (k > index - start + 1) {
                    qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
                }
            }
        }
    }

}
