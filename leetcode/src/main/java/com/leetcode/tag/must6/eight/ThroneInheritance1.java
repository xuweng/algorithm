package com.leetcode.tag.must6.eight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThroneInheritance1 {
    /**
     * 单向链表 & 标记删除
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/throne-inheritance/solution/gong-shui-san-xie-shi-yong-dan-xiang-lia-7t65/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class ThroneInheritance {
        Map<String, Node> map = new HashMap<>();
        Node head = new Node(""), tail = new Node("");

        public ThroneInheritance(String name) {
            Node root = new Node(name);
            root.next = tail;
            head.next = root;
            map.put(name, root);
        }

        public void birth(String pname, String cname) {
            Node node = new Node(cname);
            map.put(cname, node);
            Node p = map.get(pname);
            Node tmp = p;
            while (tmp.last != null) {
                tmp = tmp.last;
            }
            node.next = tmp.next;
            tmp.next = node;
            p.last = node;
        }

        public void death(String name) {
            Node node = map.get(name);
            node.isDeleted = true;
        }

        public List<String> getInheritanceOrder() {
            List<String> ans = new ArrayList<>();
            Node tmp = head.next;
            while (tmp.next != null) {
                if (!tmp.isDeleted) {
                    ans.add(tmp.name);
                }
                tmp = tmp.next;
            }
            return ans;
        }

        class Node {
            String name;
            Node next;
            // 记录最后一个儿子
            Node last;
            boolean isDeleted;

            Node(String name) {
                this.name = name;
            }
        }
    }
}
