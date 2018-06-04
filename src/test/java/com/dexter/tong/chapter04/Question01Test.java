package com.dexter.tong.chapter04;

import com.dexter.tong.common.Graph;
import com.dexter.tong.common.GraphNode;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Question01Test {

    public Graph<Character> graph;

    @Before
    public void initialize() {
        Character[] nodeNames = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        Integer[][] adjacencyMatrix = new Integer[][]{
              // A  B  C  D  E  F  G  H
                {0, 1, 0, 0, 0, 0, 0, 0}, // A
                {0, 0, 1, 1, 1, 0, 0, 0}, // B
                {0, 1, 0, 0, 0, 0, 0, 1}, // C
                {0, 0, 0, 0, 1, 1, 0, 0}, // D
                {0, 0, 0, 0, 0, 0, 0, 0}, // E
                {0, 0, 0, 1, 0, 0, 0, 0}, // F
                {0, 0, 0, 0, 1, 0, 0, 0}, // G
                {0, 0, 0, 0, 0, 0, 1, 0}  // H
        };
        graph = new Graph<>(nodeNames, adjacencyMatrix);
    }

    @Test
    public void should_find_a_path_when_one_exists() {
        List<GraphNode<Character>> expected = graphNodeListBuilder(new Character[]{'A', 'B', 'C', 'H', 'G'});
        GraphNode<Character> start = graph.getByValue('A');
        GraphNode<Character> end = graph.getByValue('G');
        assertEquals(expected, Question01.findPath(graph, start, end));
    }

    @Test
    public void should_return_void_when_no_path_exists() {
        GraphNode<Character> start = graph.getByValue('E');
        GraphNode<Character> end = graph.getByValue('H');
        assertNull(Question01.findPath(graph, start, end));
    }

    private LinkedList<GraphNode<Character>> graphNodeListBuilder(Character[] values) {
        LinkedList<GraphNode<Character>> graphNodes = new LinkedList<>();
        for(Character value : values) {
            graphNodes.add(new GraphNode<>(value));
        }
        return graphNodes;
    }

    private String GraphNodeListToString(List<GraphNode> nodeList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for(GraphNode node : nodeList) {
            stringBuilder.append(" ");
            stringBuilder.append(node.toString());
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }
}