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
                    // i是root.
                    if (i == 0 && n > 1) {
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

    class Solution1 {
        public int[] numsSameConsecDiff(int n, int k) {
            List<Integer> ans = new ArrayList<>();
            dfs(ans, 0, n, k, 0, 0);

            if (n == 1) {
                ans.add(0);
            }
            return ans.stream().mapToInt(an -> an).toArray();
        }

        public void dfs(List<Integer> ans, int index, int n, int k, int end, int num) {
            if (index == n) {
                ans.add(num);
                return;
            }
            if (index == 0) {
                for (int i = 1; i <= 9; i++) {
                    dfs(ans, index + 1, n, k, i, i);
                }
            } else {
                if (end >= k) {
                    dfs(ans, index + 1, n, k, end - k, num * 10 + end - k);
                }
                if (k != 0 && end + k <= 9) {
                    dfs(ans, index + 1, n, k, end + k, num * 10 + end + k);
                }
            }
        }

    }
}
