package com.leetcode.tag.tree.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 662. 二叉树最大宽度
 * <p>
 * 十分钟看题解.有些测试用例是一个坑.
 */
public class WidthOfBinaryTree {
    class Solution {
        List<List<Integer>> lists = new ArrayList<>();

        public int widthOfBinaryTree(TreeNode root) {
            pre(root, 0);
            int result = 0;
            for (List<Integer> list : lists) {
                if (list.size() > 1 && list.get(0) != null && list.get(list.size() - 1) != null) {
                    result = Math.max(result, list.size());
                }
            }
            return result;

        }

        private void pre(TreeNode root, int level) {
            if (root == null) {
                if (level < lists.size() && lists.get(level) != null) {
                    lists.get(level).add(null);
                }
                return;
            }
            if (lists.size() == level) {
                lists.add(new ArrayList<>());
            }
            lists.get(level).add(root.val);
            pre(root.left, level + 1);
            pre(root.right, level + 1);
        }
    }

    /**
     * bsf.
     * <p>
     * 标记每个结点
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree/solution/er-cha-shu-zui-da-kuan-du-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 当我们在看同一层深度的位置值 L 和 R 的时候，宽度就是 R - L + 1
         * <p>
         * 对于每一个深度，第一个遇到的节点是最左边的节点，最后一个到达的节点是最右边的节点l
         *
         * @param root
         * @return
         */
        public int widthOfBinaryTree(TreeNode root) {
            Queue<AnnotatedNode> queue = new LinkedList<>();
            queue.add(new AnnotatedNode(root, 0, 0));
            int curDepth = 0, left = 0, ans = 0;
            while (!queue.isEmpty()) {
                AnnotatedNode a = queue.poll();
                if (a.node == null) {
                    continue;
                }
                //null也会入队
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                if (curDepth != a.depth) {
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans, a.pos - left + 1);
            }
            return ans;
        }
    }

    class AnnotatedNode {
        TreeNode node;
        //深度
        int depth;
        //编号
        int pos;

        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
