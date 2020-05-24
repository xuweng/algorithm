package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 回溯算法题目集合
 */
public class AllBackTrack {
  /**
   * 作者：show-me-the-code-2
   * 链接：https://leetcode-cn.com/problems/subsets/solution/c-zong-jie-liao-hui-su-wen-ti-lei-xing-dai-ni-gao-/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class S {
    List<List<Integer>> res = new ArrayList<>();
    // 用栈更加合适
    Stack<Integer> path = new Stack<>();

    void backtrack(int[] nums, int start) {
      res.add(path);
      for (int i = start; i < nums.length; i++) {
        // 做出选择
        path.push(nums[i]);
        // 递归进入下一层，注意i+1，标识下一个选择列表的开始位置，最重要的一步
        backtrack(nums, i + 1);
        path.pop(); // 撤销选择
      }
    }
  }

  class S1 {
    List<List<Integer>> res = new ArrayList<>();
    // 用栈更加合适
    Stack<Integer> path = new Stack<>();

    void backtrack(int[] nums, int start) {
      res.add(path);
      for (int i = start; i < nums.length; i++) {
        // 剪枝去重
        if (i > start && nums[i] == nums[i - 1]) {
          continue;
        }
        path.push(nums[i]);
        backtrack(nums, i + 1);
        path.pop();
      }
    }
  }

  class S2 {
    List<List<Integer>> res = new ArrayList<>();
    // 用栈更加合适
    Stack<Integer> path = new Stack<>();

    void backtrack(int[] nums, int start, int sum, int target) {
      for (int i = start; i < nums.length; i++) {
        if (sum > target) {
          continue;
        }
        path.push(nums[i]);
        backtrack(nums, i, sum + nums[i], target); // 更新i和当前状态的sum
        path.pop();
      }
    }
  }
}
