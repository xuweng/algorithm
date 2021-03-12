package com.leetcode.tag.daily.eight;

/**
 * 331. 验证二叉树的前序序列化
 */
public class IsValidSerialization {
    static class Solution {
        int index;

        public boolean isValidSerialization(String preorder) {
            if (preorder == null || preorder.isEmpty()) {
                return false;
            }
            String[] split = preorder.split(",");

            return dfs(split) && index == split.length - 1;
        }

        private boolean dfs(String[] split) {
            if (index >= split.length) {
                return false;
            }
            if ("#".equals(split[index++])) {
                return true;
            }

            return dfs(split) && dfs(split);
        }
    }
}
