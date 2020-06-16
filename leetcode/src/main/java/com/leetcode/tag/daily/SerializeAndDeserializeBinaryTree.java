package com.leetcode.tag.daily;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>297. 二叉树的序列化与反序列化
 */
public class SerializeAndDeserializeBinaryTree {
  class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      if (root == null) {
        return "";
      }
      StringBuilder stringBuilder = new StringBuilder();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.poll();
          if (node.val != Integer.MAX_VALUE) {
            stringBuilder.append(node.val);
          } else {
            // 最后一层不需要加上
            stringBuilder.append("null");
          }
          stringBuilder.append(",");
          if (node.left == null) {
            queue.add(new TreeNode(Integer.MAX_VALUE));
          } else {
            if (node.left.val != Integer.MAX_VALUE) {
              queue.add(node.left);
            }
          }
          if (node.right == null) {
            queue.add(new TreeNode(Integer.MAX_VALUE));
          } else {
            if (node.right.val != Integer.MAX_VALUE) {
              queue.add(node.right);
            }
          }
        }
      }

      return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      return null;
    }
  }

  /**
   * 十分钟看答案 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/er-cha-shu-de-xu-lie-hua-yu-fan-xu-lie-hua-by-le-2/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Codec1 {
    /**
     * 使用参数计算
     *
     * <p>使用参数拼接
     *
     * @param root
     * @param str
     * @return
     */
    public String rserialize(TreeNode root, String str) {
      if (root == null) {
        str += "None,";
      } else {
        str += root.val + ",";
        str = rserialize(root.left, str);
        // 用左子树拼接完的结果再拼接右子树。厉害。
        str = rserialize(root.right, str);
      }
      return str;
    }

    public String serialize(TreeNode root) {
      return rserialize(root, "");
    }

    /**
     * 先序遍历
     *
     * @param l
     * @return
     */
    public TreeNode rdeserialize(List<String> l) {
      if ("None".equals(l.get(0))) {
        l.remove(0);
        return null;
      }

      TreeNode root = new TreeNode(Integer.parseInt(l.get(0)));
      l.remove(0);
      root.left = rdeserialize(l);
      root.right = rdeserialize(l);

      return root;
    }

    public TreeNode deserialize(String data) {
      String[] dataArray = data.split(",");
      List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
      return rdeserialize(dataList);
    }
  }

  ;

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
