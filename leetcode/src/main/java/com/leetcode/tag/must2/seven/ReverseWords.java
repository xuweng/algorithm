package com.leetcode.tag.must2.seven;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 翻转字符串里的单词
 * <p>
 * 依赖上一层 倒序
 * <p>
 * 依赖本层 正序
 * <p>
 * 倒序 倒序 倒序
 * <p>
 * 正序 正序 正序
 */
public class ReverseWords {
    class Solution {
        public String reverseWords(String s) {
            // 除去开头和末尾的空白字符
            s = s.trim();
            // 正则匹配连续的空白字符作为分隔符分割
            // 使用 split 将字符串按空格分割成字符串数组
            List<String> wordList = Arrays.asList(s.split("\\s+"));
            // 用 reverse 将字符串数组进行反转；
            Collections.reverse(wordList);
            // 使用 join 方法将字符串数组拼成一个字符串 拼接上空格
            return String.join(" ", wordList);
        }
    }

    /**
     * 1.去掉空格
     * 2.反转这个字符串
     * 3.反转每个单词
     * <p>
     * 两次反转 保证顺序和原来一样
     */
    class Solution1 {
        public String reverseWords(String s) {
            StringBuilder sb = trimSpaces(s);

            // 翻转字符串
            reverse(sb, 0, sb.length() - 1);

            // 翻转每个单词
            reverseEachWord(sb);

            return sb.toString();
        }

        /**
         * 除去开头和末尾的空白字符
         *
         * @param s
         * @return
         */
        public StringBuilder trimSpaces(String s) {
            int left = 0, right = s.length() - 1;
            // 去掉字符串开头的空白字符
            while (left <= right && s.charAt(left) == ' ') {
                ++left;
            }

            // 去掉字符串末尾的空白字符
            while (left <= right && s.charAt(right) == ' ') {
                --right;
            }

            // 将字符串间多余的空白字符去除
            StringBuilder sb = new StringBuilder();
            while (left <= right) {
                char c = s.charAt(left);

                if (c != ' ') {
                    sb.append(c);
                } else if (sb.charAt(sb.length() - 1) != ' ') {
                    // 最后一个不是空格 单词之间只能有一个空格
                    sb.append(c);
                }

                ++left;
            }
            return sb;
        }

        /**
         * 翻转字符串
         * <p>
         * 首尾两两交换
         *
         * @param sb
         * @param left
         * @param right
         */
        public void reverse(StringBuilder sb, int left, int right) {
            while (left < right) {
                char tmp = sb.charAt(left);
                sb.setCharAt(left++, sb.charAt(right));
                sb.setCharAt(right--, tmp);
            }
        }

        /**
         * 翻转每个单词
         *
         * @param sb
         */
        public void reverseEachWord(StringBuilder sb) {
            int n = sb.length();
            int start = 0, end = 0;

            while (start < n) {
                // 循环至单词的末尾 end=空格
                while (end < n && sb.charAt(end) != ' ') {
                    ++end;
                }
                // 翻转单词
                reverse(sb, start, end - 1);
                // 更新start，去找下一个单词
                start = end + 1;
                ++end;
            }
        }
    }

    class Solution2 {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();

            getReverseWords(sb, s, 0, false);

            return sb.toString();
        }

        public void getReverseWords(StringBuilder sb, String s, int start, boolean flag) {
            int size = s.length();
            while (start < size && ' ' == s.charAt(start)) {
                // 走到非空格
                start++;
            }
            if (start == size) {
                // 走完
                return;
            }
            int end = start;
            while (end < size && ' ' != s.charAt(end)) {
                // 走到空格
                end++;
            }
            // [start,end)是一个单词
            // 先递归处理[end,s.length]
            getReverseWords(sb, s, end, true);
            // 再处理[start,end]
            sb.append(s, start, end);
            if (flag) {
                sb.append(' ');
            }
        }
    }
}
