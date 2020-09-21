package com.leetcode.tag.tree.two;

import java.util.*;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 */
public class LevelOrder {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            level(root, 0);

            for (int i = 1; i < result.size(); i += 2) {
                Collections.reverse(result.get(i));
            }

            return result;
        }

        private void level(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (result.size() == level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            level(root.left, level + 1);
            level(root.right, level + 1);
        }
    }

    /**
     * 方法一：层序遍历 + 双端队列
     * <p>
     * 奇数层正序
     * <p>
     * 偶数层倒序
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/solution/mian-shi-ti-32-iii-cong-shang-dao-xia-da-yin-er--3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            queue.add(root);

            while (!queue.isEmpty()) {
                LinkedList<Integer> tmp = new LinkedList<>();
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    if (res.size() % 2 == 0) {
                        //头插法.倒序
                        tmp.addLast(node.val); // 偶数层 -> 队列头部
                    } else {
                        //尾插法.正序.
                        tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                res.add(tmp);
            }
            return res;
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
