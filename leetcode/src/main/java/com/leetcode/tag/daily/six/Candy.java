package com.leetcode.tag.daily.six;

/**
 * 135. 分发糖果
 */
public class Candy {
    /**
     * 方法一：两次遍历
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/candy/solution/fen-fa-tang-guo-by-leetcode-solution-f01p/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 左规则：当 ratings[i−1]<ratings[i] 时，i 号学生的糖果数量将比 i−1 号孩子的糖果数量多。
         * <p>
         * 右规则：当 ratings[i]>ratings[i+1] 时，i 号学生的糖果数量将比 i+1 号孩子的糖果数量多。
         * <p>
         *
         * @param ratings
         * @return
         */
        public int candy(int[] ratings) {
            int n = ratings.length;
            //左规则
            int[] left = new int[n];
            for (int i = 0; i < n; i++) {
                if (i > 0 && ratings[i] > ratings[i - 1]) {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = 1;
                }
            }
            //右规则
            int right = 0, ret = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                    right++;
                } else {
                    right = 1;
                }
                // 累加
                // 至少需要准备多少颗糖果
                ret += Math.max(left[i], right);
            }
            return ret;
        }
    }

    /**
     * 方法二：常数空间遍历
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/candy/solution/fen-fa-tang-guo-by-leetcode-solution-f01p/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int ret = 1;
            int inc = 1, dec = 0, pre = 1;
            for (int i = 1; i < n; i++) {
                if (ratings[i] >= ratings[i - 1]) {
                    dec = 0;
                    pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                    ret += pre;
                    inc = pre;
                } else {
                    dec++;
                    if (dec == inc) {
                        dec++;
                    }
                    ret += dec;
                    pre = 1;
                }
            }
            return ret;
        }
    }

}
