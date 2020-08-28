package com.leetcode.tag.daily.two;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 657. 机器人能否返回原点
 */
public class JudgeCircle {
    class Solution {
        public boolean judgeCircle(String moves) {
            if (moves == null) {
                return false;
            }

            Map<Character, Integer> map = new HashMap<>(32);

            for (int i = 0; i < moves.length(); i++) {
                map.put(moves.charAt(i), map.getOrDefault(moves.charAt(i), 0) + 1);
            }
            boolean result = false;
            if (map.containsKey('R') || map.containsKey('L')) {
                result = Objects.equals(map.getOrDefault('R', -1), map.getOrDefault('L', -2));
            }
            if (map.containsKey('U') || map.containsKey('D')) {
                result = result || Objects.equals(map.getOrDefault('U', -1), map.getOrDefault('D', -2));
            }

            return result;
        }
    }
}
