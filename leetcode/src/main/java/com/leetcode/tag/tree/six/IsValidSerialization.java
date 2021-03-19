package com.leetcode.tag.tree.six;

import java.util.Objects;

/**
 * 331. 验证二叉树的前序序列化
 */
public class IsValidSerialization {
    class Solution {
        int index;

        public boolean isValidSerialization(String preorder) {
            if (preorder == null || preorder.isEmpty()) {
                return false;
            }

            String[] split = preorder.split(",");
            return dfs(split) && index == split.length;
        }

        private boolean dfs(String[] strings) {
            if (index >= strings.length) {
                return false;
            }
            if (Objects.equals(strings[index++], "#")) {
                return true;
            }

            return dfs(strings) && dfs(strings);
        }
    }
}
