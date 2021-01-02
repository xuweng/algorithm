package com.leetcode.tag.daily.six;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 */
public class MaxSlidingWindow {
    /**
     * O(nk)
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i <= nums.length - k; i++) {
                result.add(max(nums, i, i + k));
            }

            return result.stream().mapToInt(integer -> integer).toArray();
        }

        private int max(int[] nums, int start, int end) {
            int max = Integer.MIN_VALUE;
            for (int i = start; i < end; i++) {
                max = Math.max(max, nums[i]);
            }

            return max;
        }
    }

    /**
     * 方法一：优先队列
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            //判断堆顶元素与滑动窗口的位置关系
            //存储二元组 (num,index)，表示元素num 在数组中的下标为index
            PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
            for (int i = 0; i < k; ++i) {
                pq.offer(new int[]{nums[i], i});
            }
            int[] ans = new int[n - k + 1];
            ans[0] = pq.peek()[0];
            for (int i = k; i < n; ++i) {
                pq.offer(new int[]{nums[i], i});
                while (pq.peek()[1] <= i - k) {
                    // 下标在窗口外。堆顶出堆。
                    pq.poll();
                }
                // 计算下标
                ans[i - k + 1] = pq.peek()[0];
            }
            return ans;
        }
    }

    /**
     * 最值 堆 优先队列
     * <p>
     * 方法二：单调递减队列 + 双端队列
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            //在队列中，这些下标按照从小到大的顺序被存储，并且它们在数组 nums 中对应的值是严格单调递减的
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < k; ++i) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }

            int[] ans = new int[n - k + 1];
            ans[0] = nums[deque.peekFirst()];
            for (int i = k; i < n; ++i) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                while (deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
            return ans;
        }
    }


}
