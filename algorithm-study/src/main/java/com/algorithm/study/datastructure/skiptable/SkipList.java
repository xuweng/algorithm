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
        // 创建一个 -oo 和一个 +oo 对象。这里初始化head和tail两个结点。
        head = new SkipListEntry(SkipListEntry.negInf, null);
        tail = new SkipListEntry(SkipListEntry.posInf, null);

        // 将 -oo 和 +oo 相互连接
        head.right = tail;
        tail.left = head;

        n = 0;
        h = 0;
        r = new Random();
    }

    /**
     * 有序链表。第一个数最小值。
     *
     * @param key
     * @return
     */
    private SkipListEntry findEntry(String key) {
        //head没有数据。pnext才是真正有意义的结点。
        SkipListEntry p = head, pnext = head.right;
        //pnext为空或者pnext这个最小值>key
        if (isEmpty(pnext) || pnext.key.compareTo(key) > 0) {
            return null;
        }

        //key>=pnext这个最小值。
        // 相等时可以不用向右移动，直接走到最底层，找到第一个相等的数。
        // 相等时可以向右移动，找到最后一个相等的数。
        //先执行一次循环体。再判断。
        do {
            // 从左向右查找，直到右节点的key值大于要查找的key值
            //当前指针从p开始找。但是拿p.right比较，就是拿第一个数比较，不能拿head来比较。不是拿p来比较。还是很容易理解。
            //当p没有移动?p=head。
            while (!isEmpty(p.right) && p.right.key.compareTo(key) <= 0) {
                p = p.right;
            }

            // 如果有更低层的节点，则向低层移动
            p = p.down;
        } while (p.down != null);

        // 返回p，！注意这里p的key值是小于等于传入key的值的（p.key <= key）
        return p;
    }

    /**
     * skipListEntry是否空
     * <p>
     * 边界条件
     * 是否最后一个结点
     *
     * @param skipListEntry
     * @return
     */
    private static boolean isEmpty(SkipListEntry skipListEntry) {
        return (skipListEntry != null) && (skipListEntry.key.equals(SkipListEntry.posInf));
    }
}
