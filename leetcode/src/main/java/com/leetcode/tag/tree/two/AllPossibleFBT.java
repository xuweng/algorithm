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
     * 后序遍历
     * <p>
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
            //我们知道一共有N个结点，root占了1个结点，左子树可能有1，3，5，..，N-2个结点
            //对应的，右子树可能有N-2，..，5，3，1个结点
            //那么，我们可以用一个循环，找到所有可能的左右子树的可能的数量的情况，把root放进列表里
            for (int x = 1; x < N; x = x + 2) {
                //这里就是递归的精髓了，每次看到递归，就一头雾水
                //在这里，我们不用去关心左右子树是怎么递归形成的
                //我们可以仅仅去关心，这个函数，它实现的是什么功能
                //allPossibleFBT(i)返回了一个列表，它存放着当结点数为i时，所有满足条件的树的root的集合
                //我们可以认为，allPossibleFBT(i)存放着所有满足条件的左子树的集合
                //同样，allPossibleFBT(N-1-i)存放着所有满足条件的右子树的集合
                //这是由allPossibleFBT(int N)这个函数的定义所确定的

                //接下来，就是左右子树的排列组合，当左子树为m时，右子树可能有right.size()个可能
                //所以一共有right.size() * left.size()种可能
                //我们把每一种排列，都放到我们所要的结果中
                List<TreeNode> lefts = allPossibleFBT(x);
                List<TreeNode> rights = allPossibleFBT(N - 1 - x);
                for (TreeNode left : lefts) {
                    for (TreeNode right : rights) {
                        TreeNode bns = new TreeNode(0);
                        bns.left = left;
                        bns.right = right;
                        ans.add(bns);
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
