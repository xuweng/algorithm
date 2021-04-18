package com.leetcode.tag.must1.two;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 5736. 单线程 CPU
 */
public class GetOrder {
    /**
     * 简单模拟
     * <p>
     * 排序+优先队列
     */
    class Solution {
        class Task {
            int id;
            int enqueueTime;
            int processingTime;

            public Task(int id, int enqueueTime, int processingTime) {
                this.id = id;
                this.enqueueTime = enqueueTime;
                this.processingTime = processingTime;
            }
        }

        public int[] getOrder(int[][] tasks) {
            int len = tasks.length;
            List<Task> taskList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
            }
            //按入队时间排序
            taskList.sort(Comparator.comparingInt(t -> t.enqueueTime));
            //利用最小堆获取下个要执行的任务
            PriorityQueue<Task> minHeap = new PriorityQueue<>((t1, t2) -> {
                if (t1.processingTime == t2.processingTime) {
                    //当执行时间相同时，根据id升序
                    return t1.id - t2.id;
                } else {
                    //当执行时间不同时，根据执行时间升序
                    return t1.processingTime - t2.processingTime;
                }
            });
            //当前时间，使用long防止int溢出
            long now = 0;
            //taskList的坐标
            int i = 0;
            int[] ret = new int[len];
            //ret的坐标
            int p = 0;
            //taskList中还有任务没有放入堆时
            while (i < len) {
                //将所有入队时间<=当前时间的任务放入堆中
                while (i < len && taskList.get(i).enqueueTime <= now) {
                    minHeap.offer(taskList.get(i));
                    i++;
                }
                //当堆中没有任务，即当前cpu空闲
                if (minHeap.isEmpty()) {
                    //当前时间置为任务队列taskList中入队时间最小的时间
                    now = taskList.get(i).enqueueTime;
                    while (i < len && taskList.get(i).enqueueTime <= now) {
                        minHeap.offer(taskList.get(i));
                        i++;
                    }
                }
                //此时保证堆中有任务待执行，取出执行即可
                Task task = minHeap.poll();
                ret[p++] = task.id;
                now += task.processingTime;
            }
            //当任务列表taskList中的全部任务已经入堆
            while (!minHeap.isEmpty()) {
                //按顺序取出任务执行即可
                ret[p++] = minHeap.poll().id;
            }
            return ret;
        }
    }
}
