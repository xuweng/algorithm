package com.leetcode.tag.daily.three;

/**
 * LCP 19. 秋叶收藏集
 * <p>
 * 搞懂题意.搞懂题意.搞懂题意.搞懂题意.搞懂题意.
 */
public class MinimumOperations {
    /**
     * 方法一：动态规划
     * <p>
     * 状态定义厉害.状态定义太灵活.
     * <p>
     * 我们用 f[i][j] 表示对于第 0 片到第 i 片叶子（记为 leaves[0..i]）进行调整操作，并且第 i 片叶子处于状态 j 时的最小操作次数
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/UlBDOe/solution/qiu-xie-shou-cang-ji-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int minimumOperations(String leaves) {
            int n = leaves.length();
            int[][] f = new int[n][3];
            f[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
            f[0][1] = f[0][2] = f[1][2] = Integer.MAX_VALUE;
            for (int i = 1; i < n; ++i) {
                int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
                int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
                f[i][0] = f[i - 1][0] + isYellow;
                f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + isRed;
                if (i >= 2) {
                    f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + isYellow;
                }
            }
            return f[n - 1][2];
        }
    }

    /**
     * 方法二：前缀和 + 动态规划
     * <p>
     * 我们也可以尝试从整体的角度考虑这个问题。
     * <p>
     * 排列调整成「红、黄、红」三部分
     * <p>
     * 假设我们希望将 leaves[0..x]，leaves[x+1..y] 以及 leaves[y+1..n−1] 分别作为每一部分，那么需要的操作次数为：
     * <p>
     * isYellow(i)+isRed(i)+isYellow(i)
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/UlBDOe/solution/qiu-xie-shou-cang-ji-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int minimumOperations(String leaves) {
            int n = leaves.length();
            int g = leaves.charAt(0) == 'y' ? 1 : -1;
            int gmin = g;
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i < n; ++i) {
                int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
                g += 2 * isYellow - 1;
                if (i != n - 1) {
                    ans = Math.min(ans, gmin - g);
                }
                gmin = Math.min(gmin, g);
            }
            return ans + (g + n) / 2;
        }
    }

    /**
     * 作者：leetcoder-youzg
     * 链接：https://leetcode-cn.com/problems/UlBDOe/solution/java-quan-zhu-shi-li-jie-dong-tai-gui-hua-by-leetc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int minimumOperations(String leaves) {
            if (leaves == null || "".equals(leaves)) {   // 排除 不合法参数情况
                return 0;
            }
            int length = leaves.length();
            char[] chars = leaves.toCharArray();

        /*
            状态数组，state[i][j]中：
                i表示终止下标
                j表示：0为左半边，1为中间部分，2为右半边
            state[i][j] 表示 从0到i需要调整的叶子数
         */
            int[][] state = new int[length][3];

        /*
            记录 已知状态数组元素：
                1、第一个叶子，必须是左半部分，所以只需判断是不是 黄色叶子 即可
                2、第一个叶子，必须是左半部分，所以 state[0][1] 和 state[0][2] 都是无效的
                3、第二个叶子，可以是左半部分，也可以是中间部分，但是不能是右半部分(每个区间必须有叶子)，
                    因此 state[1][2]是无效的
         */
            state[0][0] = chars[0] == 'y' ? 1 : 0;
            state[0][1] = state[0][2] = state[1][2] = Integer.MAX_VALUE;

            int isYellow = 0;   // 判断 当前遍历的叶子 是不是 黄色

        /*
            遍历 原叶集，生成状态数组
         */
            for (int i = 1; i < length; i++) {
                isYellow = chars[i] == 'y' ? 1 : 0;
                state[i][0] = state[i - 1][0] + isYellow;
                state[i][1] = Math.min(state[i - 1][0], state[i - 1][1]) + (1 - isYellow);
                if (i > 1) {    // 右半部分 的叶子 必须是第2个元素之后的元素
                    state[i][2] = Math.min(state[i - 1][1], state[i - 1][2]) + isYellow;
                }
            }

        /*
            最终结果 为 state[length - 1][2]
            因为 state[i][j]最终结果的 i 必须为 length - 1，state[length - 1][j] 中的 j 必须为2
         */
            return state[length - 1][2];
        }
    }

    /**
     * 前缀和
     * <p>
     * 逆向思维.从结果开始推导.
     * <p>
     * 用 sum[x] 表示 [0, x) 区间内红叶数量. 假设整理后红叶的区间为 [0, i) 和 [j, n), 那么黄叶区间为 [i, j).
     * <p>
     * 对于左右两个区间, 操作次数为区间长度减去红叶的数量, 对于中间的区间, 操作次数就是红叶的数量.
     * <p>
     * 需要操作的总次数为 (i - sum[i]) + (n - j - sum[n] + sum[j]) + (sum[j] - sum[i])
     * <p>
     * 作者：aerysn
     * 链接：https://leetcode-cn.com/problems/UlBDOe/solution/simple-java-by-aerysn/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public int minimumOperations(String leaves) {
            int n = leaves.length();
            char[] array = leaves.toCharArray();
            //用 sum[x] 表示 [0, x) 区间内红叶数量
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                //这个计算厉害
                sum[i + 1] = sum[i] + (array[i] == 'r' ? 1 : 0);
            }
            int[] min = new int[n + 1];
            int currentMin = Integer.MAX_VALUE;
            for (int i = 1; i < n - 1; i++) {
                currentMin = Math.min(currentMin, i - 2 * sum[i]);
                min[i] = currentMin;
            }
            int result = Integer.MAX_VALUE;
            for (int j = n - 1; j > 1; j--) {
                result = Math.min(result, n - sum[n] + min[j - 1] - j + 2 * sum[j]);
            }
            return result;
        }
    }

}
