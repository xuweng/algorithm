package com.leetcode.tag.daily.eight;

import java.util.ArrayList;
import java.util.List;

/**
 * 282. 给表达式添加运算符
 */
public class AddOperators {
    /**
     * 回溯
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/expression-add-operators/solution/gei-biao-da-shi-tian-jia-yun-suan-fu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public ArrayList<String> answer;
        public String digits;
        public long target;

        public void recurse(int index, long previousOperand, long currentOperand, long value, ArrayList<String> ops) {
            String nums = this.digits;

            // Done processing all the digits in num
            if (index == nums.length()) {
                // If the final value == target expected AND
                // no operand is left unprocessed
                if (value == this.target && currentOperand == 0) {
                    StringBuilder sb = new StringBuilder();
                    ops.subList(1, ops.size()).forEach(v -> sb.append(v));
                    this.answer.add(sb.toString());
                }
                return;
            }

            // Extending the current operand by one digit
            currentOperand = currentOperand * 10 + Character.getNumericValue(nums.charAt(index));
            String current_val_rep = Long.toString(currentOperand);

            // To avoid cases where we have 1 + 05 or 1 * 05 since 05 won't be a
            // valid operand. Hence this check
            if (currentOperand > 0) {
                // NO OP recursion
                recurse(index + 1, previousOperand, currentOperand, value, ops);
            }

            // +
            // ADDITION
            ops.add("+");
            ops.add(current_val_rep);
            recurse(index + 1, currentOperand, 0, value + currentOperand, ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);

            if (ops.size() > 0) {
                // -
                // SUBTRACTION
                ops.add("-");
                ops.add(current_val_rep);
                recurse(index + 1, -currentOperand, 0, value - currentOperand, ops);
                ops.remove(ops.size() - 1);
                ops.remove(ops.size() - 1);

                // *
                // MULTIPLICATION
                ops.add("*");
                ops.add(current_val_rep);
                recurse(
                        index + 1,
                        currentOperand * previousOperand,
                        0,
                        value - previousOperand + (currentOperand * previousOperand),
                        ops);
                ops.remove(ops.size() - 1);
                ops.remove(ops.size() - 1);
            }
        }

        public List<String> addOperators(String num, int target) {
            if (num.length() == 0) {
                return new ArrayList<>();
            }

            this.target = target;
            this.digits = num;
            this.answer = new ArrayList<>();

            this.recurse(0, 0, 0, 0, new ArrayList<>());

            return this.answer;
        }
    }

}
