package com.leetcode.tag.tree.six;

import java.util.*;

/**
 * 1600. 皇位继承顺序
 * <p>
 * 阅读理解题
 * <p>
 * 作者：jin-ai-yi
 * 链接：https://leetcode-cn.com/problems/throne-inheritance/solution/wo-tao-yan-zuo-yue-du-li-jie-ti-by-jin-ai-yi/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ThroneInheritance {
    //父节点-孩子节点链表
    HashMap<String, List<String>> hashMap = new HashMap<>();
    /**
     * 用哈希表表示多叉树
     */
    Set<String> setDead = new HashSet<>();
    String kingName;

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        hashMap.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        if (hashMap.containsKey(parentName)) {
            hashMap.get(parentName).add(childName);
        } else {
            List<String> temp = new ArrayList<>();
            temp.add(childName);
            hashMap.put(parentName, temp);
        }
    }

    public void death(String name) {
        setDead.add(name);
    }

    public List<String> getInheritanceOrder() {
        //类似先序遍历多叉树的方式遍历HashMap
        ArrayList<String> res = new ArrayList<>();
        if (!setDead.contains(kingName)) {
            res.add(kingName);
        }
        dfs(kingName, res);
        return res;
    }

    private void dfs(String name, List<String> res) {
        if (!hashMap.containsKey(name)) {
            return;
        }
        List<String> childs = hashMap.get(name);
        for (String c : childs) {
            if (!setDead.contains(c)) {
                res.add(c);
            }
            dfs(c, res);
        }

    }
}

