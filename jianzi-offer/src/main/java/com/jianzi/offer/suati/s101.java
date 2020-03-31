package com.jianzi.offer.suati;

/**
 * 递归法
 * 记忆化递归法
 * 动态规划
 * <p>
 * 面试题10- I. 斐波那契数列
 */
public class s101 {
    /**
     * 超出时间限制
     *
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 大数越界
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int i = 0, j = 1;
        int result = 0;
        for (int k = 2; k <= n; k++) {
            result = i + j;
            i = j;
            j = result;
        }
        return result;

    }

    /**
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/solution/mian-shi-ti-10-i-fei-bo-na-qi-shu-lie-dong-tai-gui/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

}
