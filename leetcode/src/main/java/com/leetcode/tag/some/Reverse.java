package com.leetcode.tag.some;

/**
 * 7. 整数反转
 */
public class Reverse {
    class Solution {
        public int reverse(int x) {
            String s = String.valueOf(Math.abs(x));
            int length = s.length() - 1;
            while (length >= 1 && s.charAt(length) == '0') {
                length--;
            }
            StringBuilder temp = new StringBuilder();
            for (int i = length; i >= 0; i--) {
                temp.append(s.charAt(i));
            }

            return x < 0 ? -Integer.parseInt(temp.toString()) : Integer.parseInt(temp.toString());
        }
    }

    /**
     * 以12345为例，先拿到5，再拿到4，之后是3，2，1
     * <p>
     * % 取末尾 ,/ 干掉末尾
     * <p>
     * 1、将12345 % 10 得到5，之后将12345 / 10
     * 2、将1234 % 10 得到4，再将1234 / 10
     * 3、将123 % 10 得到3，再将123 / 10
     * 4、将12 % 10 得到2，再将12 / 10
     * 5、将1 % 10 得到1，再将1 / 10
     * <p>
     * 作者：wang_ni_ma
     * 链接：https://leetcode-cn.com/problems/reverse-integer/solution/tu-jie-7-zheng-shu-fan-zhuan-by-wang_ni_ma/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;
                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                    return 0;
                }
                if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                    return 0;
                }
                rev = rev * 10 + pop;
            }
            return rev;
        }
    }

    /**
     * 作者：wang_ni_ma
     * 链接：https://leetcode-cn.com/problems/reverse-integer/solution/tu-jie-7-zheng-shu-fan-zhuan-by-wang_ni_ma/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int reverse(int x) {
            int res = 0;
            while (x != 0) {
                //每次取末尾数字
                int tmp = x % 10;
                //判断是否 大于 最大32位整数
                if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                    return 0;
                }
                //判断是否 小于 最小32位整数
                if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                    return 0;
                }
                res = res * 10 + tmp;
                x /= 10;
            }
            return res;
        }
    }

}
