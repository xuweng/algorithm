package com.leetcode.tag.dp;

/**
 * 53. 最大子序和
 * <p>
 * 不用花太多时间在无所谓的竞赛
 * <p>
 * 巩固基础。巩固基础。巩固基础。
 * <p>
 * 竞赛的题目不太适合
 */
public class MaxSubArray {
    /**
     * 方法一：动态规划
     * <p>
     * 用 f(i) 代表以第 i 个数结尾的「连续子数组的最大和」
     * <p>
     * 动态规划转移方程：
     * <p>
     * f(i) = max{f(i - 1)+ a_i,a_i}
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            int pre = 0, maxAns = nums[0];
            for (int x : nums) {
                pre = Math.max(pre + x, x);
                maxAns = Math.max(maxAns, pre);
            }
            return maxAns;
        }
    }

    /**
     * 答案就是：
     * <p>
     * max{ f(i) }
     * 0≤i≤n−1
     */
    class Solution1 {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

    /**
     * 方法二：分治
     * <p>
     * 线段树
     */
    class Solution2 {
        /**
         * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 注意越界,连个范围都没有还行，注意子数组连续。
         * 尝试线段树
         *
         * @param nums 整数数组
         * @return 最少包含一个元素的最大和的连续子数组的和
         */
        public int maxSubArray(int[] nums) {
            // 输入校验
            if (nums == null || nums.length <= 0) {
                return 0;
            }
            int len = nums.length;// 获取输入长度
            return getInfo(nums, 0, len - 1).mSum;
        }

        /**
         * 封装数据结构
         * <p>
         * 对于一个区间 [l,r]，我们可以维护四个量：
         * <p>
         * lSum 表示 [l,r] 内以 l 为左端点的最大子段和
         * rSum 表示 [l,r] 内以 r 为右端点的最大子段和
         * mSum 表示 [l,r] 内的最大子段和
         * iSum 表示 [l,r] 的区间和
         * <p>
         * 作者：LeetCode-Solution
         * 链接：https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        class WtevTree {
            int lSum;// 以左区间为端点的最大子段和
            int rSum;// 以右区间为端点的最大子段和
            int iSum;// 区间所有数的和
            int mSum;// 该区间的最大子段和

            // 构造函数
            WtevTree(int l, int r, int i, int m) {
                lSum = l;
                rSum = r;
                iSum = i;
                mSum = m;
            }
        }

        // 通过既有的属性，计算上一层的属性,一步步往上返回,获得线段树
        WtevTree pushUp(WtevTree leftT, WtevTree rightT) {
            // 新子段的lSum等于左区间的lSum或者左区间的 区间和 加上右区间的lSum
            int l = Math.max(leftT.lSum, leftT.iSum + rightT.lSum);
            // 新子段的rSum等于右区间的rSum或者右区间的 区间和 加上左区间的rSum
            int r = Math.max(leftT.rSum + rightT.iSum, rightT.rSum);
            // 新子段的区间和等于左右区间的区间和之和
            int i = leftT.iSum + rightT.iSum;
            // 新子段的最大子段和，其子段有可能穿过左右区间，或左区间，或右区间
            int m = Math.max(leftT.rSum + rightT.lSum, Math.max(leftT.mSum, rightT.mSum));
            return new WtevTree(l, r, i, m);
        }

        // 递归建立和获得输入区间所有子段的结构
        WtevTree getInfo(int[] nums, int left, int right) {
            // 若区间长度为1，其四个子段均为其值
            if (left == right) {
                return new WtevTree(nums[left], nums[left], nums[left], nums[left]);
            }
            int mid = (left + right) >> 1;// 获得中间点mid
            WtevTree leftT = getInfo(nums, left, mid);
            WtevTree rightT = getInfo(nums, mid + 1, right);//mid+1,左右区间没有交集。
            return pushUp(leftT, rightT);
        }
    }
}
