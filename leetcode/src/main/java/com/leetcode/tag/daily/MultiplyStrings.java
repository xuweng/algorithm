package com.leetcode.tag.daily;

/**
 * 43. 字符串相乘
 * <p>
 * 这种题没多大意义。直接看题解。
 */
public class MultiplyStrings {
    class Solution {
        public String multiply(String num1, String num2) {
            return "";
        }
    }

    /**
     * 方法一：做加法
     * <p>
     * 其余的每一位的运算结果都需要补 0
     * <p>
     * num2除了最低位以外，其余的每一位的运算结果都需要补 0
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/multiply-strings/solution/zi-fu-chuan-xiang-cheng-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            String ans = "0";
            int m = num1.length(), n = num2.length();
            for (int i = n - 1; i >= 0; i--) {
                StringBuilder curr = new StringBuilder();
                int add = 0;
                for (int j = n - 1; j > i; j--) {
                    curr.append(0);
                }
                int y = num2.charAt(i) - '0';
                for (int j = m - 1; j >= 0; j--) {
                    int x = num1.charAt(j) - '0';
                    int product = x * y + add;
                    curr.append(product % 10);
                    add = product / 10;
                }
                if (add != 0) {
                    curr.append(add % 10);
                }
                ans = addStrings(ans, curr.reverse().toString());
            }
            return ans;
        }

        public String addStrings(String num1, String num2) {
            int i = num1.length() - 1, j = num2.length() - 1, add = 0;
            StringBuilder ans = new StringBuilder();
            while (i >= 0 || j >= 0 || add != 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int result = x + y + add;
                ans.append(result % 10);
                add = result / 10;
                i--;
                j--;
            }
            ans.reverse();
            return ans.toString();
        }
    }

}

