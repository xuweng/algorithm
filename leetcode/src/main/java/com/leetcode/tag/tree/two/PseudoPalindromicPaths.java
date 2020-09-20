package com.leetcode.tag.tree.two;

import java.util.Arrays;

/**
 * 1457. 二叉树中的伪回文路径
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

        /**
         * 先序遍历
         *
         * @param node
         * @param temp
         */
        void helper(TreeNode node, int temp) {
            //node节点的val为几就左移几位
            temp ^= (1 << node.val);
            //判断是否叶子节点
            if (node.left == null && node.right == null) {
                //判断是否为伪回文
                if (temp == 0 || (temp & (temp - 1)) == 0) {
                    ans++;
                }
            }
            //剪枝
            //这种遍历也可以
            //满二叉树.满二叉树.满二叉树
            if (node.left != null) {
                helper(node.left, temp);
            }
            if (node.right != null) {
                helper(node.right, temp);
            }
        }
    }

    /**
     * 方法1.1 DFS + 数组
     * <p>
     * 作者：lixianfeng
     * 链接：https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree/solution/java-by-lixianfeng/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class S {
        int res = 0;

        public int pseudoPalindromicPaths(TreeNode root) {
            int[] arr = new int[10];
            preOrder(root, arr);
            return res;
        }

        public void preOrder(TreeNode root, int[] arr) {
            if (root == null) {
                return;
            }
            //统计结点的个数
            arr[root.val]++;
            // 叶子节点 ，统计数组中奇数个元素的个数
            if (root.left == null && root.right == null) {
                int cnt = (int) Arrays.stream(arr).filter(a -> a % 2 != 0).count();
                // 奇数个元素的小于2，才能组成回文序列
                if (cnt <= 1) {
                    res++;
                }
            }
            // 左节点不为空，将数组拷贝出一个新的，继续前序遍历
            if (root.left != null) {
                preOrder(root.left, Arrays.copyOfRange(arr, 0, arr.length));
            }
            if (root.right != null) {
                preOrder(root.right, Arrays.copyOfRange(arr, 0, arr.length));
            }

        }

    }

    /**
     * 方法1.2 DFS + 位运算（推荐）
     * <p>
     * 作者：lixianfeng
     * 链接：https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree/solution/java-by-lixianfeng/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class S1 {
        int res = 0;

        public int pseudoPalindromicPaths(TreeNode root) {
            preorder(root, 0);

            return res;
        }

        public void preorder(TreeNode root, int num) {
            if (root == null) {
                return;
            }
            //根据异或的性质，相同的节点数值，经过异或为0
            // num ^ (1 << root.val)表示当前val值是多少，就左移val位，并异或
            int tmp = num ^ (1 << root.val);
            // 叶子节点
            if (root.left == null && root.right == null) {
                // 奇数个元素的小于2，才能组成回文序列.奇数个元素为0或者为1.
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

    /**
     * 标准答案了
     */
    class Solution1 {
        int res;

        public int pseudoPalindromicPaths(TreeNode root) {
            int sign = 0;

            dfs(sign, root);
            return res;
        }

        private void dfs(int sign, TreeNode node) {
            sign ^= 1 << node.val;
            if (node.left == null && node.right == null) {
                if (sign == 0 || (sign & sign - 1) == 0) {
                    res++;
                }
            }

            if (node.left != null) {
                dfs(sign, node.left);
            }
            if (node.right != null) {
                dfs(sign, node.right);
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
