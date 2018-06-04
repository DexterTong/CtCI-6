package com.dexter.tong.common;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class GraphNode<T> {
    public T data;
    public ArrayList<GraphNode<T>> children;
    public boolean visited;
    public GraphNode<T> visitedFrom;

    public GraphNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
        this.visited = false;
        this.visitedFrom = null;
    }

    public String toString() {
        return this.data.toString();
    }

    // This looks... very ugly
    // All I wanted to do was compare GraphNodes by data value only
    public boolean equals(Object o) {
        Class c = o.getClass();
        Field f;
        if(!c.equals(this.getClass()))
            return false;
        try {
            f = c.getField("data");
        } catch(NoSuchFieldException e) {
            return false;
        }
        try {
            return data.equals(f.get(o));
        } catch(IllegalAccessException e) {
            return false;
        }
    }
}
