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

    class Solution1 {
        public int minFlips(String s) {
            int len = s.length();
            s = s + s;
            int d0 = 0;// 转换成以0开头的字符串所需要的反转次数
            int d1 = 0;// 转换成以1开头的字符串所需要的反转次数
            StringBuilder h0 = new StringBuilder();
            StringBuilder h1 = new StringBuilder();
            for (int i = 0; i < len; i++) {
                h0.append("01");
                h1.append("10");
            }
            String head0 = h0.toString();
            String head1 = h1.toString();
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < 2 * len; i++) {
                // 与head0不同，则d0++
                if (s.charAt(i) != head0.charAt(i)) {
                    d0++;
                }
                // 与head1不同，则d1++
                if (s.charAt(i) != head1.charAt(i)) {
                    d1++;
                }
                if (i >= len) {
                    if (s.charAt(i - len) != head0.charAt(i - len)) {
                        d0--;
                    }
                    // 最前面的元素出窗口，如果出窗口的元素与head0对应的元素不同，则d0--
                    //（不同的元素需要反转一次，但是不同的元素已经出窗口了，所以反转次数少一次）
                    if (s.charAt(i - len) != head1.charAt(i - len)) {
                        d1--;
                    }
                    ans = Math.min(ans, Math.min(d0, d1));
                }
            }
            return ans;
        }
    }
}
