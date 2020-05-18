package com.leetcode.tag.daily;

/**
 * 以 nums[i] 结尾，这是一个经验，可以简化讨论。
 *
 * <p>提示：以 nums[i] 结尾这件事情很重要，贯穿整个解题过程始终，请大家留意。
 *
 * <p>“最大子数组和”是DP算法里的经典案例之一，经典到这个解法甚至有一个名称Kadane's Algorithm。
 *
 * <p>本题是“最大子数组和”的变型，但Kadane's Algo依然适用。
 *
 * <p>唯一要注意的是“乘法”下由于两个负数的乘积也依然可能得到一个很大的正数，
 *
 * <p>所以必须同时计算“最小子数组和”，除此之外无任何区别。Kadane's Algo变型可以解决问题还有：
 *
 * <p>dp状态不够,添加状态
 *
 * <p>dp状态不够添加dp状态
 *
 * <p>一个数组多维状态或者多个数组
 *
 * <p>152. 乘积最大子数组
 */
public class MaxProduct {
  /**
   * 方法一：动态规划 思路和算法
   *
   * <p>如果我们用 f_{\max}(i)f max ​ (i) 开表示以第 ii 个元素结尾的乘积最大子数组的乘积，aa 表示输入参数 nums，那么根据「53.
   * 最大子序和」的经验，我们很容易推导出这样的状态转移方程：
   *
   * <p>f_{\max}(i) = \max_{i = 1}^{n} \{ f(i - 1) \times a_i, a_i \} f max ​ (i)= i=1 max n ​
   * {f(i−1)×a i ​ ,a i ​ }
   *
   * <p>它表示以第 ii 个元素结尾的乘积最大子数组的乘积可以考虑 a_ia i ​ 加入前面的 f_{\max}(i - 1)f max ​ (i−1)
   * 对应的一段，或者单独成为一段，这里两种情况下取最大值。求出所有的 f_{\max}(i)f max ​ (i) 之后选取最大的一个作为答案。
   *
   * <p>可是在这里，这样做是错误的。为什么呢？
   *
   * <p>因为这里的定义并不满足「最优子结构」。具体地讲，如果 a = \{ 5, 6, -3, 4, -3 \}a={5,6,−3,4,−3}，那么此时 f_{\max}f max ​
   * 对应的序列是 \{ 5, 30, -3, 4, -3 \}{5,30,−3,4,−3}，按照前面的算法我们可以得到答案为
   * 3030，即前两个数的乘积，而实际上答案应该是全体数字的乘积。我们来想一想问题出在哪里呢？问题出在最后一个 -3−3 所对应的 f_{\max}f max ​ 的值既不是 -3−3，也不是
   * 4 \times -34×−3，而是 5 \times 30 \times (-3) \times 4 \times
   * (-3)5×30×(−3)×4×(−3)。所以我们得到了一个结论：当前位置的最优解未必是由前一个位置的最优解转移得到的。
   *
   * @param nums
   * @return
   */
  class Solution {
    /**
     * 两两划分保险.两两划分只需要考虑左右
     *
     * <p>-1划分.可能考虑f(i-1).也可能考虑1--------->f(i-1)
     *
     * <p>第i-1可以推导i?
     *
     * <p>f(i-1)--------------------------->f(i)?
     *
     * <p>f(1),f(2),f(3).....f(i-1)-------->f(i)?
     *
     * <p>fmin(i)，它表示以第i个元素结尾的乘积最小子数组的乘积
     *
     * <p>代表第 i 个元素结尾的乘积最大子数组的乘积 fmax(i)，
     *
     * <p>可以考虑把 ai ​加入第 i−1 个元素结尾的乘积最大或最小的子数组的乘积中，二者加上 ai ​ ，三者取大，就是第 i
     *
     * <p>个元素结尾的乘积最大子数组的乘积。第 i 个元素结尾的乘积最小子数组的乘积 fmin(i) 同理。
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
      // 代表第 i 个元素结尾的乘积最大子数组的乘积
      int[][] dp = new int[nums.length][2];
      dp[0][0] = nums[0];
      dp[0][1] = nums[0];
      int ans = nums[0];
      for (int i = 1; i < nums.length; ++i) {
        // 相乘导致大数溢出
        // 三者取大
        dp[i][0] = Math.max(dp[i - 1][0] * nums[i], Math.max(nums[i], dp[i - 1][1] * nums[i]));
        // 三者取小
        dp[i][1] = Math.min(dp[i - 1][0] * nums[i], Math.min(nums[i], dp[i - 1][1] * nums[i]));
        ans = Math.max(ans, dp[i][0]);
      }
      return ans;
    }
  }

  public int maxProduct1(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    return re(nums, 0, nums.length - 1)[0];
  }

  /**
   * 两两划分太好用
   *
   * <p>两两划分vs-1划分
   *
   * <p>需要返回两个数:最大正数和最小负数
   *
   * @param nums
   * @param low
   * @param high
   * @return
   */
  public int[] re(int[] nums, int low, int high) {
    if (low > high) {
      return null;
    }
    if (low == high) {
      return new int[]{nums[low], nums[low]};
    }

    int mid = low + (high - low) / 2;
    int[] left = re(nums, low, mid);
    int[] right = re(nums, mid + 1, high);

    int leftMax = Integer.MIN_VALUE;
    int leftMin = Integer.MAX_VALUE;
    int leftp = 1;
    for (int i = mid; i >= low; i--) {
      leftp *= nums[i];
      leftMax = Math.max(leftMax, leftp);
      leftMin = Math.min(leftMin, leftp);
    }
    int rightMax = Integer.MIN_VALUE;
    int rightMin = Integer.MAX_VALUE;
    int rithtP = 1;
    for (int i = mid + 1; i <= high; i++) {
      rithtP *= nums[i];
      rightMax = Math.max(rightMax, rithtP);
      rightMin = Math.min(rightMin, rithtP);
    }
    int l1 = leftMax * rightMax;
    int l2 = leftMax * rightMin;
    int l3 = leftMin * rightMax;
    int l4 = leftMin * rightMin;

    int midMin = Math.min(Math.min(l1, l2), Math.min(l3, l4));
    int midMax = Math.max(Math.max(l1, l2), Math.max(l3, l4));

    // left,mid,right已经求出来.合并
    int[] result = new int[2];
    result[0] = Math.max(midMax, Math.max(left[0], right[0]));
    result[1] = Math.max(midMin, Math.max(left[1], right[1]));

    return result;
  }

  /**
   * 暴力法
   *
   * <p>枚举所有连续子数组
   *
   * @param nums
   * @return
   */
  public int maxProduct2(int[] nums) {
    // 思路：暴力穷举所有子数组，然后得出最大值
    int len = nums.length;
    if (len == 0) {
      return 0;
    }
    long max = Long.MIN_VALUE;
    for (int i = 0; i < len; i++) {
      int numCount = 1;
      for (int j = i; j < len; j++) {
        numCount *= nums[j];
        max = Math.max(numCount, max);
      }
    }
    return (int) max;
  }
}
