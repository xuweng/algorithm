package com.leetcode.tag.tree;

/**
 * 剑指 Offer 26. 树的子结构
 * <p>
 * 十分钟。十分钟。十分钟。十分钟。十分钟。十分钟
 * <p>
 * 刷题效率。刷题效率。刷题效率。刷题效率。刷题效率
 * <p>
 * 搞懂题目。搞懂题目。搞懂题目。搞懂题目。搞懂题目。搞懂题目。
 */
public class IsSubStructure {
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {

            return A.val == B.val ? isSubStructure(A.left, B.left) && isSubStructure(A.right, B.right)
                    : isSubStructure(A.left, B) || isSubStructure(A.right, B);
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
