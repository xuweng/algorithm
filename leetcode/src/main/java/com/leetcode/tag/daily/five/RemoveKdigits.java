package com.leetcode.tag.daily.five;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉K位数字
 * <p>
 * https://leetcode-cn.com/problems/remove-k-digits/solution/yi-zhao-chi-bian-li-kou-si-dao-ti-ma-ma-zai-ye-b-5/
 * <p>
 * 这四道题都是删除或者保留若干个字符，使得剩下的数字最小（或最大）或者字典序最小（或最大）.
 * <p>
 * 而解决问题的前提是要有一定数学前提。而基于这个数学前提，我们贪心地删除栈中相邻的字符
 */
public class RemoveKdigits {
    /**
     * 方法一：贪心 + 单调栈
     * <p>
     * 单调栈。当前元素入栈。维护单调栈。保存单调数据。
     * <p>
     * 要使得剩下的数字最小，需要保证靠前的数字尽可能小
     * <p>
     * 删除一个数字」的贪心策略：
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/remove-k-digits/solution/yi-diao-kwei-shu-zi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 最左边的数据尽可能保存小的
         *
         * @param num
         * @param k
         * @return
         */
        public String removeKdigits(String num, int k) {
            // 双端队列当作栈
            Deque<Character> deque = new LinkedList<>();
            int length = num.length();
            for (int i = 0; i < length; ++i) {
                char digit = num.charAt(i);
                // 删除单调栈比当前元素大的元素
                // 更小的元素入栈
                while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                    deque.pollLast();
                    k--;
                }
                // 当前元素入栈。相等也会入栈。
                deque.offerLast(digit);
            }

            // 此时单调栈数据单调递增
            // 删除次数不够。从尾部开始删除单调栈数据。
            for (int i = 0; i < k; ++i) {
                deque.pollLast();
            }

            StringBuilder ret = new StringBuilder();
            boolean leadingZero = true;
            while (!deque.isEmpty()) {
                // 取第一个元素
                char digit = deque.pollFirst();
                // 如果num包含0.单调栈的第一个元素是0.
                // 首字母不能为0.最左边的连续字符不能为0。
                if (leadingZero && digit == '0') {
                    continue;
                }
                leadingZero = false;
                ret.append(digit);
            }
            return ret.length() == 0 ? "0" : ret.toString();
        }
    }

}
