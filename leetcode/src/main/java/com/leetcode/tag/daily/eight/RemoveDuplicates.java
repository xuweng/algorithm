package com.leetcode.tag.daily.eight;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1047. 删除字符串中的所有相邻重复项
 */
public class RemoveDuplicates {
    class Solution {
        public String removeDuplicates(String S) {
            if (S == null || S.isEmpty()) {
                return S;
            }
            Deque<Character> deque = new LinkedList<>();
            for (int i = 0; i < S.length(); i++) {
                if (!deque.isEmpty() && deque.peek() == S.charAt(i)) {
                    deque.pop();
                } else {
                    deque.push(S.charAt(i));
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : deque) {
                stringBuilder.append(character);
            }
            return stringBuilder.reverse().toString();
        }
    }
}
