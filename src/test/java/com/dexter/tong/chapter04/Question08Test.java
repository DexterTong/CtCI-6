package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;
import com.dexter.tong.utils.Trees;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class Question08Test {
    /*
    The question explicitly states that the tree may not be a BST. Even though I'm using BSTs here out of convenience,
    my solution does not make any use of the properties that differentiate a BST from a plain BT.
     */

    private BinaryTreeNode<Integer> root;
    private Question08 question08;

    @Before
    public void initialize() {
        question08 = new Question08();
        root = Trees.initializeBST(new Integer[]{11, 5, 17, 3, 8, 15, 19, 1, 4, 6, 9, 12, 16, 18, 21});
    }

    @Test(expected = NoSuchElementException.class)
    public void should_throw_exception_when_tree_is_null() {
        question08.getLowestCommonAncestor(null, null, null);
    }

    @Test(expected = NoSuchElementException.class)
    public void should_throw_exception_when_node_does_not_exist() {
        BinaryTreeNode<Integer> childA = Trees.getNodeFromBST(9, root);
        BinaryTreeNode<Integer> childB = new BinaryTreeNode<>(21);
        question08.getLowestCommonAncestor(root, childA, childB);
    }

    @Test()
    public void should_return_lca_when_several_ancestors() {
        BinaryTreeNode<Integer> childA = Trees.getNodeFromBST(9, root);
        BinaryTreeNode<Integer> childB = Trees.getNodeFromBST(3, root);

        BinaryTreeNode<Integer> expected = Trees.getNodeFromBST(5, root);

        assertSame(expected, question08.getLowestCommonAncestor(root, childA, childB));
    }

    @Test()
    public void should_return_lca_when_one_ancestor() {
        BinaryTreeNode<Integer> childA = Trees.getNodeFromBST(6, root);
        BinaryTreeNode<Integer> childB = Trees.getNodeFromBST(19, root);

        assertSame(root, question08.getLowestCommonAncestor(root, childA, childB));
    }

    @Test()
    public void should_return_lca_when_children_are_same() {
        BinaryTreeNode<Integer> childA = Trees.getNodeFromBST(15, root);

        assertSame(childA, question08.getLowestCommonAncestor(root, childA, childA));
    }

    @Test()
    public void should_return_childA_when_childA_is_parent_of_childB() {
        BinaryTreeNode<Integer> childA = Trees.getNodeFromBST(17, root);
        BinaryTreeNode<Integer> childB = Trees.getNodeFromBST(15, root);

        assertSame(childA, question08.getLowestCommonAncestor(root, childA, childB));
    }
}