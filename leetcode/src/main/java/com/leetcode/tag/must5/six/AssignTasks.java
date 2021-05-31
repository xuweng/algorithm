package com.leetcode.tag.must5.six;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1882. 使用服务器处理任务
 */
public class AssignTasks {
    public class Solution {
        public int[] assignTasks(int[] servers, int[] tasks) {
            PriorityQueue<Server> active = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight == 0 ? o1.index - o2.index : o1.weight - o2.weight);
            PriorityQueue<Server> waste = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
            for (int i = 0; i < servers.length; i++) {
                active.add(new Server(servers[i], i, 0));
            }
            int[] res = new int[tasks.length];
            int index = 0;
            int globalTime = -1;
            while (index < res.length) {
                while (true) {
                    globalTime++;
                    while (!waste.isEmpty() && waste.peek().time == globalTime) {
                        active.offer(waste.poll());
                    }
                    if (!active.isEmpty()) {
                        break;
                    } else {
                        globalTime = waste.peek().time - 1;
                    }
                }
                while (!active.isEmpty() && index <= globalTime && index < res.length) {
                    Server server = active.poll();
                    server.time = globalTime + tasks[index];
                    res[index] = server.index;
                    waste.offer(server);
                    index++;
                }
            }
            return res;
        }
    }

    class Server {
        int weight;
        int index;
        int time;

        public Server(int weight, int index, int time) {
            this.weight = weight;
            this.index = index;
            this.time = time;
        }
    }

    /**
     * 方法一：优先队列
     */
    class Solution1 {
        class ServerState {
            int idx;
            int weight;
            int ending;

            public ServerState(int i, int w, int e) {
                idx = i;
                weight = w;
                ending = e;
            }
        }

        public int[] assignTasks(int[] servers, int[] tasks) {
            int n = servers.length, m = tasks.length;
            int[] ans = new int[m];
            PriorityQueue<ServerState> ready = new PriorityQueue<>((a, b) -> (a.weight == b.weight) ? a.idx - b.idx : a.weight - b.weight);
            for (int i = 0; i < n; i++) {
                ready.offer(new ServerState(i, servers[i], 0));
            }
            PriorityQueue<ServerState> busy = new PriorityQueue<>((a, b) -> (a.ending == b.ending) ? ((a.weight == b.weight) ? a.idx - b.idx : a.weight - b.weight) : a.ending - b.ending);
            for (int j = 0; j < m; j++) {
                while (!busy.isEmpty() && busy.peek().ending <= j) {
                    ready.offer(busy.poll());
                }
                // 如果暂时没有可用的服务器，就用最先完成服务的那个，也就是busy的堆顶
                // 更新服务结束时间，与下标j无关，因为已经不是从j时刻开始了
                if (ready.isEmpty()) {
                    ServerState top = busy.poll();
                    top.ending += tasks[j];
                    ans[j] = top.idx;
                    busy.offer(top);
                } else {
                    ServerState serv = ready.poll();
                    serv.ending = j + tasks[j];
                    ans[j] = serv.idx;
                    busy.offer(serv);
                }
            }
            return ans;
        }
    }
}
