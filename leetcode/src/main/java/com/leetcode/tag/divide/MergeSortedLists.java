package com.leetcode.tag.divide;

import java.util.PriorityQueue;

/**
 * 标准分治
 *
 * <p>标准分治
 *
 * <p>标准分治
 *
 * <p>标准分治
 *
 * <p>23. 合并K个排序链表
 */
public class MergeSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    if (lists.length == 1) {
      return lists[0];
    }

    return divide(lists, 0, lists.length - 1);
  }

  /**
   * 合并low 到high链表
   *
   * @param listNodes
   * @param low
   * @param high
   * @return
   */
  public ListNode divide(ListNode[] listNodes, int low, int high) {
    if (low >= high) {
      return listNodes[low];
    }
    int mid = low + (high - low) / 2;

    ListNode left = divide(listNodes, low, mid);
    ListNode right = divide(listNodes, mid + 1, high);

    return mergeTwo(left, right);
  }

  public ListNode mergeTwo(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    if (l1.val <= l2.val) {
      l1.next = mergeTwo(l1.next, l2);
    } else {
      l2.next = mergeTwo(l1, l2.next);
    }

    return (l1.val <= l2.val) ? l1 : l2;
  }

  /**
   * 优先级队列
   *
   * <p>时间复杂度：O(n*log(k))，n 是所有链表中元素的总和，k 是链表个数。
   *
   * <p>作者：powcai
   * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/leetcode-23-he-bing-kge-pai-xu-lian-biao-by-powcai/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    /**
     * 纵向看lists
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
        return null;
      }
      // 优先队列
      // 最小堆
      PriorityQueue<ListNode> queue =
              new PriorityQueue<>(
                      lists.length,
                      (o1, o2) -> {
                        if (o1.val < o2.val) {
                          return -1;
                        } else if (o1.val == o2.val) {
                          return 0;
                        } else {
                          return 1;
                        }
                      });

      for (ListNode node : lists) {
        if (node != null) {
          queue.add(node);
        }
      }
      // 最小值并且出队
      // 头结点.一定要新建一个头结点
      ListNode head = new ListNode(0);
      // 尾结点
      ListNode tail = head;
      while (!queue.isEmpty()) {
        // 最小值并且出队
        ListNode node = queue.poll();
        tail.next = node;
        tail = node;
        if (node.next != null) {
          queue.add(node.next);
        }
      }
      return head.next;
    }
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
