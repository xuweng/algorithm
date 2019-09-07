package com.algorithm.study.recursive;

/**
 * 递归
 */
public class Recursive {
    /**
     * factorial(5) 写作5!
     * 分：x和x-1
     * 复杂度：O(n)
     *
     * @param x 当前数据
     * @return
     */
    public static int factorial(int x) {
        if (x == 1) {//基线条件,递归出口
            return 1;
        } else {//递归条件
            return x * factorial(x - 1);
        }
    }

    /**
     * 累加
     * 分：index和index-1
     * 复杂度：O(n)
     *
     * @param array
     * @param index 当前索引
     * @return
     */
    public static int sum(Integer[] array, int index) {
        if (index == 0) {//基线条件,递归出口
            return array[index];
        } else {//递归条件
            return array[index] + sum(array, index - 1);
        }
    }

    /**
     * 查找最大值
     * 分：index和index-1
     * 复杂度：O(n)
     *
     * @param array
     * @param index 当前索引
     * @return
     */
    public static int maxValue(Integer[] array, int index) {
        if (index == 0) {//基线条件,递归出口
            return array[index];
        } else {//递归条件
            int nextValue = maxValue(array, index - 1);
            return (array[index] >= nextValue) ? array[index] : nextValue;
        }
    }
}
