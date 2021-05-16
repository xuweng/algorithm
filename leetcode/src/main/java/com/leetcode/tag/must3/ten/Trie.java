package com.leetcode.tag.must3.ten;

/**
 * 208. 实现 Trie (前缀树)
 */
public class Trie {
    Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
        root.isEnd = true;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (p.child[index] == null) {
                p.child[index] = new Node();
            }
            // 遍历
            p = p.child[index];
        }
        // 叶子结点
        p.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (p.child[index] == null) {
                return false;
            }
            // 遍历
            p = p.child[index];
        }
        // 搜索到叶子结点
        return p.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }
        Node p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (p.child[index] == null) {
                return false;
            }
            // 遍历
            p = p.child[index];
        }
        // 不用搜索到叶子结点
        return true;
    }

    class Node {
        boolean isEnd;
        Node[] child = new Node[26];
    }
}
