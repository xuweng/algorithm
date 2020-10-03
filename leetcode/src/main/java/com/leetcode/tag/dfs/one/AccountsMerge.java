package com.leetcode.tag.dfs.one;

import java.util.*;

/**
 * 721. 账户合并
 */
public class AccountsMerge {
    /**
     * 方法一：深度优先搜索
     * <p>
     * 问题归结为寻找图的连接组件
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/accounts-merge/solution/zhang-hu-he-bing-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            //记录一张从电子邮件到名字的哈希表
            Map<String, String> emailToName = new HashMap<>();
            //无向图.两个方向.
            Map<String, ArrayList<String>> graph = new HashMap<>();
            for (List<String> account : accounts) {
                String name = "";
                for (String email : account) {
                    if (Objects.equals(name, "")) {
                        //第一个是name.
                        name = email;
                        continue;
                    }
                    //这个函数厉害
                    //无向图
                    graph.computeIfAbsent(email, x -> new ArrayList<>()).add(account.get(1));
                    graph.computeIfAbsent(account.get(1), x -> new ArrayList<>()).add(email);
                    emailToName.put(email, name);
                }
            }

            Set<String> seen = new HashSet<>();
            List<List<String>> ans = new ArrayList<>();
            for (String email : graph.keySet()) {
                if (!seen.contains(email)) {
                    seen.add(email);
                    Stack<String> stack = new Stack<>();
                    stack.push(email);
                    List<String> component = new ArrayList<>();
                    while (!stack.empty()) {
                        String node = stack.pop();
                        component.add(node);
                        for (String nei : graph.get(node)) {
                            if (!seen.contains(nei)) {
                                seen.add(nei);
                                stack.push(nei);
                            }
                        }
                    }
                    Collections.sort(component);
                    component.add(0, emailToName.get(email));
                    ans.add(component);
                }
            }
            return ans;
        }
    }

    /**
     * uf
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/accounts-merge/solution/zhang-hu-he-bing-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            DSU dsu = new DSU();
            Map<String, String> emailToName = new HashMap<>();
            Map<String, Integer> emailtoid = new HashMap<>();
            int id = 0;
            for (List<String> account : accounts) {
                String name = "";
                for (String email : account) {
                    if (Objects.equals(name, "")) {
                        name = email;
                        continue;
                    }
                    emailToName.put(email, name);
                    if (!emailtoid.containsKey(email)) {
                        emailtoid.put(email, id++);
                    }
                    dsu.union(emailtoid.get(account.get(1)), emailtoid.get(email));
                }
            }

            Map<Integer, List<String>> ans = new HashMap<>();
            for (String email : emailToName.keySet()) {
                int index = dsu.find(emailtoid.get(email));
                ans.computeIfAbsent(index, x -> new ArrayList<>()).add(email);
            }
            for (List<String> component : ans.values()) {
                Collections.sort(component);
                component.add(0, emailToName.get(component.get(0)));
            }
            return new ArrayList<>(ans.values());
        }
    }

    class DSU {
        int[] parent;

        public DSU() {
            parent = new int[10001];
            for (int i = 0; i <= 10000; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

}
