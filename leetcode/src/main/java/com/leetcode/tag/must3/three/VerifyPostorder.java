package com.leetcode.tag.must3.three;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
public class VerifyPostorder {
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return dfs(postorder, 0, postorder.length - 1);
        }

        private boolean dfs(int[] postorder, int left, int right) {
            if (left >= right) {
                return true;
            }
            int min = right;
            for (int i = right; i >= left; i--) {
                if (postorder[i] < postorder[right]) {
                    // 第一个<root
                    min = i;
                    break;
                }
            }
            for (int i = min; i >= left; i--) {
                if (postorder[i] > postorder[right]) {
                    return false;
                }
            }

            return dfs(postorder, left, min) && dfs(postorder, min + 1, right - 1);
        }
    }
}
