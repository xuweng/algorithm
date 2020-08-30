package com.leetcode.tag.dp;

/**
 * 152. 乘积最大子数组
 */
public class MaxProduct {
    /**
     * 错误的状态转移方程：
     * <p>
     * fmax(i) = max{ f(i - 1) * a_i, a_i}
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-product-subarray/solution/cheng-ji-zui-da-zi-shu-zu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int[] maxF = new int[nums.length];
        int[] minF = new int[nums.length];

        maxF[0] = nums[0];
        minF[0] = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

}
