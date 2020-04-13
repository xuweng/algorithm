package com.jianzi.offer.suati;

/**
 * 面试题17. 打印从1到最大的n位数
 *
 * <p>大数溢出
 */
public class s17 {
  /**
   * 解题思路
   *
   * <p>1、快速幂方法。针对本题的常规思路，利用pow函数，秒解
   *
   * <p>2、假设可能出现大数（本题不可能），转换为大数问题求解 本题自己对于大数解法，分别练习了使用char和string两种方式分别进行求解
   *
   * <p>通过使用char数组进行求解 通过使用string进行求解
   *
   * <p>3、递归求解
   *
   * <p>作者：xdb
   * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/c-3chong-jie-fa-by-xdb/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param n
   * @return
   */
  public int[] printNumbers(int n) {
    // 10的n次方
    int max = (int) Math.pow(10, n);
    int[] ans = new int[max - 1];
    for (int i = 1; i <= max - 1; i++) {
      ans[i - 1] = i;
    }
    return ans;
  }
}
