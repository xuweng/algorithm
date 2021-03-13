package com.leetcode.tag.daily.eight;

import java.util.HashSet;
import java.util.Set;

/**
 * 705. 设计哈希集合
 */
public class MyHashSet {
    Set<Integer> set;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        set = new HashSet<>();
    }

    public void add(int key) {
        set.add(key);
    }

    public void remove(int key) {
        set.remove(key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return set.contains(key);
    }
}
