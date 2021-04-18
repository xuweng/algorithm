package com.leetcode.tag.must1.two;

import java.util.*;

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
            // 利用最小堆获取下个要执行的任务
            PriorityQueue<Task> minHeap = new PriorityQueue<>((t1, t2) -> {
                if (t1.processingTime == t2.processingTime) {
                    //当执行时间相同时，根据id升序
                    //如果多个任务具有同样的最短执行时间，则选择下标最小的任务开始执行
                    return t1.id - t2.id;
                } else {
                    //当执行时间不同时，根据执行时间升序
                    //CPU 将会选择 执行时间最短 的任务开始执行
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
                // 更新当前时间
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

    class Solution1 {
        public int[] getOrder(int[][] tasks) {
            // 用于记录 任务开始时间从大到小的数组
            Integer[] arr = new Integer[tasks.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            //这边是对 arr 按照任务开始时间从大到小的排序
            Arrays.sort(arr, Comparator.comparingInt(a -> tasks[a][0]));
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
                if (tasks[a][1] > tasks[b][1]) {
                    //任务时间长的 放后面
                    return 1;
                } else if (tasks[a][1] == tasks[b][1]) {
                    //当任务时间相同时，按照序号大小排序
                    return a - b;
                }
                return -1;
            });   //定义一个优先队列
            int j = 0;
            int i = 0;
            int[] ans = new int[tasks.length];
            //定义一个时间线 （这边卡了很久。。）
            int time = tasks[arr[0]][0];
            while (queue.isEmpty() || i < tasks.length) {
                if (queue.isEmpty()) {
                    //比如 用例 [[7,10],[7,12],[7,5],[7,4],[7,2]] 。
                    int k = tasks[arr[i]][0];
                    while (i < tasks.length && tasks[arr[i]][0] == k) {
                        queue.add(arr[i++]);
                    }
                } else {
                    int index = queue.poll();
                    //时间线 time 要加上 任务执行后 时间线 走到哪了
                    time += tasks[index][1];
                    ans[j++] = index;
                    while (i < tasks.length && tasks[arr[i]][0] <= time) {
                        //把开始时间 小于time的都加入到队列
                        queue.add(arr[i++]);
                    }
                }
            }
            return ans;
        }
    }
}
