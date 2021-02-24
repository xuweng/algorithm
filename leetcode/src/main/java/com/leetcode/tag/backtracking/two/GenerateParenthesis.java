package com.leetcode.tag.backtracking.two;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class GenerateParenthesis {
    class Solution {
        Deque<String> deque = new LinkedList<>();
        List<String> result = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            back(n, n);

            return result;
        }

        private void back(int left, int right) {
            if (left < 0 || right < 0) {
                return;
            }
            if (left > right) {
                return;
            }
            if (left == 0 && right == 0) {
                StringBuilder temp = new StringBuilder();
                for (String s : deque) {
                    temp.append(s);
                }
                result.add(temp.reverse().toString());

                return;
            }
            deque.push("(");
            back(left - 1, right);
            deque.pop();

            deque.push(")");
            back(left, right - 1);
            deque.pop();
        }
    }
}
