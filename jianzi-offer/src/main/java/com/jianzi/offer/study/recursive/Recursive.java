package com.jianzi.offer.study.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归和循环
 * <p>
 * 不同的解法,不同的时间复杂度
 * <p>
 * 重复计算相同的问题
 * <p>
 * 递归:只有数据规模不同,解法相同
 * <p>
 * 递归：重复计算、栈溢出
 */
public class Recursive {
    public static final Map<Integer, Long> map = new HashMap<>();

    /**
     * 递归求自然数和
     * <p>
     * 时间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public static int addToNRecursive(int n) {
        return (n <= 1) ? 1 : (n + addToNRecursive(n - 1));
    }

    /**
     * 循环求自然数和
     * <p>
     * 时间复杂度：O(n)
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
     * 时间复杂度：n的指数
     * <p>
     * 用递归树分析：很多重复计算，而且重复的结点随n的增大会急剧增大，恐怖；递归的复杂度是n的指数，恐怖
     * <p>
     * 解决重复计算：保存已经计算的值
     *
     * @param n
     * @return
     */
    public static long fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            long value = fibonacci(n - 1) + fibonacci(n - 2);
            map.put(n, value);
            return value;
        }
    }

    /**
     * 循环求解斐波那数列
     * <p>
     * 时间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public static long fibonacciFor(int n) {
        int result[] = {1, 2};
        if (n < 2) {
            return result[n];
        }
        long one = 1;
        long two = 0;
        long fn = 0;

        for (int i = 2; i <= n; i++) {
            fn = one + two;
            two = one;
            one = fn;
        }
        return fn;
    }
}
