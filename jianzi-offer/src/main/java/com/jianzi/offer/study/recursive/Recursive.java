package com.jianzi.offer.study.recursive;

/**
 * 递归和循环
 * <p>
 * 重复计算相同的问题
 * <p>
 * 递归:只有数据规模不同,解法相同
 */
public class Recursive {
    /**
     * 递归求自然数和
     *
     * @param n
     * @return
     */
    public static int addToNRecursive(int n) {
        return (n <= 1) ? 1 : (n + addToNRecursive(n - 1));
    }

    /**
     * 循环求自然数和
     *
     * @param n
     * @return
     */
    public static int addToNFor(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
