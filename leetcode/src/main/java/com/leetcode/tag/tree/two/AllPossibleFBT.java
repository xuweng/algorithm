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
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees/solution/suo-you-ke-neng-de-man-er-cha-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        Map<Integer, List<TreeNode>> memo = new HashMap<>();

        public List<TreeNode> allPossibleFBT(int N) {
            if (!memo.containsKey(N)) {
                List<TreeNode> ans = new LinkedList<>();
                if (N == 1) {
                    ans.add(new TreeNode(0));
                } else if (N % 2 == 1) {
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
            }

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
