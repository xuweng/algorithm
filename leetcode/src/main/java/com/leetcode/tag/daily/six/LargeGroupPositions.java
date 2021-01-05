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
            int preIndex = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(preIndex)) {
                    int count = i - preIndex;
                    if (count >= 3) {
                        List<Integer> list = new ArrayList<>();
                        list.add(preIndex);
                        list.add(i - 1);

                        result.add(list);
                    }
                    preIndex = i;
                }
            }

            return result;
        }
    }
}
