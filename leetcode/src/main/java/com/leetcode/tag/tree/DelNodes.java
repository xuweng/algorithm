package com.leetcode.tag.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 1110. 删点成林
 * <p>
 * 十分钟看答案。十分钟看答案。十分钟看答案
 */
public class DelNodes {
    class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            return null;
        }
    }

    /**
     * 后序遍历
     * <p>
     * 作者：milili
     * 链接：https://leetcode-cn.com/problems/delete-nodes-and-return-forest/solution/20xing-hou-xu-bian-li-luo-ji-chao-qing-xi-by-milil/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        Set<Integer> toDelete;

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            toDelete = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
            List<TreeNode> ans = new ArrayList<>();
            helper(root, ans, false);
            return ans;
        }

        /**
         * 带返回的后序遍历
         *
         * @param root
         * @param ans
         * @param parentExists
         * @return
         */
        boolean helper(TreeNode root, List<TreeNode> ans, boolean parentExists) {
            boolean del = false;
            if (root == null) {
                return del;
            }
            del = toDelete.contains(root.val);
            //如果子节点被删除，父节点的left、right字段需要更新
            //将parentExists标志传递给子节点
            if (helper(root.left, ans, !del)) {
                root.left = null;
            }
            if (helper(root.right, ans, !del)) {
                root.right = null;
            }
            if (!del && !parentExists) {
                ans.add(root);
            }
            return del;
        }
    }

    /**
     * 根据示例在脑海里执行一下代码
     * <p>
     * 作者：walker-3
     * 链接：https://leetcode-cn.com/problems/delete-nodes-and-return-forest/solution/javashi-yong-hou-xu-bian-li-de-fang-shi-by-walker-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            // 为了快速判断节点是否要被删除，使用HashSet加快查找
            Set<Integer> deleteSet = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());

            // 给根节点伪造一个父节点
            TreeNode fakeRoot = new TreeNode(0);
            fakeRoot.left = root;

            List<TreeNode> ans = new ArrayList<>();
            foo(ans, fakeRoot, root, deleteSet);
            // 如果根节点还在，别忘记加入根节点
            if (fakeRoot.left != null) {
                ans.add(root);
            }

            return ans;
        }

        // 使用后续遍历方式删除节点，这样不会影响子树的删除
        private void foo(List<TreeNode> ans, TreeNode parent, TreeNode root, Set<Integer> deleteSet) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                foo(ans, root, root.left, deleteSet);
            }
            if (root.right != null) {
                foo(ans, root, root.right, deleteSet);
            }
            // 如果根节点要删除
            if (deleteSet.contains(root.val)) {
                if (root.left != null) {
                    ans.add(root.left);
                }
                if (root.right != null) {
                    ans.add(root.right);
                }
                // 断掉父节点与本节点的连接
                if (parent.left == root) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
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
