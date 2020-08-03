package com.leetcode.tag.daily;

/**
 * 415. 字符串相加
 */
public class AddStrings {
    /**
     * 字符串太大了
     * <p>
     * 大数越界
     */
    class Solution {
        /**
         * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
         *
         * @param num1 定两个字符串形式的非负整数
         * @param num2 定两个字符串形式的非负整数
         * @return 计算它们的和
         */
        public String addStrings(String num1, String num2) {
            return String.valueOf(Long.parseLong(num1) + Long.parseLong(num2));
        }
    }
}
