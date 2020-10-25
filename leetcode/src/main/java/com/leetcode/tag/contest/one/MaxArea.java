package com.leetcode.tag.contest.one;

import java.util.Arrays;

/**
 * 5425. 切割后面积最大的蛋糕
 */
public class MaxArea {
  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);

    int hMax = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
    int hPre = 0;
    for (int i = 1; i < horizontalCuts.length; i++) {
      hMax = Math.max(hMax, horizontalCuts[i] - horizontalCuts[hPre]);
      hPre = i;
    }
    int vMax = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
    int vPre = 0;
    for (int i = 1; i < verticalCuts.length; i++) {
      vMax = Math.max(vMax, verticalCuts[i] - verticalCuts[vPre]);
      vPre = i;
    }

    return (int) (((long) hMax * (long) vMax) % (Math.pow(10, 9) + 7));
  }
}
