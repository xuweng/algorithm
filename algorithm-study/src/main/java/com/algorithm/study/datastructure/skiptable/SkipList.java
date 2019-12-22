package com.algorithm.study.datastructure.skiptable;

import java.util.Objects;
import java.util.Random;

/**
 * 横向单链表+纵向单链表。
 * 先连接横向单链表，再连接纵向单链表。
 * 横向双链表+纵向双链表。
 * 先连接横向双链表，再连接纵向双链表。
 * <p>
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
            //条件写在循环条件里面
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
     * 比较:拿当前比较。拿后一个比较。拿前一个比较。
     * 二分。链表。
     *
     * @param key
     * @return
     */
    public Integer get(String key) {
        SkipListEntry p = findEntry(key);

        if (p.key.equals(key)) {
            return p.value;
        } else {
            return null;
        }
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

    /**
     * 指针太多
     *
     * @param key
     * @param value
     * @return
     */
    public Integer put(String key, Integer value) {
        int i = 0;
        // 查找适合插入的位子
        SkipListEntry p = findEntry(key);
        // 如果跳跃表中存在含有key值的节点，则进行value的修改操作即可完成
        if (p.key.equals(key)) {
            Integer oldValue = p.value;
            p.value = value;
            return oldValue;
        }

        // 如果跳跃表中不存在含有key值的节点，则进行新增操作
        SkipListEntry q = new SkipListEntry(key, value, null, null, p, p.right);
        p.right.left = q;
        p.right = q;
        // 再使用随机数决定是否要向更高level攀升
        //以 0-1 的随机值决定一个数据是否能够攀升到高层次的链表中
        while (r.nextDouble() < 0.5) {
            // 如果新元素的级别已经达到跳跃表的最大高度，则新建空白层
            if (i >= h) {
                addEmptyLevel();
            }

            // 从p向左扫描含有高层节点的节点
            while (p.up == null) {
                p = p.left;
            }
            //p是上层
            p = p.up;

            // 新增和q指针指向的节点含有相同key值的节点对象
            // 这里需要注意的是除底层节点之外的节点对象是不需要value值的
            SkipListEntry z = new SkipListEntry(key, null);

            //先连接横向单链表
            //z与p连接起来
            z.left = p;
            z.right = p.right;
            p.right.left = z;
            p.right = z;

            //再连接纵向单链表
            //z是上层
            //q是本层
            z.down = q;
            q.up = z;

            //继续向上抽取
            q = z;
            i = i + 1;
        }

        n = n + 1;
        // 返回null，没有旧节点的value值
        return null;
    }

    private void addEmptyLevel() {
        SkipListEntry p1 = new SkipListEntry(SkipListEntry.negInf, null);
        SkipListEntry p2 = new SkipListEntry(SkipListEntry.posInf, null);

        p1.right = p2;
        p1.down = head;

        p2.left = p1;
        p2.down = tail;

        head.up = p1;
        tail.up = p2;

        head = p1;
        tail = p2;

        h = h + 1;
    }

    public Integer remove(String key) {
        SkipListEntry p = findEntry(key);
        if (p == null || !Objects.equals(p.key, key)) {
            return null;
        }

        Integer oldValue = p.value;
        while (p != null) {
            p.left.right = p.right;
            p.right.left = p.left;
            p = p.up;
        }

        return oldValue;
    }

    /**
     * 按照区间查找数据
     * 比如查找值在 [100, 356] 之间的数据
     * <p>
     * 高度都是logn。
     * <p>
     * 插入、删除、查找以及迭代输出有序序列这几个操作，红黑树也可以完成，时间复杂度跟跳表是一样的。都是logn。
     * 但是，按照区间来查找数据这个操作，红黑树的效率没有跳表高。
     * <p>
     * 跳表可以做到 O(logn) 的时间复杂度定位区间的起点，然后在原始链表中顺序往后遍历就可以了
     *
     * @param start 开始数据
     * @param end   结束数据
     * @return
     */
    public Integer[] findByQuJian(int start, int end) {
        return null;
    }
}
