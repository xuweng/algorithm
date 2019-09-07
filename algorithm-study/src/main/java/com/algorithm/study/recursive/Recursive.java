package com.algorithm.study.recursive;

/**
 * 递归
 */
public class Recursive {
    /**
     * factorial(5) 写作5!
     *
     * @param x
     * @return
     */
    public static int factorial(int x) {
        if (x == 1) {//基线条件,递归出口
            return 1;
        } else {//递归条件
            return x * factorial(x - 1);
        }
    }
}
