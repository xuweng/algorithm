package com.leetcode.tag.dfs.two;

import java.util.List;

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

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
