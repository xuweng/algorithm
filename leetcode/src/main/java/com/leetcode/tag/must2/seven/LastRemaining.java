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
                int index = (i + m) % list.size();
                list.remove(index);
                i = index;
            }

            return list.get(0);
        }
    }
}
