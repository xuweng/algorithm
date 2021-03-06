package com.algorithm.study.datastructure;

import com.algorithm.study.datastructure.graph.Graph;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class GraphTests {
    @Test
    public void createRelationshipTest() {
        Map<String, String[]> relationshipMap = new HashMap<>();

        Graph.createRelationship(relationshipMap, "friend5", 5, 5);

        System.err.println(relationshipMap);
    }

    @Test
    public void breadthFirstSearchTest() {
        String startName = "friend5";
        Map<String, String[]> relationshipMap = new HashMap<>();
        Graph.createRelationship(relationshipMap, startName, 5, 5);

        boolean search1 = Graph.breadthFirstSearch(relationshipMap, startName, "friend53");
        boolean search2 = Graph.breadthFirstSearch(relationshipMap, startName, "friend61");
        assertTrue(search1);
        assertFalse(search2);
    }
}
