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

}
