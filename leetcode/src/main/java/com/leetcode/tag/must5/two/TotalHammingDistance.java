package com.leetcode.tag.must5.two;

/**
 * 477. 汉明距离总和
 */
public class TotalHammingDistance {
    /**
     * 方法一：逐位统计
     */
    class Solution {
        public int totalHammingDistance(int[] nums) {
            int ans = 0, n = nums.length;
            for (int i = 0; i < 30; ++i) {
                int c = 0;
                for (int val : nums) {
                    c += (val >> i) & 1;
                }
                ans += c * (n - c);
            }
            return ans;
        }
    }

    class Solution1 {
        public int totalHammingDistance(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    res += getHamm(nums[i], nums[j]);
                }
            }
            return res;
        }

        private int getHamm(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }

    class Solution2 {
        public int totalHammingDistance(int[] nums) {
            int sum = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    sum += CountHammingDistance(nums[i], nums[j]);
                }
            }
            System.out.println(sum);
            return sum;
        }

        public int CountHammingDistance(int a, int b) {
            int res = (a ^ b);
            int count = 0;
            while (res != 0) {
                count++;
                res = res & (res - 1);
            }
            return count;
        }
    }
}
