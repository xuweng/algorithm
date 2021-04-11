package com.leetcode.tag.must.five;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
public class VerifyPostorder {
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            if (postorder == null || postorder.length == 0) {
                return true;
            }

            return dfs(postorder, 0, postorder.length - 1);
        }

        private boolean dfs(int[] postorder, int low, int high) {
            if (low >= high) {
                return true;
            }
            // 左子树最后一个结点
            int i = high;
            while (i >= low && postorder[i] >= postorder[high]) {
                i--;
            }
            for (int j = i; j >= low; j--) {
                if (postorder[j] >= postorder[high]) {
                    return false;
                }
            }

            return dfs(postorder, i + 1, high - 1) && dfs(postorder, low, i);
        }
    }
}
