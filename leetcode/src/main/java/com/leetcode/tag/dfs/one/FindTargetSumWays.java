package com.leetcode.tag.dfs.one;

/**
 * 494. 目标和
 */
public class FindTargetSumWays {
    class Solution {
        int result;

        public int findTargetSumWays(int[] nums, int S) {
            dfs(nums, S, 0, 0);

            return result;
        }

        private void dfs(int[] nums, int s, int sum, int start) {
            if (start >= nums.length) {
                if (s == sum) {
                    result++;
                }
                return;
            }

            dfs(nums, s, sum + nums[start], start + 1);
            dfs(nums, s, sum - nums[start], start + 1);
        }
    }

    /**
     * 方法一：枚举
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/target-sum/solution/mu-biao-he-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int count = 0;

        public int findTargetSumWays(int[] nums, int S) {
            calculate(nums, 0, 0, S);
            return count;
        }

        public void calculate(int[] nums, int i, int sum, int S) {
            if (i == nums.length) {
                if (sum == S) {
                    count++;
                }
            } else {
                calculate(nums, i + 1, sum + nums[i], S);
                calculate(nums, i + 1, sum - nums[i], S);
            }
        }
    }

}
