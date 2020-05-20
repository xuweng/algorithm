package com.algorithm.study.datastructure.tree.bit;

/**
 * C[i] = A[i - lowbit(i)+1] + A[i - lowbit(i)+2] + ... + A[i]; //k为i的二进制中从最低位到高位连续零的长度
 *
 * <p>例如i = 8(1000)时候，k = 3，可自行验证。
 */
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
   *
   * <p>https://zh.wikipedia.org/wiki/%E6%A0%91%E7%8A%B6%E6%95%B0%E7%BB%84
   *
   * @param a
   */
  void build(int[] a) {
    for (int i = 1; i <= MAX_N; i++) {
      bIT[i] = a[i];
      // 从后往前计算
      int start = i - lowbit(i) + 1;
      int end = i - 1;
      for (int j = end; j >= start; j--) {
        bIT[i] += a[j];
      }
    }
  }

  /**
   * 修改 假设现在要将A[i]的值增加delta，
   *
   * <p>那么，需要将BIT[i]覆盖的区间包含A[i]的值都加上delta，
   *
   * <p>这个过程可以写成递归，或者普通的循环。
   *
   * <p>需要计算的次数与数据规模N的二进制位数有关，即这部分的时间复杂度是O(LogN)
   *
   * @param i
   * @param delta
   */
  void edit(int i, int delta) {
    for (int j = i; j <= MAX_N; j += lowbit(j)) {
      bIT[j] += delta;
    }
  }

  /**
   * x这个节点所含区间元素个数
   *
   * <p>定义一个Lowbit函数，返回参数转为二进制后,最后一个1的位置所代表的数值.
   *
   * @param x
   * @return
   */
  public int lowbit(int x) {
    return x & (-x);
  }
}
