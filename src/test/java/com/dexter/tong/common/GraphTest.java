package com.dexter.tong.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void constructor_should_create_a_graph_using_values_and_adjacency_matrix() {
        Character[] labels = new Character[]{'A', 'B', 'C', 'D', 'E', 'F'};
        Integer[][] adjacencyMatrix = new Integer[][]{
                {0, 1, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0}};
        Graph<Character> graph = new Graph<>(labels, adjacencyMatrix);
        assertEquals(2, graph.nodes.get(0).children.size());
    }

}