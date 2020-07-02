package com.leetcode.tag.daily;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第K小的元素
 *
 * <p>上述三种解法，第一种没有利用矩阵的性质，所以时间复杂度最差；
 *
 * <p>第二种解法只利用了一部分性质（每一行是一个有序数列，而忽视了列之间的关系）；
 *
 * <p>第三种解法则利用了全部性质，所以时间复杂度最佳。
 */
public class KthSmallest {
  public int kthSmallest(int[][] matrix, int k) {
    return 0;
  }

  /**
   * 方法一：直接排序 思路及算法
   *
   * <p>最直接的做法是将这个二维数组另存为为一维数组，并对该一维数组进行排序。最后这个一维数组中的第 kk 个数即为答案
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-by-leetco/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public int kthSmallest(int[][] matrix, int k) {
      int rows = matrix.length, columns = matrix[0].length;
      int[] sorted = new int[rows * columns];
      int index = 0;
      for (int[] row : matrix) {
        for (int num : row) {
          sorted[index++] = num;
        }
      }
      Arrays.sort(sorted);
      return sorted[k - 1];
    }
  }

  /**
   * 方法二：归并排序
   *
   * <p>n个排序数组归并。n个排序数组merge。每个数组取最小值。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-by-leetco/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    /**
     * 方法二：归并排序 思路及算法
     *
     * <p>由题目给出的性质可知，这个矩阵的每一行均为一个有序数组。
     *
     * <p>问题即转化为从这 n 个有序数组中找第 k 大的数，可以想到利用归并排序的做法，归并到第 k 个数即可停止。
     *
     * <p>一般归并排序是两个数组归并，而本题是 n 个数组归并，所以需要用小根堆维护，以优化时间复杂度。
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
      // 扫描二维数组,最小堆先入k个元素?时间复杂度为O(nlogn)
      PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
      int n = matrix.length;
      // 第一列入堆
      for (int i = 0; i < n; i++) {
        // {值，行，列}
        pq.offer(new int[]{matrix[i][0], i, 0});
      }
      // n个排序数组归并。n个排序数组merge。
      // 取出堆顶值后，堆顶值对应的行的数组的下一个元素入堆。
      for (int i = 0; i < k - 1; i++) {
        int[] now = pq.poll();
        if (now[2] != n - 1) {
          pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
        }
      }
      return pq.poll()[0];
    }
  }

  /**
   * 方法三：二分查找
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-by-leetco/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution3 {
    /**
     * 取一些 mid 值，通过画图以加深理解
     *
     * <p>每个mid的走法时间复杂度为 O(n)，即我们可以线性计算对于任意一个 mid，矩阵中有多少数不大于它
     *
     * <p>每次对于「猜测」的答案 mid，计算矩阵中有多少数不大于 mid ：
     *
     * <p>如果数量不少于 k，那么说明最终答案 x 不大于 mid； 如果数量少于 k，那么说明最终答案 x 大于 mid。
     *
     * <p>锯齿线
     *
     * <p>图解。图解。图解。图解。图解。图解。图解
     *
     * <p>matrix[0][0] 为最小值，matrix[n−1][n−1] 为最大值，现在我们将其分别记作 l和 r。
     *
     * <p>可以发现一个性质：任取一个数 mid 满足 l< mid < r，
     *
     * <p>作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-by-leetco/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
      int n = matrix.length;
      int left = matrix[0][0];
      int right = matrix[n - 1][n - 1];
      while (left < right) {
        int mid = left + ((right - left) >> 1);
        if (check(matrix, mid, k, n)) {
          // mid划分过大，减少mid
          right = mid;
        } else {
          // mid划分过小，增加mid
          left = mid + 1;
        }
      }
      return left;
    }

    /**
     * 每个mid的走法时间复杂度为 O(n)，即我们可以线性计算对于任意一个 mid，矩阵中有多少数不大于它
     *
     * @param matrix
     * @param mid
     * @param k
     * @param n
     * @return
     */
    public boolean check(int[][] matrix, int mid, int k, int n) {
      int i = n - 1;
      int j = 0;
      int num = 0;
      while (i >= 0 && j < n) {
        if (matrix[i][j] <= mid) {
          num += i + 1;
          j++;
        } else {
          i--;
        }
      }
      return num >= k;
    }
  }
}
