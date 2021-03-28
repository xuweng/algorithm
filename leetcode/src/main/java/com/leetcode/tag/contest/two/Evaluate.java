package com.leetcode.tag.contest.two;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 5714. 替换字符串中的括号内容
 */
public class Evaluate {
    class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            Map<String, String> map = new HashMap<>();
            for (List<String> strings : knowledge) {
                map.put(strings.get(0), strings.get(1));
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                int left = i;
                if (s.charAt(i) == '(') {
                    left = i + 1;
                }
                int right = left;
                if (right > i) {
                    while (s.charAt(right) != ')') {
                        right++;
                    }
                    String substring = s.substring(left, right);
                    result.append(map.getOrDefault(substring, "?"));

                    i = right;
                } else {
                    result.append(s.charAt(i));
                }
            }

            return result.toString();
        }
    }
}
