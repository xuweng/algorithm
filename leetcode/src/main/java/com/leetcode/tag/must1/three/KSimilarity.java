package com.leetcode.tag.must1.three;

/**
 * 854. 相似度为 K 的字符串
 */
public class KSimilarity {
    class Solution {
        int min = Integer.MAX_VALUE;

        public int kSimilarity(String s1, String s2) {
            char[] chars = s1.toCharArray();
            char[] chars1 = s2.toCharArray();

            dfs(chars, chars1, 0, 0);

            return min;
        }

        private void dfs(char[] chars, char[] chars1, int index, int count) {
            if (count > min) {
                return;
            }
            if (index == chars.length - 1) {
                if (min > count) {
                    // 更新
                    min = count;
                }
                return;
            }
            if (chars[index] == chars1[index]) {
                dfs(chars, chars1, index + 1, count);
            } else {
                int i = index + 1;
                while (i < chars1.length) {
                    if (chars1[i] == chars[index]) {
                        swap(chars1, index, i);
                        dfs(chars, chars1, index + 1, count + 1);
                        swap(chars1, index, i);
                    }
                    i++;
                }
            }
        }

        void swap(char[] chars, int i, int j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
}
