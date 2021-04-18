package com.leetcode.tag.must1.two;

import java.util.HashSet;
import java.util.Set;

/**
 * 5734. 判断句子是否为全字母句
 */
public class CheckIfPangram {
    class Solution {
        public boolean checkIfPangram(String sentence) {
            if (sentence.length() < 26) {
                return false;
            }
            Set<Character> hashSet = new HashSet<>();
            char[] chars = sentence.toCharArray();
            for (char aChar : chars) {
                hashSet.add(aChar);
            }
            return 26 == hashSet.size();
        }
    }
}
