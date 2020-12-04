package com.leetcode.tag.daily.five;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 659. 分割数组为连续子序列
 * <p>
 * 由于需要将数组分割成一个或多个由连续整数组成的子序列，因此只要知道子序列的最后一个数字和子序列的长度，就能确定子序列。
 * <p>
 * 子序列:最后一个数--长度
 * <p>
 * 如果存在多个子序列以 x-1 结尾，应该将 x 加入其中的哪一个子序列？由于题目要求每个子序列的长度至少为 3，
 * <p>
 * 显然应该让最短的子序列尽可能长，因此应该将 x 加入其中最短的子序列。
 */
public class IsPossible {
    /**
     * 方法一：哈希表 + 最小堆
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/solution/fen-ge-shu-zu-wei-lian-xu-zi-xu-lie-by-l-lbs5/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public boolean isPossible(int[] nums) {
            //因此堆顶的元素即为最小的子序列长度。
            Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
            for (int x : nums) {
                if (!map.containsKey(x)) {
                    map.put(x, new PriorityQueue<>());
                }
                if (map.containsKey(x - 1)) {
                    int prevLength = map.get(x - 1).poll();
                    if (map.get(x - 1).isEmpty()) {
                        map.remove(x - 1);
                    }
                    map.get(x).offer(prevLength + 1);
                } else {
                    map.get(x).offer(1);
                }
            }
            Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
            for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
                PriorityQueue<Integer> queue = entry.getValue();
                if (queue.peek() < 3) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 方法二：贪心
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/solution/fen-ge-shu-zu-wei-lian-xu-zi-xu-lie-by-l-lbs5/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean isPossible(int[] nums) {
            //第一个哈希表存储数组中的每个数字的剩余次数
            Map<Integer, Integer> countMap = new HashMap<>();
            //第二个哈希表存储数组中的每个数字作为结尾的子序列的数量。
            Map<Integer, Integer> endMap = new HashMap<>();
            for (int x : nums) {
                countMap.put(x, countMap.getOrDefault(x, 0) + 1);
            }
            for (int x : nums) {
                int count = countMap.getOrDefault(x, 0);
                if (count > 0) {
                    int prevEndCount = endMap.getOrDefault(x - 1, 0);
                    if (prevEndCount > 0) {
                        countMap.put(x, count - 1);
                        endMap.put(x - 1, prevEndCount - 1);
                        endMap.put(x, endMap.getOrDefault(x, 0) + 1);
                    } else {
                        int count1 = countMap.getOrDefault(x + 1, 0);
                        int count2 = countMap.getOrDefault(x + 2, 0);
                        if (count1 > 0 && count2 > 0) {
                            countMap.put(x, count - 1);
                            countMap.put(x + 1, count1 - 1);
                            countMap.put(x + 2, count2 - 1);
                            endMap.put(x + 2, endMap.getOrDefault(x + 2, 0) + 1);
                        } else {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

}
