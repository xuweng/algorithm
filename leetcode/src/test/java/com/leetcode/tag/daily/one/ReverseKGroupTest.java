package com.leetcode.tag.daily.one;

import org.junit.Test;

public class ReverseKGroupTest {
  @Test
  public void reverseKGroupTest() {
    ReverseKGroup reverseKGroup = new ReverseKGroup();
    ReverseKGroup.ListNode node1 = new ReverseKGroup.ListNode(1);
    ReverseKGroup.ListNode node2 = new ReverseKGroup.ListNode(2);
    ReverseKGroup.ListNode node3 = new ReverseKGroup.ListNode(3);
    ReverseKGroup.ListNode node4 = new ReverseKGroup.ListNode(4);
    ReverseKGroup.ListNode node5 = new ReverseKGroup.ListNode(5);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = null;

    int k = 2;

    reverseKGroup.reverseKGroup(node1, k);
  }
}
