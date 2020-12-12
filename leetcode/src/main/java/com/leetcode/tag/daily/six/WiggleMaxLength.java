package com.leetcode.tag.daily.six;

/**
 * 376. 摆动序列
 */
public class WiggleMaxLength {
    /**
     * 方法一：动态规划
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/wiggle-subsequence/solution/bai-dong-xu-lie-by-leetcode-solution-yh2m/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return n;
            }
            //up[i] 表示以前 i 个元素中的某一个为结尾的最长的「上升摆动序列」的长度。
            //down[i] 表示以前 i 个元素中的某一个为结尾的最长的「下降摆动序列」的长度。
            int[] up = new int[n];
            int[] down = new int[n];
            up[0] = down[0] = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1]) {
                    up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                    down[i] = down[i - 1];
                } else if (nums[i] < nums[i - 1]) {
                    up[i] = up[i - 1];
                    down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
                } else {
                    up[i] = up[i - 1];
                    down[i] = down[i - 1];
                }
            }
            return Math.max(up[n - 1], down[n - 1]);
        }
    }

    /**
     * 方法二：优化的动态规划
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/wiggle-subsequence/solution/bai-dong-xu-lie-by-leetcode-solution-yh2m/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return n;
            }
            //仅需要前一个状态来进行转移，所以我们维护两个变量
            int up = 1, down = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1]) {
                    up = Math.max(up, down + 1);
                } else if (nums[i] < nums[i - 1]) {
                    down = Math.max(up + 1, down);
                }
            }
            return Math.max(up, down);
        }
    }

    /**
     * 方法三：贪心
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/wiggle-subsequence/solution/bai-dong-xu-lie-by-leetcode-solution-yh2m/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return n;
            }
            int prevdiff = nums[1] - nums[0];
            int ret = prevdiff != 0 ? 2 : 1;
            for (int i = 2; i < n; i++) {
                int diff = nums[i] - nums[i - 1];
                if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                    ret++;
                    prevdiff = diff;
                }
            }
            return ret;
        }
    }

    /**
     * 一定要看图 一定要看图 一定要看图 一定要看图 一定要看图
     * <p>
     * 作者：lgh18
     * 链接：https://leetcode-cn.com/problems/wiggle-subsequence/solution/tan-xin-si-lu-qing-xi-er-zheng-que-de-ti-jie-by-lg/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public int wiggleMaxLength(int[] nums) {
            int down = 1, up = 1;
            // 从索引1开始
            for (int i = 1; i < nums.length; i++) {
                // 只需要和i-1比较?
                // up和down交错.摆动序列.交错厉害.交错厉害.交错厉害.
                if (nums[i] > nums[i - 1]) {
                    up = down + 1;
                } else if (nums[i] < nums[i - 1]) {
                    down = up + 1;
                }
            }
            return nums.length == 0 ? 0 : Math.max(down, up);
        }

    }

}
