package com.leetcode.tag.daily.five;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 */
public class IsAnagram {
    /**
     * 方法一：排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * t 是 s 的异位词等价于「两个字符串排序后相等」
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            char[] str1 = s.toCharArray();
            char[] str2 = t.toCharArray();
            Arrays.sort(str1);
            Arrays.sort(str2);
            return Arrays.equals(str1, str2);
        }
    }

    /**
     * 方法二：哈希表
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            // 计数
            int[] table = new int[26];
            for (int i = 0; i < s.length(); i++) {
                table[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                table[t.charAt(i) - 'a']--;
                if (table[t.charAt(i) - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 哈希表
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        /**
         * Unicode 中可能存在一个字符对应多个字节的问题
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            //核心点在于「字符是离散未知的」，因此我们用哈希表维护对应字符的频次即可
            Map<Character, Integer> table = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                table.put(ch, table.getOrDefault(ch, 0) + 1);
            }
            for (int i = 0; i < t.length(); i++) {
                char ch = t.charAt(i);
                table.put(ch, table.getOrDefault(ch, 0) - 1);
                if (table.get(ch) < 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
