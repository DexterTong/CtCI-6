package com.dexter.tong.chapter04;

import com.dexter.tong.common.Graph;
import com.dexter.tong.common.GraphNode;

import java.util.LinkedList;
import java.util.List;

public class Question01 {

    /**
     * 4.1
     * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
     */
    public static LinkedList<GraphNode<Character>> findPath(Graph<Character> graph, GraphNode<Character> nodeA, GraphNode<Character> nodeB) {
        LinkedList<GraphNode<Character>> path = findPathDirected(graph, nodeA, nodeB);
        if(path != null)
            return path;
        return findPathDirected(graph, nodeB, nodeA);
    }

    private static LinkedList<GraphNode<Character>> findPathDirected(Graph<Character> graph, GraphNode<Character> start, GraphNode<Character> target) {
        // Where nodeA, nodeB are nodes in the graph and a path from nodeA to nodeB or nodeB to nodeA is acceptable
        LinkedList<GraphNode<Character>> queue = new LinkedList<>();

        start.visited = true;
        queue.add(start);
        while(!queue.isEmpty()) {
            GraphNode<Character> current = queue.remove();
            if(current == target)
                return tracePath(current);
            for(GraphNode<Character> child : current.children) {
                if(!child.visited) {
                    child.visited = true;
                    child.visitedFrom = current;
                    queue.add(child);
                }
            }
        }
        return null;
    }

    public static LinkedList<GraphNode<Character>> tracePath(GraphNode<Character> dest) {
        LinkedList<GraphNode<Character>> stack = new LinkedList<>();
        GraphNode<Character> current = dest;
        while(current != null) {
            stack.push(current);
            current = current.visitedFrom;
        }
        return stack;
    }
}
