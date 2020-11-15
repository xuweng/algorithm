package com.leetcode.tag.contest.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 5601. 设计有序流
 */
public class OrderedStream {
    int ptr;
    String[] strings;

    public OrderedStream(int n) {
        ptr = 1;
        strings = new String[n + 1];
    }

    public List<String> insert(int id, String value) {
        strings[id] = value;
        List<String> result = new ArrayList<>();
        while (ptr < strings.length && strings[ptr] != null) {
            result.add(strings[ptr]);
            ptr++;
        }
        return result;
    }
}
