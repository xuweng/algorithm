package com.leetcode.tag.must5.six;

/**
 * 1881. 插入后的最大值
 */
public class MaxValue {
    class Solution {
        public String maxValue(String n, int x) {
            if (n.charAt(0) == '-') {
                // 如果 n 是负数，那么根据 提示 3，我们需要寻找 n 中第一个比 x 大的位置。
                // 如果存在，则返回对应的插入后字符串；如果不存在，则返回 x 插入 n 结尾对应的字符串
                for (int i = 1; i < n.length(); i++) {
                    if (n.charAt(i) - '0' > x) {
                        return n.substring(0, i) + x + n.substring(i);
                    }
                }
            } else {
                // 如果 n 是正数，类似地，我们需要寻找 n 中第一个比 x 小的位置。
                // 如果存在，则返回对应的插入后字符串；如果不存在，则返回 x 插入 n 结尾对应的字符串
                for (int i = 0; i < n.length(); i++) {
                    if (n.charAt(i) - '0' < x) {
                        return n.substring(0, i) + x + n.substring(i);
                    }
                }
            }
            // 如果不存在
            return n + x;
        }
    }
}
