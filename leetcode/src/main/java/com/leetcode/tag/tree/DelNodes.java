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

        boolean helper(TreeNode root, List<TreeNode> ans, boolean parentExists) {
            boolean del = false;
            if (root == null) {
                return del;
            }
            del = toDelete.contains(root.val);
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

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
