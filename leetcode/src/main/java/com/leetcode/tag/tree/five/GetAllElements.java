package com.leetcode.tag.tree.five;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

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
            //注意合并后的长度.
            int size = list1.size() + list2.size() - 2;

            int list1Index = 0;
            int list2Index = 0;
            for (int i = 0; i < size; i++) {
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

    /**
     * 方法一 前序遍历+排序
     * <p>
     * 作者：yuruiyin
     * 链接：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/solution/java-san-chong-jie-fa-by-npe_tle/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class S {
        private List<Integer> ansList = new ArrayList<>();

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }

            ansList.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }

        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            dfs(root1);
            dfs(root2);

            Collections.sort(ansList);
            return ansList;
        }

    }

    /**
     * 方法三 遍历+优先队列
     * <p>
     * 在树遍历的时候用一个优先队列（默认小根堆）来添加元素；
     * 然后，将优先队列的元素逐个取出到listlist中即可。
     * <p>
     * 作者：yuruiyin
     * 链接：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/solution/java-san-chong-jie-fa-by-npe_tle/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class S1 {
        private PriorityQueue<Integer> priorityQueue;

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }

            priorityQueue.offer(root.val);
            dfs(root.left);
            dfs(root.right);
        }

        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            priorityQueue = new PriorityQueue<>();
            dfs(root1);
            dfs(root2);

            List<Integer> ansList = new ArrayList<>();
            while (!priorityQueue.isEmpty()) {
                ansList.add(priorityQueue.poll());
            }
            return ansList;
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
