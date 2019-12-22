package com.algorithm.study.datastructure.skiptable;

import java.util.Random;

/**
 * 写代码。代码模板。看懂是没用的。
 * <p>
 * 跳跃表（SkipList）是一种可以替代平衡树的数据结构。
 * 跳跃表让已排序的数据分布在多层次的链表结构中，
 * 默认是将Key值升序排列的，以 0-1 的随机值决定一个数据是否能够攀升到高层次的链表中。
 * 它通过容许一定的数据冗余，达到 “以空间换时间” 的目的。
 * 跳跃表的效率和AVL相媲美，查找／添加／插入／删除操作都能够在O（LogN）的复杂度内完成。
 */
public class SkipList {

    //对每条链表来说。head<=tail
    //i<=j
    //从最顶层链表开始找。这里的head和tail都是最顶层。
    public SkipListEntry head;    // First element of the top level
    public SkipListEntry tail;    // Last element of the top level

    public int n;        // number of entries in the Skip List
    public int h;        // Height

    //用来决定新添加的节点是否能够向更高一层的链表攀升
    public Random r;    // Coin toss

    public SkipList() {
        //初始化head和tail
        // 创建一个 -oo 和一个 +oo 对象
        head = new SkipListEntry(SkipListEntry.negInf, null);
        tail = new SkipListEntry(SkipListEntry.posInf, null);

        // 将 -oo 和 +oo 相互连接
        head.right = tail;
        tail.left = head;

        n = 0;
        h = 0;
        r = new Random();
    }

    private SkipListEntry findEntry(String key) {
        //head没有数据。pnext才是真正有意义的结点。
        SkipListEntry p = head, pnext = head.right;

        while (true) {
            // 从左向右查找，直到右节点的key值大于要查找的key值
            //当前指针从p开始找。但是拿p.right比较，就是拿第一个数比较，不能拿head来比较。不是拿p来比较。还是很容易理解。
            while (!isLast(p.right) && p.right.key.compareTo(key) <= 0) {
                p = p.right;
            }

            // 如果有更低层的节点，则向低层移动
            if (p.down != null) {
                p = p.down;
            } else {
                break;
            }
        }

        // 返回p，！注意这里p的key值是小于等于传入key的值的（p.key <= key）
        return p;
    }

    /**
     * 边界条件
     * 是否最后一个结点
     *
     * @param skipListEntry
     * @return
     */
    private static boolean isLast(SkipListEntry skipListEntry) {
        return (skipListEntry != null) && (skipListEntry.key.equals(SkipListEntry.posInf));
    }
}
