package com.dexter.tong.common;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    // Optional fields
    public BinaryTreeNode<T> parent;
    // int array representing the sums of all possible partial or full downward tree traversals ending at this node, see 4.12
    public int[] pathSums;

    public BinaryTreeNode() {
        this(null);
    }

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public String toString() {
        return data.toString();
    }
}
