package com.leetcode.tag.backtracking.two;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 */
public class Partition {
    class Solution {
        Deque<String> deque = new LinkedList<>();
        List<List<String>> result = new ArrayList<>();

        public List<List<String>> partition(String s) {
            back(s, 0);

            return result;
        }

        /**
         * index 是层次
         *
         * @param s
         * @param index
         */
        private void back(String s, int index) {
            if (index >= s.length()) {
                result.add(new ArrayList<>(deque));
                return;
            }
            for (int i = index; i < s.length(); i++) {
                if (!isHui(s, index, i)) {
                    continue;
                }
                String substring = s.substring(index, i + 1);
                deque.offerLast(substring);
                back(s, i + 1);
                deque.pollLast();
            }
        }

        private boolean isHui(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }

            return true;
        }
    }
}
