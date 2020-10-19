package com.leetcode.tag.dfs.two;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 473. 火柴拼正方形
 * <p>
 * 无需建树
 * <p>
 * 重复计算
 * <p>
 * 记忆化是重点.记忆化.记忆化.记忆化.记忆化.记忆化.记忆化.记忆化.
 * <p>
 * 十分钟.十分钟.十分钟.十分钟.十分钟.十分钟.
 * <p>
 * 记忆化.记忆化.记忆化.
 */
public class Makesquare {
    /**
     * 方法一：深度优先搜索
     * <p>
     * 因此，对于给定的若干根火柴，我们需要：
     * <p>
     * 将它们分成四组，每一根火柴恰好属于其中的一组；
     * <p>
     * 每一组火柴的长度之和都相同，等于所有火柴长度之和的四分之一。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/matchsticks-to-square/solution/huo-chai-pin-zheng-fang-xing-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public List<Integer> nums;
        //分为4组
        public int[] sums;
        //每组和
        public int possibleSquareSide;

        public Solution() {
            this.sums = new int[4];
        }

        /**
         * 方法一：深度优先搜索
         * <p>
         * 我们可以使用深度优先搜索枚举出所有的分组情况，并对于每一种情况，判断是否满足上述的两个条件。
         * <p>
         * 我们依次对每一根火柴进行搜索，当搜索到第 i 根火柴时，我们可以把它放到四组中的任意一种。对于每一种放置方法，
         * <p>
         * 我们继续对第 i + 1 根火柴进行递归搜索。当我们搜索完全部的 N 根火柴后，再判断每一组火柴的长度之和是否都相同。
         * <p>
         * 作者：LeetCode
         * 链接：https://leetcode-cn.com/problems/matchsticks-to-square/solution/huo-chai-pin-zheng-fang-xing-by-leetcode/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param index
         * @return
         */
        public boolean dfs(int index) {
            if (index == this.nums.size()) {
                //越界统计.数据全部放完.
                //4组的和是否都一样
                return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
            }

            // Get current matchstick.
            int element = this.nums.get(index);
            // Try adding it to each of the 4 sides (if possible)
            //当搜索到第 i 根火柴时，我们可以把它放到四组中的任意一种
            for (int i = 0; i < 4; i++) {
                //剪枝
                if (this.sums[i] + element > this.possibleSquareSide) {
                    continue;
                }
                //以下是标准回溯
                this.sums[i] += element;
                if (this.dfs(index + 1)) {
                    return true;
                }
                this.sums[i] -= element;
            }

            return false;
        }

        public boolean makesquare(int[] nums) {
            // Empty matchsticks.
            if (nums == null || nums.length == 0) {
                return false;
            }

            // Find the perimeter of the square (if at all possible)
            int perimeter = Arrays.stream(nums).sum();

            //每一组火柴的长度之和都相同，等于所有火柴长度之和的四分之一
            this.possibleSquareSide = perimeter / 4;
            if (this.possibleSquareSide * 4 != perimeter) {
                return false;
            }

            // Convert the array of primitive int to ArrayList (for sorting).
            this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
            this.nums.sort(Collections.reverseOrder());
            return this.dfs(0);
        }
    }

    class Solution1 {
        int[] sums = new int[4];
        int s;

        public boolean makesquare(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int sum = Arrays.stream(nums).sum();
            s = sum / 4;
            if (s * 4 != sum) {
                //没有整除
                return false;
            }

            // 倒序
            // 倒序的话有点剪枝的思想，先排大的，最后再塞小的
            // 倒序可以让程序减少做无用功，让其 在火柴长度大于正方形边长时可以直接退出
            Collections.reverse(Arrays.asList(nums));

            return dfs(nums, 0);
        }

        private boolean dfs(int[] nums, int index) {
            //越界统计.保证所有数据都选择.
            if (index >= nums.length) {
                return (sums[0] == s && sums[1] == s && sums[2] == s && sums[3] == s);
            }

            for (int i = 0; i < 4; i++) {
                //剪枝
                if (sums[i] + nums[index] > s) {
                    continue;
                }
                sums[i] += nums[index];

                if (dfs(nums, index + 1)) {
                    return true;
                }

                sums[i] -= nums[index];
            }
            return false;
        }
    }

    /**
     * 方法二：动态规划 + 状态压缩
     * <p>
     * 递归树
     * <p>
     * 使用长度为 N 的二进制来表示动态规划中的每一个状态，如果二进制的第 k 位为 1，那么当前状态包含第 k 根火柴，否则不包含第 k 根火柴
     */
    class Solution2 {
        // The memoization cache to be used during recursion.
        public HashMap<Pair<Integer, Integer>, Boolean> memo;

        // Array containing our matchsticks.
        public int[] nums;

        // Possible side of our square depending on the total sum of all the matchsticks. 
        public int possibleSquareSide;

        // Default constructor to initialise our memo cache.
        public Solution2() {
            this.memo = new HashMap<>();
        }

        // Main DP function.
        public boolean recurse(Integer mask, Integer sidesDone) {
            int total = 0;
            int l = this.nums.length;

            // The memo key for this recursion
            Pair<Integer, Integer> memoKey = new Pair(mask, sidesDone);

            // Find out the sum of matchsticks used till now.
            for (int i = l - 1; i >= 0; i--) {
                if ((mask & (1 << i)) == 0) {
                    total += this.nums[l - 1 - i];
                }
            }

            // If the sum if divisible by our square's side, then we increment our number of complete sides formed variable.
            if (total > 0 && total % this.possibleSquareSide == 0) {
                sidesDone++;
            }

            // Base case.
            if (sidesDone == 3) {
                return true;
            }


            // Return precomputed results
            if (this.memo.containsKey(memoKey)) {
                return this.memo.get(memoKey);
            }

            boolean ans = false;
            int c = total / this.possibleSquareSide;

            // Remaining vlength in the current partially formed side.
            int rem = this.possibleSquareSide * (c + 1) - total;

            // Try out all remaining options (that are valid)
            for (int i = l - 1; i >= 0; i--) {
                if (this.nums[l - 1 - i] <= rem && (mask & (1 << i)) > 0) {
                    if (this.recurse(mask ^ (1 << i), sidesDone)) {
                        ans = true;
                        break;
                    }
                }
            }

            // Cache the computed results.
            this.memo.put(memoKey, ans);
            return ans;
        }

        public boolean makesquare(int[] nums) {

            // Empty matchsticks.
            if (nums == null || nums.length == 0) {
                return false;
            }

            // Find the perimeter of the square (if at all possible)
            int L = nums.length;
            int perimeter = 0;
            for (int num : nums) {
                perimeter += num;
            }

            int possibleSquareSide = perimeter / 4;
            if (possibleSquareSide * 4 != perimeter) {
                return false;
            }

            this.nums = nums;
            this.possibleSquareSide = possibleSquareSide;
            return this.recurse((1 << L) - 1, 0);
        }
    }

    /**
     * 这是一道经典的剪枝优化问题。
     * <p>
     * 从大到小枚举，每次剪枝去掉的分支会更多；
     * 每条边内部的木棒长度规定成从大到小；
     * 如果当前木棒拼接失败，则跳过接下来所有长度相同的木棒；
     * 如果当前木棒拼接失败，且是当前边的第一个，则直接剪掉当前分支；
     * 如果当前木棒拼接失败，且是当前边的最后一个，则直接剪掉当前分支；
     * <p>
     * 作者：GitKid
     * 链接：https://leetcode-cn.com/problems/matchsticks-to-square/solution/java-1ms-tao-yong-hui-su-mo-ban-ji-zhi-de-jian-zhi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        boolean[] flag;

        public boolean makesquare(int[] nums) {
            // 计算每条边的边长
            int sum = Arrays.stream(nums).sum();

            if (sum == 0 || sum % 4 != 0) {
                return false;
            }
            int len = sum / 4;
            flag = new boolean[nums.length];
            // 降序排列，大的先上，这样剪枝可以剪多点
            // 升序降序都是1ms
            Arrays.sort(nums);
            int l = 0, R = nums.length - 1;
            while (l <= R) {
                int t = nums[l];
                nums[l] = nums[R];
                nums[R] = t;
                l++;
                R--;
            }
            return dfs(0, len, 0, 0, nums);
        }

        // edge 表示当前是第几条边，总共四条边
        // len 表示每条边应该的长度
        // u 表示当前边已经到多少长度了
        // start 认为规定一个遍历的顺序，防止重复
        // nums[] 木棍的数组
        boolean dfs(int edge, int len, int u, int start, int[] nums) {
            if (edge == 4) {
                return true;
            }
            // u 到达len，就可以换条边摆了
            if (u == len) {
                return dfs(edge + 1, len, 0, 0, nums);
            }

            for (int i = start; i < nums.length; i++) {
                if (flag[i] || u + nums[i] > len) {
                    continue;
                }
                flag[i] = true;
                if (dfs(edge, len, u + nums[i], i + 1, nums)) {
                    return true;
                }
                flag[i] = false;

                // 能够走到这一步，说明这根火柴不行，否则已经return了
                // 相等的火柴也不行
                while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                    i++;
                }

                // 如果这条火柴是边的第一条，那说明在这条边的任意一个位置都不行，那说明这一整个方案也不行，
                if (u == 0) {
                    return false;
                }
                // 如果是最后一条，同理
                if (u + nums[i] == len) {
                    return false;
                }
            }
            return false;
        }

    }

}
