package com.leetcode.tag.daily.seven;

import java.util.*;

/**
 * 721. 账户合并
 * <p>
 * 方法一：哈希表 + 并查集
 */
public class AccountsMerge {
    class Solution {
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
