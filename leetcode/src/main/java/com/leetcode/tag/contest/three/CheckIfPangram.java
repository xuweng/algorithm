package com.leetcode.tag.contest.three;

/**
 * 5734. 判断句子是否为全字母句
 */
public class CheckIfPangram {
    class Solution {
        public boolean checkIfPangram(String sentence) {
            if (sentence == null || sentence.isEmpty()) {
                return false;
            }
            int[] a = new int[26];
            for (int i = 0; i < sentence.length(); i++) {
                a[sentence.charAt(i) - 'a']++;
            }
            for (int i : a) {
                if (i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
