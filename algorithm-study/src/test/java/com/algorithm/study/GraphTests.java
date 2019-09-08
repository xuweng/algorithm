package com.algorithm.study;

import com.algorithm.study.graph.Graph;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GraphTests {
    @Test
    public void createRelationship() {
        Map<String, String[]> relationshipMap = new HashMap<>();

        Graph.createRelationship(relationshipMap, "friend5", 5);

        System.err.println(relationshipMap);
    }
}
