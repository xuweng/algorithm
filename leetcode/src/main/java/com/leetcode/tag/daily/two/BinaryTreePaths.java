package com.leetcode.tag.daily.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 */
public class BinaryTreePaths {
    class Solution {
        List<String> list = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            back(root, "");

            return list;
        }

        private void back(TreeNode root, String temp) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                list.add(temp + root.val);
                return;
            }
            back(root.left, temp + root.val + "->");
            back(root.right, temp + root.val + "->");
        }
    }

    /**
     * 方法一：深度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-tree-paths/solution/er-cha-shu-de-suo-you-lu-jing-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<>();
            constructPaths(root, "", paths);
            return paths;
        }

        public void constructPaths(TreeNode root, String path, List<String> paths) {
            if (root == null) {
                return;
            }
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(root.val);
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
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
