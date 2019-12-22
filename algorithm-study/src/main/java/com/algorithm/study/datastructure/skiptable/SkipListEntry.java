package com.algorithm.study.datastructure.skiptable;

public class SkipListEntry {
    // data
    public String key;
    public Integer value;

    // links
    public SkipListEntry up;
    public SkipListEntry down;
    public SkipListEntry left;
    public SkipListEntry right;

    // special
    public static final String negInf = "-oo";
    public static final String posInf = "+oo";

    // constructor
    public SkipListEntry(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public SkipListEntry(String key, SkipListEntry left, SkipListEntry right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public SkipListEntry(String key, Integer value, SkipListEntry up, SkipListEntry down, SkipListEntry left, SkipListEntry right) {
        this.key = key;
        this.value = value;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }
// methods...
}
