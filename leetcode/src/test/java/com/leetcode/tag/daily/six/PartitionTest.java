package com.leetcode.tag.daily.six;

import org.junit.jupiter.api.Test;

class PartitionTest {
    Partition.Solution solution = new Partition.Solution();

    @Test
    void Test() {
        Partition.ListNode head = new Partition.ListNode(1);
        Partition.ListNode listNode = new Partition.ListNode(4);
        Partition.ListNode listNode1 = new Partition.ListNode(3);
        Partition.ListNode listNode2 = new Partition.ListNode(2);
        Partition.ListNode listNode3 = new Partition.ListNode(5);
        Partition.ListNode listNode4 = new Partition.ListNode(2);

        head.next = listNode;
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        int x = 3;
        solution.partition(head, x);
    }
}