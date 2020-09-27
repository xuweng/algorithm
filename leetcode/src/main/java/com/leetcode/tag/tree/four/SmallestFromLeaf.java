package com.leetcode.tag.tree.four;

/**
 * 988. 从叶结点开始的最小字符串
 * <p>
 * 数字字符串是一个坑.数字如何隔离.
 * <p>
 * 数字字符串隔离是一个坑.换一种思路.
 * <p>
 * 十分钟看答案.
 */
public class SmallestFromLeaf {
    class Solution {
        public String smallestFromLeaf(TreeNode root) {
            String[] str = hou(root).split(",");

            StringBuilder result = new StringBuilder();
            for (String s : str) {
                result.append((char) (Integer.parseInt(s) + 97));
            }
            return result.toString();
        }

        public String hou(TreeNode root) {
            if (root == null) {
                return "";
            }
            String left = hou(root.left);
            String right = hou(root.right);

            return right.isEmpty() || left.compareTo(right) <= 0 ? left + root.val + "," : right + root.val + ",";
        }
    }

    /**
     * 方法：暴力法
     * <p>
     * 让我们创建出所有可能的字符串，然后逐一比较，输出字典序最小的那个。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/solution/cong-xie-jie-dian-kai-shi-de-zui-xiao-zi-fu-chuan-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        String ans = "~";

        public String smallestFromLeaf(TreeNode root) {
            dfs(root, new StringBuilder());
            return ans;
        }

        /**
         * 先序遍历
         *
         * @param node
         * @param sb
         */
        public void dfs(TreeNode node, StringBuilder sb) {
            if (node == null) {
                return;
            }
            //int转char.转换这么简单
            sb.append((char) ('a' + node.val));

            //叶子结点.
            if (node.left == null && node.right == null) {
                //反转.叶子->root.
                sb.reverse();
                String S = sb.toString();
                //还原
                sb.reverse();

                //保存最小值
                if (S.compareTo(ans) < 0) {
                    ans = S;
                }
            }

            dfs(node.left, sb);
            dfs(node.right, sb);
            //回溯.干掉最后一个.
            sb.deleteCharAt(sb.length() - 1);
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
