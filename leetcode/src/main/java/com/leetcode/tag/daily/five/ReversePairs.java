package com.leetcode.tag.daily.five;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 493. 翻转对
 */
public class ReversePairs {
    /**
     * 方法一：归并排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reverse-pairs/solution/fan-zhuan-dui-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int reversePairs(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            return reversePairsRecursive(nums, 0, nums.length - 1);
        }

        /**
         * 则 nums[l..r] 中的翻转对数目，就等于两个子数组的翻转对数目之和，加上左右端点分别位于两个子数组的翻转对数目。
         * <p>
         * [left,mid],[mid,right],[left,right]
         *
         * @param nums
         * @param left
         * @param right
         * @return
         */
        public int reversePairsRecursive(int[] nums, int left, int right) {
            if (left == right) {
                return 0;
            }
            int mid = (left + right) / 2;
            //将两个子数组分别排好序
            int n1 = reversePairsRecursive(nums, left, mid);
            //将两个子数组分别排好序
            int n2 = reversePairsRecursive(nums, mid + 1, right);
            int ret = n1 + n2;

            // 计算[left,right]
            // 首先统计下标对的数量
            int i = left;
            int j = mid + 1;
            while (i <= mid) {
                while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                    j++;
                }
                //why?
                // 的确是j-mid。求j移动的次数.
                // 如果nums[i]>2*nums[j]，比nums[i]还大的数，且在nums[j]左边，就一定是翻转对
                ret += j - mid - 1;
                i++;
            }

            // 随后合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = nums[p2++];
                } else if (p2 > right) {
                    sorted[p++] = nums[p1++];
                } else {
                    if (nums[p1] < nums[p2]) {
                        sorted[p++] = nums[p1++];
                    } else {
                        sorted[p++] = nums[p2++];
                    }
                }
            }
            System.arraycopy(sorted, 0, nums, left, sorted.length);
            return ret;
        }
    }

    /**
     * 方法二：树状数组
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reverse-pairs/solution/fan-zhuan-dui-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int reversePairs(int[] nums) {
            Set<Long> allNumbers = new TreeSet<>();
            for (int x : nums) {
                allNumbers.add((long) x);
                allNumbers.add((long) x * 2);
            }
            // 利用哈希表进行离散化
            Map<Long, Integer> values = new HashMap<>();
            int idx = 0;
            for (long x : allNumbers) {
                values.put(x, idx);
                idx++;
            }

            int ret = 0;
            BIT bit = new BIT(values.size());
            for (int num : nums) {
                int left = values.get((long) num * 2), right = values.size() - 1;
                ret += bit.query(right + 1) - bit.query(left + 1);
                bit.update(values.get((long) num) + 1, 1);
            }
            return ret;
        }
    }

    static class BIT {
        int[] tree;
        int n;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public static int lowbit(int x) {
            return x & (-x);
        }

        public void update(int x, int d) {
            while (x <= n) {
                tree[x] += d;
                x += lowbit(x);
            }
        }

        public int query(int x) {
            int ans = 0;
            while (x != 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }

}
