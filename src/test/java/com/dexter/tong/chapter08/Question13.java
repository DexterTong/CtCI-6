package com.dexter.tong.chapter08;

import java.util.*;

public class Question13 {
    /**
     * 8.13
     * You have a stack of n boxes, with widths wi, heights hi, and depths di. The boxes
     * cannot be rotated and can only be stacked on top of one another if each box in the stack is strictly
     * larger than the box above it in width, height, and depth. Implement a method to compute the
     * height of the tallest possible stack. The height of a stack is the sum of the heights of each box.
     */
    public int stackHeight(ArrayList<Box> boxes) {
        BoxGraph boxGraph = new BoxGraph(boxes);
        addEdges(boxes, boxGraph);

        LinkedList<BoxNode> roots = boxGraph.getRoots();
        roots.forEach(boxNode -> {
            boxNode.heightOfTallestStack = boxNode.box.height;
            boxNode.boxBelowInTallestStack = null;
            boxNode.visited = true;

        });

        return -1;
    }

    private void addEdges(ArrayList<Box> boxes, BoxGraph boxGraph) {
        for(int i = 0; i < boxes.size(); i++) {
            for(int j = 0; j < boxes.size(); j++) {
                if(boxes.get(i).canBeStackedUnder(boxes.get(j)))
                    boxGraph.addEdge(boxes.get(i), boxes.get(j));
            }
        }
    }

    private class Box {
        private int depth;
        private int width;
        private int height;

        public Box(int depth, int width, int height) {
            this.depth = depth;
            this.width = width;
            this.height = height;
        }

        public boolean canBeStackedUnder(Box top) {
            return depth > top.depth && width > top.width && height > top.height;
        }
    }

    private class BoxGraph {
        private HashMap<Box, BoxNode> nodes;
        private HashMap<BoxNode, LinkedList<Edge>> edges;

        public BoxGraph(Collection<Box> boxes) {
            nodes = new HashMap<>(boxes.size());
            edges = new HashMap<>(boxes.size());

            boxes.forEach(box -> {
                BoxNode boxNode = new BoxNode(box);
                edges.put(boxNode, new LinkedList<>());
                nodes.put(box, boxNode);
            });
        }

        private void addEdge(Box source, Box destination) {
            BoxNode sourceNode = nodes.get(source);
            BoxNode destNode = nodes.get(destination);
            LinkedList<Edge> edgeList = edges.get(sourceNode);
            edgeList.add(new Edge(sourceNode, destNode, destination.height));
        }

        private LinkedList<BoxNode> getRoots() {
            return getRootsOrLeaves(true);
        }

        private LinkedList<BoxNode> getLeaves() {
            return getRootsOrLeaves(false);
        }

        private LinkedList<BoxNode> getRootsOrLeaves(boolean roots) {
            HashMap<BoxNode, Boolean> nodeFlags = new HashMap<>();
            nodes.forEach((box, boxNode) -> nodeFlags.put(boxNode, true));
            if(roots)
                getEdges().forEach(edge -> nodeFlags.put(edge.destination, false));
            else
                getEdges().forEach(edge -> nodeFlags.put(edge.source, false));
            LinkedList<BoxNode> results = new LinkedList<>();
            nodeFlags.forEach((boxNode, flag) -> {
                if(flag)
                    results.add(boxNode);
            });
            return results;
        }

        private LinkedList<Edge> getEdges() {
            LinkedList<Edge> allEdges = new LinkedList<>();
            edges.forEach((boxNode, edgeList) -> allEdges.addAll(edgeList));
            return allEdges;
        }
    }

    private class BoxNode {
        private Box box;
        private boolean visited;
        private int heightOfTallestStack;
        private BoxNode boxBelowInTallestStack;

        public BoxNode(Box box) {
            this.box = box;
        }
    }

    private class Edge {
        private BoxNode source;
        private BoxNode destination;
        private int weight;

        public Edge(BoxNode source, BoxNode destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
}
