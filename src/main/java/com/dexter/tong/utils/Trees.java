package com.dexter.tong.utils;

import com.dexter.tong.common.BSTNode;

import java.util.LinkedList;
import java.util.List;

public class Trees{

    public static <T> List<T> inOrderTraversal(BSTNode<T> node) {
        if(node == null)
            return new LinkedList<>();
        LinkedList<T> values = new LinkedList<>();
        values.addAll(inOrderTraversal(node.left));
        values.add(node.data);
        values.addAll(inOrderTraversal(node.right));
        return values;
    }

    public static <T> List<T> preOrderTraversal(BSTNode<T> node) {
        if(node == null)
            return new LinkedList<>();
        LinkedList<T> values = new LinkedList<>();
        values.add(node.data);
        values.addAll(preOrderTraversal(node.left));
        values.addAll(preOrderTraversal(node.right));
        return values;
    }

    public static <T> List<T> postOrderTraversal(BSTNode<T> node) {
        if(node == null)
            return new LinkedList<>();
        LinkedList<T> values = new LinkedList<>();
        values.addAll(postOrderTraversal(node.left));
        values.addAll(postOrderTraversal(node.right));
        values.add(node.data);
        return values;
    }
}
