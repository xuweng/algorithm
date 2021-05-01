package com.leetcode.tag.must2.six;

import java.util.*;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 */
public class FirstUniqChar {
    /**
     * 方法一：使用哈希表存储频数
     */
    class Solution {
        public char firstUniqChar(String s) {
            Map<Character, Integer> frequency = new HashMap<>();
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
            }
            for (int i = 0; i < s.length(); ++i) {
                if (frequency.get(s.charAt(i)) == 1) {
                    return s.charAt(i);
                }
            }
            return ' ';
        }
    }

    /**
     * 方法三：队列
     */
    class Solution1 {
        public char firstUniqChar(String s) {
            Map<Character, Integer> position = new HashMap<>();
            Queue<Pair> queue = new LinkedList<>();
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                char ch = s.charAt(i);
                if (!position.containsKey(ch)) {
                    position.put(ch, i);
                    queue.offer(new Pair(ch, i));
                } else {
                    position.put(ch, -1);
                    while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                        queue.poll();
                    }
                }
            }
            return queue.isEmpty() ? ' ' : queue.poll().ch;
        }

        class Pair {
            char ch;
            int pos;

            Pair(char ch, int pos) {
                this.ch = ch;
                this.pos = pos;
            }
        }
    }

    class Solution2 {
        public char firstUniqChar(String s) {
            HashMap<Character, Boolean> dic = new HashMap<>();
            char[] sc = s.toCharArray();
            for (char c : sc) {
                dic.put(c, !dic.containsKey(c));
            }
            for (char c : sc) {
                if (dic.get(c)) {
                    return c;
                }
            }
            return ' ';
        }
    }

    class Solution3 {
        public char firstUniqChar(String s) {
            Map<Character, Boolean> dic = new LinkedHashMap<>();
            char[] sc = s.toCharArray();
            for (char c : sc) {
                dic.put(c, !dic.containsKey(c));
            }
            for (Map.Entry<Character, Boolean> d : dic.entrySet()) {
                if (d.getValue()) {
                    return d.getKey();
                }
            }
            return ' ';
        }
    }
}
