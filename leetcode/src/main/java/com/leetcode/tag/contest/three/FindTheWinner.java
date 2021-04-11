package com.leetcode.tag.contest.three;

/**
 * 5727. 找出游戏的获胜者
 */
public class FindTheWinner {
    class Solution {
        public int findTheWinner(int n, int k) {
            boolean[] used = new boolean[n + 1];
            int i = 1;
            int nu = n;
            while (nu > 1) {
                int c = 0;
                int j = i % n + 1;
                for (; j < used.length; j++) {
                    if (used[i]) {
                        continue;
                    }
                    c++;
                    if (c == k - 1) {
                        break;
                    }
                }
                used[j] = true;
                nu--;
                i = j % n + 1;
            }

            for (int j = 1; j < used.length; j++) {
                if (!used[j]) {
                    return j;
                }
            }

            return 0;
        }
    }
}
