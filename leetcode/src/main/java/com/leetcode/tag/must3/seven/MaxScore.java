package com.leetcode.tag.must3.seven;

/**
 * 1423. 可获得的最大点数
 */
public class MaxScore {
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int left = 0;
            int right = 0;
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int no = cardPoints.length - k;

            while (right < cardPoints.length) {
                sum += cardPoints[right];
                if (right >= no - 1) {
                    min = Math.min(min, sum);
                    sum -= cardPoints[left];
                    left++;
                }
                right++;
            }

            return min;
        }
    }
}
