package com.dexter.tong.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph<T> {
    public List<GraphNode<T>> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    /*
    While using a boolean array for the adjacency matrix would be more optimal from a space+time perspective, it is much
    harder to read a 2D array of trues and falses than one of 0s and 1s.
    */
    public Graph(T[] graphNodeValues, Integer[][] adjacencyMatrix) {

        int nodeCount = graphNodeValues.length;
        nodes = new ArrayList<>();

        if(adjacencyMatrix.length != nodeCount) {
            return;
        }
        for(Integer[] col : adjacencyMatrix) {
            if(col.length != nodeCount)
                return;
        }

        for(T value : graphNodeValues) {
            nodes.add(new GraphNode<>(value));
        }

        for(int i = 0; i < adjacencyMatrix.length; i++) {
            GraphNode<T> current = nodes.get(i);
            for(int j = 0; j < adjacencyMatrix[i].length; j++) {
                if(adjacencyMatrix[i][j] != 0)
                    current.children.add(nodes.get(j));
            }
        }
    }

    public void add(GraphNode<T> graphNode) {
        nodes.add(graphNode);
    }

    public GraphNode<T> getByValue(T value) {
        for(GraphNode<T> node : nodes) {
            if(node.data.equals(value))
                return node;
        }
        return null;
    }
}
