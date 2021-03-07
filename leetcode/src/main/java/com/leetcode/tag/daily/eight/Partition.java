package com.leetcode.tag.daily.eight;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 */
public class Partition {
    class Solution {
        List<List<String>> list = new ArrayList<>();
        List<String> stack = new ArrayList<>();

        public List<List<String>> partition(String s) {
            if (s == null || s.isEmpty()) {
                return null;
            }

            back(s, 0);

            return list;
        }

        private void back(String s, int start) {
            if (start >= s.length()) {
                list.add(new ArrayList<>(stack));

                return;
            }
            for (int i = start; i < s.length(); i++) {
                String substring = s.substring(start, i + 1);
                if (!check(substring)) {
                    continue;
                }

                stack.add(substring);
                back(s, i + 1);
                stack.remove(stack.size() - 1);
            }
        }

        private boolean check(String s) {
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }

    }
}
