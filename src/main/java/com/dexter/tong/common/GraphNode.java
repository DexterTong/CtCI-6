package com.dexter.tong.common;

import java.util.ArrayList;

public class GraphNode<T> {
    public T data;
    public ArrayList<GraphNode<T>> children;

    public GraphNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public String toString() {
        return this.data.toString();
    }
}
