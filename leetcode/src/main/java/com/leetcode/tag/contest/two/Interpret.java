package com.leetcode.tag.contest.two;

/**
 * 5617. 设计 Goal 解析器
 */
public class Interpret {
    class Solution {
        public String interpret(String command) {
            if (command == null || command.isEmpty()) {
                return command;
            }
            while (command.contains("()")) {
                command = command.replace("()", "o");
            }
            while (command.contains("(al)")) {
                command = command.replace("(al)", "al");
            }

            return command;
        }
    }
}
