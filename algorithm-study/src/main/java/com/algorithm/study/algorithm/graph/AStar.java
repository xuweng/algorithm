package com.algorithm.study.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * https://blog.csdn.net/v_JULY_v/article/details/6093380
 * <p>
 * A*搜寻算法
 * A*搜寻算法，俗称A星算法，作为启发式搜索算法中的一种，这是一种在图形平面上，有多个节点的路径，求出最低通过成本的算法。
 * 常用于游戏中的NPC的移动计算，或线上游戏的BOT的移动计算上。该算法像Dijkstra算法一样，可以找到一条最短路径；
 * 也像BFS一样，进行启发式的搜索。
 * <p>
 * A*算法最为核心的部分，就在于它的一个估值函数的设计上：
 * f(n)=g(n)+h(n)
 * <p>
 *     其中f(n)是每个可能试探点的估值，它有两部分组成：
 *     一部分，为g(n)，它表示从起始搜索点到当前点的代价（通常用某结点在搜索树中的深度来表示）。
 *     另一部分，即h(n)，它表示启发式搜索中最为重要的一部分，即当前结点到目标结点的估值，
 *     h(n)设计的好坏，直接影响着具有此种启发式函数的启发式算法的是否能称为A*算法。
 * <p>
 * 而所有“已探知的但未搜索过点”可以通过一个按f值升序的队列(即优先队列)进行排列。
 * 这样，在整体的搜索过程中，只要按照类似广度优先的算法框架，从优先队列中弹出队首元素（f值），
 * 对其可能子结点计算g、h和f值，直到优先队列为空(无解)或找到终止点为止。
 * <p>
 * A*算法与广度、深度优先和Dijkstra 算法的联系就在于：当g(n)=0时，该算法类似于DFS，
 * 当h(n)=0时，该算法类似于BFS。且同时，如果h(n)为0，只需求出g(n)，即求出起点到任意顶点n的最短路径，
 * 则转化为单源最短路径问题，即Dijkstra算法。
 * 这一点，可以通过上面的A*搜索树的具体过程中将h(n)设为0或将g(n)设为0而得到。 
 * https://blog.csdn.net/u010758410/article/details/82426672
 */
public class AStar {

    public static final int[][] maps = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    // 四个方向
    public static final int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static final int step = 10;

    private ArrayList<Node> openList = new ArrayList<Node>();
    private ArrayList<Node> closeList = new ArrayList<Node>();

    /**
     * 查找最小的F值。
     * 用小顶堆实现。
     *
     * @return
     */
    public Node findMinFNodeInOpneList() {
        Node tempNode = openList.get(0);
        for (Node node : openList) {
            if (node.F < tempNode.F) {
                tempNode = node;
            }
        }
        return tempNode;
    }

    /**
     * 当前结点的所有邻接结点
     *
     * @param currentNode
     * @return
     */
    public ArrayList<Node> findNeighborNodes(Node currentNode) {
        ArrayList<Node> arrayList = new ArrayList<Node>();
        // 只考虑上下左右，不考虑斜对角
        for (int i = 0; i < 4; i++) {
            int newX = currentNode.x + direct[i][0];
            int newY = currentNode.y + direct[i][1];
            // 如果当前节点的相邻节点，可达（不是障碍位置） 且 不在闭合链表
            if (canReach(newX, newY) && !exists(openList, newX, newY)) {
                arrayList.add(new Node(newX, newY));
            }
        }

        return arrayList;
    }

    public boolean canReach(int x, int y) {
        if (x >= 0 && x < maps.length && y >= 0 && y < maps[0].length) {
            return maps[x][y] == 0;
        }
        return false;
    }

    public Node findPath(Node startNode, Node endNode) {
        // 把起点加入 open list
        openList.add(startNode);

        while (!openList.isEmpty()) {
            // 遍历 open list ，查找 F值最小的节点，把它作为当前要处理的节点
            Node currentNode = findMinFNodeInOpneList();
            // 从open list中移除
            openList.remove(currentNode);
            // 把这个节点移到 close list
            closeList.add(currentNode);

            ArrayList<Node> neighborNodes = findNeighborNodes(currentNode);
            for (Node node : neighborNodes) {
                //当前节点的相邻界节点已经在开放链表中
                if (exists(openList, node)) {
                    foundPoint(currentNode, node);
                } else {
                    notFoundPoint(currentNode, endNode, node);
                }
            }
            //终点在开放链表中，则找到路径
            if (find(openList, endNode) != null) {
                return find(openList, endNode);
            }
        }

        return find(openList, endNode);
    }

    private void foundPoint(Node tempStart, Node node) {
        int G = calcG(tempStart, node);
        //途径当前节点tempStart到达该节点node的距离G更小时，更新F
        if (G < node.G) {
            node.parent = tempStart;
            node.G = G;
            node.calcF();
        }
    }

    private void notFoundPoint(Node tempStart, Node end, Node node) {
        node.parent = tempStart;
        node.G = calcG(tempStart, node);
        node.H = calcH(end, node);
        node.calcF();
        openList.add(node);
    }

    /**
     * 计算G
     *
     * @param start
     * @param node
     * @return
     */
    private int calcG(Node start, Node node) {
        int G = step;
        int parentG = node.parent != null ? node.parent.G : 0;
        return G + parentG;
    }

    /**
     * 计算H
     *
     * @param node
     * @param end
     * @return
     */
    private int calcH(Node node, Node end) {
        int step = Math.abs(node.x - end.x) + Math.abs(node.y - end.y);
        return step * step;
    }

    public static void main(String[] args) {
        //定点:起点终点
        Node startNode = new Node(5, 1);
        Node endNode = new Node(2, 4);
        //尝试寻找最短路径
        Node parent = new AStar().findPath(startNode, endNode);

        printMap(maps);

        ArrayList<Node> arrayList = parent != null ? getPaths(parent) : null;

        printPaths(arrayList);

    }

    private static void printMap(int[][] maps) {

        for (int i = 0; i < maps[0].length; i++) {
            System.out.print("\t" + i + ",");
        }
        System.out.print("\n-----------------------------------------\n");
        int count = 0;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                if (j == 0)
                    System.out.print(count++ + "|\t");
                System.out.print(maps[i][j] + ",\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    //从终点开始沿着路径退回起点
    private static ArrayList<Node> getPaths(Node endNode) {
        ArrayList<Node> arrayList = new ArrayList<Node>();
        Node pre = endNode;
        while (pre != null) {
            arrayList.add(new Node(pre.x, pre.y));
            pre = pre.parent;
        }
        return arrayList;
    }

    public static void printPaths(ArrayList<Node> arrayList) {
        // 地图形式
        for (int i = 0; i < maps[0].length; i++) {
            System.out.print("\t" + i + ",");
        }
        System.out.print("\n-----------------------------------------\n");
        int count = 0;

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                if (j == 0)
                    System.out.print(count++ + "|\t");
                if (exists(arrayList, i, j)) {
                    System.out.print("@,\t");
                } else {
                    System.out.print(maps[i][j] + ",\t");
                }

            }
            System.out.println();
        }
        System.out.println();
        // 路径形式
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (i == 0)
                System.out.print(arrayList.get(i));
            else
                System.out.print(arrayList.get(i) + "->");
        }
        System.out.println();
    }

    public static Node find(List<Node> maps, Node point) {
        for (Node n : maps)
            if ((n.x == point.x) && (n.y == point.y)) {
                return n;
            }
        return null;
    }

    public static boolean exists(List<Node> maps, Node node) {
        for (Node n : maps) {
            if ((n.x == node.x) && (n.y == node.y)) {
                return true;
            }
        }
        return false;
    }

    public static boolean exists(List<Node> maps, int x, int y) {
        for (Node n : maps) {
            if ((n.x == x) && (n.y == y)) {
                return true;
            }
        }
        return false;
    }


}

/**
 * 定义数据结构。
 * 学习定义数据结构。
 */
class Node {
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //坐标
    //横坐标
    public int x;
    //纵坐标
    public int y;

    public int F;
    public int G;
    public int H;

    /**
     * 计算F
     */
    public void calcF() {
        this.F = this.G + this.H;
    }

    public Node parent;

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

