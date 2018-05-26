package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Question03Test {

    @Test
    public void should_delete_middle_node() {
        LinkedListNode<Integer> head = utils.createLinkedList(new Integer[]{3, 5, 7, 8, 1, 0});
        List<Integer> expected = Arrays.asList(3, 7, 8, 1, 0);
        LinkedListNode<Integer> toDelete = utils.get(head, 1);
        Question03.deleteMiddle(toDelete);
        assertEquals(expected, head.asList());
    }
}