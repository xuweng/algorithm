package com.leetcode.tag.daily.seven;

/**
 * 1128. 等价多米诺骨牌对的数量
 */
public class NumEquivDominoPairs {
    /**
     * 方法一：二元组表示 + 计数
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/solution/deng-jie-duo-mi-nuo-gu-pai-dui-de-shu-li-yjlz/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 为了使得「等价」更易于比较，我们都让较小的数排在前面。例如：让 [1, 4] 拼成 14，让 [4, 1] 也拼成 14
         *
         * @param dominoes
         * @return
         */
        public int numEquivDominoPairs(int[][] dominoes) {
            int[] num = new int[100];
            int ret = 0;
            for (int[] domino : dominoes) {
                //将每一个二元对拼接成一个两位的正整数
                int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
                ret += num[val];
                num[val]++;
            }
            return ret;
        }
    }

}
