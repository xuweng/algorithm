package com.leetcode.tag.tree.four;

import org.junit.Test;

public class ConnectTest {
    Connect.Solution solution = new Connect.Solution();

    @Test
    public void connectTest() {
        Connect.Node node1 = new Connect.Node(1);
        Connect.Node node2 = new Connect.Node(2);
        Connect.Node node3 = new Connect.Node(3);
        Connect.Node node4 = new Connect.Node(4);
        Connect.Node node5 = new Connect.Node(5);
        Connect.Node node6 = new Connect.Node(6);
        Connect.Node node7 = new Connect.Node(7);
        Connect.Node node8 = new Connect.Node(8);
        Connect.Node node9 = new Connect.Node(9);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;

        node7.left = node9;

        solution.connect(node1);

        System.out.println(node1);
    }
}