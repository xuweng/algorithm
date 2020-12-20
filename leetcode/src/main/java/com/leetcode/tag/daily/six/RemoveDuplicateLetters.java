package com.leetcode.tag.daily.six;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * 316. 去除重复字母
 */
public class RemoveDuplicateLetters {
    /**
     * 算法错误 算法错误 算法错误 算法错误
     * <p>
     * 返回结果的字典序最小
     */
    class Solution {
        public String removeDuplicateLetters(String s) {
            if (s == null || s.isEmpty()) {
                return s;
            }
            char[] chars = new char[26];
            for (int i = 0; i < s.length(); i++) {
                chars[s.charAt(i) - 'a']++;
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != 0) {
                    result.append((char) (i + 'a'));
                }
            }
            return result.toString();
        }
    }

    /**
     * 方法一：贪心 + 栈
     * <p>
     * 看视频 看视频 看视频 看视频 看视频 看视频 看视频 看视频 看视频 看视频 看视频
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters/solution/qu-chu-zhong-fu-zi-mu-by-leetcode-soluti-vuso/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public String removeDuplicateLetters(String s) {
            boolean[] vis = new boolean[26];
            int[] num = new int[26];
            for (int i = 0; i < s.length(); i++) {
                num[s.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!vis[ch - 'a']) {
                    while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                        if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                            vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                            sb.deleteCharAt(sb.length() - 1);
                        } else {
                            break;
                        }
                    }
                    vis[ch - 'a'] = true;
                    sb.append(ch);
                }
                num[ch - 'a'] -= 1;
            }
            return sb.toString();
        }
    }

    /**
     * 方法一：贪心 + 栈
     */
    class Solution2 {
        public String removeDuplicateLetters(String s) {
            char[] chars = s.toCharArray();
            int[] lastInx = new int[26];
            for (int i = 0; i < chars.length; i++) {
                // 不断覆盖下标
                // 记录每个元素最后一次出现的位置
                lastInx[chars[i] - 'a'] = i;
            }
            Deque<Character> stack = new ArrayDeque<>();
            //某一个字符是否在栈中出现
            boolean[] visited = new boolean[26];
            for (int i = 0; i < chars.length; i++) {
                //如果出现舍弃当前字符
                if (visited[chars[i] - 'a']) {
                    continue;
                }
                //当前字符在栈顶元素之前，且栈顶元素在后面还有
                while (!stack.isEmpty() && stack.peekLast() > chars[i] && lastInx[stack.peekLast() - 'a'] > i) {
                    //移除栈顶元素
                    Character c = stack.removeLast();
                    //表示该字符没有在栈中出现
                    visited[c - 'a'] = false;
                }
                // 入栈
                stack.addLast(chars[i]);
                visited[chars[i] - 'a'] = true;
            }
            return stack.stream().map(String::valueOf).collect(Collectors.joining());
        }
    }

}
