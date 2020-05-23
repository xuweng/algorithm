package com.leetcode.tag.backtracking;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 这道题目确实就是一个“上升子序列问题”
 *
 * <p>本题的目标是上升子序列的最大数据总和，而并非序列长度。所以我们只能考虑O(N^2)的方法。
 *
 * <p>十分钟没有思路看答案
 *
 * <p>十分钟.没有思路看答案.
 *
 * <p>没有思路看答案.
 *
 * <p>没有思路看答案.
 *
 * <p>没有思路看答案
 *
 * <p>没有思路看答案.
 *
 * <p>面试题 08.13. 堆箱子
 */
public class PileBox {
  public int pileBox(int[][] box) {
    return 0;
  }

  /**
   * 作者：gfu
   * 链接：https://leetcode-cn.com/problems/pile-box-lcci/solution/xian-gen-ju-kuan-du-sheng-xu-pai-xu-kuan-du-yi-yan/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    /**
     * 题目要求在3个维度（宽度 + 深度 + 高度）上整体严格递增。 先排序1个维度（宽度），先保证在1个维度上递增（并非严格递增）。 之后专心处理剩余的2个维度（深度 +
     * 高度）即可，而这就需要使用动态规划。
     *
     * @param box
     * @return
     */
    public int pileBox(int[][] box) {
      int len = box.length;
      Arrays.sort(
              box, (a, b) -> a[0] == b[0] ? a[1] == b[1] ? b[2] - a[2] : b[1] - a[1] : a[0] - b[0]);
      int[] dpVal = new int[len];
      dpVal[0] = box[0][2];
      int res = dpVal[0];
      for (int i = 1; i < len; ++i) {
        int maxVal = 0, baseDepth = box[i][1], baseHeight = box[i][2];
        for (int j = 0; j < i; ++j) {
          if (baseDepth > box[j][1] && baseHeight > box[j][2]) {
            maxVal = Math.max(maxVal, dpVal[j]);
          }
        }

        dpVal[i] = maxVal + baseHeight;
        res = Math.max(res, dpVal[i]);
      }
      return res;
    }
  }

  /**
   * 人家马戏团的题是第二个维度可以按照LIS来做，时间复杂度是nlogn.
   *
   * <p>你这一看就是 n^2. 这道题根据第二三个维度再想套LIS很复杂，据说要考虑树什么的。
   *
   * <p>这道题应该考虑的就是用动态规划就好了，所以排序一个维度就好了。
   *
   * @param box
   * @return
   */
  public int pileBox1(int[][] box) {
    if (box.length == 0) {
      return 0;
    }
    Arrays.sort(box, Comparator.comparingInt(e -> e[2]));

    int[] dp = new int[box.length];
    int ans = 1;
    for (int i = 0; i < dp.length; i++) {
      int max = box[i][2];
      for (int j = 0; j < i; j++) {
        if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
          max = Math.max(dp[j] + box[i][2], max);
        }
      }
      dp[i] = max;
      ans = Math.max(dp[i], ans);
    }
    return ans;
  }
}
