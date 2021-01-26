package com.leetcode.tag.daily.seven;

/**
 * 1457. 二叉树中的伪回文路径
 * <p>
 * 状态压缩
 * <p>
 * 把两个有序整数用一个整数表示，其实是比较常见的「状态压缩」
 */
public class PseudoPalindromicPaths {
    /**
     * 作者：rational-irrationality
     * 链接：https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree/solution/java-dfs-shuang-bai-by-rational-irrationality/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        int ans = 0;

        public int pseudoPalindromicPaths(TreeNode root) {
            if (root == null) {
                return 0;
            }
            helper(root, 0);

            return ans;
        }

        void helper(TreeNode node, int temp) {
            temp ^= (1 << node.val);//node节点的val为几就左移几位
            if (node.left == null && node.right == null) {//判断是否叶子节点
                if (temp == 0 || (temp & (temp - 1)) == 0) {//判断是否为伪回文
                    ans++;
                }
            }
            if (node.left != null) {
                helper(node.left, temp);
            }
            if (node.right != null) {
                helper(node.right, temp);
            }
        }
    }

    class Solution1 {
        int res = 0;

        public int pseudoPalindromicPaths(TreeNode root) {
            preorder(root, 0);

            return res;
        }

        /**
         * 回文：奇数个元素<=1 奇数个数为0或者为1
         * <p>
         * 奇数个数为1:121（1，2） 奇数个数为0:1111（4） 奇数个数为2:1211（1，3）
         *
         * @param root
         * @param num
         */
        public void preorder(TreeNode root, int num) {
            if (root == null) {
                return;
            }
            //根据异或的性质，相同的节点数值，经过异或为0
            // num ^ (1 << root.val)表示当前val值是多少，就左移val位，并异或
            int tmp = num ^ (1 << root.val);
            // 叶子节点
            if (root.left == null && root.right == null) {
                // tmp==0表示当前路径奇数个元素的个数为0
                // tmp&(tmp-1)会消除tmp中二进制位的最右边一个1，值等于0，表示只有一个1，奇数个元素的个数为1
                if (tmp == 0 || (tmp & (tmp - 1)) == 0) {
                    res++;
                }
            }
            if (root.left != null) {
                preorder(root.left, tmp);
            }
            if (root.right != null) {
                preorder(root.right, tmp);
            }
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
