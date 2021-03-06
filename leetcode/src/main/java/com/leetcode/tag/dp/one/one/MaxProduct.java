package com.leetcode.tag.dp.one.one;

/**
 * 152. 乘积最大子数组
 * <p>
 * 脑海里执行一遍测试用例
 */
public class MaxProduct {
    /**
     * 错误的状态转移方程：
     * <p>
     * fmax(i) = max{f(i - 1) * a_i, a_i}
     * <p>
     * 当前位置的最优解未必是由前一个位置的最优解转移得到的
     * <p>
     * 我们可以根据正负性进行分类讨论。
     * <p>
     * 考虑当前位置如果是一个负数的话，那么我们希望以它前一个位置结尾的某个段的积也是个负数，这样就可以负负得正，并且我们希望这个积尽可能「负得更多」，
     * <p>
     * 即尽可能小。如果当前位置是一个正数的话，我们更希望以它前一个位置结尾的某个段的积也是个正数，并且希望它尽可能地大
     * <p>
     * 于是这里我们可以再维护一个 fmin(i),它表示以第 i 个元素结尾的乘积最小子数组的乘积，那么我们可以得到这样的动态规划转移方程：
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
        //以第 i 个元素结尾的乘积最大子数组的乘积
        int[] maxF = new int[nums.length];
        //以第 i 个元素结尾的乘积最小子数组的乘积
        int[] minF = new int[nums.length];

        maxF[0] = nums[0];
        minF[0] = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            //同号，异号
            //++,--,+-
            //当前做选择，当前做判断
            //当前+，前一个+
            //当前-，前一个-
            //当前+，前一个-
            //当前-，前一个+
            //无论怎样，都是3个变量比较
            //都是3个变量比较
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

    /**
     * 算法错误
     */
    class S {
        public int maxProduct(int[] nums) {
            //以第 i 个元素结尾的乘积最大子数组的乘积
            int[] maxF = new int[nums.length];
            //以第 i 个元素结尾的乘积最小子数组的乘积
            int[] minF = new int[nums.length];

            maxF[0] = nums[0];
            minF[0] = nums[0];
            int ans = nums[0];

            for (int i = 1; i < nums.length; ++i) {
                //同号，异号
                //++,--,+-
                //当前做选择，当前做判断
                //当前+，前一个+
                //当前-，前一个-
                //当前+，前一个-
                //当前-，前一个+

                //需要排除0
                //同号
                //++,--
                if (isTong(maxF[i - 1], nums[i])) {
                    maxF[i] = Math.max(maxF[i - 1] * nums[i], minF[i - 1] * nums[i]);
                } else {
                    maxF[i] = nums[i];
                }
                //同号
                if (isTong(minF[i - 1], nums[i])) {
                    minF[i] = nums[i];
                } else {
                    minF[i] = Math.min(minF[i - 1] * nums[i], maxF[i - 1] * nums[i]);
                }
                ans = Math.max(ans, maxF[i]);
            }
            return ans;
        }

        private boolean isTong(int i, int j) {
            if (j == 0) {
                return false;
            }
            if (j > 0) {
                return i > 0;
            }
            return i < 0;
        }
    }

    /**
     * 根据当前元素判断正负，太多条件，累死。
     */
    class S1 {
        public int maxProduct(int[] nums) {
            //以第 i 个元素结尾的乘积最大子数组的乘积
            int[] maxF = new int[nums.length];
            //以第 i 个元素结尾的乘积最小子数组的乘积
            int[] minF = new int[nums.length];

            maxF[0] = nums[0];
            minF[0] = nums[0];
            int ans = nums[0];

            for (int i = 1; i < nums.length; ++i) {
                //同号，异号
                //++,--,+-
                //当前做选择，当前做判断
                //当前+，前一个+
                //当前-，前一个-
                //当前+，前一个-
                //当前-，前一个+

                //需要排除0
                //同号
                //++,--
                if (nums[i] > 0) {
                    if (maxF[i - 1] > 0) {
                        maxF[i] = maxF[i - 1] * nums[i];
                    } else {
                        maxF[i] = nums[i];
                    }
                } else if (nums[i] < 0) {
                    if (minF[i - 1] < 0) {
                        maxF[i] = minF[i - 1] * nums[i];
                    } else {
                        maxF[i] = nums[i];
                    }
                } else {
                    maxF[i] = nums[i];
                }
            }
            return ans;
        }

        private boolean isTong(int i, int j) {
            if (j == 0) {
                return false;
            }
            if (j > 0) {
                return i > 0;
            }
            return i < 0;
        }
    }

}
