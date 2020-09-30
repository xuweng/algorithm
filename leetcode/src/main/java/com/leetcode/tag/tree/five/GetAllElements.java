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
            List<Long> list1 = new ArrayList<>();
            List<Long> list2 = new ArrayList<>();

            inorder(root1, list1);
            inorder(root2, list2);

            //哨兵
            list1.add(Long.MAX_VALUE);
            list2.add(Long.MAX_VALUE);

            List<Integer> result = new ArrayList<>();
            int maxSize = Math.max(list1.size(), list2.size());

            int list1Index = 0;
            int list2Index = 0;
            for (int i = 0; i < maxSize; i++) {
                //注意数组越界
                if (list1.get(list1Index) <= list2.get(list2Index)) {
                    result.add(Math.toIntExact(list1.get(list1Index)));
                    list1Index++;
                } else {
                    result.add(Math.toIntExact(list2.get(list2Index)));
                    list2Index++;
                }
            }
            return result;
        }

        private void inorder(TreeNode root, List<Long> list) {
            if (root == null) {
                return;
            }
            inorder(root.left, list);
            list.add((long) root.val);
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
