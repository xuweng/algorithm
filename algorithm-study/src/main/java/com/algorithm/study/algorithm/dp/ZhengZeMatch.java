package com.algorithm.study.algorithm.dp;

/**
 * 正则表达式匹配
 */
public class ZhengZeMatch {
    /**
     * 递归正则表达式匹配
     *
     * @param s
     * @param p
     * @param sIndex
     * @param pIndex
     * @return
     */
    public static boolean isMatchRe(String s, String p, int sIndex, int pIndex) {
        if (sIndex < 0 && sIndex <= pIndex) {
            return true;
        }
        if (sIndex < 0 || pIndex < 0) {
            return false;
        }

        boolean match = (s.charAt(sIndex) == p.charAt(pIndex)) ||
                (p.charAt(pIndex) == '.') ||
                (((pIndex >= 1) && p.charAt(pIndex) == '*') && (p.charAt(pIndex - 1) == '.' || s.charAt(sIndex) == p.charAt(pIndex - 1)));

        return match && isMatchRe(s, p, sIndex - 1, pIndex - 1);
    }
}
