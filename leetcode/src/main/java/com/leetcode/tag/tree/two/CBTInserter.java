package com.leetcode.tag.tree.two;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 919. 完全二叉树插入器
 * <p>
 * 直接看题解
 * <p>
 * 使用used就可以.used和begin不会一起使用.
 * <p>
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/complete-binary-tree-inserter/solution/wan-quan-er-cha-shu-cha-ru-qi-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CBTInserter {
    TreeNode root;
    Deque<TreeNode> deque;

    public CBTInserter(TreeNode root) {
        this.root = root;
        deque = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // BFS to populate deque
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null || node.right == null) {
                deque.offerLast(node);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));
        if (node.left == null) {
            node.left = deque.peekLast();
        } else {
            node.right = deque.peekLast();
            deque.pollFirst();
        }

        return node.val;
    }

    public TreeNode get_root() {
        return root;
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

