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
                // 扩大区间 在[l,pos]找到 num个 , 在[pos+1,r] 找剩余 k-num
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

    class Solution4 {
        public int[] getLeastNumbers(int[] arr, int k) {
            // 两个参数校验
            if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
                return new int[0];
            }
            // top k中轴下标
            int index = divide(arr, 0, arr.length - 1, k);

            int[] result = new int[k];

            System.arraycopy(arr, 0, result, 0, index + 1);

            return result;
        }

        public int divide(int[] arr, int low, int high, int k) {
            // 递归终止条件
            int p = patition(arr, low, high);
            if (p == k - 1) {
                // 找到top k 下标
                return p;
            }
            if (p < k - 1) {
                // 扩大区间
                return divide(arr, p + 1, high, k);
            } else {
                // 缩小区间
                return divide(arr, low, p - 1, k);
            }
        }

        public int patition(int[] arr, int low, int high) {
            // 记录中轴
            int p = arr[low];
            // [3,2,1] 3
            // 死循环?
            while (low < high) {
                // [3,2,1]
                // 边界判断边界麻烦
                while (low < high && arr[high] >= p) {
                    high--;
                }
                // [1,2,1]
                if (low < high) {
                    // 小的放在左边
                    arr[low] = arr[high];
                }
                while (low < high && arr[low] < p) {
                    low++;
                }
                // []
                if (low < high) {
                    // 大的放在右边
                    arr[high] = arr[low];
                }
                // 到这里 交换low和high 循环继续
            }
            arr[low] = p;
            return low;
        }
    }

    class Solution5 {
        public int[] getLeastNumbers(int[] arr, int k) {
            // 两个参数校验
            if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
                return new int[0];
            }
            // top k中轴下标
            int index = divide(arr, 0, arr.length - 1, k);

            int[] result = new int[k];

            System.arraycopy(arr, 0, result, 0, index + 1);

            return result;
        }

        public int divide(int[] arr, int low, int high, int k) {
            // 递归终止条件
            int p = patition(arr, low, high);
            if (p == k - 1) {
                // 区间 [0,k-1]
                // 找到top k 下标
                return p;
            }
            if (p < k - 1) {
                // 扩大区间
                return divide(arr, p + 1, high, k);
            } else {
                // 缩小区间
                return divide(arr, low, p - 1, k);
            }
        }

        /**
         * 0123456 4
         * <p>
         * high=3 low=4
         * <p>
         * [3,2,1] 3
         * <p>
         * [1,2,3]
         *
         * @param arr
         * @param low
         * @param high
         * @return
         */
        public int patition(int[] arr, int low, int high) {
            // 记录中轴
            int p = arr[low];
            while (low < high) {
                // 判断边界
                while (low < high && arr[high] >= p) {
                    high--;
                }
                while (low < high && arr[low] < p) {
                    low++;
                }
                // 倒序 交换 [3,2,1] [1,2,3]
                // 交换 交换后循环继续
                if (low < high) {
                    int temp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = temp;
                }
            }
            // 设置中轴
            arr[low + 1] = p;
            // 中轴下标
            return low + 1;
        }
    }

    public static int patition(int[] arr, int low, int high) {
        // 记录中轴
        int p = arr[low];
        // [3,2,1] 3
        // 死循环?
        while (low < high) {
            // [3,2,1]
            // 边界判断边界麻烦
            while (low < high && arr[high] >= p) {
                high--;
            }
            // [1,2,1]
            if (low < high) {
                // 小的放在左边
                arr[low] = arr[high];
            }
            while (low < high && arr[low] < p) {
                low++;
            }
            // low=high
            if (low < high) {
                // 大的放在右边
                arr[high] = arr[low];
            }
            // 到这里 交换low和high 循环继续
        }
        arr[low] = p;
        return low;
    }

    public static int patition1(int[] arr, int low, int high) {
        // 记录中轴
        int p = arr[low];
        while (low < high) {
            // 判断边界
            while (low < high && arr[high] >= p) {
                high--;
            }
            while (low < high && arr[low] < p) {
                low++;
            }
            // 倒序 交换 [3,2,1] [1,2,3]
            // 交换 交换后循环继续
            if (low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }
        // 设置中轴
        arr[low + 1] = p;
        // 中轴下标
        return low + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1};
        int low = 0;
        int high = arr.length - 1;

        //        patition1(arr, low, high);

        patition(arr, low, high);
    }
}
