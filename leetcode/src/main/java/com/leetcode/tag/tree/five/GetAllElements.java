package com.leetcode.tag.tree.five;

import java.util.ArrayList;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 */
public class GetAllElements {
    class Solution {

        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            inorder(root1, list1);
            inorder(root2, list2);

            List<Integer> result = new ArrayList<>();
            int minSize = Math.max(list1.size(), list2.size());
            List<Integer> list3 = (list1.size() < list2.size()) ? list1 : list2;
            List<Integer> list4 = (list1.size() > list2.size()) ? list1 : list2;

            for (int i = 0; i < minSize; i++) {
                if (list3.get(i) <= list4.get(i)) {
                    result.add(list3.get(i));
                    result.add(list4.get(i));
                } else {
                    result.add(list4.get(i));
                    result.add(list3.get(i));
                }
            }
            if (minSize < list4.size()) {
                result.addAll(minSize, list4);
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
