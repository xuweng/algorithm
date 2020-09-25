package com.leetcode.tag.tree.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 958. 二叉树的完全性检验
 */
public class IsCompleteTree {
    /**
     * 树中所有节点的编号按照广度优先搜索顺序正好是升序
     * <p>
     * 们检测编号序列是否为无间隔的.检查最后一个编号是否正确，因为最后一个编号的值最大
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/solution/er-cha-shu-de-wan-quan-xing-jian-yan-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            List<ANode> nodes = new ArrayList<>();
            //对于根节点，我们定义其编号为 1
            nodes.add(new ANode(root, 1));
            int cur = 0;
            while (cur < nodes.size()) {
                ANode anode = nodes.get(cur++);
                if (anode.node != null) {
                    nodes.add(new ANode(anode.node.left, anode.code * 2));
                    nodes.add(new ANode(anode.node.right, anode.code * 2 + 1));
                }
            }

            return nodes.get(nodes.size() - 1).code == nodes.size();
        }
    }

    class ANode {  // Annotated Node
        TreeNode node;
        //编号
        int code;

        ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }

    /**
     *
     */
    class Solution1 {
        //tree的数量
        int count = 0;
        //最大编号
        int maxSize = 0;

        public boolean isCompleteTree(TreeNode root) {
            if (root == null) {
                return true;
            }
            getMax(root, 1);

            return count == maxSize;
        }

        /**
         * 访问一个结点就调用一次函数
         *
         * @param root
         * @param k
         */
        public void getMax(TreeNode root, int k) {
            if (root == null) {
                return;
            }
            count++;
            maxSize = Math.max(maxSize, k);

            getMax(root.left, k * 2);
            getMax(root.right, k * 2 + 1);
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
