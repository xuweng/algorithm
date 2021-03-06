package com.leetcode.tag.must2.six;

import java.util.Arrays;

/**
 * 剑指 Offer 51. 数组中的逆序对
 */
public class ReversePairs {
    /**
     * 方法一：归并排序
     */
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

    class Solution2 {
        public int reversePairs(int[] nums) {
            int cnt = 0;
            int len = nums.length;
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (nums[i] > nums[j]) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }

    class Solution3 {
        int[] nums, tmp;

        public int reversePairs(int[] nums) {
            this.nums = nums;
            tmp = new int[nums.length];

            return mergeSort(0, nums.length - 1);
        }

        private int mergeSort(int l, int r) {
            // 终止条件
            if (l >= r) {
                return 0;
            }
            // 递归划分
            int m = (l + r) / 2;
            // left区间+right区间+跨区间
            int res = mergeSort(l, m) + mergeSort(m + 1, r);
            // left和right已经有序
            // 合并阶段
            int i = l, j = m + 1;
            // 辅助数组 tmp ，用于合并阶段暂存元素
            for (int k = l; k <= r; k++) {
                tmp[k] = nums[k];
            }
            // nums排序
            for (int k = l; k <= r; k++) {
                if (i == m + 1) {
                    // 当 j = r + 1,代表左子数组已合并完，因此添加右子数组当前元素 tmp[j] ，并执行 j = j + 1
                    nums[k] = tmp[j++];
                } else if (j == r + 1 || tmp[i] <= tmp[j]) {
                    // 代表右子数组已合并完，因此添加左子数组当前元素 tmp[i]，并执行 i = i + 1
                    // 当 tmp[i]≤tmp[j] 时： 添加左子数组当前元素 tmp[i]，并执行 i = i + 1
                    nums[k] = tmp[i++];
                } else {
                    // tmp[i] > tmp[j]
                    // 添加右子数组当前元素 tmp[j]，并执行 j = j + 1 ；此时构成 m - i + 1个「逆序对」，统计添加至 res
                    nums[k] = tmp[j++];
                    // 统计逆序对
                    res += m - i + 1;
                }
            }
            return res;
        }
    }

    /**
     * 厉害
     */
    class Solution4 {
        int count = 0;

        public int reversePairs(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return count;
            }
            mergeSort(nums, 0, n - 1);
            return count;
        }

        private int[] mergeSort(int[] nums, int left, int right) {
            if (left == right) {
                return new int[]{nums[left]};
            }
            int mid = (left + right) / 2;
            int[] leftArr = mergeSort(nums, left, mid);
            int[] rightArr = mergeSort(nums, mid + 1, right);

            // 创建新数组
            int[] res = new int[leftArr.length + rightArr.length];
            int l = 0;
            int r = 0;
            //res的下标
            int i = 0;
            // 合并
            while (l < leftArr.length && r < rightArr.length) {
                if (leftArr[l] <= rightArr[r]) {
                    res[i++] = leftArr[l++];
                } else {
                    //左边数组l位置开始都可以和r位置组成逆序对
                    count += leftArr.length - l;
                    res[i++] = rightArr[r++];
                }
            }
            // left有剩余
            while (l < leftArr.length) {
                res[i++] = leftArr[l++];
            }
            // right有剩余
            while (r < rightArr.length) {
                res[i++] = rightArr[r++];
            }
            return res;
        }
    }

    class Solution5 {
        int count;

        public int reversePairs(int[] nums) {
            if (nums.length < 2) {
                return 0;
            }
            merge(nums, 0, nums.length - 1);

            return count;
        }

        private int[] merge(int[] nums, int left, int right) {
            if (left >= right) {
                // 必须初始化nums[left]
                return new int[]{nums[left]};
            }
            int mid = (left + right) / 2;
            int[] mergeLeft = merge(nums, left, mid);
            int[] mergeRight = merge(nums, mid + 1, right);
            int[] result = new int[mergeLeft.length + mergeRight.length];

            // left和right都是新数组,下标从0开始
            int i = 0;
            int j = 0;
            int r = 0;
            while (i < mergeLeft.length && j < mergeRight.length) {
                if (mergeLeft[i] <= mergeRight[j]) {
                    result[r++] = mergeLeft[i++];
                } else {
                    // i后面都是
                    count += mergeLeft.length - i;
                    result[r++] = mergeRight[j++];
                }
            }
            while (i < mergeLeft.length) {
                result[r++] = mergeLeft[i++];
            }
            while (j < mergeRight.length) {
                result[r++] = mergeRight[j++];
            }

            return result;
        }
    }
}
