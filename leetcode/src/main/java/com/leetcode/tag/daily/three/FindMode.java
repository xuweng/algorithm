package com.leetcode.tag.daily.three;

import java.util.*;

/**
 * 501. 二叉搜索树中的众数
 */
public class FindMode {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public int[] findMode(TreeNode root) {
            zhong(root);

            Integer max = map.values().stream().max(Integer::compareTo).orElse(0);

            List<Integer> result = new ArrayList<>();
            map.forEach((k, v) -> {
                if (Objects.equals(v, max)) {
                    result.add(k);
                }
            });

            //转换为数组这么简单.记住.
            return result.stream().mapToInt(item -> item).toArray();
        }

        private void zhong(TreeNode root) {
            if (root == null) {
                return;
            }
            zhong(root.left);
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            zhong(root.right);
        }
    }

    /**
     * 两轮没有多大意义
     * <p>
     * 作者：leetcoder-youzg
     * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/solution/java-jian-dan-yi-dong-de-zhong-xu-bian-li-by-leetc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        private TreeNode pre = null;    // 前驱节点
        private int[] result;   // 结果数组
        private int resultCount = 0;    // 结果个数
        private int maxCount = 0;   // 众数数量
        private int currCount = 0;  // 当前重复的数的数量

        public int[] findMode(TreeNode root) {
            // 第一轮，查询 “众数个数”
            findAndFill(root);

            // 复位
            // 记录前一个结点,这个变量可以
            this.pre = null;
            this.result = new int[this.resultCount];    // 初始化数组
            this.resultCount = 0;
            this.currCount = 0;

            // 第二轮，填充 众数
            findAndFill(root);
            return this.result;
        }

        /**
         * 中根序 遍历 目标二叉树<br/>
         */
        private void findAndFill(TreeNode root) {
            if (root == null) {
                return;
            }
            findAndFill(root.left); // 递归遍历 左子树

            //这个条件可以
            if (this.pre != null && this.pre.val == root.val) {
                // 与前一个节点的值相等
                this.currCount++;
            } else {
                // 若 不相等，则 刷新currCount
                this.currCount = 1;
            }

            if (this.currCount > this.maxCount) {
                // 当前最大数 > 最大众数数
                this.maxCount = this.currCount;
                this.resultCount = 1;
            } else if (this.currCount == this.maxCount) {
                // 当前最大数 == 最大众数数
                if (this.result != null) {
                    this.result[this.resultCount] = root.val;
                }
                // 使 指针向后移动，便于下次录入
                this.resultCount++;
            }
            // 进行下轮遍历
            this.pre = root;

            // 递归遍历 右子树
            findAndFill(root.right);
        }
    }

    /**
     * 简洁代码
     * <p>
     * index指针
     * <p>
     * 中序遍历序列.重复出现的数字一定是一个连续出现的.
     * 用 count 记录当前数字重复的次数，用 maxCount 来维护已经扫描过的数当中出现最多的那个数字的出现次数
     */
    class Solution2 {

        int preVal = 0;
        //记录当前数字重复的次数
        int curTimes = 0;
        //维护已经扫描过的数当中出现最多的那个数字的出现次数
        int maxTimes = 0;
        ArrayList<Integer> list = new ArrayList<>();

        public int[] findMode(TreeNode root) {
            traversal(root);
            //list转换为int[]
            return list.stream().mapToInt(integer -> integer).toArray();
        }

        private void traversal(TreeNode root) {
            if (root == null) {
                return;
            }
            traversal(root.left);

            if (preVal == root.val) {
                curTimes++;
            } else {
                preVal = root.val;
                curTimes = 1;
            }
            if (curTimes == maxTimes) {
                list.add(root.val);
            } else if (curTimes > maxTimes) {
                //这里直接清空厉害.不会添加重复数字.
                list.clear();
                list.add(root.val);
                maxTimes = curTimes;
            }

            traversal(root.right);
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
