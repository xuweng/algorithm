package com.leetcode.tag.divide;

/**
 * 特殊数据结构
 *
 * <p>特殊数据结构.特殊数据结构.特殊数据结构.特殊数据结构.特殊数据结构.特殊数据结构
 *
 * <p>没有思路看答案
 *
 * <p>看答案
 *
 * <p>看答案
 *
 * <p>看答案
 *
 * <p>常规分治
 *
 * <p>常规思路
 *
 * <p>子问题依赖
 *
 * <p>算法正确性
 *
 * <p>算法正确性
 *
 * <p>证明算法正确性
 *
 * <p>答案正确性
 *
 * <p>493. 翻转对
 */
public class ReversePairs {
  /**
   * 归并两个子数组 nums[start .. mid] 和 nums[mid + 1 .. end] 时，
   *
   * <p>我们可以计算出对于前者中的每一个元素 nums[i]，
   *
   * <p>后者中满足 nums[i] > 2 * nums[j] 的 j 的数目
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/reverse-pairs/solution/fan-zhuan-dui-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int reversePairs(int[] nums) {
    return mergesortAndCount(nums, 0, nums.length - 1);
  }

  void merge(int[] a, int start, int mid, int end) {
    int leftLength = (mid - start + 1);
    int rightLength = (end - mid);
    // mid放在l
    // mid一般放在l
    long[] left = new long[leftLength + 1];
    long[] right = new long[rightLength + 1];

    // 哨兵
    left[left.length - 1] = Long.MAX_VALUE;
    right[right.length - 1] = Long.MAX_VALUE;
    for (int j = 0; j < leftLength; j++) {
      left[j] = a[start + j];
    }
    for (int j = 0; j < rightLength; j++) {
      right[j] = a[mid + 1 + j];
    }
    int i = 0, j = 0;
    for (int k = start; k <= end; k++) {
      a[k] = left[i] <= right[j] ? (int) left[i++] : (int) right[j++];
    }
  }

  /**
   * 修改归并排序代码
   *
   * @param a
   * @param start
   * @param end
   * @return
   */
  int mergesortAndCount(int[] a, int start, int end) {
    // 一个数没有逆序对
    if (start >= end) {
      return 0;
    }
    int mid = start + (end - start) / 2;
    int count = mergesortAndCount(a, start, mid) + mergesortAndCount(a, mid + 1, end);
    // 假设左右已经排序?
    // 左和右排序后影响结果?
    // 横跨左右
    for (int i = start; i <= mid; i++) {
      for (int j = mid + 1; j <= end && a[i] > a[j] * 2; j++) {
        count++;
      }
    }
    // 最后才合并
    merge(a, start, mid, end);
    // a已经排序
    return count;
  }

  /**
   * 树状数组和下面的线段树可是亲兄弟了，但他俩毕竟还有一些区别：
   *
   * <p>树状数组能有的操作，线段树一定有； 线段树有的操作，树状数组不一定有。
   *
   * <p>如果用某个数据结构存放了所有已经遍历过的元素的两倍，那么我们希望知道，该数据结构中有多少个元素小于 nums[i]。
   *
   * <p>即我们需要实现支持如下操作的数据结构：
   *
   * <p>对于一个数 x，我们希望找出当前有多少个数小于 x；
   *
   * <p>对于一个数 x，将它的两倍添加到数据结构中。
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/reverse-pairs/solution/fan-zhuan-dui-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * <p>树状数组
   *
   * <p>现多用于高效计算数列的前缀和， 区间和
   *
   * <p>基础的树状数组支持 “添加一个数” 和 “查询当前小于等于某个数的数量” 这两种操作。
   */
  class TreeArray {
    private static final int MAX_N = 100;
    private final int[] BIT = new int[MAX_N];

    void update(int[] bit, int index, int val) {
      while (index > 0) {
        bit[index] += val;
        index -= index & (-index);
      }
    }

    int query(int[] bit, int index) {
      int sum = 0;
      while (index < bit.length) {
        sum += bit[index];
        index += index & (-index);
      }
      return sum;
    }

    /**
     * 定义一个数组 BIT，用以维护A的前缀和
     *
     * @param a
     */
    void build(int[] a) {
      for (int i = 1; i <= MAX_N; i++) {
        BIT[i] = a[i - 1];
        for (int j = i - 2; j >= i - lowbit(i); j--) {
          BIT[i] += a[j];
        }
      }
    }

    /**
     * //算出x二进制的从右往左出现第一个1以及这个1之后的那些0组成数的二进制对应的十进制的数
     *
     * <p>定义一个Lowbit函数，返回参数转为二进制后,最后一个1的位置所代表的数值.
     *
     * <p>例如,Lowbit(34)的返回值将是2；而Lowbit(12)返回4；Lowbit(8)返回8。
     *
     * <p>将34转为二进制,为0010 0010,这里的"最后一个1"指的是从2^0位往前数,见到的第一个1,也就是2^1位上的1.
     *
     * @param x
     * @return
     */
    int lowbit(int x) {
      return x & (-x);
    }
  }
}
