package com.leetcode.tag.daily.eight;

import java.util.HashMap;
import java.util.Map;

/**
 * 781. 森林中的兔子
 */
public class NumRabbits {
    /**
     * 方法一：贪心
     * <p>
     * 贪心解法【分析&证明】
     * 答案要我们求最少的兔子数量。
     * <p>
     * 不妨设有某种颜色的兔子 mm 只，它们回答的答案数值为 cnt，那么 m 和 cnt 满足什么关系？
     * <p>
     * 显然两者关系为 m = cnt + 1。
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/rabbits-in-forest/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-v17p5/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 我们应该让「同一颜色的兔子数量」尽量多，从而实现「总的兔子数量」最少。
     * <p>
     * 重点：当某个兔子回答 x 的时候，那么数组中最多允许 x+1 个同花色的兔子🐰同时回答 x。
     * <p>
     * [1, 1, 2] 1最多2个 2最多3 2+3
     * <p>
     * [10, 10, 10] 10最多11个 3个10划分为用一个颜色
     */
    class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int y : answers) {
                count.put(y, count.getOrDefault(y, 0) + 1);
            }
            int ans = 0;
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                int y = entry.getKey(), x = entry.getValue();
                ans += (x + y) / (y + 1) * (y + 1);
            }
            return ans;
        }
    }
}
