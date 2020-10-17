package com.leetcode.tag.dfs.two;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 690. 员工的重要性
 */
public class GetImportance {
    class Solution {
        public int getImportance(List<Employee> employees, int id) {
            Employee e = employees.stream().filter(employee -> employee.id == id).findFirst().orElse(null);
            if (e.subordinates.isEmpty()) {
                return e.importance;
            }
            int result = e.importance;
            for (Integer subordinate : e.subordinates) {
                result += getImportance(employees, subordinate);
            }
            return result;
        }
    }

    /**
     * 方法一：深度优先搜索DFS
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/employee-importance/solution/yuan-gong-de-zhong-yao-xing-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        Map<Integer, Employee> map;

        public int getImportance(List<Employee> employees, int queryid) {
            map = new HashMap<>();
            for (Employee e : employees) {
                map.put(e.id, e);
            }
            return dfs(queryid);
        }

        public int dfs(int eid) {
            Employee employee = map.get(eid);
            int ans = employee.importance;
            for (Integer subid : employee.subordinates) {
                ans += dfs(subid);
            }
            return ans;
        }
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
