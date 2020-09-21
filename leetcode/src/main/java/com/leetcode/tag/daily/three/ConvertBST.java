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

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
