package com.leetcode.tag.must.ten;

/**
 * 415. 字符串相加
 */
public class AddStrings {
    /**
     * 方法一：模拟
     */
    class Solution {
        public String addStrings(String num1, String num2) {
            int i = num1.length() - 1, j = num2.length() - 1;
            // 维护当前是否有进位
            int add = 0;
            StringBuilder ans = new StringBuilder();
            //从末尾到开头逐位相加
            while (i >= 0 || j >= 0 || add != 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int result = x + y + add;
                // 取末尾
                ans.append(result % 10);
                //进位
                add = result / 10;
                i--;
                j--;
            }
            // 计算完以后的答案需要翻转过来
            ans.reverse();
            return ans.toString();
        }
    }
}
