package com.leetcode.tag.must1.eight;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 */
public class MedianFinder {
    /**
     * 当前大顶堆和小顶堆的元素个数之和
     */
    private int count;
    /**
     * 最大堆的堆顶元素，小于或者等于最小堆的堆顶元素
     * 最大堆的元素个数或者与最小堆的元素个数相等，或者多 1 相等就是偶数，多1就是奇数
     */
    private final PriorityQueue<Integer> maxheap;
    private final PriorityQueue<Integer> minheap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        count = 0;
        maxheap = new PriorityQueue<>((x, y) -> y - x);
        minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());

        if (count % 2 != 0) {
            maxheap.offer(minheap.poll());
        }
    }

    public double findMedian() {
        if (count % 2 == 0) {
            return (double) (maxheap.peek() + minheap.peek()) / 2;
        }

        return maxheap.peek();
    }
}