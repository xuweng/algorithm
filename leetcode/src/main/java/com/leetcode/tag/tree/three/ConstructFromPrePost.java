package com.leetcode.tag.tree.three;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 889. 根据前序和后序遍历构造二叉树
 * <p>
 * 没有null.
 * <p>
 * 注意数组越界和下标计算
 */
public class ConstructFromPrePost {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            for (int i = 0; i < post.length; i++) {
                map.put(post[i], i);
            }

            return constructFromPrePost(pre, 0, pre.length - 1, post, 0, post.length - 1);
        }

        /**
         * 计算下标.确定left结点的个数.
         *
         * @param pre
         * @param preStart
         * @param preEnd
         * @param post
         * @param postStart
         * @param postEnd
         * @return
         */
        public TreeNode constructFromPrePost(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
            //防止数组下标越界.此条件必须.
            if (preStart > preEnd || postStart > postEnd) {
                return null;
            }
            if (preStart == preEnd || postStart == postEnd) {
                return new TreeNode(pre[preStart]);
            }
            int l = map.get(pre[preStart + 1]);
            TreeNode root = new TreeNode(pre[preStart]);
            //(l - postStart + 1)是left结点的个数
            root.left = constructFromPrePost(pre, preStart + 1, preStart + l - postStart + 1, post, postStart, l);
            //(preStart + l - postStart + 2)=(preStart + l - postStart + 1 + 1)
            root.right = constructFromPrePost(pre, preStart + l - postStart + 2, preEnd, post, l + 1, postEnd - 1);

            return root;
        }
    }

    /**
     * 方法一：递归
     * <p>
     * 创建新数组.不通过下标
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/solution/gen-ju-qian-xu-he-hou-xu-bian-li-gou-zao-er-cha-sh/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            int N = pre.length;
            if (N == 0) {
                return null;
            }
            TreeNode root = new TreeNode(pre[0]);
            if (N == 1) {
                return root;
            }

            //left结点的个数
            int L = 0;
            for (int i = 0; i < N; ++i) {
                if (post[i] == pre[1]) {
                    L = i + 1;
                    break;
                }
            }

            root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1),
                    Arrays.copyOfRange(post, 0, L));
            root.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, N),
                    Arrays.copyOfRange(post, L, N - 1));
            return root;
        }
    }

    /**
     *
     */
    class Solution2 {
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            if (pre.length == 0) {
                return null;
            }
            int len = post.length - 1;
            return build(pre, post, 0, len, 0, len);
        }

        public TreeNode build(int[] preorder, int[] postorder, int prel, int prer, int postl, int postr) {
            if ((prel > prer) || (postl > postr)) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[prel]);
            if (prel == prer) {
                return root;
            }
            int start = postl;
            while (start < postr && postorder[start] != preorder[prel + 1]) {
                start++;
            }
            root.left = build(preorder, postorder, prel + 1, prel + (start - postl) + 1, postl, start);
            root.right = build(preorder, postorder, prel + (start - postl) + 2, prer, start + 1, postr - 1);
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
