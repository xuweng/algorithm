package com.leetcode.tag.daily.eight;

import java.util.Arrays;

/**
 * 561. 数组拆分 I
 * <p>
 * 思路清晰 思路清晰 思路清晰
 * <p>
 * 图bfs dfs 计数
 */
public class ArrayPairSum {
    /**
     * 方法一：排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/array-partition-i/solution/shu-zu-chai-fen-i-by-leetcode-solution-9m9y/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0; i < nums.length; i += 2) {
                ans += nums[i];
            }
            return ans;
        }
    }

}
