package com.leetcode.tag.contest;

import java.util.*;

/**
 * 5465. 子树中标签相同的节点数
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 */
public class CountSubTrees {

  class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int count;
    boolean[] visited;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
      for (int[] a : edges) {
        List<Integer> list = map.getOrDefault(a[0], new ArrayList<>());
        list.add(a[1]);
        map.put(a[0], list);

        List<Integer> list1 = map.getOrDefault(a[1], new ArrayList<>());
        list1.add(a[0]);
        map.put(a[1], list1);
      }
      visited = new boolean[n];
      char[] chars = labels.toCharArray();
      int[] result = new int[n];
      Arrays.fill(result, 1);
      for (int i = 0; i < n; i++) {
        List<Integer> list = map.get(i);
        if (list == null) {
          continue;
        }
        visited[i] = true;
        re(chars[i], i, chars);
        result[i] = result[i] + count;
        count = 0;
      }

      return result;
    }

    private void re(char c, int i, char[] chars) {
      List<Integer> list = map.get(i);
      if (list == null) {
        return;
      }
      for (int j : list) {
        if (visited[j]) {
          continue;
        }
        if (c == chars[j]) {
          count++;
        }
        visited[j] = true;
        re(c, j, chars);
        visited[j] = false;
      }
    }
  }
}
