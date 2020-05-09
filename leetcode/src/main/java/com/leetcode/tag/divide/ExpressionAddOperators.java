package com.leetcode.tag.divide;

import java.util.ArrayList;
import java.util.List;

/**
 * 尽管我们定义了运算符的数量，即3个不同的二元运算符，但是操作数的数量并没有很好地为我们定义
 *
 * <p>现在，我们的算法中有4个不同的递归路径，我们必须尝试所有这些路径，看看哪一个会导致潜在的解决方案。
 *
 * <p>如上所述，我们有多种选择，可以选择使用什么运算符，可以选择哪些操作数，因此，我们必须考虑找到所有有效表达式的所有可能性。
 *
 * <p>f(i):这类算法都是固定最后一个数
 *
 * <p>固定第i个数可行?不可行
 *
 * <p>在数字之间添加二元运
 *
 * <p>审题
 *
 * <p>审题.审题.审题
 *
 * <p>防止
 *
 * <p>链表断开
 *
 * <p>282. 给表达式添加运算符
 */
public class ExpressionAddOperators {
  public List<String> addOperators(String num, int target) {
    return divide(num, num.length() - 1, target);
  }

  /**
   * 假设计算出n-1 的target和string
   *
   * <p>需要子问题的解,需要处理子问题的解
   *
   * <p>不需要处理子问题的解
   *
   * <p>需要处理子问题的解
   *
   * <p>小数据规模验证
   *
   * @param num
   * @param n
   * @param target
   * @return
   */
  public List<String> divide(String num, int n, int target) {
    if (n <= 0) {
      return new ArrayList<>();
    }
    if (n <= 1) {
      int j = Integer.parseInt(String.valueOf(num.charAt(n)));
      int i = Integer.parseInt(String.valueOf(num.charAt(n - 1)));

      List<String> list = new ArrayList<>();
      if (i + j == target) {
        list.add(i + "+" + j);
      }
      if (i - j == target) {
        list.add(i + "-" + j);
      }
      if (i * j == target) {
        list.add(i + "*" + j);
      }
      return list;
    }

    // 固定第n个数
    // 第n个数
    int i = Integer.parseInt(String.valueOf(num.charAt(n)));
    if (i == target) {
      // 计算前n-1
      // 前n-1 - i
      List<String> list = divide(num, n - 1, i + target);
      // 处理list
      List<String> list1 = new ArrayList<>();
      for (String s : list) {
        list1.add(s + "-" + i);
      }
      // 前n-1 + i
      List<String> list2 = divide(num, n - 1, target - i);
      List<String> list3 = new ArrayList<>();
      for (String s : list2) {
        list3.add(s + "+" + i);
      }
      list1.addAll(list3);
      return list1;
    } else if (i > target) {
      // 计算前n-1
      // 前n-1 - i
      List<String> list = divide(num, n - 1, i + target);

      // 处理list
      List<String> list1 = new ArrayList<>();
      for (String s : list) {
        list1.add(s + "-" + i);
      }
      return list1;
    } else {
      // 前n-1 + i
      List<String> list1 = divide(num, n - 1, target - i);
      List<String> list2 = new ArrayList<>();
      for (String s : list1) {
        list2.add(s + "+" + i);
      }
      // 前n-1 * i
      if (target % i == 0) {
        List<String> list3 = new ArrayList<>();
        List<String> list4 = divide(num, n - 1, target / i);
        for (String s : list4) {
          list3.add(s + "*" + i);
        }
        list2.addAll(list3);
      }
      return list2;
    }
  }

  /**
   * 作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/expression-add-operators/solution/gei-biao-da-shi-tian-jia-yun-suan-fu-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public ArrayList<String> answer;
    public String digits;
    public long target;

    /**
     * 如果我们只需要考虑那些简单地用数字作为操作数的表达式，那么这个问题就更容易解决了。
     *
     * <p>但是，在这个问题中，我们可以让各种数字组合在一起，形成一个更大的数字，成为表达式的一部分。
     *
     * <p>作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/expression-add-operators/solution/gei-biao-da-shi-tian-jia-yun-suan-fu-by-leetcode/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param index
     * @param previousOperand
     * @param currentOperand
     * @param value
     * @param ops
     */
    public void recurse(
            int index, long previousOperand, long currentOperand, long value, ArrayList<String> ops) {
      String nums = this.digits;

      // Done processing all the digits in num
      if (index == nums.length()) {
        // If the final value == target expected AND
        // no operand is left unprocessed
        if (value == this.target && currentOperand == 0) {
          StringBuilder sb = new StringBuilder();
          ops.subList(1, ops.size()).forEach(sb::append);
          this.answer.add(sb.toString());
        }
        return;
      }

      // Extending the current operand by one digit
      currentOperand = currentOperand * 10 + Character.getNumericValue(nums.charAt(index));
      String currentValRep = Long.toString(currentOperand);
      int length = nums.length();

      // To avoid cases where we have 1 + 05 or 1 * 05 since 05 won't be a
      // valid operand. Hence this check
      if (currentOperand > 0) {
        // NO OP recursion
        recurse(index + 1, previousOperand, currentOperand, value, ops);
      }

      // ADDITION
      ops.add("+");
      ops.add(currentValRep);
      recurse(index + 1, currentOperand, 0, value + currentOperand, ops);
      ops.remove(ops.size() - 1);
      ops.remove(ops.size() - 1);

      if (ops.size() > 0) {

        // SUBTRACTION
        ops.add("-");
        ops.add(currentValRep);
        recurse(index + 1, -currentOperand, 0, value - currentOperand, ops);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);

        // MULTIPLICATION
        ops.add("*");
        ops.add(currentValRep);
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
      this.answer = new ArrayList<String>();
      this.recurse(0, 0, 0, 0, new ArrayList<>());
      return this.answer;
    }
  }
}
