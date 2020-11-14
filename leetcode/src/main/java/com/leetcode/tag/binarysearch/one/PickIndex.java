package com.leetcode.tag.binarysearch.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 528. 按权重随机选择
 */
public class PickIndex {
    /**
     * 方法 1：前缀和与二分搜索
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/random-pick-with-weight/solution/an-quan-zhong-sui-ji-xuan-ze-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        List<Integer> psum = new ArrayList<>();
        int sum = 0;
        Random rand = new Random();

        /**
         * @param w 正整数数组 w
         */
        public Solution(int[] w) {
            for (int x : w) {
                sum += x;
                psum.add(sum);
            }
        }

        public int pickIndex() {
            int targ = rand.nextInt(sum);

            int lo = 0;
            int hi = psum.size() - 1;
            while (lo != hi) {
                int mid = (lo + hi) / 2;
                if (targ >= psum.get(mid)) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }
    }

}
