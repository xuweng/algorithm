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
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/matchsticks-to-square/solution/huo-chai-pin-zheng-fang-xing-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public List<Integer> nums;
        public int[] sums;
        public int possibleSquareSide;

        public Solution() {
            this.sums = new int[4];
        }

        // Depth First Search function.
        public boolean dfs(int index) {
            // If we have exhausted all our matchsticks, check if all sides of the square are of equal length
            if (index == this.nums.size()) {
                return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
            }

            // Get current matchstick.
            int element = this.nums.get(index);

            // Try adding it to each of the 4 sides (if possible)
            for (int i = 0; i < 4; i++) {
                if (this.sums[i] + element <= this.possibleSquareSide) {
                    this.sums[i] += element;
                    if (this.dfs(index + 1)) {
                        return true;
                    }
                    this.sums[i] -= element;
                }
            }

            return false;
        }

        public boolean makesquare(int[] nums) {
            // Empty matchsticks.
            if (nums == null || nums.length == 0) {
                return false;
            }

            // Find the perimeter of the square (if at all possible)
            int l = nums.length;
            int perimeter = 0;
            for (int num : nums) {
                perimeter += num;
            }

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

}
