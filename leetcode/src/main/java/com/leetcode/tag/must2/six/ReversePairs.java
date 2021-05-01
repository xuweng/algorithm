package com.leetcode.tag.must2.six;

import java.util.Arrays;

/**
 * 剑指 Offer 51. 数组中的逆序对
 */
public class ReversePairs {
    public class Solution {
        public int reversePairs(int[] nums) {
            int len = nums.length;

            if (len < 2) {
                return 0;
            }

            int[] copy = new int[len];
            for (int i = 0; i < len; i++) {
                copy[i] = nums[i];
            }

            int[] temp = new int[len];
            return reversePairs(copy, 0, len - 1, temp);
        }

        private int reversePairs(int[] nums, int left, int right, int[] temp) {
            if (left == right) {
                return 0;
            }

            int mid = left + (right - left) / 2;
            int leftPairs = reversePairs(nums, left, mid, temp);
            int rightPairs = reversePairs(nums, mid + 1, right, temp);

            if (nums[mid] <= nums[mid + 1]) {
                return leftPairs + rightPairs;
            }

            int crossPairs = mergeAndCount(nums, left, mid, right, temp);
            return leftPairs + rightPairs + crossPairs;
        }

        private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
            for (int i = left; i <= right; i++) {
                temp[i] = nums[i];
            }

            int i = left;
            int j = mid + 1;

            int count = 0;
            for (int k = left; k <= right; k++) {
                if (i == mid + 1) {
                    nums[k] = temp[j];
                    j++;
                } else if (j == right + 1) {
                    nums[k] = temp[i];
                    i++;
                } else if (temp[i] <= temp[j]) {
                    nums[k] = temp[i];
                    i++;
                } else {
                    nums[k] = temp[j];
                    j++;
                    count += (mid - i + 1);
                }
            }
            return count;
        }
    }

    /**
     * 方法二：离散化树状数组
     */
    class Solution1 {
        public int reversePairs(int[] nums) {
            int n = nums.length;
            int[] tmp = new int[n];
            System.arraycopy(nums, 0, tmp, 0, n);
            // 离散化
            Arrays.sort(tmp);
            for (int i = 0; i < n; ++i) {
                nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
            }
            // 树状数组统计逆序对
            BIT bit = new BIT(n);
            int ans = 0;
            for (int i = n - 1; i >= 0; --i) {
                ans += bit.query(nums[i] - 1);
                bit.update(nums[i]);
            }
            return ans;
        }
    }

    class BIT {
        private int[] tree;
        private int n;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public int lowbit(int x) {
            return x & (-x);
        }

        public int query(int x) {
            int ret = 0;
            while (x != 0) {
                ret += tree[x];
                x -= lowbit(x);
            }
            return ret;
        }

        public void update(int x) {
            while (x <= n) {
                ++tree[x];
                x += lowbit(x);
            }
        }
    }

}
