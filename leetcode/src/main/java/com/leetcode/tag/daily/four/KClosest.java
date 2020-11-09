package com.leetcode.tag.daily.four;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 973. 最接近原点的 K 个点
 */
public class KClosest {
    /**
     * 方法一：排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin/solution/zui-jie-jin-yuan-dian-de-k-ge-dian-by-leetcode-sol/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int[][] kClosest(int[][] points, int K) {
            Arrays.sort(points, Comparator.comparingInt(point -> (point[0] * point[0] + point[1] * point[1])));
            return Arrays.copyOfRange(points, 0, K);
        }
    }

    /**
     * 方法二：优先队列
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin/solution/zui-jie-jin-yuan-dian-de-k-ge-dian-by-leetcode-sol/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int[][] kClosest(int[][] points, int K) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((array1, array2) -> array2[0] - array1[0]);
            for (int i = 0; i < K; ++i) {
                pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
            }
            int n = points.length;
            for (int i = K; i < n; ++i) {
                int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
                if (dist < pq.peek()[0]) {
                    pq.poll();
                    pq.offer(new int[]{dist, i});
                }
            }
            int[][] ans = new int[K][2];
            for (int i = 0; i < K; ++i) {
                ans[i] = points[pq.poll()[1]];
            }
            return ans;
        }
    }

    /**
     * 方法三：快速选择（快速排序的思想）
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin/solution/zui-jie-jin-yuan-dian-de-k-ge-dian-by-leetcode-sol/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        Random rand = new Random();

        public int[][] kClosest(int[][] points, int K) {
            int n = points.length;
            randomSelect(points, 0, n - 1, K);
            return Arrays.copyOfRange(points, 0, K);
        }

        public void randomSelect(int[][] points, int left, int right, int K) {
            int pivotId = left + rand.nextInt(right - left + 1);
            int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
            swap(points, right, pivotId);
            int i = left - 1;
            for (int j = left; j < right; ++j) {
                int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
                if (dist <= pivot) {
                    ++i;
                    swap(points, i, j);
                }
            }
            ++i;
            swap(points, i, right);

            //如果 K=i−left+1，那么说明 pivot 就是第 K 个距离最小的点，我们可以结束整个过程

            // [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
            if (K < i - left + 1) {
                //说明第 K 个距离最小的点在 pivot 左侧
                randomSelect(points, left, i - 1, K);
            } else if (K > i - left + 1) {
                //说明第 K 个距离最小的点在 pivot 右侧
                randomSelect(points, i + 1, right, K - (i - left + 1));
            }
        }

        public void swap(int[][] points, int index1, int index2) {
            int[] temp = points[index1];
            points[index1] = points[index2];
            points[index2] = temp;
        }
    }

}
