package com.leetcode.tag.dfs.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 967. 连续差相同的数字
 */
public class NumsSameConsecDiff {
    class Solution {
        List<Integer> result = new ArrayList<>();


        public int[] numsSameConsecDiff(int n, int k) {
            dfs(n, k, -1, "");

            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        private void dfs(int n, int k, int pre, String temp) {
            if (temp.length() > n) {
                return;
            }
            if (temp.length() == n) {
                result.add(Integer.parseInt(temp));
                return;
            }
            for (int i = 0; i <= 9; i++) {
                if (pre == -1) {
                    if (i == 0) {
                        continue;
                    }
                } else {
                    if (Math.abs(pre - i) != k) {
                        continue;
                    }
                }
                dfs(n, k, i, temp + i);
            }
        }
    }
}
