package com.leetcode.tag.daily.five;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 659. 分割数组为连续子序列
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
            Map<Integer, Integer> countMap = new HashMap<>();
            Map<Integer, Integer> endMap = new HashMap<>();
            for (int x : nums) {
                int count = countMap.getOrDefault(x, 0) + 1;
                countMap.put(x, count);
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
