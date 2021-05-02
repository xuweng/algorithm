package com.leetcode.tag.must2.seven;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 翻转字符串里的单词
 * <p>
 * 依赖上一层 倒序
 * <p>
 * 依赖本层 正序
 * <p>
 * 倒序 倒序 倒序
 * <p>
 * 正序 正序 正序
 */
public class ReverseWords {
    class Solution {
        public String reverseWords(String s) {
            // 除去开头和末尾的空白字符
            s = s.trim();
            // 正则匹配连续的空白字符作为分隔符分割
            // 使用 split 将字符串按空格分割成字符串数组
            List<String> wordList = Arrays.asList(s.split("\\s+"));
            // 用 reverse 将字符串数组进行反转；
            Collections.reverse(wordList);
            // 使用 join 方法将字符串数组拼成一个字符串 拼接上空格
            return String.join(" ", wordList);
        }
    }
}
