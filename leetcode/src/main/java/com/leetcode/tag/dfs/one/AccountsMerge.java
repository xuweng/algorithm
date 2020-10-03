package com.leetcode.tag.dfs.one;

import java.util.*;

/**
 * 721. 账户合并
 */
public class AccountsMerge {
    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/accounts-merge/solution/zhang-hu-he-bing-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, String> emailToName = new HashMap<>();
            Map<String, ArrayList<String>> graph = new HashMap<>();
            for (List<String> account : accounts) {
                String name = "";
                for (String email : account) {
                    if (Objects.equals(name, "")) {
                        name = email;
                        continue;
                    }
                    graph.computeIfAbsent(email, x -> new ArrayList<String>()).add(account.get(1));
                    graph.computeIfAbsent(account.get(1), x -> new ArrayList<String>()).add(email);
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
}
