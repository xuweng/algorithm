package com.leetcode.tag.daily.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 1431. 拥有最多糖果的孩子
 */
public class KidsWithCandies {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    if (candies == null || candies.length == 0) {
      return new ArrayList<>();
    }
    int max = 0;
    for (int i : candies) {
      max = Math.max(max, i);
    }
    List<Boolean> list = new ArrayList<>();
    for (int i : candies) {
      list.add(i + extraCandies >= max);
    }

    return list;
  }
}
