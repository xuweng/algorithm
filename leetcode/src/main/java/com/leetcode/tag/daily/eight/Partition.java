package com.leetcode.tag.daily.eight;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 */
public class Partition {
    class Solution {
        List<List<String>> list = new ArrayList<>();
        Deque<String> deque = new LinkedList<>();

        public List<List<String>> partition(String s) {
            if (s == null || s.isEmpty()) {
                return null;
            }

            back(s, 0);

            return list;
        }

        private void back(String s, int start) {
            if (start >= s.length()) {
                list.add(new ArrayList<>(deque));

                return;
            }
            for (int i = start; i < s.length(); i++) {
                String substring = s.substring(start, i + 1);
                if (!check(substring)) {
                    continue;
                }

                deque.push(substring);
                back(s, i + 1);
                deque.pop();
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
