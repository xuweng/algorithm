package com.leetcode.tag.daily.six;

import java.util.ArrayList;
import java.util.List;

/**
 * 830. 较大分组的位置
 */
public class LargeGroupPositions {
    class Solution {
        public List<List<Integer>> largeGroupPositions(String s) {
            if (s == null || s.isEmpty()) {
                return null;
            }

            List<List<Integer>> result = new ArrayList<>();
            int houIndex = s.length() - 1;
            for (int i = s.length() - 2; i >= 0; i--) {
                if (s.charAt(i) != s.charAt(houIndex)) {
                    int count = houIndex - i;
                    if (count >= 3) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i + 1);
                        list.add(houIndex);

                        result.add(list);
                    }
                    houIndex = i;
                }
            }

            return result;
        }
    }
}
