package com.leetcode.tag.tree.two;

/**
 * 606. 根据二叉树创建字符串
 * <p>
 * 慢慢想
 */
public class Tree2Str {
    /**
     * 没有去掉多余括号
     */
    class Solution {
        public String tree2str(TreeNode t) {
            if (t == null) {
                return "";
            }
            if (t.left == null && t.right == null) {
                return t.val + "";
            }

            String left = "(" + tree2str(t.left) + ")";
            String right = "(" + tree2str(t.right) + ")";

            return t.val + left + right;
        }
    }

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree/solution/gen-ju-er-cha-shu-chuang-jian-zi-fu-chuan-by-leetc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * }
     */
    class Solution1 {
        public String tree2str(TreeNode t) {
            if (t == null) {
                return "";
            }
            if (t.left == null && t.right == null) {
                return t.val + "";
            }
            //就差这个条件
            //根据示例，这样去掉括号
            if (t.right == null) {
                return t.val + "(" + tree2str(t.left) + ")";
            }
            return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
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
