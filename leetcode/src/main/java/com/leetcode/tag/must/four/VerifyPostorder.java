package com.leetcode.tag.must.four;

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
            int i = high;
            while (i >= low && postorder[i] >= postorder[high]) {
                i--;
            }
            int j = i;
            while (j >= low) {
                if (postorder[j] > postorder[high]) {
                    return false;
                }
                j--;
            }

            return dfs(postorder, i + 1, high - 1) && dfs(postorder, low, i);
        }
    }
}
