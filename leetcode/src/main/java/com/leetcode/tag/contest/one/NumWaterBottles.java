package com.leetcode.tag.contest.one;

/**
 * 5464. 换酒问题
 */
public class NumWaterBottles {
  class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
      int result = numBottles;
      while (numBottles >= numExchange) {
        int i = numBottles / numExchange;
        result += i;

        numBottles = i + (numBottles % numExchange);
      }

      return result;
    }
  }
}
