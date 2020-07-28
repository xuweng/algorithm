package com.leetcode.tag.daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 */
public class MaxDepth {
  class Solution {
    int result;

    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      pre(root, 1);

      return result;
    }

    public void pre(TreeNode root, int count) {
      if (root == null) {
        return;
      }
      if (root.left == null && root.right == null) {
        result = Math.max(result, count);
        return;
      }
      pre(root.left, count + 1);
      pre(root.right, count + 1);
    }
  }

  /**
   * 方法一：递归
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int leftHeight = maxDepth(root.left);
      int rightHeight = maxDepth(root.right);

      return Math.max(leftHeight, rightHeight) + 1;
    }
  }

  /**
   * 方法二：广度优先搜索
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution2 {
    /**
     * 不同于广度优先搜索的每次只从队列里拿出一个节点，我们需要将队列里的所有节点都拿出来进行拓展，
     *
     * <p>这样能保证每次拓展完的时候队列里存放的是当前层的所有节点，即我们是一层一层地进行拓展
     *
     * <p>最后我们用一个变量 ans 来维护拓展的次数，该二叉树的最大深度即为 \textit{ans}ans
     *
     * <p>作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode-solution/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      int ans = 0;
      while (!queue.isEmpty()) {
        int size = queue.size();
        while (size > 0) {
          TreeNode node = queue.poll();
          if (node.left != null) {
            queue.offer(node.left);
          }
          if (node.right != null) {
            queue.offer(node.right);
          }
          size--;
        }
        ans++;
      }
      return ans;
    }
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
