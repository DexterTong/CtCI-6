package com.dexter.tong.common;

public class BSTNode<T> {
    public T data;
    public BSTNode<T> left;
    public BSTNode<T> right;

    public BSTNode(T data) {
        this.data = data;
    }

    public String toString() {
        return data.toString();
    }
}
