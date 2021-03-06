package com.leetcode.tag.daily.seven;

import java.util.Arrays;

/**
 * 1423. 可获得的最大点数
 */
public class MaxScore {
    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/solution/ke-huo-de-de-zui-da-dian-shu-by-leetcode-7je9/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int n = cardPoints.length;
            // 滑动窗口大小为 n-k
            // 只能从开头和末尾拿 k 张卡牌，所以最后剩下的必然是连续的 n−k 张卡牌。
            int windowSize = n - k;
            // 求出剩余卡牌点数之和的最小值
            // 选前 n-k 个作为初始值
            int sum = Arrays.stream(cardPoints, 0, windowSize).sum();
            int minSum = sum;
            for (int i = windowSize; i < n; ++i) {
                // 滑动窗口每向右移动一格，增加从右侧进入窗口的元素值，并减少从左侧离开窗口的元素值
                sum += cardPoints[i] - cardPoints[i - windowSize];
                minSum = Math.min(minSum, sum);
            }
            return Arrays.stream(cardPoints).sum() - minSum;
        }
    }

}
