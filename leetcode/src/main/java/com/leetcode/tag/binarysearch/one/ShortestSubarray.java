package com.leetcode.tag.binarysearch.one;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 862. 和至少为 K 的最短子数组
 * <p>
 * 买股票:交易次数不会改变
 * <p>
 * 卖股票:交易次数+1
 */
public class ShortestSubarray {
    class Solution {
        public int shortestSubarray(int[] A, int K) {
            if (A == null || A.length == 0) {
                return -1;
            }
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < A.length; i++) {
                int sum = A[i];
                if (sum >= K) {
                    result = Math.min(result, 1);
                    break;
                }
                for (int j = i + 1; j < A.length; j++) {
                    sum += A[j];
                    if (sum >= K) {
                        result = Math.min(result, j - i + 1);
                        break;
                    }
                }
            }
            return result == Integer.MAX_VALUE ? -1 : result;
        }
    }

    /**
     * 方法一：滑动窗口
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/solution/he-zhi-shao-wei-k-de-zui-duan-zi-shu-zu-by-leetcod/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int shortestSubarray(int[] A, int K) {
            int n = A.length;
            //用数组 P 表示数组 A 的前缀和
            long[] p = new long[n + 1];
            for (int i = 0; i < n; ++i) {
                p[i + 1] = p[i] + (long) A[i];
            }

            // Want smallest y-x with p[y] - p[x] >= K
            int ans = n + 1; // n+1 is impossible
            //双端队列
            //存放了下标 x：x0, x1, ... 满足 P[x0], P[x1], ... 单调递增
            Deque<Integer> deque = new LinkedList<>(); //opt(y) candidates, as indices of p

            for (int y = 0; y < p.length; ++y) {
                //我们遇到了一个新的下标 y 时，我们会在队尾移除若干元素，直到 P[x0], P[x1], ..., P[y] 单调递增
                // Want opt(y) = largest x with p[x] <= p[y] - K;
                while (!deque.isEmpty() && p[y] <= p[deque.getLast()]) {
                    deque.removeLast();
                }
                //如果 P[y] >= P[x0] + K，则将队首元素移除
                while (!deque.isEmpty() && p[y] >= p[deque.getFirst()] + K) {
                    ans = Math.min(ans, y - deque.removeFirst());
                }

                deque.addLast(y);
            }

            return ans < n + 1 ? ans : -1;
        }
    }

}
