package com.algorithm.study.graph;

import java.util.Map;

/**
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
     * 创建人际关系
     * 第level与第(level-1)之间的关系
     *
     * @param level 层次,第几层
     */
    public static void createRelationship(Map<String, String[]> relationshipMap, String friend, Integer level) {
        if (level < 1) {
            return;
        }
        String[] friendFriends = {"friend" + level + "1", "friend" + level + "2", "friend" + level + "3"};
        relationshipMap.put(friend, friendFriends);

        createRelationship(relationshipMap, "friend" + (level - 1), level - 1);
    }
}
