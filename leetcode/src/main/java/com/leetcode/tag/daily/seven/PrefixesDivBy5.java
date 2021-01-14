package com.leetcode.tag.daily.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀
 */
public class PrefixesDivBy5 {
    class Solution {
        public List<Boolean> prefixesDivBy5(int[] A) {
            if (A == null || A.length == 0) {
                return null;
            }
            List<Boolean> result = new ArrayList<>();
            String s = "";
            for (int i : A) {
                s += i;
                result.add(Integer.parseInt(s, 2) % 5 == 0);
            }

            return result;
        }
    }
}
