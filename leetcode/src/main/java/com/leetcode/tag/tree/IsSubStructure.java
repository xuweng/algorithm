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

    /**
     * 遍历+判断
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 先序遍历树 A 中的每个节点 n_An
         * <p>
         * 先序遍历?
         * <p>
         * 中序遍历倒序遍历
         * <p>
         * 结点的先序遍历。树的先序遍历。
         * <p>
         * 在A里面搜索B。把B放到A里面搜索
         *
         * @param A
         * @param B
         * @return
         */
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            //!=null才会先序遍历
            return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
        }

        /**
         * 判断树 A 中 以 n_A为根节点的子树 是否包含树 B
         *
         * @param A
         * @param B
         * @return
         */
        boolean recur(TreeNode A, TreeNode B) {
            //当作true来处理
            if (B == null) {
                return true;
            }
            if (A == null || A.val != B.val) {
                return false;
            }
            return A.val == B.val && recur(A.left, B.left) && recur(A.right, B.right);
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
