package com.leetcode.tag.daily.one;

import java.util.*;

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
     * 先序遍历
     *
     * <p>使用参数计算
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
     * 反序列化
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

  /**
   * 优秀代码
   *
   * <p>优秀代码
   *
   * <p>优秀代码
   *
   * <p>优秀代码
   *
   * <p>优秀代码
   */
  class Codec2 {
    TreeNode tmp = null;
    List<Integer> pre = new ArrayList<>();
    List<Integer> in = new ArrayList<>();

    public String serialize(TreeNode root) {
      StringBuilder ans = new StringBuilder();
      if (root == null) {
        return "";
      }
      preOrder(root);
      inOrder(root);
      tmp = root;
      return ans.toString();
    }

    // 先序遍历
    void preOrder(TreeNode root) {
      if (root == null) {
        return;
      }
      pre.add(root.val);
      preOrder(root.left);
      preOrder(root.right);
    }

    // 中序遍历
    void inOrder(TreeNode root) {
      if (root == null) {
        return;
      }
      inOrder(root.left);
      in.add(root.val);
      inOrder(root.right);
    }

    public TreeNode deserialize(String data) {
      return tmp;
    }

    TreeNode buildTree(
            int[] p, int[] i, int pstart, int pend, int istart, int iend, Map<Integer, Integer> map) {
      if (pstart > pend || istart > iend) {
        return null;
      }
      TreeNode root = new TreeNode(p[pstart]);
      int index = map.get(p[pstart]);
      root.left = buildTree(p, i, pstart + 1, pstart + index - istart, istart, index - 1, map);
      root.right = buildTree(p, i, pstart + index - istart + 1, pend, index + 1, iend, map);
      return root;
    }
  }

  /**
   * 优秀代码
   *
   * <p>优秀代码
   *
   * <p>优秀代码
   *
   * <p>优秀代码
   */
  class Codec3 {

    int index = 0; // 记录遍历到的string的下标

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder str = new StringBuilder();
      dfs1(root, str);
      return str.toString();
    }

    /**
     * 用一个全局StringBuilder，不是用String
     *
     * @param root
     * @param str
     */
    public void dfs1(TreeNode root, StringBuilder str) {
      if (root == null) { // 先序遍历，先处理根节点
        str.append("#,");
        return;
      }
      str.append(root.val).append(",");
      dfs1(root.left, str); // 再递归遍历左子树
      dfs1(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

      return dfs2(data);
    }

    public TreeNode dfs2(String data) {
      if (data.charAt(index) == '#') {
        index += 2; // 跳过‘#’，和‘，’
        return null;
      }
      boolean isMinus = false;
      if (data.charAt(index) == '-') {
        isMinus = true;
        index++; // 跳过减号
      }
      int t = 0;
      while (data.charAt(index) != ',') {
        t = t * 10 + data.charAt(index) - '0';
        index++; // 算好一个数的每位数
      }
      index++; // 跳过逗号
      if (isMinus) {
        t = -t;
      }
      TreeNode root = new TreeNode(t);
      root.left = dfs2(data);
      root.right = dfs2(data);
      return root;
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
