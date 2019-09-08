package com.algorithm.study;

import com.algorithm.study.graph.Graph;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphTests {
    @Test
    public void createRelationshipTest() {
        Map<String, String[]> relationshipMap = new HashMap<>();

        Graph.createRelationship(relationshipMap, "friend5", 5, 5);

        System.err.println(relationshipMap);
    }

    @Test
    public void breadthFirstSearchTest() {
        Map<String, String[]> relationshipMap = new HashMap<>();
        Graph.createRelationship(relationshipMap, "friend5", 5, 5);

        boolean search1 = Graph.breadthFirstSearch(relationshipMap, "friend1", "friend53");
        boolean search2 = Graph.breadthFirstSearch(relationshipMap, "friend1", "friend61");
        assertTrue(search1);
        assertFalse(search2);
    }
}
