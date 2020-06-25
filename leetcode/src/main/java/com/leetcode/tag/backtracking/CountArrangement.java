package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 526. 优美的排列
 */
public class CountArrangement {
  public int countArrangement(int N) {
    boolean[] used = new boolean[N + 1];
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> stack = new LinkedList<>();

    backTrack(N, 1, used, result, stack);

    return result.size();
  }

  private void backTrack(
          int N, int start, boolean[] used, List<List<Integer>> result, Deque<Integer> stack) {
    // 越界统计
    if (start > N) {
      result.add(new ArrayList<>(stack));
      return;
    }
    // 第start个位置有N种选择，且不能重复选择
    for (int i = 1; i <= N; i++) {
      if (used[i] || (i % start != 0 && start % i != 0)) {
        continue;
      }
      used[i] = true;
      stack.push(i);
      backTrack(N, start + 1, used, result, stack);
      used[i] = false;
      stack.pop();
    }
  }

  /**
   * 我们找到使用数字 1 到 N 的所有排列。然后我们逐一遍历每个数字并检查是否满足两个条件中的一个。
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/beautiful-arrangement/solution/you-mei-de-pai-lie-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    int count = 0;

    public int countArrangement(int N) {
      int[] nums = new int[N];
      for (int i = 1; i <= N; i++) {
        nums[i - 1] = i;
      }
      permute(nums, 0);
      return count;
    }

    public void permute(int[] nums, int l) {
      if (l == nums.length - 1) {
        int i;
        for (i = 1; i <= nums.length; i++) {
          if (nums[i - 1] % i != 0 && i % nums[i - 1] != 0) {
            break;
          }
        }
        if (i > nums.length) {
          count++;
        }
      }
      for (int i = l; i < nums.length; i++) {
        swap(nums, i, l);
        permute(nums, l + 1);
        swap(nums, i, l);
      }
    }

    public void swap(int[] nums, int x, int y) {
      int temp = nums[x];
      nums[x] = nums[y];
      nums[y] = temp;
    }
  }

  /**
   * 方法 3：回溯 [Accepted]
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/beautiful-arrangement/solution/you-mei-de-pai-lie-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    int count = 0;

    public int countArrangement(int N) {
      boolean[] visited = new boolean[N + 1];
      calculate(N, 1, visited);
      return count;
    }

    public void calculate(int N, int pos, boolean[] visited) {
      if (pos > N) {
        count++;
      }
      for (int i = 1; i <= N; i++) {
        if (visited[i] || (pos % i != 0 && i % pos != 0)) {
          continue;
        }
        visited[i] = true;
        calculate(N, pos + 1, visited);
        visited[i] = false;
      }
    }
  }
}
