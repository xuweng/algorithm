package com.leetcode.tag.daily.six;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 */
public class IsIsomorphic {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> map = new HashMap<>();
            Map<Character, Character> map1 = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
                if (map1.containsKey(t.charAt(i)) && map1.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
                map1.put(t.charAt(i), s.charAt(i));
            }

            return true;
        }
    }

    class Solution1 {
        public boolean isIsomorphic(String s, String t) {
            char[] chars = s.toCharArray();
            char[] chart = t.toCharArray();
            int[] preIndexOfs = new int[256];
            int[] preIndexOft = new int[256];
            for (int i = 0; i < chars.length; i++) {
                if (preIndexOfs[chars[i]] != preIndexOft[chart[i]]) {
                    return false;
                }
                preIndexOfs[chars[i]] = i + 1;
                preIndexOft[chart[i]] = i + 1;
            }
            return true;
        }
    }
}
