package com.leetcode.tag.binarysearch.one;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 668. 乘法表中第k小的数
 */
public class FindKthNumber {
    /**
     * 方法一：暴力法[超过内存限制]
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table/solution/cheng-fa-biao-zhong-di-kxiao-de-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int findKthNumber(int m, int n, int k) {
            int[] table = new int[m * n];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    table[(i - 1) * n + j - 1] = i * j;
                }
            }
            Arrays.sort(table);
            return table[k - 1];
        }
    }

    /**
     * 方法二：Next Heap[超过时间限制]
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table/solution/cheng-fa-biao-zhong-di-kxiao-de-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int findKthNumber(int m, int n, int k) {
            //维护每行中最小的未使用的元素堆
            PriorityQueue<Node> heap = new PriorityQueue<>(m, Comparator.comparingInt(node -> node.val));
            for (int i = 1; i <= m; i++) {
                heap.offer(new Node(i, i));
            }

            Node node = null;
            for (int i = 0; i < k; i++) {
                node = heap.poll();
                int nxt = node.val + node.root;
                if (nxt <= node.root * n) {
                    heap.offer(new Node(nxt, node.root));
                }
            }
            return node.val;
        }
    }

    class Node {
        int val;
        int root;

        public Node(int v, int r) {
            val = v;
            root = r;
        }
    }

    /**
     * 方法三：二分搜索[通过]
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table/solution/cheng-fa-biao-zhong-di-kxiao-de-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public boolean enough(int x, int m, int n, int k) {
            int count = 0;
            for (int i = 1; i <= m; i++) {
                count += Math.min(x / i, n);
            }
            return count >= k;
        }

        public int findKthNumber(int m, int n, int k) {
            int left = 1, right = m * n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (!enough(mid, m, n, k)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }

}
