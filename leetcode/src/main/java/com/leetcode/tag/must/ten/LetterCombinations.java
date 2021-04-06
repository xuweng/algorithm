package com.leetcode.tag.must.ten;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * <p>
 * 区间 区间 区间 重复 相等 相似题目
 */
public class LetterCombinations {
    class Solution {
        List<String> result = new ArrayList<>();
        Map<Character, String> phoneMap = new HashMap<>(32);

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.isEmpty()) {
                return result;
            }
            phoneMap.put('2', "abc");
            phoneMap.put('3', "def");
            phoneMap.put('4', "ghi");
            phoneMap.put('5', "jkl");
            phoneMap.put('6', "mno");
            phoneMap.put('7', "pqrs");
            phoneMap.put('8', "tuv");
            phoneMap.put('9', "wxyz");

            dfs(digits, 0, "");

            return result;
        }

        private void dfs(String digits, int index, String temp) {
            if (index >= digits.length()) {
                result.add(temp);
                return;
            }
            for (int i = index; i < digits.length(); i++) {
                String s = phoneMap.get(digits.charAt(i));
                for (int j = 0; j < s.length(); j++) {
                    dfs(digits, i + 1, temp + s.charAt(j));
                }
            }
        }
    }
}
