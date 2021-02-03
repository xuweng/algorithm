package com.leetcode.tag.daily.seven;

import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * <p>
 * 作者：liweiwei1419
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream/solution/you-xian-dui-lie-python-dai-ma-java-dai-ma-by-liwe/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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
        count += 1;
        // 先加入最大堆
        maxheap.offer(num);
        // 再把最大堆的堆顶元素加入最小堆 保证最小堆的元素都>最大堆

        // 最小堆存放最大堆的堆顶元素
        minheap.add(maxheap.poll());
        // 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
        if ((count & 1) != 0) {
            // 最大堆存放最小堆的最小值
            maxheap.add(minheap.poll());
        }
    }

    public double findMedian() {
        if ((count & 1) == 0) {
            // 如果两个堆合起来的元素个数是偶数，数据流的中位数就是各自堆顶元素的平均值
            return (double) (maxheap.peek() + minheap.peek()) / 2;
        }

        // 如果两个堆合起来的元素个数是奇数，数据流的中位数大顶堆的堆顶元素
        return (double) maxheap.peek();
    }
}

