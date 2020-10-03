package com.leetcode.tag.tree.six;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 04.03. 特定深度节点链表
 */
public class ListOfDepth {
    class Solution {
        Map<Integer, ListNode> map = new HashMap<>();
        List<ListNode> result = new ArrayList<>();

        public ListNode[] listOfDepth(TreeNode tree) {
            pre(tree, 0);

            return result.toArray(new ListNode[0]);
        }

        private void pre(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (map.containsKey(level)) {
                map.get(level).next = new ListNode(root.val);
            } else {
                ListNode listNode = new ListNode(root.val);
                result.add(listNode);
                map.put(level, listNode);
            }
            pre(root, level + 1);
            pre(root, level + 1);
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

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
