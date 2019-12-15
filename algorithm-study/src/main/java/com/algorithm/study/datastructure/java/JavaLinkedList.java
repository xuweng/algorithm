package com.algorithm.study.datastructure.java;


import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 类库LinkedList
 */
public class JavaLinkedList<E> {
    transient int size = 0;
    /**
     * 被结构修改的次数。
     * 结构修改是指更改大小的修改
     * 此字段供迭代器和列表迭代器实现使用
     */
    protected transient int modCount = 0;

    /**
     * 头结点
     * 初始化null
     * <p>
     * Pointer to first node.
     * Invariant: (first == null && last == null) ||
     * (first.prev == null && first.item != null)
     */
    transient Node<E> first;

    /**
     * 尾结点
     * 初始化null
     * <p>
     * Pointer to last node.
     * Invariant: (first == null && last == null) ||
     * (last.next == null && last.item != null)
     */
    transient Node<E> last;


    /**
     * first一定在last前面
     * <p>
     * 不正常的双链表
     * <p>
     * 从右往左增加结点
     * <---------
     * <p>
     * 将e链接为第一个元素。
     * <p>
     * last不变,first指向新结点
     * <p>
     * Links e as first element.
     */
    private void linkFirst(E e) {
        final Node<E> f = first;
        //prev==null
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
        modCount++;
    }

    /**
     * first一定在last前面
     * <p>
     * 正常的双链表
     * <p>
     * 从左往右增加结点
     * ------------>
     * <p>
     * 将e链接为最后一个元素。
     * <p>
     * first不变,last指向新结点
     * <p>
     * Links e as last element.
     */
    void linkLast(E e) {
        final Node<E> l = last;
        //next==null
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    /**
     * 在非null节点succ之前插入元素e。
     * <p>
     * Inserts element e before non-null Node succ.
     */
    void linkBefore(E e, Node<E> succ) {
        // assert succ != null;
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
        modCount++;
    }

    /**
     * 删除f和f之前的结点
     * <p>
     * Unlinks non-null first node f.
     */
    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        modCount++;
        return element;
    }

    /**
     * 删除l和l之后的结点
     * <p>
     * Unlinks non-null last node l.
     */
    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;
        modCount++;
        return element;
    }

    /**
     * 删除x
     * <p>
     * Unlinks non-null node x.
     */
    E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }

    /**
     * 双端队列使用
     * <p>
     * 检索但不删除此双端队列的第一个元素。
     * <p>
     * 获取第一个元素
     *
     * @return
     */
    public E getFirst() {
        final Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.item;
    }

    /**
     * 双端队列使用
     * <p>
     * 检索但不删除此双端队列的最后一个元素。
     * <p>
     * 获取最后一个元素
     *
     * @return
     */
    public E getLast() {
        final Node<E> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.item;
    }

    /**
     * first和last在两端
     * <p>
     * 删除first
     * <p>
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return unlinkFirst(f);
    }

    /**
     * first和last在两端
     * <p>
     * 删除last
     * <p>
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public E removeLast() {
        final Node<E> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return unlinkLast(l);
    }

    /**
     * 双链表
     *
     * @param <E>
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

}
