package com.jianzi.offer.study.recursive;

/**
 * 递归和循环
 * <p>
 * 重复计算相同的问题
 * <p>
 * 递归:只有数据规模不同,解法相同
 * <p>
 * 递归：重复计算、栈溢出
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

    /**
     * 递归求解斐波那数列
     * <p>
     * 用递归树分析：很多重复计算，而且重复的结点随n的增大会急剧增大，恐怖；递归的复杂度是n的指数，恐怖
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
