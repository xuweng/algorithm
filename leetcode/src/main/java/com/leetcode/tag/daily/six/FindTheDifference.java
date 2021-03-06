package com.leetcode.tag.daily.six;

import java.util.Arrays;

/**
 * 389. 找不同
 */
public class FindTheDifference {
    class Solution {
        public char findTheDifference(String s, String t) {
            for (int i = 0; i < t.length(); i++) {
                if (!s.contains(String.valueOf(t.charAt(i)))) {
                    return t.charAt(i);
                }
            }
            return t.charAt(0);
        }
    }

    class Solution1 {
        public char findTheDifference(String s, String t) {
            if (s.isEmpty()) {
                return t.charAt(0);
            }
            char[] chars = s.toCharArray();
            char[] chars1 = t.toCharArray();
            Arrays.sort(chars);
            Arrays.sort(chars1);

            for (int i = 0; i < chars1.length; i++) {
                if (i == s.length()) {
                    return chars1[i];
                }
                if (chars[i] != chars1[i]) {
                    return chars1[i];
                }
            }
            return t.charAt(0);
        }
    }

    /**
     * 方法一：计数
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-the-difference/solution/zhao-bu-tong-by-leetcode-solution-mtqf/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public char findTheDifference(String s, String t) {
            int[] cnt = new int[26];
            //首先遍历字符串 s，对其中的每个字符都将计数值加 1
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                cnt[ch - 'a']++;
            }
            //遍历字符串 t，对其中的每个字符都将计数值减 1
            for (int i = 0; i < t.length(); ++i) {
                char ch = t.charAt(i);
                cnt[ch - 'a']--;
                if (cnt[ch - 'a'] < 0) {
                    //当发现某个字符计数值为负数时，说明该字符在字符串 t 中出现的次数大于在字符串 s 中出现的次数
                    return ch;
                }
            }
            return ' ';
        }
    }

    /**
     * 方法二：求和
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-the-difference/solution/zhao-bu-tong-by-leetcode-solution-mtqf/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public char findTheDifference(String s, String t) {
            int as = 0, at = 0;
            //将字符串 s 中每个字符的 ASCII 码的值求和
            for (int i = 0; i < s.length(); ++i) {
                as += s.charAt(i);
            }
            for (int i = 0; i < t.length(); ++i) {
                at += t.charAt(i);
            }
            //两者的差值
            return (char) (at - as);
        }
    }

    /**
     * 方法三：位运算
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-the-difference/solution/zhao-bu-tong-by-leetcode-solution-mtqf/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution4 {
        /**
         * 如果将两个字符串拼接成一个字符串，则问题转换成求字符串中出现奇数次的字符
         *
         * @param s
         * @param t
         * @return
         */
        public char findTheDifference(String s, String t) {
            int ret = 0;
            for (int i = 0; i < s.length(); ++i) {
                ret ^= s.charAt(i);
            }
            for (int i = 0; i < t.length(); ++i) {
                ret ^= t.charAt(i);
            }
            return (char) ret;
        }
    }

}
