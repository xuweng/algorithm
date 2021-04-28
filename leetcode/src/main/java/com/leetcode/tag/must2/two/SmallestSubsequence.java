package com.leetcode.tag.must2.two;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * 1081. 不同字符的最小子序列
 */
public class SmallestSubsequence {
    class Solution {
        public String smallestSubsequence(String s) {
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
