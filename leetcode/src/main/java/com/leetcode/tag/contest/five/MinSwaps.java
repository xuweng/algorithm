package com.leetcode.tag.contest.five;

import java.util.Arrays;

/**
 * 5760. 构成交替字符串需要的最小交换次数
 */
public class MinSwaps {
    class Solution {
        public int minSwaps(String s) {
            char[] arr = s.toCharArray();
            int num1 = 0, num0 = 0;
            for (char c : arr) {
                if (c == '0') {
                    num0++;
                } else {
                    num1++;
                }
            }
            // |'1'的数量 - '0'的数量| <= 1
            if (Math.abs(num0 - num1) > 1) {
                return -1;
            }
            if (num0 > num1) {
                // 0开头
                return getSum(arr, '1');
            }
            if (num1 > num0) {
                // 1开头
                return getSum(arr, '0');
            }
            // 取0开头和1开头的min值
            return Math.min(getSum(arr, '0'), getSum(arr, '1'));
        }

        // even: 偶数位需要替换的字符
        // 若是'1'开始，那么当偶数位为'0'时需要替换
        // 若是'0'开始，那么当偶数位为'1'时需要替换
        private int getSum(char[] arr, char even) {
            // 从哪个下标开始替换
            // 注：假设偶数都为'1' 则 需要把奇数位的'1'和偶数位的'0'进行交换
            int index = 1;
            int res = 0;
            // 注意：i+=2
            for (int i = 0; i < arr.length; i += 2) {
                if (arr[i] == even) {
                    while (index < arr.length && arr[index] == even) {
                        // 注意：index+=2
                        index += 2;
                    }
                    res++;
                    /*
                     * 假设在这里替换了，那么替换完需要index需要来到index+2的地方 方便下一次循环
                     * 因为题目中只是要交换次数 而不需要返回替换完成的交替字符串 那么交换过程可以省略
                     * 只需要用两个下标来记录'交换到哪'即可
                     * */
                    index += 2;
                }
            }
            return res;
        }
        // 以下为示例：
        // 111100000   1:4个 0:5个
        // i    取值：0 2 4 6 8
        // index取值：1 3 5 7 9

        // i=0 需要替换 找到第一个值为0的下标5 （不是4 每次+2）
        // arr[0]和arr[5]交换 sum=1; 011101000

        // i=2 需要交换 找到下一个值为0的下标7
        // arr[2]和arr[7]交换 sum=2; 010101010

        // 结束 sum=2 需要交换2次
    }

    class Solution1 {
        public int minSwaps(String s) {
            char[] chars = s.toCharArray();
            int n = s.length();
            // 初始化两种目标串
            char[] a = new char[n];
            Arrays.fill(a, '0');
            char[] b = new char[n];
            Arrays.fill(b, '0');

            // 无非就两种情况，
            // 一种是'1'在第一位例如"101010..."
            for (int i = 0; i < n; i += 2) {
                // 偶数
                a[i] = '1';
            }
            // 第二种是 '1'在第二位,比如"010101...."
            for (int i = 1; i < n; i += 2) {
                // 奇数
                b[i] = '1';
            }
            // 比较原串到两种目标串需要移动的次数，取最小值
            int res = Math.min(getValue(chars, a), getValue(chars, b));
            if (res == Integer.MAX_VALUE) {
                // 说明不是两种情况
                return -1;
            }
            return res;
        }

        private int getValue(char[] chars, char[] b) {
            int count0 = 0;
            int count1 = 0;
            // "111000" -> "101010"
            for (int i = 0; i < chars.length; i++) {
                // 跟目标串不同的情况下，说明当前位置错了
                if (chars[i] != b[i]) {
                    // 分别统计'0', '1'的错误次数，两种的错误次数一样的情况下才有解，解就是他们的错误次数
                    if (chars[i] == '0') {
                        count0++;
                    } else {
                        count1++;
                    }
                }
            }
            // 错误次数不一样的情况下是无解的，'0' '1' 必须是成对存在的，比如'1'错误了2次，'0'错误了一次，无论怎么交换都不行
            if (count0 != count1) {
                return Integer.MAX_VALUE;
            }
            return count0;
        }
    }
}
