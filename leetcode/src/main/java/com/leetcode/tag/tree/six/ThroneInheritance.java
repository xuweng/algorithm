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
        List<String> list = hashMap.getOrDefault(parentName, new ArrayList<>());
        list.add(childName);
        hashMap.put(parentName, list);
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
        List<String> childes = hashMap.get(name);
        for (String c : childes) {
            if (!setDead.contains(c)) {
                res.add(c);
            }
            dfs(c, res);
        }

    }

    class ThroneInheritance1 {
        /**
         * 自定义数据结构
         */
        class Node {
            String name;
            Node left;
            Node right;
            boolean isAlive;

            public Node(String name) {
                this.name = name;
                isAlive = true;
                left = null;
                right = null;
            }
        }

        Node root;
        Map<String, Node> map;
        List<String> inherit;

        public ThroneInheritance1(String kingName) {
            root = new Node(kingName);
            map = new HashMap<>();
            map.put(kingName, root);
        }

        public void birth(String parentName, String childName) {
            Node parentNode = map.get(parentName);
            Node childNode = new Node(childName);
            map.put(childName, childNode);
            if (parentNode.left == null) {
                parentNode.left = childNode;
            } else {
                Node tmp = parentNode.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = childNode;
            }
        }

        public void death(String name) {
            map.get(name).isAlive = false;
        }

        public List<String> getInheritanceOrder() {
            inherit = new ArrayList<>();
            preOrder(root);
            return inherit;
        }

        private void preOrder(Node root) {
            if (root == null) {
                return;
            }
            if (root.isAlive) {
                inherit.add(root.name);
            }
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}

