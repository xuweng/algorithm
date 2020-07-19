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

    public int[] countSubTrees(int n, int[][] edges, String labels) {
      for (int[] a : edges) {
        if (a[0] != 0) {
          continue;
        }
        List<Integer> list = map.getOrDefault(0, new ArrayList<>());
        list.add(a[1]);
        map.put(0, list);
      }

      List<Integer> list1 = map.get(0);
      for (int i : list1) {
        for (int[] a : edges) {
          if (a[0] == 0) {
            continue;
          }

          if (a[0] == i) {
            List<Integer> list = map.getOrDefault(i, new ArrayList<>());
            list.add(a[1]);
            map.put(i, list);
          }
          if (a[1] == i) {
            List<Integer> list = map.getOrDefault(i, new ArrayList<>());
            list.add(a[0]);
            map.put(i, list);
          }
        }
      }

      char[] chars = labels.toCharArray();
      int[] result = new int[n];
      Arrays.fill(result, 1);
      for (int i = 0; i < n; i++) {
        List<Integer> list = map.get(i);
        if (list == null) {
          continue;
        }
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
        if (c == chars[j]) {
          count++;
        }
        re(c, j, chars);
      }
    }
  }
}
