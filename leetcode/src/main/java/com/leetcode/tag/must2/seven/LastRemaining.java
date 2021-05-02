package com.leetcode.tag.must2.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * <p>
 * 单调队列 单调栈 一一对应
 * <p>
 * api api api
 */
public class LastRemaining {
    class Solution {
        public int lastRemaining(int n, int m) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int i = 0;
            while (list.size() != 1) {
                int index = (i + m - 1) % list.size();
                list.remove(index);
                i = index;
            }

            return list.get(0);
        }
    }

    /**
     * 方法一：数学 + 递归
     * <p>
     * 长度为 n 的序列会先删除第 m % n 个元素，然后剩下一个长度为 n - 1 的序列
     */
    class Solution1 {
        public int lastRemaining(int n, int m) {
            return f(n, m);
        }

        public int f(int n, int m) {
            if (n == 1) {
                return 0;
            }
            int x = f(n - 1, m);
            // 长度为 n 的序列最后一个删除的元素，应当是从 m % n 开始数的第 x 个元素
            return (m + x) % n;
        }
    }

    /**
     * 方法二：数学 + 迭代
     */
    class Solution2 {
        public int lastRemaining(int n, int m) {
            int f = 0;
            for (int i = 2; i != n + 1; ++i) {
                f = (m + f) % i;
            }
            return f;
        }
    }
}
