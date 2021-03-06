package com.algorithm.study.datastructure.graph;

import java.util.*;

/**
 * 学习课本中的知识不算难。学习已经存在的知识不算难，学习没有存在的东西才难。生活中的场景抽象成数据结构和算法才难。
 * 学习的目标就是运用。学以致用。数据结构与算法运用到生活中。
 * <p>
 * 图算法
 * 散列表是一对一映射,图是一对多映射
 *
 * @author hh
 */
public class Graph {
    /**
     * 获取亲密度
     * 朋友是一度关系，朋友的朋友是二度关系。
     * 一度关系胜过二度关系，二度关系胜过三度关系，以此类推。因此，你应先在一
     * 度关系中搜索，确定其中没有芒果销售商后，才在二度关系中搜索
     *
     * @return
     */
    public static Integer getIntimacy() {
        return 0;
    }

    /**
     * 广度优先搜索
     * <p>
     * 如果你在你的整个人际关系网中搜索芒果销售商，就意味着你将沿每条边前行（记住，边是
     * 从一个人到另一个人的箭头或连接），因此运行时间至少为O(边数)。
     * 你还使用了一个队列，其中包含要检查的每个人。将一个人添加到队列需要的时间是固定的，
     * 即为O(1)，因此对每个人都这样做需要的总时间为O(人数)。所以，广度优先搜索的运行时间为
     * O(人数 + 边数)，这通常写作O(V + E)，其中V为顶点（vertice）数，E为边数。
     *
     * @param relationshipMap 图结构人际关系
     * @param startName       从startName开始搜索
     * @param searchName      需要搜索的姓名
     * @return
     */
    public static boolean breadthFirstSearch(Map<String, String[]> relationshipMap, String startName, String searchName) {
        Objects.requireNonNull(relationshipMap);
        Objects.requireNonNull(startName);
        Objects.requireNonNull(searchName);
        //列出需要的数据结构
        //已经搜索过的人,用于记录检查过的人
        Set<String> hasSearch = new HashSet<>();
        //待搜索队列
        Queue<String> needSearchQueue = new java.util.LinkedList<>();
        //从startName开始搜索
        if (startName.equals(searchName)) {
            return true;
        }


        needSearchQueue.addAll(new HashSet<>(Arrays.asList(relationshipMap.getOrDefault(startName, new String[]{}))));

        while (!needSearchQueue.isEmpty()) {
            String currentName = needSearchQueue.poll();

            if (!hasSearch.contains(currentName)) {//仅当这个人没检查过时才检查
                if (currentName.equals(searchName)) {
                    return true;
                } else {
                    needSearchQueue.addAll(new HashSet<>(Arrays.asList(relationshipMap.getOrDefault(currentName, new String[]{}))));
                    hasSearch.add(currentName);//将这个人标记为检查过
                }
            }
        }

        return false;
    }

    /**
     * 创建人际关系
     * 第level与第(level-1)之间的关系
     *
     * @param relationshipMap
     * @param startName       从startName开始搜索
     * @param level           层次,第几层
     * @param number          朋友数量
     */
    public static void createRelationship(Map<String, String[]> relationshipMap, String startName, Integer level, Integer number) {
        if (level < 1) {
            return;
        }
        String[] friendFriends = new String[number];
        for (int i = 1; i <= number; i++) {
            String friend = "friend" + level + i;
            friendFriends[i - 1] = friend;
        }
        relationshipMap.put(startName, friendFriends);

        for (String friendName : friendFriends) {
            createRelationship(relationshipMap, friendName, level - 1, number);
        }
    }
}
