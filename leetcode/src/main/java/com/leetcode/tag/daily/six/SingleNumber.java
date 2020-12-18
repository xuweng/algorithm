package com.leetcode.tag.daily.six;

/**
 * 136. 只出现一次的数字
 */
public class SingleNumber {
    /**
     * 方法一：位运算
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 任何数和 0 做异或运算，结果仍然是原来的数，
         * 任何数和其自身做异或运算，
         * 异或运算满足交换律和结合律，
         * <p>
         * 根据性质 3 把出现一次的数字移到最后
         * <p>
         * 作者：LeetCode-Solution
         * 链接：https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param nums
         * @return
         */
        public int singleNumber(int[] nums) {
            int single = 0;
            for (int num : nums) {
                single ^= num;
            }
            return single;
        }
    }

}
