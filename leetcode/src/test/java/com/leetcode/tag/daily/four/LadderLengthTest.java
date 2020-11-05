package com.leetcode.tag.daily.four;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LadderLengthTest {
    LadderLength.Solution solution = new LadderLength.Solution();

    @Test
    public void ladderLength() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        solution.ladderLength(beginWord, endWord, wordList);
    }
}