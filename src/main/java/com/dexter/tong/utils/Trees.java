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

    public static <T> List<BinaryTreeNode<T>> inOrderNodeTraversal(BinaryTreeNode<T> node) {
        if(node == null)
            return new LinkedList<>();
        LinkedList<BinaryTreeNode<T>> values = new LinkedList<>();
        values.addAll(inOrderNodeTraversal(node.left));
        values.add(node);
        values.addAll(inOrderNodeTraversal(node.right));
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
            if (root.left == null) {
                BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(value);
                newNode.parent = root;
                root.left = newNode;
            } else
                insertIntoBST(value, root.left);
        } else {
            if (root.right == null) {
                BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(value);
                newNode.parent = root;
                root.right = newNode;
            } else
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

    public static BinaryTreeNode<Integer> getNodeFromBST(Integer valueToFind, BinaryTreeNode<Integer> root) {
        if(root == null)
            return null;
        if(root.data.equals(valueToFind))
            return root;
        if(valueToFind < root.data)
            return getNodeFromBST(valueToFind, root.left);
        return getNodeFromBST(valueToFind, root.right);
    }

    public static BinaryTreeNode<Integer> removeFromBST(Integer value, BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> node = getNodeFromBST(value, root);
        if(node == null)
            return null;

        if(node.left != null && node.right != null) {
            // Find successor
            // replace node with its successor
            // remember to remove successor from old position
            // update the parent field
            return node;
        }

        BinaryTreeNode<Integer> parent = node.parent;
        BinaryTreeNode<Integer> child = node.left != null ? node.left : node.right;
        if(parent.left == node)
            parent.left = child;
        else
            parent.right = child;
        if(child != null)
            child.parent = parent;

        return  node;
    }

    public static int getSize(BinaryTreeNode root) {
        if(root == null)
            return 0;
        return 1 + getSize(root.left) + getSize(root.right);
    }
}
