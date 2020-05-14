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
  public int reversePairs(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        long n1 = nums[i];
        // 加和乘导致大数溢出
        long n2 = 2 * nums[j];
        if (n2 < Integer.MAX_VALUE && n1 > n2) {
          count++;
        }
      }
    }
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
