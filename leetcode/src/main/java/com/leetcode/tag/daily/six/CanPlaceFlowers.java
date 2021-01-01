package com.leetcode.tag.daily.six;

/**
 * 605. 种花问题
 */
public class CanPlaceFlowers {
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            if (n == 0) {
                return true;
            }
            if (flowerbed == null || flowerbed.length == 0) {
                return false;
            }

            int result = 0;
            for (int i = 0; i < flowerbed.length; i++) {
                if (i == 0) {
                    if (flowerbed[i] == 0) {
                        if (i + 1 < flowerbed.length) {
                            if (flowerbed[i + 1] == 0) {
                                result++;
                                flowerbed[i] = 1;
                            }
                        } else {
                            result++;
                            flowerbed[i] = 1;
                        }
                    }
                } else if (i == flowerbed.length - 1) {
                    if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                        result++;
                        flowerbed[i] = 1;
                    }
                } else {
                    if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && i + 1 < flowerbed.length && flowerbed[i + 1] == 0) {
                        result++;
                        flowerbed[i] = 1;
                    }
                }
            }

            return result >= n;
        }
    }
}
