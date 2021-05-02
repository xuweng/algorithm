package com.leetcode.tag.must2.seven;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. 砖墙
 */
public class LeastBricks {
    /**
     * 方法一：哈希表
     * <p>
     * 问题可以转换成求「垂线穿过的砖块边缘数量的最大值」
     */
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (List<Integer> widths : wall) {
                int n = widths.size();
                int sum = 0;
                for (int i = 0; i < n - 1; i++) {
                    sum += widths.get(i);
                    cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
                }
            }
            int maxCnt = 0;
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                maxCnt = Math.max(maxCnt, entry.getValue());
            }
            return wall.size() - maxCnt;
        }
    }

    class Solution1 {
        public int leastBricks(List<List<Integer>> wall) {
            int n = wall.size();
            // 间隙计数
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0, sum = 0; i < n; i++, sum = 0) {
                for (int cur : wall.get(i)) {
                    sum += cur;
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
                map.remove(sum); // 不能从两边穿过，需要 remove 掉最后一个
            }
            int ans = n;
            for (int u : map.keySet()) {
                int cnt = map.get(u);
                // 最少穿过的砖块数 = 总行数 - 出现次数
                ans = Math.min(ans, n - cnt);
            }
            return ans;
        }
    }
}
