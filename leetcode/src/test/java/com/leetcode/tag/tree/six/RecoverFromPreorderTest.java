package com.leetcode.tag.tree.six;

import org.junit.Test;

public class RecoverFromPreorderTest {
    RecoverFromPreorder.Solution solution = new RecoverFromPreorder.Solution();

    @Test
    public void recoverFromPreorderTest() {
        String S = "1-2--3--4-5--6--7";

        RecoverFromPreorder.TreeNode treeNode = solution.recoverFromPreorder(S);

        pre(treeNode);

        System.out.println();
    }

    @Test
    public void recoverFromPreorderTest1() {
        String S = "1-401--349---90--88";

        RecoverFromPreorder.TreeNode treeNode = solution.recoverFromPreorder(S);

        pre(treeNode);

        System.out.println();
    }

    @Test
    public void recoverFromPreorderTest2() {
        String S = "1-2--3---4-5--6---7";

        RecoverFromPreorder.TreeNode treeNode = solution.recoverFromPreorder(S);

        pre(treeNode);

        System.out.println();
    }

    private void pre(RecoverFromPreorder.TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + ",");
        pre(root.left);
        pre(root.right);
    }

}