package com.leetcode.tag.must2.ten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 740. 删除并获得点数
 */
public class DeleteAndEarn {
    /**
     * 方法一：动态规划
     * <p>
     * 与「198. 打家劫舍」是一样的
     * <p>
     * 若选择了 x，则可以获取 sum[x] 的点数，且无法再选择 x−1 和 x+1
     */
    class Solution {
        public int deleteAndEarn(int[] nums) {
            int maxVal = 0;
            for (int val : nums) {
                maxVal = Math.max(maxVal, val);
            }
            int[] sum = new int[maxVal + 1];
            for (int val : nums) {
                sum[val] += val;
            }
            return rob(sum);
        }

        public int rob(int[] nums) {
            int size = nums.length;
            int first = nums[0], second = Math.max(nums[0], nums[1]);
            for (int i = 2; i < size; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            return second;
        }
    }

    /**
     * 方法二：排序 + 动态规划
     */
    class Solution1 {
        public int deleteAndEarn(int[] nums) {
            int n = nums.length;
            int ans = 0;
            Arrays.sort(nums);
            List<Integer> sum = new ArrayList<>();
            sum.add(nums[0]);
            int size = 1;
            for (int i = 1; i < n; ++i) {
                int val = nums[i];
                if (val == nums[i - 1]) {
                    sum.set(size - 1, sum.get(size - 1) + val);
                } else if (val == nums[i - 1] + 1) {
                    sum.add(val);
                    ++size;
                } else {
                    ans += rob(sum);
                    sum.clear();
                    sum.add(val);
                    size = 1;
                }
            }
            ans += rob(sum);
            return ans;
        }

        public int rob(List<Integer> nums) {
            int size = nums.size();
            if (size == 1) {
                return nums.get(0);
            }
            int first = nums.get(0), second = Math.max(nums.get(0), nums.get(1));
            for (int i = 2; i < size; i++) {
                int temp = second;
                second = Math.max(first + nums.get(i), second);
                first = temp;
            }
            return second;
        }
    }

    /**
     * 打家劫舍的最优子结构的公式：
     * dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
     * <p>
     * 这个问题的最优子结构公式：
     * dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
     */
    class Solution2 {
        public int deleteAndEarn(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int max = nums[0];
            for (int num : nums) {
                max = Math.max(max, num);
            }
            // 构造一个新的数组all
            int[] all = new int[max + 1];
            for (int item : nums) {
                // 计数
                all[item]++;
            }
            int[] dp = new int[max + 1];
            dp[1] = all[1];
            // 不是枚举原数组，是枚举最大值
            // 从小到大枚举 考虑i，i+1根本不需要考虑
            // 动态规划求解
            for (int i = 2; i <= max; ++i) {
                // 不选择i 选择i-1，i-2和i就会删除  i-2,i-1,i
                // 选择i   不能选择i-1,只能选择i-2，只会把i-3和i-1删除 i-1 i i+1

                // 选择i-1，就不能选择i
                // 选择i，就不能选择i-1 i+1
                // 不选择i，选择i-1
                // 相邻不能同时选择
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
            }
            return dp[max];
        }
    }

    /**
     * 当我们选择 nums[i] 的时候，比 nums[i-1],nums[i+1] 都不能被选择。
     * <p>
     * 如果我们将数组排好序，从前往后处理，其实只需要考虑“i”与“i-1”的「大小 & 选择」关系即可，
     * <p>
     * 这样处理完，显然每个数的「i-1/i+1」都会被考虑到。
     */
    class Solution3 {
        int[] cnts = new int[10009];

        public int deleteAndEarn(int[] nums) {
            int n = nums.length;
            int max = 0;
            for (int x : nums) {
                cnts[x]++;
                max = Math.max(max, x);
            }
            // f[i][0] 代表「不选」数值 i；f[i][1] 代表「选择」数值 i
            int[][] f = new int[max + 1][2];
            for (int i = 1; i <= max; i++) {
                f[i][1] = f[i - 1][0] + i * cnts[i];
                f[i][0] = Math.max(f[i - 1][1], f[i - 1][0]);
            }
            return Math.max(f[max][0], f[max][1]);
        }
    }
}
