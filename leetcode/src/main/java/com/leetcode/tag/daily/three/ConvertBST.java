package com.leetcode.tag.daily.three;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 538. 把二叉搜索树转换为累加树
 * <p>
 * 核心是反序处理
 */
public class ConvertBST {
    class Solution {
        TreeNode root;
        Map<Integer, Integer> map;

        public TreeNode convertBST(TreeNode root) {
            this.root = root;
            map = new HashMap<>();

            pre(root);
            pre1(root);

            return root;
        }

        private void pre(TreeNode root) {
            if (root == null) {
                return;
            }
            pre(this.root, root.val);
            pre(root.left);
            pre(root.right);
        }

        private void pre1(TreeNode root) {
            if (root == null) {
                return;
            }
            root.val += map.get(root.val);
            pre1(root.left);
            pre1(root.right);
        }

        /**
         * 每次都是遍历原来的tree,会修改原来tree的值
         *
         * @param root
         * @param val
         */
        private void pre(TreeNode root, int val) {
            if (root == null) {
                return;
            }
            if (root.val > val) {
                map.put(val, map.getOrDefault(val, 0) + root.val);
            } else {
                map.put(val, map.getOrDefault(val, 0));
            }
            pre(root.left, val);
            pre(root.right, val);
        }
    }

    class Solution1 {
        public TreeNode convertBST(TreeNode root) {
            List<TreeNode> result = new ArrayList<>();

            zhong(root, result);

            for (int i = 0; i < result.size(); i++) {
                int sum = IntStream.range(i + 1, result.size()).map(j -> result.get(j).val).sum();
                result.get(i).val += sum;
            }

            return root;
        }

        private void zhong(TreeNode root, List<TreeNode> result) {
            if (root == null) {
                return;
            }
            zhong(root.left, result);
            result.add(root);
            zhong(root.right, result);
        }
    }

    /**
     * 方法一：反序中序遍历
     * <p>
     * 厉害.反序中序遍历厉害
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree/solution/ba-er-cha-sou-suo-shu-zhuan-huan-wei-lei-jia-sh-14/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return root;
            }
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
            return root;
        }
    }

    /**
     * 用栈也很厉害
     */
    class Solution3 {
        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return root;
            }
            //用栈也很厉害
            Stack<TreeNode> stack = new Stack<>();
            f(root, stack);

            TreeNode next = stack.pop();
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                cur.val += next.val;
                next = cur;
            }
            return root;
        }

        private void f(TreeNode root, Stack<TreeNode> stack) {
            if (root == null) {
                return;
            }
            f(root.left, stack);
            stack.push(root);
            f(root.right, stack);
        }
    }

    /**
     * 方法二：Morris 遍历
     * <p>
     * 有一种巧妙的方法可以在线性时间内，只占用常数空间来实现中序遍历
     * <p>
     * Morris 遍历的核心思想是利用树的大量空闲指针，实现空间开销的极限缩减
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree/solution/ba-er-cha-sou-suo-shu-zhuan-huan-wei-lei-jia-sh-14/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution4 {
        public TreeNode convertBST(TreeNode root) {
            int sum = 0;
            TreeNode node = root;

            while (node != null) {
                if (node.right == null) {
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                } else {
                    TreeNode succ = getSuccessor(node);
                    if (succ.left == null) {
                        succ.left = node;
                        node = node.right;
                    } else {
                        succ.left = null;
                        sum += node.val;
                        node.val = sum;
                        node = node.left;
                    }
                }
            }

            return root;
        }

        public TreeNode getSuccessor(TreeNode node) {
            TreeNode succ = node.right;
            while (succ.left != null && succ.left != node) {
                succ = succ.left;
            }
            return succ;
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
