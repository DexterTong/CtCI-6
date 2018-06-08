package com.dexter.tong.utils;

import com.dexter.tong.common.BinaryTreeNode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Trees{

    public static <T> List<T> inOrderTraversal(BinaryTreeNode<T> node) {
        if(node == null)
            return new LinkedList<>();
        LinkedList<T> values = new LinkedList<>();
        values.addAll(inOrderTraversal(node.left));
        values.add(node.data);
        values.addAll(inOrderTraversal(node.right));
        return values;
    }

    public static <T> List<T> preOrderTraversal(BinaryTreeNode<T> node) {
        if(node == null)
            return new LinkedList<>();
        LinkedList<T> values = new LinkedList<>();
        values.add(node.data);
        values.addAll(preOrderTraversal(node.left));
        values.addAll(preOrderTraversal(node.right));
        return values;
    }

    public static <T> List<T> postOrderTraversal(BinaryTreeNode<T> node) {
        if(node == null)
            return new LinkedList<>();
        LinkedList<T> values = new LinkedList<>();
        values.addAll(postOrderTraversal(node.left));
        values.addAll(postOrderTraversal(node.right));
        values.add(node.data);
        return values;
    }

    public static void insertIntoBST(Integer value, BinaryTreeNode<Integer> root) {
        if (value <= root.data) {
            if (root.left == null)
                root.left = new BinaryTreeNode<>(value);
            else
                insertIntoBST(value, root.left);
        } else {
            if (root.right == null)
                root.right = new BinaryTreeNode<>(value);
            else
                insertIntoBST(value, root.right);
        }
    }

    public static BinaryTreeNode<Integer> initializeBST(Integer[] values) {
        Iterator<Integer> iter = Arrays.stream(values).iterator();
        if(!iter.hasNext())
            return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(iter.next());
        while(iter.hasNext()) {
            insertIntoBST(iter.next(), root);
        }
        return root;
    }
}
