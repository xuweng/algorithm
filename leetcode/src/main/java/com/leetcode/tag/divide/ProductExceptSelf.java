package com.leetcode.tag.divide;

/**
 * 技巧性题目就算了
 *
 * <p>不用浪费时间
 *
 * <p>238. 除自身以外数组的乘积
 */
public class ProductExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    return null;
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/product-of-array-except-self/solution/chu-zi-shen-yi-wai-shu-zu-de-cheng-ji-by-leetcode-/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public int[] productExceptSelf(int[] nums) {
      int length = nums.length;

      // L 和 R 分别表示左右两侧的乘积列表
      int[] L = new int[length];
      int[] R = new int[length];

      int[] answer = new int[length];

      // L[i] 为索引 i 左侧所有元素的乘积
      // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
      L[0] = 1;
      for (int i = 1; i < length; i++) {
        L[i] = nums[i - 1] * L[i - 1];
      }

      // R[i] 为索引 i 右侧所有元素的乘积
      // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
      R[length - 1] = 1;
      for (int i = length - 2; i >= 0; i--) {
        R[i] = nums[i + 1] * R[i + 1];
      }

      // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
      for (int i = 0; i < length; i++) {
        answer[i] = L[i] * R[i];
      }

      return answer;
    }
  }
}
