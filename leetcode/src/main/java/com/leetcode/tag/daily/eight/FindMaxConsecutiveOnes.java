package com.leetcode.tag.daily.eight;

/**
 * 485. 最大连续 1 的个数
 * <p>
 * 思路 合理
 * <p>
 * 图bfs dfs 计数 滑动窗口
 */
public class FindMaxConsecutiveOnes {
    /**
     * 方法一：一次遍历
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/max-consecutive-ones/solution/zui-da-lian-xu-1de-ge-shu-by-leetcode-so-252a/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int maxCount = 0, count = 0;
            int n = nums.length;
            for (int num : nums) {
                if (num == 1) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 0;
                }
            }
            maxCount = Math.max(maxCount, count);
            return maxCount;
        }
    }

}
