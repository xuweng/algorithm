package com.leetcode.tag.tree.two;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 894. 所有可能的满二叉树
 */
public class AllPossibleFBT {
    /**
     * 每个满二叉树 T 含有 3 个或更多结点，在其根结点处有 2 个子结点。这些子结点 left 和 right 本身就是满二叉树。
     * <p>
     * 对于 N≥3，我们可以设定如下的递归策略
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees/solution/suo-you-ke-neng-de-man-er-cha-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        //缓存
        Map<Integer, List<TreeNode>> memo = new HashMap<>();

        public List<TreeNode> allPossibleFBT(int N) {
            if (memo.containsKey(N)) {
                return memo.get(N);
            }
            List<TreeNode> ans = new LinkedList<>();
            if (N == 1) {
                ans.add(new TreeNode(0));

                memo.put(N, ans);
                return memo.get(N);
            }
            //没有满二叉树具有正偶数个结点
            //满二叉树是奇数个结点
            if (N % 2 == 1) {
                //我们知道一共有N个结点，root占了1个结点，左子树可能有1，3，5，..，N-2个结点
                //对应的，右子树可能有N-2，..，5，3，1个结点
                //那么，我们可以用一个循环，找到所有可能的左右子树的可能的数量的情况，把root放进列表里
                for (int x = 0; x < N; ++x) {
                    int y = N - 1 - x;
                    for (TreeNode left : allPossibleFBT(x)) {
                        for (TreeNode right : allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                    }
                }
            }
            memo.put(N, ans);

            return memo.get(N);
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
