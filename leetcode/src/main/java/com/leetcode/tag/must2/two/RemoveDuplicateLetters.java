package com.leetcode.tag.must2.two;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * 316. 去除重复字母
 */
public class RemoveDuplicateLetters {
    /**
     * 方法一：贪心 + 单调栈
     */
    class Solution {
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
     * 返回结果的字典序最小
     * <p>
     * 单调栈来维护去除「关键字符」后得到的字符串，单调栈满足栈底到栈顶的字符递增
     * <p>
     * 单调递增栈
     */
    class Solution1 {
        public String removeDuplicateLetters(String s) {
            char[] chars = s.toCharArray();
            int[] lastInx = new int[26];
            for (int i = 0; i < chars.length; i++) {
                // 不断覆盖下标
                // 记录每个元素最后一次出现的位置
                lastInx[chars[i] - 'a'] = i;
            }
            // 单调递增栈
            // 栈保存无重复,字典序更小的
            Deque<Character> stack = new LinkedList<>();
            //某一个字符是否在栈中出现
            boolean[] visited = new boolean[26];
            for (int i = 0; i < chars.length; i++) {
                //如果出现舍弃当前字符
                if (visited[chars[i] - 'a']) {
                    continue;
                }
                // 输入：s = "cbacdcbc"
                // 输出："acdb"
                // d只有一个，后面没有d，d不能删除
                // 后面有c，b
                // 当前字符在栈顶元素之前，且栈顶元素在后面还有
                // 只有栈顶元素在当前i的后面还有才能删除栈顶元素 删除重复元素
                while (!stack.isEmpty() && stack.peekLast() > chars[i] && lastInx[stack.peekLast() - 'a'] > i) {
                    // i后面出现栈顶元素.此条件必须.
                    // 移除栈顶元素
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
