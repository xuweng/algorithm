package com.leetcode.tag.tree.six;

/**
 * 1028. 从先序遍历还原二叉树
 * <p>
 * 数字字符串.
 */
public class RecoverFromPreorder {
    class Solution {
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
            int index = getIndex(S, low, high, length);
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

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
