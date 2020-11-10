package com.leetcode.tag.binarysearch.one;

/**
 * 1011. 在 D 天内送达包裹的能力
 * <p>
 * 线段树
 * <p>
 * 树状数组
 * <p>
 * 前缀和
 */
public class ShipWithinDays {
    /**
     * 方法一：二分查找 + 贪心
     * <p>
     * 必然会在不超过其承载力的前提下贪心地往上装载货物
     * <p>
     * 作者：KLEA
     * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/solution/zai-dtian-nei-song-da-bao-guo-de-neng-li-by-lenn12/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int shipWithinDays(int[] weights, int D) {
            int lo = 0, hi = Integer.MAX_VALUE;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (canShip(weights, D, mid)) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            return lo;
        }

        /**
         * 判断在最低承载力为K的情形下能否在D天内送达所有包裹
         *
         * @param weights
         * @param D
         * @param K
         * @return
         */
        private boolean canShip(int[] weights, int D, int K) {
            int cur = K; // cur 表示当前船的可用承载量
            for (int weight : weights) {
                if (weight > K) {
                    return false;
                }
                if (cur < weight) {
                    cur = K;
                    D--;
                }
                cur -= weight;
            }
            return D > 0; // 能否在D天内运完
        }
    }

}
