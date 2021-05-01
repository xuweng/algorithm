package com.leetcode.tag.must2.five;

import java.util.List;

/**
 * 690. 员工的重要性
 */
public class GetImportance {
    class Solution {
        public int getImportance(List<Employee> employees, int id) {
            int sum = 0;
            for (Employee employee : employees) {
                if (employee.id == id) {
                    sum = employee.importance;
                    List<Integer> subordinates = employee.subordinates;
                    for (Integer subordinate : subordinates) {
                        sum += getImportance(employees, subordinate);
                    }
                    break;
                }
            }

            return sum;
        }
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
