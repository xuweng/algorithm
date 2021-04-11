package com.leetcode.tag.contest.three;

/**
 * 5727. 找出游戏的获胜者
 */
public class FindTheWinner {
    class Solution {
        public int findTheWinner(int n, int k) {
            boolean[] used = new boolean[n + 1];
            int c = n;
            while (c > 1) {
                int i = 1;
                while (i <= n) {
                    int next = (i + k - 1) % (n + 1);
                    if (used[next]) {
                        continue;
                    }
                    used[next] = true;
                    c--;
                    i = (next + 1) % (n + 1);
                }
            }
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    return i;
                }
            }

            return 0;
        }
    }
}
