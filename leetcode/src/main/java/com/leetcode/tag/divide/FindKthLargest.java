package com.leetcode.tag.divide;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * 代码模板太好用
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>215. 数组中的第K个最大元素
 */
public class FindKthLargest {
  public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
      return 0;
    }
    Queue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      queue.offer(nums[i]);
    }
    for (int i = k; i < nums.length; i++) {
      if (nums[i] > queue.peek()) {
        queue.poll();
        queue.offer(nums[i]);
      }
    }
    return queue.peek();
  }

  public int findKthLargest1(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
      return 0;
    }

    return divide(nums, 0, nums.length - 1, k);
  }

  private int divide(int[] nums, int low, int high, int k) {
    if (low > high) {
      return 0;
    }
    int p = patition(nums, low, high);
    if (nums.length - k == p) {
      return nums[p];
    } else if (nums.length - k < p) {
      return divide(nums, low, p - 1, k);
    } else {
      return divide(nums, p + 1, high, k);
    }
  }

  private int patition(int[] nums, int low, int high) {
    int p = nums[low];
    while (low < high) {
      while (low < high && nums[high] >= p) {
        high--;
      }
      nums[low] = nums[high];
      while (low < high && nums[low] < p) {
        low++;
      }
      nums[high] = nums[low];
    }
    nums[low] = p;
    return low;
  }

  /**
   * 修改基础代码模板
   *
   * <p>修改快排的代码模板
   *
   * <p>修改建堆的代码模板
   */
  class Solution {
    public int findKthLargest(int[] nums, int k) {
      return quickSort(nums, 0, nums.length - 1, k);
    }

    int quickSort(int[] nums, int l, int r, int k) {
      if (l >= r) {
        return nums[l];
      }
      int i = l - 1, j = r + 1;
      int mid = nums[l + r >> 1];
      while (i < j) {
        do {
          i++;
        } while (nums[i] < mid);
        do {
          j--;
        } while (nums[j] > mid);
        if (i < j) {
          swap(nums, i, j);
        }
      }
      if (r - j >= k) {
        return quickSort(nums, j + 1, r, k);
      }
      return quickSort(nums, l, j, k - (r - j));
    }

    void swap(int[] nums, int l, int r) {
      int tmp = nums[l];
      nums[l] = nums[r];
      nums[r] = tmp;
    }
  }

  class Solution1 {

    public int findKthLargest(int[] nums, int k) {
      // 前K个元素原地建小顶堆
      buildHeap(nums, k);
      // 遍历剩下的元素
      for (int i = k; i < nums.length; i++) {
        if (nums[i] < nums[0]) {
          continue;
        }
        swap(nums, i, 0);
        heapify(nums, k, 0);
      }
      return nums[0];
    }

    /**
     * 堆化函数 父节点下标i，左右子节点的下标分别为 2*i+1 和 2*i+2
     */
    public void heapify(int[] a, int k, int i) {
      // 临时变量 minPos 用于存储最小值的下标，先假设父节点最小
      int minPos = i;
      while (true) {
        // 和左子节点比较
        if (i * 2 + 1 < k && a[i * 2 + 1] < a[i]) {
          minPos = i * 2 + 1;
        }
        if (i * 2 + 2 < k && a[i * 2 + 2] < a[minPos]) {
          minPos = i * 2 + 2;
        }
        // 如果 minPos没有发生变化，说明父节点已经是最小了，直接跳出
        if (minPos == i) {
          break;
        }
        // 交换
        swap(a, i, minPos);
        i = minPos;
      }
    }

    /* 建堆函数 */
    public void buildHeap(int[] a, int k) {
      for (int i = k / 2 - 1; i >= 0; i--) {
        heapify(a, k, i);
      }
    }

    public void swap(int[] a, int n, int m) {
      int tmp = a[n];
      a[n] = a[m];
      a[m] = tmp;
    }
  }

  /**
   * 方法一：堆
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution2 {
    /**
     * 代码巧妙
     *
     * <p>代码简洁
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
      // init heap 'the smallest element first'
      PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n));

      // keep k largest elements in the heap
      // 先把元素入堆,再把最小值干掉
      for (int n : nums) {
        // 先把k+1个元素入堆
        heap.add(n);
        if (heap.size() > k) {
          // 第k+1个元素,也是堆顶元素,也是最小值出堆
          heap.poll();
        }
      }

      // output
      return heap.poll();
    }
  }

  /**
   * 方方法二：快速选择
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution3 {
    int[] nums;

    public void swap(int a, int b) {
      int tmp = this.nums[a];
      this.nums[a] = this.nums[b];
      this.nums[b] = tmp;
    }

    /**
     * 代码简洁
     *
     * <p>这个分区函数更加简单,更加容易理解
     *
     * <p>快速选择
     *
     * @param left
     * @param right
     * @param pivotIndex
     * @return
     */
    public int partition(int left, int right, int pivotIndex) {
      int pivot = this.nums[pivotIndex];
      // 1. move pivot to end
      swap(pivotIndex, right);
      int storeIndex = left;

      // 2. move all smaller elements to the left
      for (int i = left; i <= right; i++) {
        if (this.nums[i] < pivot) {
          swap(storeIndex, i);
          storeIndex++;
        }
      }

      // 3. move pivot to its final place
      swap(storeIndex, right);

      return storeIndex;
    }

    public int quickSelect(int left, int right, int kSmallest) {
      /*
      Returns the k-th smallest element of list within left..right.
      */

      if (left == right) // If the list contains only one element,
      {
        return this.nums[left]; // return that element
      }

      // select a random pivot_index
      Random randomNum = new Random();
      int pivotIndex = left + randomNum.nextInt(right - left);

      pivotIndex = partition(left, right, pivotIndex);

      // the pivot is on (N - k)th smallest position
      if (kSmallest == pivotIndex) {
        return this.nums[kSmallest];
      }
      // go left side
      else if (kSmallest < pivotIndex) {
        return quickSelect(left, pivotIndex - 1, kSmallest);
      }
      // go right side
      return quickSelect(pivotIndex + 1, right, kSmallest);
    }

    public int findKthLargest(int[] nums, int k) {
      this.nums = nums;
      int size = nums.length;
      // kth largest is (N - k)th smallest
      // 注意到第 k 个最大元素也就是第 size - k 个最小元素，因此可以用第 k 小算法来解决本问题。
      return quickSelect(0, size - 1, size - k);
    }
  }
}
