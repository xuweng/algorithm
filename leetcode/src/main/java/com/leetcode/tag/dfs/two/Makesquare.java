package com.leetcode.tag.dfs.two;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 473. 火柴拼正方形
 * <p>
 * 无需建树
 * <p>
 * 重复计算
 * <p>
 * 记忆化是重点.记忆化.记忆化.记忆化.记忆化.记忆化.记忆化.记忆化.
 * <p>
 * 十分钟.十分钟.十分钟.十分钟.十分钟.十分钟.
 * <p>
 * 记忆化.记忆化.记忆化.
 */
public class Makesquare {
    /**
     * 方法一：深度优先搜索
     * <p>
     * 因此，对于给定的若干根火柴，我们需要：
     * <p>
     * 将它们分成四组，每一根火柴恰好属于其中的一组；
     * <p>
     * 每一组火柴的长度之和都相同，等于所有火柴长度之和的四分之一。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/matchsticks-to-square/solution/huo-chai-pin-zheng-fang-xing-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public List<Integer> nums;
        //分为4组
        public int[] sums;
        //每组和
        public int possibleSquareSide;

        public Solution() {
            this.sums = new int[4];
        }

        /**
         * 方法一：深度优先搜索
         * <p>
         * 我们可以使用深度优先搜索枚举出所有的分组情况，并对于每一种情况，判断是否满足上述的两个条件。
         * <p>
         * 我们依次对每一根火柴进行搜索，当搜索到第 i 根火柴时，我们可以把它放到四组中的任意一种。对于每一种放置方法，
         * <p>
         * 我们继续对第 i + 1 根火柴进行递归搜索。当我们搜索完全部的 N 根火柴后，再判断每一组火柴的长度之和是否都相同。
         * <p>
         * 作者：LeetCode
         * 链接：https://leetcode-cn.com/problems/matchsticks-to-square/solution/huo-chai-pin-zheng-fang-xing-by-leetcode/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param index
         * @return
         */
        public boolean dfs(int index) {
            if (index == this.nums.size()) {
                //越界统计.数据全部放完.
                //4组的和是否都一样
                return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
            }

            // Get current matchstick.
            int element = this.nums.get(index);
            // Try adding it to each of the 4 sides (if possible)
            //当搜索到第 i 根火柴时，我们可以把它放到四组中的任意一种
            for (int i = 0; i < 4; i++) {
                //剪枝
                if (this.sums[i] + element > this.possibleSquareSide) {
                    continue;
                }
                //以下是标准回溯
                this.sums[i] += element;
                if (this.dfs(index + 1)) {
                    return true;
                }
                this.sums[i] -= element;
            }

            return false;
        }

        public boolean makesquare(int[] nums) {
            // Empty matchsticks.
            if (nums == null || nums.length == 0) {
                return false;
            }

            // Find the perimeter of the square (if at all possible)
            int perimeter = Arrays.stream(nums).sum();

            //每一组火柴的长度之和都相同，等于所有火柴长度之和的四分之一
            this.possibleSquareSide = perimeter / 4;
            if (this.possibleSquareSide * 4 != perimeter) {
                return false;
            }

            // Convert the array of primitive int to ArrayList (for sorting).
            this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
            this.nums.sort(Collections.reverseOrder());
            return this.dfs(0);
        }
    }

    class Solution1 {
        int[] sums = new int[4];
        int s;

        public boolean makesquare(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int sum = Arrays.stream(nums).sum();
            s = sum / 4;
            if (s * 4 != sum) {
                //没有整除
                return false;
            }

            return dfs(nums, 0);
        }

        private boolean dfs(int[] nums, int index) {
            if (index >= nums.length) {
                return (sums[0] == s && sums[1] == s && sums[2] == s && sums[3] == s);
            }

            for (int i = 0; i < 4; i++) {
                if (sums[i] + nums[index] >= s) {
                    continue;
                }
                sums[i] += nums[index];

                if (dfs(nums, index + 1)) {
                    return true;
                }

                sums[i] -= nums[index];
            }
            return false;
        }
    }

}
