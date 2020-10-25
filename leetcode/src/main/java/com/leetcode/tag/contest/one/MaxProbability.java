package com.leetcode.tag.contest.one;

import java.util.*;

/**
 * 5211. 概率最大的路径
 *
 * <p>概率最大?最优解。用dp。
 *
 * <p>dp：最优解、计数
 */
public class MaxProbability {
  /**
   * 越测试，程序越健壮，bug越少
   *
   * <p>多测试。多测试。多测试
   */
  class Solution {
    Map<Integer, List<Object[]>> map = new HashMap<>();
    double max;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

      // map计算错误
      for (int i = 0; i < edges.length; i++) {
        int[] array = edges[i];
        List<Object[]> list = map.getOrDefault(array[0], new ArrayList<>());
        list.add(new Object[]{array[1], succProb[i]});
        map.put(array[0], list);

        List<Object[]> list1 = map.getOrDefault(array[1], new ArrayList<>());
        list1.add(new Object[]{array[0], succProb[i]});
        map.put(array[1], list1);
      }

      boolean[] used = new boolean[n];
      dfs(start, end, 1, used);

      return max;
    }

    /**
     * 超出时间限制
     *
     * <p>大量数据就会超出时间限制
     *
     * @param start
     * @param end
     * @param sum
     * @param used
     */
    public void dfs(int start, int end, double sum, boolean[] used) {
      if (start == end) {
        max = Math.max(max, sum);
        return;
      }
      List<Object[]> list = map.get(start);
      if (list == null || list.isEmpty()) {
        return;
      }
      for (Object[] array : list) {
        if (used[start]) {
          continue;
        }
        used[start] = true;
        dfs((int) array[0], end, sum * (double) array[1], used);
        used[start] = false;
      }
    }
  }

  /**
   * 最大概率
   *
   * <p>最优解
   *
   * <p>dp
   *
   * <p>图遍历。bfs。dp。
   *
   * <p>图dp。
   */
  class Solution1 {
    Map<Integer, List<Object[]>> map = new HashMap<>();
    double max;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
      for (int i = 0; i < edges.length; i++) {
        int[] array = edges[i];
        List<Object[]> list = map.getOrDefault(array[0], new ArrayList<>());
        list.add(new Object[]{array[1], succProb[i]});
        map.put(array[0], list);
      }
      double[] dp = new double[n];
      dp[start] = 0;
      List<Object[]> list = map.get(start);
      if (list == null || list.isEmpty()) {
        return 0;
      }
      // bfs
      Queue<Object[]> queue = new LinkedList<>();
      queue.offer(new Object[]{start, 1});
      while (!queue.isEmpty()) {
        Object[] root = queue.poll();
        List<Object[]> list1 = map.get(root[0]);
      }
      return max;
    }
  }
}
