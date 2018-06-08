package com.dexter.tong.chapter04;

import com.dexter.tong.common.BinaryTreeNode;
import com.dexter.tong.utils.Trees;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class Question03Test {

    @Before

    @Test
    public void should_return_a_list_of_nodes_at_each_depth() {
        Integer[] input = new Integer[]{13, 6, 7, 9, 10, 2, 5, 15, 17, 8, 12, 11, 1, 14, 4, 3, 16};
        BinaryTreeNode<Integer> root = Trees.initializeBST(input);
        ArrayList<LinkedList<BinaryTreeNode<Integer>>> listOfDepths = Question03.listOfDepths(root);

        ArrayList<HashSet<Integer>> expected = new ArrayList<>(7);
        expected.add(new HashSet<>(Arrays.asList(13)));
        expected.add(new HashSet<>(Arrays.asList(6, 15)));
        expected.add(new HashSet<>(Arrays.asList(2, 7, 14, 17)));
        expected.add(new HashSet<>(Arrays.asList(1, 5, 9, 16)));
        expected.add(new HashSet<>(Arrays.asList(4, 8, 10)));
        expected.add(new HashSet<>(Arrays.asList(3, 12)));
        expected.add(new HashSet<>(Arrays.asList(11)));

        assertEquals(expected.size(), listOfDepths.size());
        for(int i = 0; i < expected.size(); i++) {
            assertTrue(compareIntegerSetToNodeList(expected.get(i), listOfDepths.get(i)));
        }
    }

    private boolean compareIntegerSetToNodeList(Set<Integer> intSet, LinkedList<BinaryTreeNode<Integer>> nodeList) {
        if(intSet.size() != nodeList.size())
            return false;
        HashSet<Integer> nodeValues = new HashSet<>(nodeList.size());
        for(BinaryTreeNode<Integer> node : nodeList) {
            nodeValues.add(node.data);
        }
        return intSet.equals(nodeValues);
    }
}