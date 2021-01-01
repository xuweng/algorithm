package com.leetcode.tag.dp.five;

/**
 * 403. 青蛙过河
 */
public class CanCross {
    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/frog-jump/solution/qing-wa-guo-he-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public class Solution {
        public boolean canCross(int[] stones) {
            return canCross(stones, 0, 0);
        }

        public boolean canCross(int[] stones, int ind, int jumpsize) {
            for (int i = ind + 1; i < stones.length; i++) {
                int gap = stones[i] - stones[ind];
                if (gap >= jumpsize - 1 && gap <= jumpsize + 1) {
                    if (canCross(stones, i, gap)) {
                        return true;
                    }
                }
            }
            // 在这里返回厉害 叶子结点
            return ind == stones.length - 1;
        }
    }

}
