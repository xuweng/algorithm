package com.leetcode.tag.tree.two;

import java.util.Stack;

/**
 * 617. 合并二叉树
 * <p>
 * 不纠结。不纠结。不纠结。不纠结
 */
public class MergeTrees {
    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return null;
            }
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }

            TreeNode root = new TreeNode(t1.val + t2.val);
            TreeNode left = mergeTrees(t1.left, t2.left);
            TreeNode right = mergeTrees(t1.right, t2.right);

            root.left = left;
            root.right = right;

            return root;
        }
    }

    /**
     * 方法一：递归
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees/solution/he-bing-er-cha-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * }
     */
    class Solution1 {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
    }

    /**
     * 方法二：迭代
     * <p>
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution2 {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                return t2;
            }
            Stack<TreeNode[]> stack = new Stack<>();
            stack.push(new TreeNode[]{t1, t2});
            while (!stack.isEmpty()) {
                TreeNode[] t = stack.pop();
                if (t[0] == null || t[1] == null) {
                    continue;
                }
                t[0].val += t[1].val;
                if (t[0].left == null) {
                    t[0].left = t[1].left;
                } else {
                    stack.push(new TreeNode[]{t[0].left, t[1].left});
                }
                if (t[0].right == null) {
                    t[0].right = t[1].right;
                } else {
                    stack.push(new TreeNode[]{t[0].right, t[1].right});
                }
            }
            return t1;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
