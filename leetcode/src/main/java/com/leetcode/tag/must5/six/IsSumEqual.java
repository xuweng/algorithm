package com.leetcode.tag.must5.six;

/**
 * 1880. 检查某单词是否等于两单词之和
 */
public class IsSumEqual {
    class Solution {
        public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
            return get(firstWord) + get(secondWord) == get(targetWord);
        }

        /**
         * 按照题目要求将字符串转换成对应的数字
         */
        int get(String str) {
            int res = 0;
            for (Character c : str.toCharArray()) {
                res = res * 10 + (c - 'a');
            }
            return res;
        }
    }
}
