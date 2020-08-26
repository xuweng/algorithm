package com.leetcode.tag.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 04.03. 特定深度节点链表
 * <p>
 * 十分钟看题解
 * <p>
 * 十分钟看题解
 * <p>
 * 十分钟看题解
 * <p>
 * 十分钟看题解
 * <p>
 * 层次遍历
 * <p>
 * 层次遍历
 */
public class ListOfDepth {
    static class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            List<List<TreeNode>> listNodes = new ArrayList<>();

            reCeng(tree, listNodes, 0);

            List<ListNode> result = new ArrayList<>();
            for (List<TreeNode> nodes : listNodes) {
                if (nodes.isEmpty()) {
                    continue;
                }
                ListNode head = new ListNode(nodes.get(0).val);
                //注意tail
                //在细节花太多时间
                ListNode tail = head;
                for (int i = 1; i < nodes.size(); i++) {
                    ListNode listNode = new ListNode(nodes.get(i).val);
                    tail.next = listNode;
                    tail = listNode;
                }
                result.add(head);
            }

            return result.toArray(new ListNode[0]);

        }

        /**
         * 模板
         * <p>
         * 递归写层次遍历
         *
         * @param treeNode
         * @param listNodes
         * @param high
         */
        private void reCeng(TreeNode treeNode, List<List<TreeNode>> listNodes, int high) {
            if (treeNode == null) {
                return;
            }
            if (listNodes.size() == high) {
                listNodes.add(new ArrayList<>());
            }
            listNodes.get(high).add(treeNode);
            reCeng(treeNode.left, listNodes, high + 1);
            reCeng(treeNode.right, listNodes, high + 1);
        }
    }

    /**
     * 模板
     * <p>
     * 作者：fisher12
     * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci/solution/ceng-xu-bian-li-by-fisher12/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public ListNode[] listOfDepth(TreeNode tree) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(tree);

            List<ListNode> res = new ArrayList<>();
            //使用了dummy这样的虚拟节点，
            //使得代码相对简洁一些，不用考虑head
            ListNode dummy = new ListNode(0);
            while (!queue.isEmpty()) {
                int size = queue.size();
                ListNode curr = dummy;
                //处理一层
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    curr.next = new ListNode(treeNode.val);
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                    curr = curr.next;
                }
                //dummy.next就是head
                res.add(dummy.next);
                dummy.next = null;
            }

            return res.toArray(new ListNode[]{});
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
