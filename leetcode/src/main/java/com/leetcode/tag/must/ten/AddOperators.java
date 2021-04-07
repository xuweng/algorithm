package com.leetcode.tag.must.ten;

import java.util.ArrayList;
import java.util.List;

/**
 * 282. 给表达式添加运算符
 */
public class AddOperators {
    class Solution {
        List<String> result = new ArrayList<>();
        char[] chars;

        public List<String> addOperators(String num, int target) {
            if (num == null || num.isEmpty()) {
                return result;
            }
            chars = new char[]{'+', '-', '*'};

            dfs(num, "", ' ', 0, target, 0);

            return result;
        }

        private void dfs(String num, String temp, char pre, int sum, int target, int index) {
            if (sum == target && index >= num.length()) {
                result.add(temp);
                return;
            }
            for (int i = index; i < num.length(); i++) {
                int s = sum(Integer.parseInt(String.valueOf(num.charAt(i))), sum, pre);
                for (char aChar : chars) {
                    dfs(num, temp + num.charAt(i) + aChar, aChar, s, target, i + 1);
                }
            }
        }

        private int sum(int i, int sum, char pre) {
            if (pre == '+') {
                return sum + i;
            }
            if (pre == '-') {
                return sum - i;
            }
            if (pre == '*') {
                return sum * i;
            }
            return i;
        }
    }
}
