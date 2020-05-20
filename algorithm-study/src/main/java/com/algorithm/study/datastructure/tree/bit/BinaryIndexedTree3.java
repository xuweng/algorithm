package com.algorithm.study.datastructure.tree.bit;

public class BinaryIndexedTree3 {
  private int MAX_N;
  private int[] bIT;

  /**
   * Binary Indexed Tree的建立
   *
   * <p>Binary Indexed Tree的建立非常简单。我们只需初始化一个全为0的数组，
   *
   * <p>并对原数组中的每一个位置对应的数字调用一次update(i, delta)操作即可。这是一个O(nlogn)的建立过程。
   *
   * <p>此外，还存在一个O(n)时间简历Binary Indexed Tree的算法，其步骤如下(数组下标从0开始)：
   *
   * <p>给定一个长度为n的输入数组list。
   *
   * <p>初始化长度为n + 1的Binary Indexed Tree数组bit，并将list中的数字对应地放在bit[1]到bit[n]的各个位置。 对于1到n的每一个i，进行如下操作：
   * 令j = i + (i & -i)，若j < n + 1，则bit[j] = bit[j] + bit[i]
   */
  void build(int[] a) {
    for (int i = 1; i <= MAX_N; i++) {
      bIT[i] = a[i - 1];
      for (int j = i - 2; j >= i - lowbit(i); j--) {
        bIT[i] += a[j];
      }
    }
  }

  /**
   * 定义一个Lowbit函数，返回参数转为二进制后,最后一个1的位置所代表的数值.
   *
   * @param x
   * @return
   */
  private int lowbit(int x) {
    return x & (-x);
  }
}
