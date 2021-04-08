package com.leetcode.tag.must.one.ten;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class GenerateParenthesis {
    class Solution {
        List<String> result = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            dfs(n, n, "");

            return result;
        }

        private void dfs(int left, int right, String temp) {
            if (left < 0 || right < 0 || left > right) {
                return;
            }
            if (left == 0 && right == 0) {
                result.add(temp);
                return;
            }
            dfs(left - 1, right, temp + "(");
            dfs(left, right - 1, temp + ")");
        }
    }
}
