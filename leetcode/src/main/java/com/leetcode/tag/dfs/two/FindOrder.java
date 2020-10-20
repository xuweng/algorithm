package com.leetcode.tag.dfs.two;

import java.util.*;

/**
 * 210. 课程表 II
 * <p>
 * dfs
 * <p>
 * 并查集.并查集.并查集.每个root.每个连通分量.
 * <p>
 * 本题是一道经典的「拓扑排序」问题。
 * <p>
 * 3种状态.拓扑排序.环.
 */
public class FindOrder {
    /**
     * 方法一：深度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/course-schedule-ii/solution/ke-cheng-biao-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        // 存储有向图
        List<List<Integer>> edges;
        // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
        int[] visited;
        // 用数组来模拟栈，下标 n-1 为栈底，0 为栈顶
        int[] result;
        // 判断有向图中是否有环
        boolean valid = true;
        // 栈下标
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<>());
            }
            visited = new int[numCourses];
            result = new int[numCourses];
            index = numCourses - 1;
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
            }
            // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索
            for (int i = 0; i < numCourses && valid; ++i) {
                //未搜索
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            if (!valid) {
                return new int[0];
            }
            // 如果没有环，那么就有拓扑排序
            // 在整个深度优先搜索的过程结束后，如果我们没有找到图中的环，那么栈中存储这所有的 n 个节点，从栈顶到栈底的顺序即为一种拓扑排序。
            return result;
        }

        /**
         * 节点有3种状态
         * <p>
         * 对于图中的任意一个节点，它在搜索的过程中有三种状态，即：
         * <p>
         * 「未搜索」：我们还没有搜索到这个节点；
         * <p>
         * 「搜索中」：我们搜索过这个节点，但还没有回溯到该节点，即该节点还没有入栈，还有相邻的节点没有搜索完成）；
         * <p>
         * 「已完成」：我们搜索过并且回溯过这个节点，即该节点已经入栈，并且所有该节点的相邻节点都出现在栈的更底部的位置，满足拓扑排序的要求。
         * <p>
         * 作者：LeetCode-Solution
         * 链接：https://leetcode-cn.com/problems/course-schedule-ii/solution/ke-cheng-biao-ii-by-leetcode-solution/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param u
         */
        public void dfs(int u) {
            // 开始
            // 将节点标记为「搜索中」
            visited[u] = 1;
            // 进行dfs

            // 搜索其相邻节点
            // 只要发现有环，立刻停止搜索
            for (int v : edges.get(u)) {
                // 如果「未搜索」那么搜索相邻节点
                if (visited[v] == 0) {
                    dfs(v);
                    if (!valid) {
                        return;
                    }
                }
                // 如果「搜索中」说明找到了环
                // 因此是不存在拓扑排序的
                else if (visited[v] == 1) {
                    valid = false;
                    return;
                }
            }
            // 回溯
            // 将节点标记为「已完成」
            visited[u] = 2;
            // 将节点入栈
            result[index--] = u;
        }
    }

    class Solution1 {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] visited;
        int[] result;
        int index;
        boolean flag = true;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            index = numCourses - 1;
            visited = new int[numCourses];
            result = new int[numCourses];
            for (int[] prerequisite : prerequisites) {
                map.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
            }

            for (int i = 0; i < numCourses && flag; i++) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            //有环
            if (!flag) {
                return new int[0];
            }

            return result;
        }

        private void dfs(int i) {
            visited[i] = 1;
            if (map.containsKey(i)) {
                for (Integer integer : map.get(i)) {
                    if (visited[integer] == 0) {
                        dfs(integer);
                        //这里return效率会提高.
                        if (!flag) {
                            return;
                        }
                    } else if (visited[integer] == 1) {
                        // 有环
                        flag = false;
                        return;
                    }
                }
            }
            visited[i] = 2;
            result[index--] = i;
        }
    }

    /**
     * 方法二：广度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/course-schedule-ii/solution/ke-cheng-biao-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        // 存储有向图
        // 下标是结点
        List<List<Integer>> edges;
        // 存储每个节点的入度
        // 下标是结点
        int[] indeg;
        // 存储答案
        int[] result;
        // 答案下标
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<>());
            }
            indeg = new int[numCourses];
            result = new int[numCourses];
            index = 0;
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
                //统计入度
                ++indeg[info[0]];
            }

            // 队列只保存入度为 0的结点
            Queue<Integer> queue = new LinkedList<>();
            // 将所有入度为 0 的节点放入队列中
            for (int i = 0; i < numCourses; ++i) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                // 从队首取出一个节点
                int u = queue.poll();
                // 放入答案中
                result[index++] = u;
                //u的邻接结点
                for (int v : edges.get(u)) {
                    // 删除u.u的邻接结点的入度都-1.
                    --indeg[v];
                    // 如果相邻节点 v 的入度为 0，就可以选 v 对应的课程了
                    if (indeg[v] == 0) {
                        queue.offer(v);
                    }
                }
            }

            // 图中包含环
            if (index != numCourses) {
                return new int[0];
            }
            return result;
        }
    }

    class Solution4 {
        int[] flag;//课程i=0表示尚未访问，=1表示此次dfs已经访问，=-1表示之前的dfs已访问
        int[] path;//学习路线
        int index;//path下一个节点的位置

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            flag = new int[numCourses];
            path = new int[numCourses];
            index = numCourses - 1;
            //邻接表 读入数据
            List<List<Integer>> graph = new ArrayList<>(numCourses);
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] cp : prerequisites) {
                graph.get(cp[1]).add(cp[0]);
            }
            //每个节点开始dfs 返回是否有环
            for (int i = 0; i < numCourses; i++) {
                if (hasCircle(i, graph)) {
                    return new int[0];
                }
            }
            return path;
        }

        /**
         * 厉害
         * <p>
         * 通过返回值控制是否有环
         *
         * @param course
         * @param graph
         * @return
         */
        public boolean hasCircle(int course, List<List<Integer>> graph) {
            if (flag[course] == 1) {
                return true;
            }
            if (flag[course] == -1) {
                return false;
            }

            flag[course] = 1;
            for (int after : graph.get(course)) {
                if (hasCircle(after, graph)) {
                    return true;
                }
            }
            path[index--] = course;
            flag[course] = -1;
            return false;
        }
    }


    /**
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/course-schedule-ii/solution/tuo-bu-pai-xu-shen-du-you-xian-bian-li-python-dai-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @author liwei
     * @date 18/6/24 下午4:10
     */
    class Solution6 {

        /**
         * @param numCourses
         * @param prerequisites
         * @return
         */
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            if (numCourses <= 0) {
                // 连课程数目都没有，就根本没有办法完成练习了，根据题意应该返回空数组
                return new int[0];
            }
            int plen = prerequisites.length;
            if (plen == 0) {
                // 没有有向边，则表示不存在课程依赖，任务一定可以完成
                int[] ret = new int[numCourses];
                for (int i = 0; i < numCourses; i++) {
                    ret[i] = i;
                }
                return ret;
            }
            int[] marked = new int[numCourses];
            // 初始化有向图 begin
            HashSet<Integer>[] graph = new HashSet[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new HashSet<>();
            }
            // 初始化有向图 end
            // 有向图的 key 是前驱结点，value 是后继结点的集合
            for (int[] p : prerequisites) {
                graph[p[1]].add(p[0]);
            }
            // 使用 Stack 或者 List 记录递归的顺序，这里使用 Stack
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < numCourses; i++) {
                if (dfs(i, graph, marked, stack)) {
                    // 注意方法的语义，如果图中存在环，表示课程任务不能完成，应该返回空数组
                    return new int[0];
                }
            }
            // 在遍历的过程中，一直 dfs 都没有遇到已经重复访问的结点，就表示有向图中没有环
            // 所有课程任务可以完成，应该返回 true
            // 下面这个断言一定成立，这是拓扑排序告诉我们的结论
            assert stack.size() == numCourses;
            int[] ret = new int[numCourses];
            // 想想要怎么得到结论，我们的 dfs 是一致将后继结点进行 dfs 的
            // 所以压在栈底的元素，一定是那个没有后继课程的结点
            // 那个没有前驱的课程，一定在栈顶，所以课程学习的顺序就应该是从栈顶到栈底
            // 依次出栈就好了
            for (int i = 0; i < numCourses; i++) {
                ret[i] = stack.pop();
            }
            return ret;
        }

        /**
         * 注意这个 dfs 方法的语义
         *
         * @param i      当前访问的课程结点
         * @param graph
         * @param marked 如果 == 1 表示正在访问中，如果 == 2 表示已经访问完了
         * @return true 表示图中存在环，false 表示访问过了，不用再访问了
         */
        private boolean dfs(int i,
                            HashSet<Integer>[] graph,
                            int[] marked,
                            Stack<Integer> stack) {
            // 如果访问过了，就不用再访问了
            if (marked[i] == 1) {
                // 从正在访问中，到正在访问中，表示遇到了环
                return true;
            }
            if (marked[i] == 2) {
                // 表示在访问的过程中没有遇到环，这个节点访问过了
                return false;
            }
            // 走到这里，是因为初始化呢，此时 marked[i] == 0
            // 表示正在访问中
            marked[i] = 1;
            // 后继结点的集合
            HashSet<Integer> successorNodes = graph[i];
            for (Integer successor : successorNodes) {
                if (dfs(successor, graph, marked, stack)) {
                    // 层层递归返回 true ，表示图中存在环
                    return true;
                }
            }
            // i 的所有后继结点都访问完了，都没有存在环，则这个结点就可以被标记为已经访问结束
            // 状态设置为 2
            marked[i] = 2;
            stack.add(i);
            // false 表示图中不存在环
            return false;
        }
    }

    class Solution7 {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] visited;
        int[] result;
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            for (int[] prerequisite : prerequisites) {
                map.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
            }
            visited = new int[numCourses];
            index = numCourses - 1;
            result = new int[numCourses];

            for (int i = 0; i < numCourses; i++) {
                if (visited[i] == 2) {
                    continue;
                }
                if (dfs(i)) {
                    return new int[0];
                }
            }
            return result;
        }

        private boolean dfs(int i) {
            if (visited[i] == 1) {
                return true;
            }
            if (visited[i] == 2) {
                return false;
            }
            visited[i] = 1;
            if (map.containsKey(i)) {
                for (Integer j : map.get(i)) {
                    if (dfs(j)) {
                        return true;
                    }
                }
            }
            visited[i] = 2;
            result[index--] = i;
            return false;
        }

    }
}
