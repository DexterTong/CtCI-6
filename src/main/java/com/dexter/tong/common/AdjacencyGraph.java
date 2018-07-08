package com.dexter.tong.common;

import java.util.LinkedList;

public class AdjacencyGraph {
    private int[][] edges;
    private int size;

    //public

    // Implemented through an adjacency matrix
    public class Graph {
        // Read as follows: if edgeMatrix[i][j] != 0, there is an edge from i to j with weight edgeMatrix[i][j]
        private int[][] edgeMatrix;
        private boolean[] visited;
        private int size;

        public Graph(int[][] edges) {
            if(edges.length != edges[0].length)
                throw new IllegalArgumentException("edge matrix must be square");
            this.size = edges.length;
            this.edgeMatrix = new int[size][size];
            for(int i = 0; i < edgeMatrix.length; i++) {
                if(edgeMatrix[i].length != edges[i].length)
                    throw new IllegalArgumentException("edge matrix must be square");
                System.arraycopy(edges[i], 0, edgeMatrix[i], 0, edgeMatrix[i].length);
            }
            this.visited = new boolean[size];
        }

        private void clearVisited() {
            visited = new boolean[size];
        }

        public LinkedList<Integer> DFS(int src, int dest) {
            clearVisited();
            if(src < 0 || src >= size)
                throw new IllegalArgumentException("src node is out of bounds");
            if(dest < 0 || dest >= size)
                throw new IllegalArgumentException("dest node is out of bounds");
            if(visited[src])
                return null;

            visited[src] = true;
            if(src == dest) {
                LinkedList<Integer> path = new LinkedList<>();
                path.add(dest);
                return path;
            }

            for(int j = 0; j < edgeMatrix[src].length; j++) {
                if(edgeMatrix[src][j] != 0) {
                    LinkedList<Integer> path = DFS(j, dest);
                    if(path != null) {
                        path.addFirst(src);
                        return path;
                    }
                    return null;
                }
            }

            return null;
        }
    }



}
