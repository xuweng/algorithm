package com.leetcode.tag.dfs.one;

/**
 * 430. 扁平化多级双向链表
 * <p>
 * 开始递归、结束递归
 * <p>
 * 开始递归:[
 * 结束递归:]
 */
public class Flatten {
    class Solution {
        public Node flatten(Node head) {
            dfs(head);

            return head;
        }

        private Node dfs(Node head) {
            if (head == null) {
                return null;
            }
            Node child = head;
            while (child.next != null) {
                if (child.child != null) {
                    break;
                }
                child = child.next;
            }
            if (child.child == null) {
                return child;
            }
            Node node = dfs(child.child);
            if (child.next != null) {
                node.next = child.next;
                child.next.prev = node;
            }
            child.next = child.child;
            child.child.prev = child;

            Node result = child.child;
            while (result.next != null) {
                result = result.next;
            }
            //注意置为null
            child.child = null;

            return result;
        }
    }

    /**
     * 扁平化的操作也就是对二叉树进行先序遍历（深度优先搜索）
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/solution/bian-ping-hua-duo-ji-shuang-xiang-lian-biao-by-lee/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public Node flatten(Node head) {
            if (head == null) {
                return null;
            }
            // 哑结点
            // pseudo head to ensure the `prev` pointer is never none
            Node pseudoHead = new Node(0, null, head, null);

            flattenDfs(pseudoHead, head);

            // detach the pseudo head from the real head
            pseudoHead.next.prev = null;
            return pseudoHead.next;
        }

        /**
         * return the tail of the flatten list
         * <p>
         * 定义递归函数 flatten_dfs(prev, curr)，它接收两个指针作为函数参数并返回扁平化列表中的尾部指针
         *
         * @param prev prev 指针指向 curr 指向元素的前一个元素
         * @param curr 指针指向我们要扁平化的子列表
         * @return
         */
        public Node flattenDfs(Node prev, Node curr) {
            if (curr == null) {
                return prev;
            }
            curr.prev = prev;
            prev.next = curr;

            // the curr.next would be tempered in the recursive function
            Node tempNext = curr.next;

            // 左子树
            Node tail = flattenDfs(curr, curr.child);
            curr.child = null;

            // 右子树
            // 左子树的结果传给右子树
            return flattenDfs(tail, tempNext);
        }

        class Node {
            public int val;
            public Node prev;
            public Node next;
            public Node child;

            public Node() {
            }

            public Node(int val, Node prev, Node next, Node child) {
                this.val = val;
                this.prev = prev;
                this.next = next;
                this.child = child;
            }
        }
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
