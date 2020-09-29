package com.leetcode.tag.tree.four;

/**
 * 449. 序列化和反序列化二叉搜索树
 */
public class Codec {
    private int root;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        pre(root, stringBuilder);

        return stringBuilder.toString();
    }

    private void pre(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("#").append(",");
            return;
        }
        stringBuilder.append(root.val).append(",");
        pre(root.left, stringBuilder);
        pre(root.right, stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(data.split(","));
    }

    private TreeNode deserialize(String[] data) {
        if ("#".equals(data[root])) {
            root++;
            return null;
        }
        TreeNode rootNode = new TreeNode(Integer.parseInt(data[root++]));
        rootNode.left = deserialize(data);
        rootNode.right = deserialize(data);

        return rootNode;
    }

    /**
     * 普通的二叉树需要两种遍历结果才能固定二叉树，而对于BST，得到BST的前序遍历，根据BST的性质，第一个元素值为根节点，
     * <p>
     * 所有小于根节点的元素为左子树，使用大于根节点的元素为右子树
     * <p>
     * 作者：mmmmmJCY
     * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-bst/solution/java-shi-yong-qian-xu-bian-li-jin-xing-xu-lie-hua-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Codec1 {
        // Encodes a tree to a single string.
        //BST的前序遍历结果
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            helper(root, sb);
            return sb.substring(0, sb.length() - 1);
        }

        private void helper(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            //拼接当前节点
            sb.append(root.val).append(",");
            helper(root.left, sb);
            helper(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }
            String[] arr = data.split(",");
            return builder(arr, 0, arr.length - 1);
        }

        private TreeNode builder(String[] arr, int low, int high) {
            if (low > high) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(arr[low]));
            //找到第一个比首元素大的元素位置.就是right.
            int index = high + 1;
            for (int i = low + 1; i <= high; i++) {
                if (Integer.parseInt(arr[i]) > root.val) {
                    index = i;
                    break;
                }
            }
            //递归构建子树
            root.left = builder(arr, low + 1, index - 1);
            root.right = builder(arr, index, high);
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
