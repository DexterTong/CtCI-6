package com.dexter.tong.chapter02;

import com.dexter.tong.common.LinkedListNode;

public class Question05 {

    /**
     * 2.5a
     * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in 
     * reverse order, such that the 1 's digit is at the head of the list. Write a function that adds the two numbers and returns 
     * the sum as a linked list.
     * Time: O(m+n)
     * Space: O(m+n)
     */
    public static LinkedListNode<Integer> reverseSumList(LinkedListNode<Integer> listA, LinkedListNode<Integer> listB) {
        // Assumption: listA and listB represent base-10 numbers and consist of base-10 digits only
        // The basic idea here is to traverse listA and listB once to calculate the int sum of them, and then create
        // the sum linked list.

        int sum = reverseListToInt(listA) + reverseListToInt(listB);
        LinkedListNode<Integer> sumList = new LinkedListNode<>(sum % 10);
        LinkedListNode<Integer> curr = sumList;
        sum /= 10;
        while(sum > 0) {
            curr.next = new LinkedListNode<>(sum % 10);
            sum /= 10;
            curr = curr.next;
        }
        return sumList;
    }

    private static int reverseListToInt(LinkedListNode<Integer> head) {
        int sum = 0;
        int place = 1;
        LinkedListNode<Integer> current = head;
        while(current != null) {
            sum += current.data * place;
            current = current.next;
            place *= 10;
        }
        return sum;
    }

    /**
     * 2.5b
     * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in 
     * reverse order, such that the 1 's digit is at the head of the list. Write a function that adds the two numbers and returns 
     * the sum as a linked list. Suppose the digits are stored in forward order. Repeat the above problem.
     * Time: O(m+n)
     * Space: O(m+n)
     */
    public static LinkedListNode<Integer> forwardSumList(LinkedListNode<Integer> listA, LinkedListNode<Integer> listB) {
        // Assumption: listA and listB represent base-10 numbers and consist of base-10 digits only
        int lengthA = 0;
        int lengthB = 0;

        // Get the lengths of the lists representing A and B
        LinkedListNode<Integer> current = listA;
        while(current != null) {
            lengthA++;
            current = current.next;
        }

        current = listB;
        while(current != null) {
            lengthB++;
            current = current.next;
        }

        // Make them the same length by padding zeroes
        if(lengthA > lengthB) {
            while(lengthB < lengthA) {
                LinkedListNode<Integer> n = new LinkedListNode<Integer>(0);
                n.next = listB;
                listB = n;
                lengthB++;
            }
        } else if (lengthB > lengthA) {
            LinkedListNode<Integer> n = new LinkedListNode<Integer>(0);
            n.next = listA;
            listA = n;
            lengthA++;
        }

        // Sum up A and B
        int sum = 0;
        int place = (int) Math.pow(10, (lengthA - 1));
        LinkedListNode<Integer> currentA = listA;
        LinkedListNode<Integer> currentB = listB;

        while(currentA != null) {
            sum += currentA.data * place;
            sum += currentB.data * place;
            currentA = currentA.next;
            currentB = currentB.next;
            place /= 10;
        }

        // Finally, create the sum list
        place = (int) Math.pow(10, getDigitCount(sum) - 1);
        LinkedListNode<Integer> sumList = new LinkedListNode<Integer>(sum / place);
        place /= 10;
        current = sumList;
        while(place > 0) {
            current.next = new LinkedListNode<Integer>( (sum / place) % 10 );
            place /= 10;
            current = current.next;
        }

        return sumList;
    }

    private static int getDigitCount(int num) {
        if(num == 0)
            return 1;
        return (int) Math.log10(num) + 1;
    }
}
