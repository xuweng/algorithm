package com.leetcode.tag.dfs.two;

import java.util.*;

/**
 * 934. 最短的桥
 * <p>
 * 缓存.dp.
 * <p>
 * 十分钟.十分钟.十分钟.
 */
public class ShortestBridge {
    /**
     * 方法一：搜索
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/shortest-bridge/solution/zui-duan-de-qiao-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int shortestBridge(int[][] A) {
            int R = A.length, C = A[0].length;
            int[][] colors = getComponents(A);

            //对数组 A 中的 1 进行深度优先搜索，可以得到两座岛的位置集合，分别为 source 和 target
            Queue<Node> queue = new LinkedList<>();
            Set<Integer> target = new HashSet<>();

            for (int r = 0; r < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    //source染色为1
                    if (colors[r][c] == 1) {
                        queue.add(new Node(r, c, 0));
                    } else if (colors[r][c] == 2) {
                        //target染色为2
                        target.add(r * C + c);
                    }
                }
            }

            //从 source 中的所有位置开始进行广度优先搜索，当它们到达了 target 中的任意一个位置时，搜索的层数就是答案
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (target.contains(node.r * C + node.c)) {
                    return node.depth - 1;
                }
                for (int nei : neighbors(A, node.r, node.c)) {
                    int nr = nei / C, nc = nei % C;
                    if (colors[nr][nc] != 1) {
                        queue.add(new Node(nr, nc, node.depth + 1));
                        colors[nr][nc] = 1;
                    }
                }
            }

            throw null;
        }

        public int[][] getComponents(int[][] A) {
            int R = A.length, C = A[0].length;
            int[][] colors = new int[R][C];
            int t = 0;

            for (int r0 = 0; r0 < R; ++r0) {
                for (int c0 = 0; c0 < C; ++c0) {
                    if (colors[r0][c0] == 0 && A[r0][c0] == 1) {
                        // 用栈dfs
                        // Start dfs
                        Stack<Integer> stack = new Stack<>();
                        stack.push(r0 * C + c0);
                        colors[r0][c0] = ++t;

                        while (!stack.isEmpty()) {
                            int node = stack.pop();
                            int r = node / C, c = node % C;
                            for (int nei : neighbors(A, r, c)) {
                                int nr = nei / C, nc = nei % C;
                                if (A[nr][nc] == 1 && colors[nr][nc] == 0) {
                                    colors[nr][nc] = t;
                                    stack.push(nr * C + nc);
                                }
                            }
                        }
                    }
                }
            }

            return colors;
        }

        public List<Integer> neighbors(int[][] A, int r, int c) {
            int R = A.length, C = A[0].length;
            List<Integer> ans = new ArrayList<>();
            if (0 <= r - 1) {
                ans.add((r - 1) * R + c);
            }
            if (0 <= c - 1) {
                ans.add(r * R + (c - 1));
            }
            if (r + 1 < R) {
                ans.add((r + 1) * R + c);
            }
            if (c + 1 < C) {
                ans.add(r * R + (c + 1));
            }
            return ans;
        }
    }

    class Node {
        int r, c, depth;

        Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            depth = d;
        }
    }

}
