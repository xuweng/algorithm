package com.leetcode.tag.must.one.eight;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 */
public class Partition {
    class Solution {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        boolean[][] is;

        public List<List<String>> partition(String s) {
            if (s == null) {
                return result;
            }
            is = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                is[i][i] = true;
            }
            for (int i = s.length() - 2; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    is[i][j] = s.charAt(i) == s.charAt(j);
                    if (j > i + 1) {
                        is[i][j] = is[i][j] && is[i + 1][j - 1];
                    }
                }
            }

            dfs(s, 0);

            return result;
        }

        private void dfs(String s, int index) {
            if (index >= s.length()) {
                result.add(new ArrayList<>(list));
                return;
            }
            for (int i = index; i < s.length(); i++) {
                if (!is[index][i]) {
                    continue;
                }
                list.add(s.substring(index, i + 1));
                dfs(s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
