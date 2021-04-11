package com.leetcode.tag.must.five;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 */
public class DiffWaysToCompute {
    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < expression.length(); i++) {
                if (Character.isDigit(expression.charAt(i))) {
                    continue;
                }
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (Integer l : left) {
                    for (Integer r : right) {
                        if (expression.charAt(i) == '+') {
                            result.add(l + r);
                        } else if (expression.charAt(i) == '-') {
                            result.add(l - r);
                        } else if (expression.charAt(i) == '*') {
                            result.add(l * r);
                        }
                    }
                }
                if (result.isEmpty()) {
                    result.add(Integer.parseInt(expression));
                }
            }
            return result;
        }
    }
}