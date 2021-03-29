package com.leetcode.tag.must.four;

/**
 * 7. 整数反转
 */
public class Reverse {
    class Solution {
        public int reverse(int x) {
            int y = 0;
            while (x != 0) {
                // 最大的值与最小的值为：[−2^31, 2^31 − 1]即：[-2147483648, 2147483647]
                // 如果y = y * 10 + x % 10溢出，则 y>=214748364 ，
                // 当y=214748364时，输入的值只能为：1463847412，此时不溢出
                // 即：y > 214748364 || y < -214748364 必定溢出
                if (y > 214748364 || y < -214748364) {
                    return 0;
                }
                y = y * 10 + x % 10;
                x = x / 10;
            }
            return y;
        }
    }
}
