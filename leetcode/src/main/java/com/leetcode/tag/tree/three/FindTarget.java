package com.leetcode.tag.tree.three;

import java.util.*;

/**
 * 653. 两数之和 IV - 输入 BST
 */
public class FindTarget {
    class Solution {
        List<Integer> list = new ArrayList<>();

        public boolean findTarget(TreeNode root, int k) {
            zhong(root);

            Set<Integer> set = new HashSet<>(list);

            for (Integer integer : list) {
                if (integer != k - integer && set.contains(k - integer)) {
                    return true;
                }
            }

            return false;
        }

        private void zhong(TreeNode root) {
            if (root == null) {
                return;
            }
            zhong(root.left);
            list.add(root.val);
            zhong(root.right);

        }
    }

    /**
     * 方法一：使用 HashSet
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/solution/liang-shu-zhi-he-iv-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean findTarget(TreeNode root, int k) {
            Set<Integer> set = new HashSet<>();
            return find(root, k, set);
        }

        public boolean find(TreeNode root, int k, Set<Integer> set) {
            if (root == null) {
                return false;
            }
            //这个条件厉害.遍历时检查另外一个数.
            if (set.contains(k - root.val)) {
                return true;
            }
            set.add(root.val);
            return find(root.left, k, set) || find(root.right, k, set);
        }
    }

    /**
     * 方法二：使用 BFS 和 HashSet【通过】
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/solution/liang-shu-zhi-he-iv-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public boolean findTarget(TreeNode root, int k) {
            Set<Integer> set = new HashSet<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (set.contains(k - node.val)) {
                    return true;
                }
                set.add(node.val);
                //队列保证存储非null结点
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
            return false;
        }
    }

    /**
     * 方法三：使用 BST【通过】
     * <p>
     * 利用排序.
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/solution/liang-shu-zhi-he-iv-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public boolean findTarget(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            inorder(root, list);
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int sum = list.get(l) + list.get(r);
                if (sum == k) {
                    return true;
                }
                if (sum < k) {
                    l++;
                } else {
                    r--;
                }
            }
            return false;
        }

        public void inorder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
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
