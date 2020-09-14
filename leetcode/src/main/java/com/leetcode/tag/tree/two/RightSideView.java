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

                    //我们在这层见到的第一个结点一定是最右边的结点
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

    /**
     * 方法二：广度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/er-cha-shu-de-you-shi-tu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public List<Integer> rightSideView(TreeNode root) {
            Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
            int max_depth = -1;

            Queue<TreeNode> nodeQueue = new LinkedList<>();
            Queue<Integer> depthQueue = new LinkedList<>();
            nodeQueue.add(root);
            depthQueue.add(0);

            while (!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.remove();
                int depth = depthQueue.remove();

                if (node != null) {
                    // 维护二叉树的最大深度
                    max_depth = Math.max(max_depth, depth);

                    // 由于每一层最后一个访问到的节点才是我们要的答案，因此不断更新对应深度的信息即可
                    // 不断覆盖key,保留最后一个key
                    rightmostValueAtDepth.put(depth, node.val);

                    nodeQueue.add(node.left);
                    nodeQueue.add(node.right);
                    depthQueue.add(depth + 1);
                    depthQueue.add(depth + 1);
                }
            }

            List<Integer> rightView = new ArrayList<>();
            for (int depth = 0; depth <= max_depth; depth++) {
                rightView.add(rightmostValueAtDepth.get(depth));
            }

            return rightView;
        }
    }

    /**
     * 代码简洁
     */
    class Solution3 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    //一个队列有出队,有入队,队列大小不断改变
                    //只需要0到size之间的元素即可
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    //将当前层的最后一个节点放入结果列表
                    if (i == size - 1) {
                        res.add(node.val);
                    }
                }
            }
            return res;
        }
    }

    /**
     * 二、DFS
     * <p>
     * 我们按照 「根结点 -> 右子树 -> 左子树」 的顺序访问， 就可以保证每层都是最先访问最右边的节点的。
     * <p>
     * （与先序遍历 「根结点 -> 左子树 -> 右子树」 正好相反，先序遍历每层最先访问的是最左边的节点）
     */
    class Solution4 {
        List<Integer> res = new ArrayList<>();

        public List<Integer> rightSideView(TreeNode root) {
            dfs(root, 0); // 从根节点开始访问，根节点深度是0
            return res;
        }

        private void dfs(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            // 先访问 当前节点，再递归地访问 右子树 和 左子树。
            // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            if (depth == res.size()) {
                res.add(root.val);
            }
            dfs(root.right, depth + 1);
            dfs(root.left, depth + 1);
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
