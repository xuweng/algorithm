package com.leetcode.tag.tree.three;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * <p>
 * dfs+bfs
 */
public class DistanceK {
    /**
     * 对所有节点添加一个指向父节点的引用，之后做bsf，找到所有距离 target 节点 K 距离的节点
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/solution/er-cha-shu-zhong-suo-you-ju-chi-wei-k-de-jie-dian-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        //key是结点.value是结点的父节点.
        Map<TreeNode, TreeNode> parent;

        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            parent = new HashMap<>();
            dfs(root, null);

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(null);
            //从target开始做bsf.不是从root开始.
            queue.add(target);

            //是否搜索过
            Set<TreeNode> seen = new HashSet<>();
            seen.add(target);
            seen.add(null);

            int dist = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    if (dist == K) {
                        return queue.stream().map(n -> n.val).collect(Collectors.toList());
                    }
                    queue.offer(null);
                    dist++;
                } else {
                    //每个结点最多3个方向
                    //left
                    if (!seen.contains(node.left)) {
                        seen.add(node.left);
                        queue.offer(node.left);
                    }
                    //right
                    if (!seen.contains(node.right)) {
                        seen.add(node.right);
                        queue.offer(node.right);
                    }
                    //parent
                    TreeNode par = parent.get(node);
                    if (!seen.contains(par)) {
                        seen.add(par);
                        queue.offer(par);
                    }
                }
            }

            return new ArrayList<>();
        }

        public void dfs(TreeNode node, TreeNode par) {
            if (node == null) {
                return;
            }
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
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
