package com.leetcode.tag.tree.six;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1028. 从先序遍历还原二叉树
 * <p>
 * 数字字符串.保佑下标没有计算错误.
 */
public class RecoverFromPreorder {
    static class Solution {
        public TreeNode recoverFromPreorder(String S) {
            return recoverFromPreorder(S, 0, S.length() - 1);
        }

        public TreeNode recoverFromPreorder(String S, int low, int high) {
            if (low > high) {
                return null;
            }

            int[] firstIndex = getFirstIndex(S, low, high);
            if (firstIndex[0] == -1 && firstIndex[1] == -1) {
                return new TreeNode(Integer.parseInt(S.substring(low, high + 1)));
            }
            int length = firstIndex[1] - firstIndex[0] + 1;
            int index = getIndex(S, firstIndex[1] + 1, high, length);
            int left = index == -1 ? high : index - length - 1;
            int right = index == -1 ? high + 1 : index;

            TreeNode root = new TreeNode(Integer.parseInt(S.substring(low, firstIndex[0])));
            root.left = recoverFromPreorder(S, firstIndex[1] + 1, left);
            root.right = recoverFromPreorder(S, right, high);
            return root;
        }

        private int[] getFirstIndex(String S, int low, int high) {
            int a = -1, b = -1;
            for (int i = low; i <= high; i++) {
                if (!Character.isDigit(S.charAt(i))) {
                    a = a == -1 ? i : a;
                    b = i;
                }
                if (b != -1 && Character.isDigit(S.charAt(i))) {
                    break;
                }

            }

            return new int[]{a, b};
        }

        private int getIndex(String S, int low, int high, int length) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = low; i <= high; i++) {
                if (Character.isDigit(S.charAt(i))) {
                    if (stringBuilder.length() == length) {
                        return i;
                    }
                    if (stringBuilder.length() > length) {
                        stringBuilder = new StringBuilder();
                    }
                } else {
                    stringBuilder.append(S.charAt(i));
                }
            }
            return -1;
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/solution/cong-xian-xu-bian-li-huan-yuan-er-cha-shu-by-leetc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public TreeNode recoverFromPreorder(String S) {
            Deque<TreeNode> path = new LinkedList<>();
            int pos = 0;
            while (pos < S.length()) {
                int level = 0;
                while (S.charAt(pos) == '-') {
                    ++level;
                    ++pos;
                }
                int value = 0;
                while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                    value = value * 10 + (S.charAt(pos) - '0');
                    ++pos;
                }
                TreeNode node = new TreeNode(value);
                if (level == path.size()) {
                    if (!path.isEmpty()) {
                        path.peek().left = node;
                    }
                } else {
                    while (level != path.size()) {
                        path.pop();
                    }
                    path.peek().right = node;
                }
                path.push(node);
            }
            while (path.size() > 1) {
                path.pop();
            }
            return path.peek();
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
