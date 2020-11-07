package com.leetcode.tag.daily.four;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 327. 区间和的个数
 */
public class CountRangeSum {
    /**
     * 方法一：归并排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/count-of-range-sum/solution/qu-jian-he-de-ge-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            long s = 0;
            //前缀和
            long[] sum = new long[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                s += nums[i];
                sum[i + 1] = s;
            }
            return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
        }

        public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
            if (left == right) {
                return 0;
            }
            int mid = (left + right) / 2;
            int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
            int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                while (l <= right && sum[l] - sum[i] < lower) {
                    l++;
                }
                while (r <= right && sum[r] - sum[i] <= upper) {
                    r++;
                }
                ret += r - l;
                i++;
            }

            // 随后合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = (int) sum[p2++];
                } else if (p2 > right) {
                    sorted[p++] = (int) sum[p1++];
                } else {
                    if (sum[p1] < sum[p2]) {
                        sorted[p++] = (int) sum[p1++];
                    } else {
                        sorted[p++] = (int) sum[p2++];
                    }
                }
            }
            for (int j = 0; j < sorted.length; j++) {
                sum[left + j] = sorted[j];
            }
            return ret;

        }
    }

    /**
     * 方法二：线段树
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/count-of-range-sum/solution/qu-jian-he-de-ge-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int countRangeSum(int[] nums, int lower, int upper) {
            long sum = 0;
            long[] preSum = new long[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                sum += nums[i];
                preSum[i + 1] = sum;
            }

            Set<Long> allNumbers = new TreeSet<>();
            for (long x : preSum) {
                allNumbers.add(x);
                allNumbers.add(x - lower);
                allNumbers.add(x - upper);
            }
            // 利用哈希表进行离散化
            Map<Long, Integer> values = new HashMap<>();
            int idx = 0;
            for (long x : allNumbers) {
                values.put(x, idx);
                idx++;
            }

            SegNode root = build(0, values.size() - 1);
            int ret = 0;
            for (long x : preSum) {
                int left = values.get(x - upper), right = values.get(x - lower);
                ret += count(root, left, right);
                insert(root, values.get(x));
            }
            return ret;
        }

        public SegNode build(int left, int right) {
            SegNode node = new SegNode(left, right);
            if (left == right) {
                return node;
            }
            int mid = (left + right) / 2;
            node.leftChild = build(left, mid);
            node.rightChild = build(mid + 1, right);
            return node;
        }

        public int count(SegNode root, int left, int right) {
            if (left > root.hi || right < root.lo) {
                return 0;
            }
            if (left <= root.lo && root.hi <= right) {
                return root.add;
            }
            return count(root.leftChild, left, right) + count(root.rightChild, left, right);
        }

        public void insert(SegNode root, int val) {
            root.add++;
            if (root.lo == root.hi) {
                return;
            }
            int mid = (root.lo + root.hi) / 2;
            if (val <= mid) {
                insert(root.leftChild, val);
            } else {
                insert(root.rightChild, val);
            }
        }
    }

    class SegNode {
        int lo, hi, add;
        SegNode leftChild, rightChild;

        public SegNode(int left, int right) {
            lo = left;
            hi = right;
            add = 0;
            leftChild = null;
            rightChild = null;
        }
    }

}
