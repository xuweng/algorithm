package com.leetcode.tag.must.four;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
public class VerifyPostorder {
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            if (postorder == null || postorder.length == 0) {
                return true;
            }

            return dfs(postorder, 0, postorder.length - 1);
        }

        private boolean dfs(int[] postorder, int low, int high) {
            if (low >= high) {
                return true;
            }
            int i = high;
            while (i >= low && postorder[i] >= postorder[high]) {
                i--;
            }
            // 左子树最后一个结点
            int j = i;
            while (j >= low) {
                if (postorder[j] > postorder[high]) {
                    return false;
                }
                j--;
            }

            // dfs右子树 dfs左子树
            return dfs(postorder, i + 1, high - 1) && dfs(postorder, low, i);
        }
    }

    /**
     * 方法一：递归分治
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean verifyPostorder(int[] postorder) {
            return recur(postorder, 0, postorder.length - 1);
        }

        boolean recur(int[] postorder, int i, int j) {
            if (i >= j) {
                return true;
            }
            int p = i;
            while (postorder[p] < postorder[j]) {
                p++;
            }
            int m = p;
            while (postorder[p] > postorder[j]) {
                p++;
            }
            return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
        }
    }

}
