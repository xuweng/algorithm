package com.algorithm.study.algorithm.string;

import java.util.Objects;

/**
 * kmp算法
 * <p>
 * 多种解法
 */
public class Kmp {
    /**
     * 暴力穷举字符串匹配
     *
     * @param s 字符串
     * @param p 模式串
     * @return
     */
    public static int baoLi(String s, String p) {
        Objects.requireNonNull(s);
        Objects.requireNonNull(p);

        int result = -1;
        for (int i = 0; i <= s.length() - p.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i + j) != p.charAt(j)) {
                    break;
                } else {
                    result = j;
                }
            }

            if (result == p.length() - 1) {
                return i;
            }
        }

        return -1;
    }
}