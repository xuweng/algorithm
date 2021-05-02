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
            // 间隙,间隙个数
            Map<Integer, Integer> cnt = new HashMap<>();
            for (List<Integer> widths : wall) {
                int n = widths.size();
                // 垂线不能通过砖墙的两个垂直边缘，所以砖墙两侧的边缘不应当被统计。只需要统计每行砖块中除了最右侧的砖块以外的其他砖块的右边缘即可
                // 统计每行间隙 [0,n-2]
                int sum = 0;
                for (int i = 0; i < n - 1; i++) {
                    // 累加得到间隙 边缘
                    sum += widths.get(i);
                    cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
                }
            }
            int maxCnt = 0;
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                maxCnt = Math.max(maxCnt, entry.getValue());
            }
            // 砖墙的高度 - 最大值
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
