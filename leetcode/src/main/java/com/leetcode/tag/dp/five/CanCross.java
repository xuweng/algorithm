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

        /**
         * 从f(i) 能不能跳到 f(i+1....length).
         *
         * @param stones
         * @param index    位置
         * @param jumpsize
         * @return
         */
        public boolean canCross(int[] stones, int index, int jumpsize) {
            for (int i = index + 1; i < stones.length; i++) {
                // index+1和index的距离
                int gap = stones[i] - stones[index];
                // 升序剪枝
                if (gap < jumpsize - 1 || gap > jumpsize + 1) {
                    break;
                }
                if (canCross(stones, i, gap)) {
                    // 只要找到一个答案就返回
                    return true;
                }
            }
            // 在这里返回厉害 叶子结点
            return index == stones.length - 1;
        }
    }

}
