package com.jianzi.offer.suati;

import java.util.HashMap;

/**
 * 面试题07. 重建二叉树
 * <p>
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class g071 {
    HashMap<Integer, Integer> dic = new HashMap<>();
    int[] po;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    TreeNode recur(int preRoot, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(po[preRoot]);
        int i = dic.get(po[preRoot]);
        root.left = recur(preRoot + 1, inLeft, i - 1);
        root.right = recur(preRoot + i - inLeft + 1, i + 1, inRight);
        return root;
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
