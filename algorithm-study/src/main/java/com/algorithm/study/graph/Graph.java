package com.algorithm.study.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 图算法
 * 散列表是一对一映射,图是一对多映射
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
     * graph["longGe"] = ["friend1", "friend2", "friend3"]
     * graph["friend1"] = ["friend11", "friend12", "friend13"]
     * graph["friend2"] = ["friend21", "friend22", "friend23"]
     * graph["friend3"] = ["friend31", "friend32", "friend33"]
     *
     * @return
     */
    public static Map<String, String[]> createRelationship() {
        Map<String, String[]> map = new HashMap<>();

        String longGe = "longGe";
        String[] longGeFriends = {"friend1", "friend2", "friend3"};
        map.put(longGe, longGeFriends);

        String friend1 = "friend1";
        String[] friend1Friends = {"friend11", "friend12", "friend13"};
        map.put(friend1, friend1Friends);

        String friend2 = "friend2";
        String[] friend2Friends = {"friend21", "friend22", "friend23"};
        map.put(friend2, friend2Friends);

        String friend3 = "friend3";
        String[] friend3Friends = {"friend31", "friend32", "friend33"};
        map.put(friend3, friend3Friends);
        return map;
    }
}
