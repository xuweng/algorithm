package com.leetcode.tag.daily.one;

/**
 * 415. 字符串相加
 */
public class AddStrings {
    /**
     * 字符串太大了
     * <p>
     * 大数越界
     */
    class Solution {
        /**
         * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
         *
         * @param num1 定两个字符串形式的非负整数
         * @param num2 定两个字符串形式的非负整数
         * @return 计算它们的和
         */
        public String addStrings(String num1, String num2) {
            return String.valueOf(Long.parseLong(num1) + Long.parseLong(num2));
        }
    }

    /**
     * 方法一：模拟
     * <p>
     * 思路与算法
     * <p>
     * 主要是进位和补零。
     * <p>
     * 具体实现也不复杂，我们定义两个指针 i 和 j 分别指向num1 和 num2 的末尾，即最低位，
     * <p>
     * 同时定义一个变量 add 维护当前是否有进位，然后从末尾到开头逐位相加即可。
     * <p>
     * 你可能会想两个数字位数不同怎么处理，这里我们统一在指针当前下标处于负数的时候返回 0，
     * <p>
     * 等价于对位数较短的数字进行了补零操作，这样就可以除去两个数字位数不同情况的处理
     *
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/add-strings/solution/zi-fu-chuan-xiang-jia-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 补零是一个小技巧。这类题目不容易想，直接看答案。
         *
         * @param num1
         * @param num2
         * @return
         */
        public String addStrings(String num1, String num2) {
            int i = num1.length() - 1, j = num2.length() - 1, add = 0;
            StringBuffer ans = new StringBuffer();
            while (i >= 0 || j >= 0 || add != 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int result = x + y + add;
                ans.append(result % 10);
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
