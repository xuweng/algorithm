package com.leetcode.tag.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class ValidParentheses {
    class Solution {
        public boolean isValid(String s) {
            if (s == null) {
                return false;
            }
            Stack<Character> stack = new Stack<>();
            Map<Character, Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('{', '}');
            map.put('[', ']');

            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    stack.push(s.charAt(i));
                } else {
                    if (stack.isEmpty() || map.get(stack.pop()) != s.charAt(i)) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }
    }
}
