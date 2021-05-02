package com.leetcode.tag.must2.seven;

/**
 * 剑指 Offer 67. 把字符串转换成整数
 */
public class StrToInt {
    /**
     * 根据题意，有以下四种字符需要考虑：
     * <p>
     * 1.首部空格： 删除之即可；
     * 2.符号位： 三种情况，即 ''+'' , ''−'' , ''无符号" ；新建一个变量保存符号位，返回前判断正负即可。
     * 3.非数字字符： 遇到首个非数字的字符时，应立即返回。
     * 4.数字字符：
     * 字符转数字： “此数字的 ASCII 码” 与 “ 0 的 ASCII 码” 相减即可；
     * 数字拼接： 若从左向右遍历数字，设当前位字符为 c ，当前位数字为 x ，数字结果为 res ，则数字拼接公式为：
     * res = 10 * res + x
     * x = ascii(c) - ascii('0')
     */
    class Solution {
        public int strToInt(String str) {
            // 首部空格： 删除
            char[] c = str.trim().toCharArray();
            if (c.length == 0) {
                return 0;
            }
            int res = 0, bndry = Integer.MAX_VALUE / 10;
            int i = 1;
            // 符号位
            int sign = 1;
            if (c[0] == '-') {
                sign = -1;
            } else if (c[0] != '+') {
                i = 0;
            }
            for (int j = i; j < c.length; j++) {
                if (c[j] < '0' || c[j] > '9') {
                    // 非数字字符
                    break;
                }
                // 情况一：执行拼接 10×res ≥ 2147483650 越界
                // 情况二：拼接后是 2147483648 或 2147483649 越界
                if (res > bndry || res == bndry && c[j] > '7') {
                    // 判断数字越界时，要始终保持 res 在 int 类型的取值范围内
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + (c[j] - '0');
            }
            return sign * res;
        }
    }
}
