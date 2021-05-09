package com.leetcode.tag.must3.three;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 */
public class GetLeastNumbers {
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
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
}
