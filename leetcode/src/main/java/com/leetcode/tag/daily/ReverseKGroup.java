package com.leetcode.tag.daily;

/**
 * 去掉冗余代码.去掉冗余代码.去掉冗余代码.去掉冗余代码.去掉冗余代码
 *
 * <p>思路清晰更加重要.不用高大尚
 *
 * <p>思路清晰更加重要.思路清晰更加重要.思路清晰更加重要
 *
 * <p>去掉多余循环,在原来的循环里面搞
 *
 * <p>去掉多余循环
 *
 * <p>考察代码基本功.没有复杂算法.
 *
 * <p>本题的目标非常清晰易懂，不涉及复杂的算法，但是实现过程中需要考虑的细节比较多，容易写出冗长的代码。主要考察面试者设计的能力。
 *
 * <p>递归考虑当前层
 *
 * <p>只能测试才能发现问题
 *
 * <p>推导,问题转换
 *
 * <p>只能测试发现问题
 *
 * <p>只能测试才能发现问题
 *
 * <p>25. K 个一组翻转链表
 */
public class ReverseKGroup {
  /**
   * 考虑当前层
   *
   * <p>连接k个断开的链表
   *
   * <p>连接k个断开的链表
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>递归只需要考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * @param head
   * @param k
   * @return
   */
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k <= 0) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    ListNode node = head;
    // 我们新建一个结点，把它接到链表的头部，让它作为 pre 的初始值，这样 head 前面就有了一个结点，我们就可以避开链表头部的边界条件
    ListNode hair = new ListNode(0);
    hair.next = head;
    ListNode pre = hair;
    while (node != null) {
      // 当前结点为node
      ListNode tail = node;
      for (int i = 0; i < k - 1 && tail != null; i++) {
        tail = tail.next;
      }
      if (tail == null) {
        pre.next = node;
        break;
      }
      // 记录next
      ListNode nodeNext = tail.next;
      re(node, tail);
      pre.next = tail;
      pre = node;
      node = nodeNext;
    }

    return hair.next;
  }

  /**
   * 考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * <p>考虑当前层
   *
   * @param head
   * @param tail
   * @return
   */
  public ListNode re(ListNode head, ListNode tail) {
    if (head == tail) {
      return head;
    }

    re(head.next, tail).next = head;
    // 置为null.防止链表出现环
    head.next = null;
    return head;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
