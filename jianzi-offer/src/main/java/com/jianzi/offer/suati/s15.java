package com.jianzi.offer.suati;

/**
 * 面试题15. 二进制中1的个数
 *
 * <p>复杂度分析： 时间复杂度 O(M)O(M) ： n \& (n - 1)n&(n−1) 操作仅有减法和与运算，占用 O(1)O(1) ；设 MM 为二进制数字 nn 中 11
 * 的个数，则需循环 MM 次（每轮消去一个 11 ），占用 O(M)O(M) 。 空间复杂度 O(1)O(1) ： 变量 resres 使用常数大小额外空间。
 *
 * <p>作者：jyd
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class s15 {
  /**
   * 作者：jyd
   * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param n
   * @return
   */
  public int hammingWeight(int n) {
    int res = 0;
    while (n != 0) {
      res++;
      n &= n - 1;
    }
    return res;
  }
}
