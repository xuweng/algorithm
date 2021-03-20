package com.leetcode.tag.daily.eight;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 150. 逆波兰表达式求值
 */
public class EvalRPN {
    class Solution {
        Deque<Integer> deque = new LinkedList<>();

        public int evalRPN(String[] tokens) {
            if (tokens == null || tokens.length == 0) {
                return 0;
            }
            for (String token : tokens) {
                switch (token) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        compute(token);
                        break;
                    default:
                        deque.push(Integer.valueOf(token));
                        break;
                }
            }

            return deque.pop();
        }

        private void compute(String token) {
            Integer j = deque.pop();
            Integer i = deque.pop();
            if (Objects.equals(token, "+")) {
                deque.push(i + j);
            } else if (Objects.equals(token, "-")) {
                deque.push(i - j);
            } else if (Objects.equals(token, "*")) {
                deque.push(i * j);
            } else if (Objects.equals(token, "/")) {
                deque.push(i / j);
            }
        }
    }
}
