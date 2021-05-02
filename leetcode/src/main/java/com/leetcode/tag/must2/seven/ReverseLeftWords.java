package com.leetcode.tag.must2.seven;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class ReverseLeftWords {
    class Solution {
        public String reverseLeftWords(String s, int n) {
            return s.substring(n) + s.substring(0, n);
        }
    }

    class Solution1 {
        public String reverseLeftWords(String s, int n) {
            StringBuilder res = new StringBuilder();
            for (int i = n; i < s.length(); i++) {
                res.append(s.charAt(i));
            }
            for (int i = 0; i < n; i++) {
                res.append(s.charAt(i));
            }
            return res.toString();
        }
    }

    class Solution2 {
        public String reverseLeftWords(String s, int n) {
            StringBuilder res = new StringBuilder();
            for (int i = n; i < n + s.length(); i++) {
                res.append(s.charAt(i % s.length()));
            }
            return res.toString();
        }
    }

    /**
     * 反转全部
     * 反转单词
     * <p>
     * 3次反转
     */
    class Solution3 {
        public String reverseLeftWords(String s, int n) {
            char[] chars = s.toCharArray();

            // [0,n]反转
            reverse(chars, 0, n - 1);
            // [n,s.length]反转
            reverse(chars, n, s.length() - 1);
            // [0,s.length]反转
            reverse(chars, 0, s.length() - 1);

            return new String(chars);
        }

        void reverse(char[] chars, int begin, int end) {
            while (begin < end) {
                char temp = chars[begin];
                chars[begin] = chars[end];
                chars[end] = temp;
                ++begin;
                --end;
            }
        }
    }

}
