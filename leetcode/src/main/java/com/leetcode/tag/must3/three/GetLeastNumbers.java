package com.leetcode.tag.must3.three;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 剑指 Offer 40. 最小的k个数
 */
public class GetLeastNumbers {
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            // 大顶堆
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i : arr) {
                priorityQueue.offer(i);
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }

            int index = 0;
            int[] result = new int[k];
            while (!priorityQueue.isEmpty()) {
                result[index++] = priorityQueue.poll();
            }

            return result;
        }
    }

    /**
     * 方法一：排序
     */
    class Solution1 {
        public int[] getLeastNumbers(int[] arr, int k) {
            int[] vec = new int[k];
            Arrays.sort(arr);
            for (int i = 0; i < k; ++i) {
                vec[i] = arr[i];
            }
            return vec;
        }
    }

    /**
     * 方法二：堆
     */
    class Solution2 {
        public int[] getLeastNumbers(int[] arr, int k) {
            int[] vec = new int[k];
            if (k == 0) { // 排除 0 的情况
                return vec;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
            for (int i = 0; i < k; ++i) {
                queue.offer(arr[i]);
            }
            for (int i = k; i < arr.length; ++i) {
                if (queue.peek() > arr[i]) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
            for (int i = 0; i < k; ++i) {
                vec[i] = queue.poll();
            }
            return vec;
        }
    }

    /**
     * 方法三：快排思想
     */
    class Solution3 {
        public int[] getLeastNumbers(int[] arr, int k) {
            randomizedSelected(arr, 0, arr.length - 1, k);
            // [0,k] 已经是top k

            int[] vec = new int[k];
            for (int i = 0; i < k; ++i) {
                vec[i] = arr[i];
            }
            return vec;
        }

        private void randomizedSelected(int[] arr, int l, int r, int k) {
            // 1个不需要排序
            if (l >= r) {
                return;
            }
            // 中轴
            int pos = randomizedPartition(arr, l, r);
            // [l,pos] 区间的个数=k
            // pos - l + 1 = k
            int num = pos - l + 1;
            if (k == num) {
                return;
            }
            if (k < num) {
                // 缩小区间 在[l,pos-1] 找 k 个
                randomizedSelected(arr, l, pos - 1, k);
            } else {
                // 扩大区间 在[pos+1,r] 找剩余 k-num
                randomizedSelected(arr, pos + 1, r, k - num);
            }
        }

        // 基于随机的划分
        private int randomizedPartition(int[] nums, int l, int r) {
            // 随机下标i
            int i = new Random().nextInt(r - l + 1) + l;
            // i，r交换
            swap(nums, r, i);
            // 分区
            return partition(nums, l, r);
        }

        private int partition(int[] nums, int l, int r) {
            int pivot = nums[r];
            int i = l - 1;
            for (int j = l; j <= r - 1; ++j) {
                if (nums[j] <= pivot) {
                    i = i + 1;
                    swap(nums, i, j);
                }
            }
            swap(nums, i + 1, r);
            return i + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
