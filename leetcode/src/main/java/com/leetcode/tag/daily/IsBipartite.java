package com.leetcode.tag.daily;

import java.util.Arrays;

/**
 * 十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>难题看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>785. 判断二分图
 */
public class IsBipartite {
  /**
   * 对于图中的任意两个节点 u 和 v，如果它们之间有一条边直接相连，那么 u 和 v 必须属于不同的集合。
   *
   * <p>算法的流程如下：
   *
   * <p>我们任选一个节点开始，将其染成红色，并从该节点开始对整个无向图进行遍历；
   *
   * <p>在遍历的过程中，如果我们通过节点 u 遍历到了节点 v（即 u 和 v 在图中有一条边直接相连），那么会有两种情况：
   *
   * <p>如果 v 未被染色，那么我们将其染成与 u 不同的颜色，并对 v 直接相连的节点进行遍历；
   *
   * <p>如果 v 被染色，并且颜色与 u 相同，那么说明给定的无向图不是二分图。我们可以直接退出遍历并返回 False 作为答案。
   *
   * <p>当遍历结束时，说明给定的无向图是二分图，返回 True 作为答案。
   *
   * <p>我们可以使用「深度优先搜索」或「广度优先搜索」对无向图进行遍历，下文分别给出了这两种搜索对应的代码。
   *
   * <p>注意：题目中给定的无向图不一定保证连通，因此我们需要进行多次遍历，直到每一个节点都被染色，
   *
   * <p>或确定答案为False为止。每次遍历开始时，我们任选一个未被染色的节点，将所有与该节点直接或间接相连的节点进行染色。
   */
  class Solution {
    public boolean isBipartite(int[][] graph) {
      return true;
    }
  }

  /**
   * 图染色
   *
   * <p>图遍历
   *
   * <p>方法一：深度优先搜索
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/is-graph-bipartite/solution/pan-duan-er-fen-tu-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;

    public boolean isBipartite(int[][] graph) {
      int n = graph.length;
      valid = true;
      color = new int[n];
      // 初始化所有结点未软色
      Arrays.fill(color, UNCOLORED);
      // 无向图不一定保证连通.需要遍历每个结点
      for (int i = 0; i < n && valid; ++i) {
        if (color[i] == UNCOLORED) {
          dfs(i, RED, graph);
        }
      }
      return valid;
    }

    public void dfs(int node, int c, int[][] graph) {
      color[node] = c;
      int cNei = c == RED ? GREEN : RED;
      for (int neighbor : graph[node]) {
        if (color[neighbor] == UNCOLORED) {
          dfs(neighbor, cNei, graph);
          if (!valid) {
            return;
          }
        } else if (color[neighbor] != cNei) {
          valid = false;
          return;
        }
      }
    }
  }
}
