package com.leetcode.tag.daily.three;

import java.util.Arrays;

/**
 * 771. 宝石与石头
 */
public class NumJewelsInStones {
    static class Solution {
        public int numJewelsInStones(String J, String S) {
            boolean[] Jb = new boolean[100];
            int[] Sb = new int[100];
            Arrays.fill(Jb, false);
            Arrays.fill(Sb, -1);
            for (char c : J.toCharArray()) {
                int index = c - '0';
                Jb[index] = true;
            }
            for (char c : S.toCharArray()) {
                int index = c - '0';
                if (Jb[index]) {
                    Sb[index]++;
                }
            }
            return Arrays.stream(Sb).filter(i -> i != -1).sum();
        }
    }
}
