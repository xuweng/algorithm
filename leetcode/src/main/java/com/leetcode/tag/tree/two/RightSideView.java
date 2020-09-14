package com.leetcode.tag.tree.two;

import java.util.*;

/**
 * 199. 二叉树的右视图
 * <p>
 * 十分钟看答案
 * <p>
 * 十分钟看答案
 */
public class RightSideView {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            return null;
        }
    }

    /**
     * 深度和高度
     * <p>
     * 深度自上往下递增
     * <p>
     * 高度自下往上递增
     * <p>
     * 方法一：深度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/er-cha-shu-de-you-shi-tu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 在搜索过程中，我们总是先访问右子树。那么对于每一层来说，我们在这层见到的第一个结点一定是最右边的结点
         *
         * @param root
         * @return
         */
        public List<Integer> rightSideView(TreeNode root) {
            Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
            int max_depth = -1;

            //使用栈，不是使用队列
            Stack<TreeNode> nodeStack = new Stack<>();
            Stack<Integer> depthStack = new Stack<>();
            nodeStack.push(root);
            depthStack.push(0);

            while (!nodeStack.isEmpty()) {
                TreeNode node = nodeStack.pop();
                int depth = depthStack.pop();

                if (node != null) {
                    // 维护二叉树的最大深度
                    max_depth = Math.max(max_depth, depth);

                    // 如果不存在对应深度的节点我们才插入
                    if (!rightmostValueAtDepth.containsKey(depth)) {
                        rightmostValueAtDepth.put(depth, node.val);
                    }

                    //left和right可能为null
                    //left先入栈,right后入栈.总是先访问right
                    nodeStack.push(node.left);
                    nodeStack.push(node.right);
                    depthStack.push(depth + 1);
                    depthStack.push(depth + 1);
                }
            }

            List<Integer> rightView = new ArrayList<>();
            for (int depth = 0; depth <= max_depth; depth++) {
                rightView.add(rightmostValueAtDepth.get(depth));
            }

            return rightView;
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
