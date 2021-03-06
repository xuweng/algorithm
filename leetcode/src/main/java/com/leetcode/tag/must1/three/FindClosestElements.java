package com.leetcode.tag.must1.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 658. 找到 K 个最接近的元素
 */
public class FindClosestElements {
    /**
     * 方法 1： 使用 Collection.sort()
     * <p>
     * 可以将数组中的元素按照与目标 x 的差的绝对值排序，排好序后前 k 个元素就是我们需要的答案
     */
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            // 可以将数组中的元素按照与目标 x 的差的绝对值排序
            List<Integer> ret = Arrays.stream(arr).boxed()
                    .sorted((a, b) -> a.equals(b) ? 0 : Math.abs(a - x) - Math.abs(b - x))
                    .collect(Collectors.toList());

            // 排好序后前 k 个元素就是我们需要的答案
            ret = ret.subList(0, k);

            Collections.sort(ret);
            return ret;
        }
    }

    /**
     * 方法 2：二叉查找和双指针
     */
    public class Solution1 {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
            if (x <= ret.get(0)) {
                // 如果目标 x 小于等于有序数组的第一个元素，那么前 k 个元素就是答案。
                return ret.subList(0, k);
            }
            int n = ret.size();
            if (ret.get(n - 1) <= x) {
                // 如果目标 x 大于等于有序数组的最后一个元素，那么最后 k 个元素就是答案
                return ret.subList(n - k, n);
            }
            // 其他情况，我们可以使用二分查找来找到恰好大于 x 一点点的元素的索引 index
            int index = Collections.binarySearch(ret, x);
            if (index < 0) {
                index = -index - 1;
            }
            // low 等于 index 左边 k-1 个位置的索引
            int low = Math.max(0, index - k - 1);
            // high 等于 index 右边 k-1 个位置的索引
            int high = Math.min(ret.size() - 1, index + k - 1);

            // 需要的 k 个数字肯定在范围 [index-k-1, index+k-1] 里面
            // 当且仅当 [low, high] 之间恰好有 k 个元素，循环终止
            while (high - low > k - 1) {
                if ((x - ret.get(low)) <= (ret.get(high) - x)) {
                    // 如果 low 小于 0 或者 low 对应的元素比 high 对应的元素更接近 x ，那么减小 high 索引
                    high--;
                } else if ((x - ret.get(low)) > (ret.get(high) - x)) {
                    // 如果 high 大于最后一个元素的索引 arr.size()-1 或者它比起 low 对应的元素更接近 x ，那么增加 low 索引
                    low++;
                } else {
                    System.out.println("unhandled case: " + low + " " + high);
                }
            }
            return ret.subList(low, high + 1);
        }
    }

    /**
     * 方法一：排除法（双指针）
     * <p>
     * 回溯 回溯 回溯 回溯
     */
    public class Solution2 {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int size = arr.length;

            int left = 0;
            int right = size - 1;

            // 一个一个删，因为是有序数组，且返回的是连续升序子数组，所以 每一次删除的元素一定位于边界
            // 删除元素的个数
            int removeNums = size - k;
            while (removeNums > 0) {
                if (x - arr[left] <= arr[right] - x) {
                    right--;
                } else {
                    left++;
                }
                removeNums--;
            }

            List<Integer> res = new ArrayList<>();
            for (int i = left; i < left + k; i++) {
                res.add(arr[i]);
            }
            return res;
        }
    }

    /**
     * 方法二：二分查找最优区间的左边界
     */
    public class Solution3 {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int size = arr.length;

            int left = 0;
            int right = size - k;

            while (left < right) {
                // int mid = left + (right - left) / 2;
                int mid = (left + right) >>> 1;
                // 尝试从长度为 k + 1 的连续子区间删除一个元素
                // 从而定位左区间端点的边界值
                if (x - arr[mid] > arr[mid + k] - x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            List<Integer> res = new ArrayList<>();
            for (int i = left; i < left + k; i++) {
                res.add(arr[i]);
            }
            return res;
        }
    }
}
