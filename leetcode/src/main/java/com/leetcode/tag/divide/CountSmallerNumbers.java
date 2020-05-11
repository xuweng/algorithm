package com.leetcode.tag.divide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 315. 计算右侧小于当前元素的个数
 */
public class CountSmallerNumbers {
  public List<Integer> countSmaller(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums.length - 1; i++) {
      int count = 0;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          count++;
        }
      }
      list.add(count);
    }
    list.add(0);
    return list;
  }

  /**
   * 分治.递归
   *
   * <p>重叠子问题?子问题依赖?
   *
   * <p>右子问题没有依赖.左子问题依赖右子问题
   *
   * @param nums
   * @return
   */
  public List<Integer> divide(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }

    return null;
  }

  /**
   * 把输入数组反过来插入一个有序数组（降序）中，插入的位置就是在原数组中位于它右侧的元素的个数
   *
   * <p>反常思维.反常思维.反常思维.反常思维.反常思维.反常思维.反常思维.反常思维.反常思维
   *
   * <p>左----.右
   *
   * <p>右----.左
   *
   * <p>搞破.不搞破
   *
   * @param nums
   * @return
   */
  public List<Integer> countSmaller1(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    int[] sortNums = new int[nums.length];
    Integer[] result = new Integer[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      result[i] = insert(sortNums, nums[i]);
    }

    return Arrays.asList(result);
  }

  // 已经排序数组的数量
  int sortNumsCount;

  public int insert(int[] sortNums, int target) {
    if (sortNumsCount == 0) {
      sortNumsCount++;
      sortNums[0] = target;
      return 0;
    }
    int i = sortNumsCount - 1;
    while (i >= 0 && target <= sortNums[i]) {
      sortNums[i + 1] = sortNums[i];
      i--;
    }
    sortNumsCount++;
    sortNums[i + 1] = target;

    return i + 1;
  }

  /**
   * 线段树
   *
   * <p>线段范围
   *
   * <p>start
   *
   * <p>end
   *
   * <p>线段范围内有几个元素
   *
   * <p>count
   *
   * <p>指向左右结点的指针
   *
   * <p>left（左结点的线段范围是[start, start+(end-start)/2]）
   *
   * <p>right(右结点的线段范围是[start+(end-start)/2+1, end])
   */
  class SegmentTreeNode {
    int start;
    int end;
    // 线段范围内有几个元素
    int count;

    SegmentTreeNode left;
    SegmentTreeNode right;
    // 叶子结点改为单链表,统计count容易多
    SegmentTreeNode next;

    public SegmentTreeNode() {}

    SegmentTreeNode(int start, int end) {
      count = 0;
      this.start = start;
      this.end = end;
    }

    /**
     * 构造线段树 找出数组中最小和最大的元素，做为根节点的线段范围
     *
     * @param start 最小值
     * @param end 最大值
     * @return
     */
    public SegmentTreeNode build(int start, int end) {
      // 非法
      if (start > end) {
        return null;
      }

      SegmentTreeNode root = new SegmentTreeNode(start, end);
      if (start == end) {
        root.count = 0;
        return root;
      }
      int mid = start + (end - start) / 2;
      root.left = build(start, mid);
      root.right = build(mid + 1, end);
      return root;
    }

    /**
     * 画图
     *
     * <p>逻辑清晰多了.如果错误肯定有哪些情况没有考虑到
     *
     * <p>只在左,只在右,左右.3种情况
     *
     * <p>这个函数比较难理解
     *
     * <p>返回[start, end]的count值
     *
     * @param root
     * @param start
     * @param end
     * @return
     */
    int count(SegmentTreeNode root, int start, int end) {
      if (root == null || start > end) {
        return 0;
      }
      if (start == root.start && end == root.end) {
        return root.count;
      }
      int mid = root.start + (root.end - root.start) / 2;
      if (root.start <= start && end <= mid) {
        // 只在左
        return count(root.left, start, end);
      } else if (start > mid && end <= root.end) {
        // 只在右
        return count(root.right, start, end);
      } else {
        // 在左右,横跨mid
        return count(root.left, start, mid) + count(root.right, mid + 1, end);
      }
    }

    /**
     * 更新线段树的count值
     *
     * @param root
     * @param index
     * @param val
     */
    void updateCount(SegmentTreeNode root, int index, int val) {
      if (root.start == index && root.end == index) {
        root.count += val;
        return;
      }

      int mid = root.start + (root.end - root.start) / 2;
      if (index >= root.start && index <= mid) {
        updateCount(root.left, index, val);
      }
      if (index > mid && index <= root.end) {
        updateCount(root.right, index, val);
      }

      // 左子树和右子树搞完后,更新root的count
      root.count = root.left.count + root.right.count;
    }
  }

  /**
   * 作者：Dufre
   * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/solution/c-xian-duan-shu-jie-fa-by-dufre/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public List<Integer> countSmaller(int[] nums) {
      if (nums == null || nums.length == 0) {
        return new ArrayList<>();
      }
      Integer[] res = new Integer[nums.length];
      int min = Arrays.stream(nums).min().getAsInt();
      int max = Arrays.stream(nums).max().getAsInt();

      SegmentTreeNode root = new SegmentTreeNode().build(min, max);

      for (int i = nums.length - 1; i >= 0; i--) {
        // 统计线段树中[min, x-1]范围内的元素，即右侧小于x的元素个数
        res[i] = root.count(root, min, nums[i] - 1);
        root.updateCount(root, nums[i], 1);
      }

      return Arrays.asList(res);
    }
  };
}
