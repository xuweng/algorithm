package com.leetcode.tag.daily.seven;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 888. 公平的糖果棒交换
 */
public class FairCandySwap {
    /**
     * 方法一：哈希表
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/fair-candy-swap/solution/gong-ping-de-tang-guo-jiao-huan-by-leetc-tlam/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            int sumA = Arrays.stream(A).sum();
            int sumB = Arrays.stream(B).sum();
            int delta = (sumA - sumB) / 2;
            Set<Integer> rec = Arrays.stream(A).boxed().collect(Collectors.toSet());

            int[] ans = new int[2];
            for (int y : B) {
                // 求x
                int x = y + delta;
                if (rec.contains(x)) {
                    ans[0] = x;
                    ans[1] = y;
                    break;
                }
            }
            return ans;
        }
    }

}
