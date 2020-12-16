package com.leetcode.tag.daily.six;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 */
public class WordPattern {
    /**
     * 方法一：哈希表
     * <p>
     * 用示例理解代码 用示例理解代码 用示例理解代码 用示例理解代码
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/word-pattern/solution/dan-ci-gui-lu-by-leetcode-solution-6vqv/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public boolean wordPattern(String pattern, String str) {
            //这种关系被称为「双射」。
            //任意一个字符串也只被唯一的一个字符对应
            Map<String, Character> str2ch = new HashMap<>();
            //任意一个字符都对应着唯一的字符串
            Map<Character, String> ch2str = new HashMap<>();
            int m = str.length();
            int i = 0;
            //枚举pattern 中的每一个字符
            for (int p = 0; p < pattern.length(); ++p) {
                //利用双指针来均摊线性地找到该字符在 str 中对应的字符串
                char ch = pattern.charAt(p);
                if (i >= m) {
                    return false;
                }
                int j = i;
                while (j < m && str.charAt(j) != ' ') {
                    j++;
                }
                // 按照空格截取单词
                String tmp = str.substring(i, j);
                if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                    return false;
                }
                if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                    return false;
                }
                str2ch.put(tmp, ch);
                ch2str.put(ch, tmp);
                i = j + 1;
            }
            return i >= m;
        }
    }

}
