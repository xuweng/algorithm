package com.leetcode.tag.must4.four;

import java.util.Arrays;

/**
 * 1423. 可获得的最大点数
 */
public class MaxScore {
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            if (cardPoints.length == k) {
                return Arrays.stream(cardPoints).sum();
            }
            int no = cardPoints.length - k;
            int left = 0;
            int right = 0;
            int sum = 0;
            int min = Integer.MAX_VALUE;

            while (right < cardPoints.length) {
                sum += cardPoints[right];
                if (right >= no - 1) {
                    min = Math.min(min, sum);
                    sum -= cardPoints[left];
                    left++;
                }
                right++;
            }

            return Arrays.stream(cardPoints).sum() - min;
        }
    }
}
