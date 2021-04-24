package com.leetcode.tag.must1.seven;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 */
public class MedianFinder1 {
    /**
     * 当前大顶堆和小顶堆的元素个数之和
     */
    private int count;
    // 最大堆 左部分 比最小堆都小 count是奇数 最大堆放多一个 count是偶数 两个堆平分
    private final PriorityQueue<Integer> maxheap;
    // 最小堆 右部分 比最大堆都大
    private final PriorityQueue<Integer> minheap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder1() {
        count = 0;
        maxheap = new PriorityQueue<>((x, y) -> y - x);
        minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count++;
        maxheap.offer(num);
        minheap.offer(maxheap.poll());

        if (count % 2 != 0) {
            maxheap.offer(minheap.poll());
        }
    }

    public double findMedian() {
        if (count % 2 == 0) {
            return (maxheap.peek() + minheap.peek()) / 2;
        }

        return maxheap.peek();
    }
}