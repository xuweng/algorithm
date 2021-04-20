package com.leetcode.tag.must1.three;

/**
 * 28. 实现 strStr()
 */
public class StrStr {
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle == null || needle.isEmpty()) {
                return 0;
            }
            int[] next = getNext(needle);
            int j = 0;
            for (int i = 0; i < haystack.length(); i++) {
                while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                    j = next[j - 1];
                }
                if (haystack.charAt(i) == needle.charAt(j)) {
                    j++;
                }
                if (j == needle.length()) {
                    return i - needle.length() + 1;
                }
            }

            return -1;
        }

        private int[] getNext(String needle) {
            // 前i 最大前后缀
            int[] next = new int[needle.length()];
            int j = 0;
            for (int i = 1; i < needle.length(); i++) {
                while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                    j = next[j - 1];
                }
                if (needle.charAt(i) == needle.charAt(j)) {
                    j++;
                }
                next[i] = j;
            }

            return next;
        }
    }
}
