package com.leetcode.tag.contest.one;

import java.util.*;

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
 * <p>不要浪费时间
 *
 * <p>十分钟看答案
 *
 * <p>不要浪费时间
 *
 * <p>5465. 子树中标签相同的节点数
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
      // 构建map错误
      // 构建树的map
      // 不是构建图的map
      // 构建单向?构建双向?
      for (int[] a : edges) {
        List<Integer> list = map.getOrDefault(a[0], new ArrayList<>());
        list.add(a[1]);
        map.put(a[0], list);
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
