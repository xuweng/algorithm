package com.leetcode.tag.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 */
public class IsValid {
    class Solution {
        public boolean isValid(String s) {
            if (s == null || s.isEmpty()) {
                return true;
            }
            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');
            Deque<Character> deque = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                if (!map.containsKey(s.charAt(i))) {
                    deque.push(s.charAt(i));
                } else {
                    if (deque.isEmpty() || !map.get(s.charAt(i)).equals(deque.peek())) {
                        return false;
                    }
                    deque.poll();
                }
            }

            return deque.isEmpty();
        }
    }
}
