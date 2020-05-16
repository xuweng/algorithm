package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归考虑当前层
 *
 * <p>只能测试才能发现问题
 *
 * <p>推导,问题转换 只能测试发现问题
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
    ListNode result = head;
    ListNode node = head;
    List<ListNode[]> listNodeList = new ArrayList<>();
    while (node != null) {
      ListNode tail = node;
      for (int i = 0; i < k - 1 && tail != null; i++) {
        tail = tail.next;
      }
      if (node == head) {
        result = tail;
      }
      if (tail == null) {
        break;
      }
      ListNode[] listNodes = new ListNode[2];
      listNodes[0] = node;
      listNodes[1] = tail;
      listNodeList.add(listNodes);
      // 记录next
      ListNode nodeNext = tail.next;
      re(node, tail).next = null;
      node = nodeNext;
    }
    for (int i = 0; i < listNodeList.size() - 1; i++) {
      listNodeList.get(i)[0].next = listNodeList.get(i + 1)[1];
    }
    listNodeList.get(listNodeList.size() - 1)[0].next = node;

    return result;
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
