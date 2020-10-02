package com.leetcode.tag.daily.three;

import java.util.Arrays;

/**
 * 771. 宝石与石头
 */
public class NumJewelsInStones {
    class Solution {
        public int numJewelsInStones(String J, String S) {
            boolean[] Jb = new boolean[100];
            int[] Js = new int[100];
            Arrays.fill(Jb, false);
            Arrays.fill(Js, -1);
            for (char c : J.toCharArray()) {
                int index = c - '0';
                Jb[index] = true;
            }
            for (char c : S.toCharArray()) {
                int index = c - '0';
                if (Jb[index]) {
                    Js[index]++;
                }
            }
            return Arrays.stream(Js).filter(i -> i != -1).sum();
        }
    }
}
