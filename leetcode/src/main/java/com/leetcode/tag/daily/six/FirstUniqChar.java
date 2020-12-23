package com.leetcode.tag.daily.six;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 */
public class FirstUniqChar {
    static class Solution {
        public int firstUniqChar(String s) {
            if (s == null || s.isEmpty()) {
                return -1;
            }
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            char c = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Character k = entry.getKey();
                Integer v = entry.getValue();
                if (v == 1) {
                    c = k;
                    break;
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    return i;
                }
            }
            return -1;
        }
    }

    /**
     * 方法一：使用哈希表存储频数
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-zi-x9rok/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int firstUniqChar(String s) {
            Map<Character, Integer> frequency = new HashMap<>();
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
            }
            for (int i = 0; i < s.length(); ++i) {
                if (frequency.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    /**
     * 方法二：使用哈希表存储索引
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-zi-x9rok/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int firstUniqChar(String s) {
            Map<Character, Integer> position = new HashMap<>();
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                char ch = s.charAt(i);
                position.put(ch, position.containsKey(ch) ? -1 : i);
            }
            int first = n;
            for (Map.Entry<Character, Integer> entry : position.entrySet()) {
                int pos = entry.getValue();
                if (pos != -1 && pos < first) {
                    first = pos;
                }
            }
            if (first == n) {
                first = -1;
            }
            return first;
        }
    }

}
