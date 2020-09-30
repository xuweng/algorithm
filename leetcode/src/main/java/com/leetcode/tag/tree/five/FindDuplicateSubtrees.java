package com.leetcode.tag.tree.five;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树.
 * <p>
 * 直接递归不行.
 */
public class FindDuplicateSubtrees {
    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/find-duplicate-subtrees/solution/xun-zhao-zhong-fu-de-zi-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        Map<String, Integer> count;
        List<TreeNode> ans;

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            count = new HashMap<>();
            ans = new ArrayList<>();
            collect(root);
            return ans;
        }

        /**
         * 序列化二叉树。
         * <p>
         * 使用深度优先搜索，其中递归函数返回当前子树的序列化结果。把每个节点开始的子树序列化结果保存在 mapmap 中，然后判断是否存在重复的子树
         *
         * @param node
         * @return 当前树的序列化结果
         */
        public String collect(TreeNode node) {
            if (node == null) {
                return "#";
            }
            //数字字符串拼接一定要隔离
            String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
            count.put(serial, count.getOrDefault(serial, 0) + 1);
            if (count.get(serial) == 2) {
                ans.add(node);
            }
            return serial;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
