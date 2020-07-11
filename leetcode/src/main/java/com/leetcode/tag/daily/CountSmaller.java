package com.leetcode.tag.daily;

import java.util.*;

/**
 * 315. 计算右侧小于当前元素的个数
 *
 * <p>十分钟看答案
 *
 * <p>为什么是对的？
 *
 * <p>为什么是对的？
 *
 * <p>为什么是对的？
 *
 * <p>特殊的数据结构想不到的
 */
public class CountSmaller {
  /**
   * 方法一：离散化树状数组
   *
   * <p>「树状数组」是一种可以动态维护序列前缀和的数据结构，它的功能是：
   *
   * <p>单点更新 update(i, v)： 把序列 i 位置的数加上一个值 v，在该题中 v=1
   *
   * <p>区间查询 query(i)：查询序列 [1⋯i]区间的区间和，即 i 位置的前缀和
   *
   * <p>修改和查询的时间代价都是 O(logn)，其中 n 为需要维护前缀和的序列的长度。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/solution/ji-suan-you-ce-xiao-yu-dang-qian-yuan-su-de-ge-s-7/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    private int[] c;
    private int[] a;

    /**
     * 「树状数组」是一种可以动态维护序列前缀和的数据结构
     *
     * <p>动态?不动态?
     *
     * <p>高级数据结构。动态维护。
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
      List<Integer> resultList = new ArrayList<>();
      discretization(nums);
      init(nums.length + 5);
      for (int i = nums.length - 1; i >= 0; --i) {
        int id = getId(nums[i]);
        resultList.add(query(id - 1));
        update(id);
      }
      Collections.reverse(resultList);
      return resultList;
    }

    private void init(int length) {
      c = new int[length];
      Arrays.fill(c, 0);
    }

    private int lowBit(int x) {
      return x & (-x);
    }

    private void update(int pos) {
      while (pos < c.length) {
        c[pos] += 1;
        pos += lowBit(pos);
      }
    }

    private int query(int pos) {
      int ret = 0;
      while (pos > 0) {
        ret += c[pos];
        pos -= lowBit(pos);
      }

      return ret;
    }

    private void discretization(int[] nums) {
      Set<Integer> set = new HashSet<>();
      for (int num : nums) {
        set.add(num);
      }
      int size = set.size();
      a = new int[size];
      int index = 0;
      for (int num : set) {
        a[index++] = num;
      }
      Arrays.sort(a);
    }

    private int getId(int x) {
      return Arrays.binarySearch(a, x) + 1;
    }
  }
}
