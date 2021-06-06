package com.leetcode.tag.must6.one;

/**
 * 5778. 使二进制字符串字符交替的最少反转次数
 */
public class MinFlips {
    class Solution {
        public int minFlips(String s) {
            char[] cs = s.toCharArray();
            char[] target = new char[]{'0', '1'};
            int count = 0, n = cs.length;
            for (int i = 0; i < n; i++) {
                //01排列
                if (cs[i] != target[i % 2]) {
                    count++;
                }
            }
            int res = Math.min(count, n - count);
            //偶数就直接跳过, 01010101
            if (n % 2 == 0) {
                return res;
            }
            int count1 = 0;
            for (int i = 0; i < n - 1; i++) {
                //到i为止的要放在后面，并且从01转为10
                //求到i为止的01排列
                if (cs[i] != target[i % 2]) {
                    count1++;
                }
                //[i + 1, n - 1] 01排列, [0, i] 10排列
                //此时的cc是01排列了
                int cc = count - count1 + i + 1 - count1;
                res = Math.min(res, Math.min(cc, n - cc));
            }
            return res;
        }
    }
}
