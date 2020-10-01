package com.leetcode.tag.tree.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 572. 另一个树的子树
 * <p>
 * 这道题有点坑.难怪通过率这么低.
 */
public class IsSubtree {
    class Solution {
        boolean result;

        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) {
                return t == null;
            }
            if (t == null) {
                return false;
            }
            preorder(s, t);

            return result;
        }

        private void preorder(TreeNode s, TreeNode t) {
            if (s == null || result) {
                return;
            }
            if (s.val == t.val) {
                result = myIsSubtree(s, t);
            }
            preorder(s.left, t);
            preorder(s.right, t);
        }

        public boolean myIsSubtree(TreeNode s, TreeNode t) {
            if (s == null) {
                return t == null;
            }
            if (t == null || s.val != t.val) {
                return false;
            }
            return myIsSubtree(s.left, t.left) && myIsSubtree(s.right, t.right);
        }
    }

    /**
     * 先序遍历
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree/solution/ling-yi-ge-shu-de-zi-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 简洁代码.
         * <p>
         * 简单的先序遍历.厉害.
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isSubtree(TreeNode s, TreeNode t) {
            return s != null && (check(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
        }

        public boolean check(TreeNode s, TreeNode t) {
            if (s == null) {
                return t == null;
            }
            if (t == null || s.val != t.val) {
                return false;
            }
            return check(s.left, t.left) && check(s.right, t.right);
        }
    }

    /**
     * 方法二：DFS 序列上做串匹配
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree/solution/ling-yi-ge-shu-de-zi-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        List<Integer> sOrder = new ArrayList<>();
        List<Integer> tOrder = new ArrayList<>();
        int maxElement, lNull, rNull;

        public boolean isSubtree(TreeNode s, TreeNode t) {
            maxElement = Integer.MIN_VALUE;
            getMaxElement(s);
            getMaxElement(t);
            lNull = maxElement + 1;
            rNull = maxElement + 2;

            getDfsOrder(s, sOrder);
            getDfsOrder(t, tOrder);

            return kmp();
        }

        public void getMaxElement(TreeNode t) {
            if (t == null) {
                return;
            }
            maxElement = Math.max(maxElement, t.val);
            getMaxElement(t.left);
            getMaxElement(t.right);
        }

        public void getDfsOrder(TreeNode t, List<Integer> tar) {
            if (t == null) {
                return;
            }
            tar.add(t.val);
            if (t.left != null) {
                getDfsOrder(t.left, tar);
            } else {
                //两个null不一样
                tar.add(lNull);
            }
            if (t.right != null) {
                getDfsOrder(t.right, tar);
            } else {
                //两个null不一样
                tar.add(rNull);
            }
        }

        /**
         * 可以暴力匹配，也可以使用 KMP 或者 Rabin-Karp 算法
         *
         * @return
         */
        public boolean kmp() {
            int sLen = sOrder.size(), tLen = tOrder.size();
            int[] fail = new int[tOrder.size()];
            Arrays.fill(fail, -1);
            for (int i = 1, j = -1; i < tLen; ++i) {
                while (j != -1 && !(tOrder.get(i).equals(tOrder.get(j + 1)))) {
                    j = fail[j];
                }
                if (tOrder.get(i).equals(tOrder.get(j + 1))) {
                    ++j;
                }
                fail[i] = j;
            }
            for (int i = 0, j = -1; i < sLen; ++i) {
                while (j != -1 && !(sOrder.get(i).equals(tOrder.get(j + 1)))) {
                    j = fail[j];
                }
                if (sOrder.get(i).equals(tOrder.get(j + 1))) {
                    ++j;
                }
                if (j == tLen - 1) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 方法三：树哈希
     * <p>
     * 把每个子树都映射成一个唯一的数，如果 t 对应的数字和 s 中任意一个子树映射的数字相等，则 t 是 s 的某一棵子树。
     */
    class S {

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
