package com.leetcode.tag.must.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 */
public class Partition {
    class Solution {
        List<List<String>> result = new ArrayList<>();
        List<String> stack = new ArrayList<>();

        public List<List<String>> partition(String s) {
            if (s == null || s.isEmpty()) {
                return result;
            }

            dfs(s, 0);

            return result;
        }

        private void dfs(String s, int index) {
            if (index >= s.length()) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = index; i < s.length(); i++) {
                if (!is(s, index, i)) {
                    continue;
                }
                stack.add(s.substring(index, i + 1));
                dfs(s, i + 1);
                stack.remove(stack.size() - 1);
            }
        }

        private boolean is(String s, int i, int j) {
            while (i <= j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }

            return true;
        }
    }
}
