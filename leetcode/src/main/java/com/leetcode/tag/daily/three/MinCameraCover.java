package com.leetcode.tag.daily.three;

/**
 * 968. 监控二叉树
 * <p>
 * 这道题和 打家劫舍III 很像，同样是二叉树，打家劫舍规定不能打劫相邻的节点，求打劫节点值的最大收益。
 * <p>
 * 树形 DP 不像常规 DP 那样在迭代中 “填表”，而是在递归遍历中 “填表”。
 * <p>
 * 看图.看图
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-cameras/solution/968-jian-kong-er-cha-shu-di-gui-shang-de-zhuang-ta/
 */
public class MinCameraCover {
    class Solution {
        public int minCameraCover(TreeNode root) {
            return 0;
        }
    }

    /**
     * 两种情况.安装与不安装.选择与不选择
     * <p>
     * 假设当前节点为 root，其左右孩子为 left,right。如果要覆盖以 root 为根的树，有两种情况：
     * <p>
     * 若在 root 处安放摄像头，则孩子 left,right 一定也会被监控到。此时，只需要保证left 的两棵子树被覆盖，同时保证 right 的两棵子树也被覆盖即可。
     * <p>
     * 否则， 如果 root 处不安放摄像头，则除了覆盖 root 的两棵子树之外，孩子 left,right 之一必须要安装摄像头，从而保证 root 会被监控到。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-tree-cameras/solution/jian-kong-er-cha-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int minCameraCover(TreeNode root) {
            int[] array = dfs(root);
            return array[1];
        }

        /**
         * 树形dp
         *
         * @param root
         * @return
         */
        public int[] dfs(TreeNode root) {
            if (root == null) {
                return new int[]{Integer.MAX_VALUE / 2, 0, 0};
            }
            int[] leftArray = dfs(root.left);
            int[] rightArray = dfs(root.right);
            int[] array = new int[3];
            array[0] = leftArray[2] + rightArray[2] + 1;
            array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], rightArray[0] + leftArray[1]));
            array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
            return array;
        }
    }

    /**
     * 作者：rorke76753
     * 链接：https://leetcode-cn.com/problems/binary-tree-cameras/solution/dfsjavajian-dan-yi-dong-by-rorke76753/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        int result = 0;

        public int minCameraCover(TreeNode root) {
            if (dfs(root) == 1) {
                result++;
            }
            return result;
        }

        //0:可被观测但无监控，上一层节点为1
        //1：不可被观测到，上一层节点为2
        //2：有摄像机，上一层节点为0
        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftStatus = dfs(root.left);
            int rightStatus = dfs(root.right);
            if (leftStatus == 1 || rightStatus == 1) {
                result++;
                return 2;
            } else if (leftStatus == 2 || rightStatus == 2) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    /**
     * 每个节点可能有几种状态：
     * <p>
     * 可以说有如下三种：
     * <p>
     * 该节点无覆盖
     * 本节点有摄像头
     * 本节点有覆盖
     * <p>
     * 我们分别有三个数字来表示：
     * <p>
     * 0：该节点无覆盖
     * 1：本节点有摄像头
     * 2：本节点有覆盖
     * <p>
     * 作者：carlsun-2
     * 链接：https://leetcode-cn.com/problems/binary-tree-cameras/solution/968-jian-kong-er-cha-shu-di-gui-shang-de-zhuang-ta/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        private int result;

        int traversal(TreeNode cur) {

            // 空节点，该节点有覆盖
            if (cur == null) {
                return 2;
            }

            int left = traversal(cur.left);    // 左
            int right = traversal(cur.right);  // 右

            // 情况1
            // 左右节点都有覆盖
            if (left == 2 && right == 2) {
                //则该节点无覆盖
                return 0;
            }

            // 情况2
            // 左右节点至少有一个无覆盖的情况
            // left == 0 && right == 0 左右节点无覆盖
            // left == 1 && right == 0 左节点有摄像头，右节点无覆盖
            // left == 0 && right == 1 左节点有无覆盖，右节点摄像头
            // left == 0 && right == 2 左节点无覆盖，右节点覆盖
            // left == 2 && right == 0 左节点覆盖，右节点无覆盖
            if (left == 0 || right == 0) {
                //则该节点放摄像头
                result++;
                return 1;
            }

            // 情况3
            // 左右节点至少有一个有摄像头
            // left == 1 && right == 2 左节点有摄像头，右节点有覆盖
            // left == 2 && right == 1 左节点有覆盖，右节点有摄像头
            // left == 1 && right == 1 左右节点都有摄像头
            // 其他情况前段代码均已覆盖
            if (left == 1 || right == 1) {
                //则该节点覆盖
                return 2;
            }

            // 以上代码我没有使用else，主要是为了把各个分支条件展现出来，这样代码有助于读者理解
            // 这个 return -1 逻辑不会走到这里。
            return -1;
        }

        public int minCameraCover(TreeNode root) {
            result = 0;
            // 情况4
            if (traversal(root) == 0) { // root 无覆盖
                result++;
            }
            return result;
        }
    }

    ;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
