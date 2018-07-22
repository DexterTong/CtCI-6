package com.dexter.tong.chapter10;

import com.dexter.tong.common.BinaryTreeNode;

import java.util.NoSuchElementException;


/**
 * 10.10
 * Imagine you are reading in a stream of integers. Periodically, you wish to be able
 * to look up the rank of a number x (the number of values less than or equal to x). Implement the data
 * structures and algorithms to support these operations. That is, implement the method track(int x), which is
 * called when each number is generated, and the method getRankOfNumber(int x) , which returns the number of values
 * less than or equal to X (not including x itself).
 */
class RankedIntStore {

    private RankedBTNode root;

    public RankedIntStore() {
    }

    public void track(int x) {
        if (root == null) {
            root = new RankedBTNode(x);
            return;
        }
        insert(x, root);
    }

    private void insert(int x, RankedBTNode root) {
        if (root.data == x) {
            root.duplicates++;
            return;
        }
        if (root.data > x) {
            root.leftChildren++;
            if (root.left == null) {
                root.left = new RankedBTNode(x);
            } else {
                insert(x, (RankedBTNode) root.left);
            }
        } else {
            if (root.right == null) {
                root.right = new RankedBTNode(x);
            } else {
                insert(x, (RankedBTNode) root.right);
            }
        }
    }

    public int getRankOfNumber(int x) {
        return getRankOfNumber(x, root);
    }

    private int getRankOfNumber(int x, RankedBTNode root) {
        if(root == null)
            throw new NoSuchElementException("Int has not been tracked");
        if(root.data == x) {
            return root.leftChildren + root.duplicates;
        }
        if(root.data < x) {
            return root.leftChildren + root.duplicates + 1 + getRankOfNumber(x, (RankedBTNode) root.right);
        } else {
            return getRankOfNumber(x, (RankedBTNode) root.left);
        }
    }
}

class RankedBTNode extends BinaryTreeNode<Integer> {
    public int leftChildren;
    public int duplicates;

    public RankedBTNode(int value) {
        super(value);
        duplicates = 0;
        leftChildren = 0;
    }
}
