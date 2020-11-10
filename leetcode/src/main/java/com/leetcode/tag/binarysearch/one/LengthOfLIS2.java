package com.leetcode.tag.binarysearch.one;

/**
 * 最长上升子序列
 */
public class LengthOfLIS2 {
    /**
     * 方法一：动态规划
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            //定义 dp[i] 为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度，注意 nums[i] 必须被选取。
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int maxans = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxans = Math.max(maxans, dp[i]);
            }
            return maxans;
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int lengthOfLIS(int[] nums) {
            int len = 1, n = nums.length;
            if (n == 0) {
                return 0;
            }
            int[] d = new int[n + 1];
            d[len] = nums[0];
            for (int i = 1; i < n; ++i) {
                // nums[i]一定要放入d
                if (nums[i] > d[len]) {
                    // nums[i]放入d的末尾
                    d[++len] = nums[i];
                } else {
                    // nums[i]放入d的中间
                    // 在 d 数组中二分查找，找到第一个比 nums[i] 小的数 d[k]
                    int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                    while (l <= r) {
                        int mid = (l + r) >> 1;
                        if (d[mid] < nums[i]) {
                            pos = mid;
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    }
                    // i赋值
                    d[pos + 1] = nums[i];
                }
            }
            return len;
        }
    }

}
