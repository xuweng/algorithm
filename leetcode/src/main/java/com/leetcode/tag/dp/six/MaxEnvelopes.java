package com.leetcode.tag.dp.six;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 * <p>
 * 方法：排序 + 最长递增子序列
 * <p>
 * 这道题目其实是最长递增子序列（Longes Increasing Subsequence，简写为 LIS）的一个变种
 */
public class MaxEnvelopes {
    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes/solution/e-luo-si-tao-wa-xin-feng-wen-ti-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            // sort on increasing in first dimension and decreasing in second
            // 按 w 进行升序排序，若 w 相同则按 h 降序排序
            Arrays.sort(envelopes, (arr1, arr2) -> arr1[0] == arr2[0] ? arr2[1] - arr1[1] : arr1[0] - arr2[0]);
            // extract the second dimension and run LIS
            int[] secondDim = Arrays.stream(envelopes).mapToInt(envelope -> envelope[1]).toArray();
            return lengthOfLIS(secondDim);
        }

        public int lengthOfLIS(int[] nums) {
            // 保存单调递增序列
            int[] dp = new int[nums.length];
            int len = 0;
            for (int num : nums) {
                int i = Arrays.binarySearch(dp, 0, len, num);
                if (i < 0) {
                    i = -(i + 1);
                }
                // 替换
                dp[i] = num;
                if (i == len) {
                    len++;
                }
            }
            return len;
        }
    }

}
