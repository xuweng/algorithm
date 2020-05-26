package com.leetcode.tag.backtracking;

import java.util.*;

/**
 * 46. 全排列
 */
public class Permutations {
  /**
   * 老办法
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> permute(int[] nums) {
    return re(nums, nums.length - 1);
  }

  public List<List<Integer>> re(int[] nums, int n) {
    if (n <= 0) {
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> list = new ArrayList<>();
      list.add(nums[0]);
      result.add(list);

      return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<List<Integer>> lists = re(nums, n - 1);
    if (lists == null) {
      return result;
    }

    for (List<Integer> list : lists) {
      List<Integer> list2 = new ArrayList<>();
      list2.add(nums[n]);
      list2.addAll(list);
      result.add(list2);
      for (int i = 0; i < list.size(); i++) {
        List<Integer> list1 = new ArrayList<>(list.subList(0, i + 1));
        list1.add(nums[n]);
        if (i != lists.size() - 1) {
          list1.addAll(list.subList(i + 1, list.size()));
        }

        result.add(list1);
      }
    }

    return result;
  }

  List<List<Integer>> result = new ArrayList<>();
  Stack<Integer> stack = new Stack<>();

  public List<List<Integer>> permute2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    backTrack(nums);
    return result;
  }

  public void backTrack(int[] nums) {
    if (nums.length == 0) {
      result.add(new ArrayList<>(stack));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      stack.push(nums[i]);
      backTrack(delete(nums, i));
      stack.pop();
    }
  }

  public int[] delete(int[] nums, int index) {
    int[] array = new int[nums.length - 1];
    if (index == nums.length - 1) {
      if (nums.length >= 2) {
        System.arraycopy(nums, 0, array, 0, nums.length - 1);
      }
      return array;
    }
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i != index) {
        array[j++] = nums[i];
      }
    }

    return array;
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public void backtrack(int n, ArrayList<Integer> output, List<List<Integer>> res, int first) {
      // 所有数都填完了
      if (first == n) {
        res.add(new ArrayList<>(output));
      }
      for (int i = first; i < n; i++) {
        // 动态维护数组
        Collections.swap(output, first, i);
        // 继续递归填下一个数
        backtrack(n, output, res, first + 1);
        // 撤销操作
        Collections.swap(output, first, i);
      }
    }

    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> res = new LinkedList<>();
      ArrayList<Integer> output = new ArrayList<>();
      for (int num : nums) {
        output.add(num);
      }

      int n = nums.length;
      backtrack(n, output, res, 0);
      return res;
    }
  }

  /**
   * 跟着大佬写代码
   *
   * <p>学习优秀代码
   *
   * <p>快捷键用得很厉害
   */
  class S {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      if (nums.length == 0) {
        return result;
      }
      // java stack推荐使用这个
      // 全局path
      Deque<Integer> path = new ArrayDeque<Integer>();
      // 全局used
      boolean[] used = new boolean[nums.length];
      dfs(nums, 0, path, used, result);
      return result;
    }

    private void dfs(
            int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> result) {
      if (depth == nums.length) {
        result.add(new ArrayList<>(path));
        return;
      }
      // 候选集都是全部nums
      for (int i = 0; i < nums.length; i++) {
        if (used[i]) {
          continue;
        }
        path.push(nums[i]);
        used[i] = true;
        dfs(nums, depth + 1, path, used, result);
        path.pop();
        used[i] = false;
      }
    }
  }

  /**
   * 使用标记数组来处理填过的数是一个很直观的思路，但是可不可以去掉这个标记数组呢？毕竟标记数组也增加了我们算法的空间复杂度。
   *
   * <p>答案是可以的，我们可以将题目给定的 n 个数的数组nums[]
   *
   * <p>划分成左右两个部分，左边的表示已经填过的数，右边表示待填的数，我们在递归搜索的时候只要动态维护这个数组即可。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class S1 {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      if (nums.length == 0) {
        return result;
      }
      backTrack(nums, 0, result);

      return result;
    }

    /**
     * 假设我们已经填到第 \textit{first}first 个位置，那么 \textit{nums}[]nums[] 数组中
     * [0,\textit{first}-1][0,first−1] 是已填过的数的集合，[\textit{first},n-1][first,n−1] 是待填的数的集合。我们肯定是尝试用
     * [\textit{first},n-1][first,n−1] 里的数去填第 \textit{first}first 个数
     *
     * <p>作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param first
     * @param result
     */
    private void backTrack(int[] nums, int first, List<List<Integer>> result) {
      if (first == nums.length - 1) {
        result.add(get(nums));
        return;
      }
      // 候选集是first--------->nums.length
      // 尝试用[first,n−1] 里的数去填第 first 个数
      for (int i = first; i < nums.length; i++) {
        // 假设我们已经填到第first 个位置
        // 选择i填到第first 个位置
        swap(nums, first, i);
        // 填下一个
        backTrack(nums, first + 1, result);
        // 状态重置
        // 下一个分支
        swap(nums, first, i);
      }
    }

    private List<Integer> get(int[] nums) {
      List<Integer> list = new ArrayList<>();
      for (int i : nums) {
        list.add(i);
      }
      return list;
    }

    private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }
}
