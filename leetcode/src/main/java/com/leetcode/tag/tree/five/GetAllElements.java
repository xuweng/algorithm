package com.leetcode.tag.tree.five;

import java.util.ArrayList;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 * <p>
 * 先通过所有示例再提交
 */
public class GetAllElements {
    class Solution {

        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            inorder(root1, list1);
            inorder(root2, list2);

            List<Integer> result = new ArrayList<>();
            int minSize = Math.min(list1.size(), list2.size());
            List<Integer> minList = (list1.size() <= list2.size()) ? list1 : list2;
            List<Integer> maxList = (list1.size() > list2.size()) ? list1 : list2;

            for (int i = 0; i < minSize; i++) {
                if (minList.get(i) <= maxList.get(i)) {
                    result.add(minList.get(i));
                    result.add(maxList.get(i));
                } else {
                    result.add(maxList.get(i));
                    result.add(minList.get(i));
                }
            }
            if (minSize < maxList.size()) {
                result.addAll(maxList.subList(minSize, maxList.size()));
            }
            return result;
        }

        private void inorder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
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
