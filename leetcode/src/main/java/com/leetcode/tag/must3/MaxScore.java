package com.leetcode.tag.must3;

import java.util.Arrays;

/**
 * 1423. 可获得的最大点数
 */
public class MaxScore {
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int no = cardPoints.length - k;
            int left = 0;
            int right = 0;
            int min = Integer.MAX_VALUE;

            while (right < cardPoints.length) {
                no += cardPoints[right];
                if (right >= no - 1) {
                    min = Math.min(min, no);
                    no -= cardPoints[left++];
                }
                right++;
            }

            return Arrays.stream(cardPoints).sum() - min;
        }
    }
}
