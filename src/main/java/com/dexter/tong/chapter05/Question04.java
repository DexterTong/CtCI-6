package com.dexter.tong.chapter05;

public class Question04 {

    /**
     * 5.4
     * Given a positive integer, print the next smallest and the next largest number that
     * have the same number of 1 bits in their binary representation.
     */
    /*
    I admit this method is a total mess.
     */
    public static int[] nextNumber(int num) {
        if(num < 0)
            throw new IllegalArgumentException();
        if(num == 0)
            return new int[]{0, 0};

        int[] result = new int[2];

        // Look for the rightmost occurence of the sequence '10'
        int[] temp = findBitTuple(num, true, false);
        int smallSwapIndex = temp[0];
        if(smallSwapIndex == -1) {
            // Need some way of conveying that a smaller number does not exist
            result[0] = Integer.MAX_VALUE;
        } else {
            int smallMask = temp[1];
            result[0] = num & ~smallMask;
            smallMask = smallMask >> 1;
            result[0] = result[0] | smallMask;
        }

        int bitsToClear = smallSwapIndex - 1;
        int clearMask = -1;
        for(int i = 0; i < bitsToClear; i++)
            clearMask = clearMask << 1;
        result[0] = result[0] & clearMask;

        int insertMask = -1;
        for(int i = 0; i < temp[2]; i++)
            insertMask = insertMask << 1;
        insertMask = ~insertMask;
        for(int i = 0; i < bitsToClear - temp[2]; i++)
            insertMask = insertMask << 1;
        result[0] = result[0] | insertMask;

        // Look for the rightmost occurence of the sequence '01'
        temp = findBitTuple(num, false, true);
        int largeSwapIndex = temp[0];
        // Need to account for case where the rightmost '01' includes the sign bit
        if(largeSwapIndex == -1 || largeSwapIndex == Integer.SIZE - 1) {
            // Need some way of conveying that a larger number does not exist
            result[1] = Integer.MIN_VALUE;
        } else {
            int largeMask = temp[1];
            result[1] = num | largeMask;
            largeMask = largeMask >> 1;
            result[1] = result[1] & ~largeMask;
        }

        bitsToClear = largeSwapIndex - 1;
        clearMask = -1;
        for(int i = 0; i < bitsToClear; i++)
            clearMask = clearMask << 1;
        result[1] = result[1] & clearMask;

        insertMask = -1;
        for(int i = 0; i < temp[2]; i++)
            insertMask = insertMask << 1;
        insertMask = ~insertMask;
        result[1] = result[1] | insertMask;

        return result;
    }

    private static int[] findBitTuple(int num, boolean leftBit, boolean rightBit) {
        int mask = 2;
        int patternLIndex = -1;
        int setBitCount = 0;

        boolean prevBit = false;
        boolean currBit = (num & 1) != 0;

        for(int i = 1; i < Integer.SIZE; i++) {
            if(prevBit)
                setBitCount++;
            prevBit = currBit;
            currBit = (num & mask) != 0;
            if((leftBit == currBit) && (rightBit == prevBit)) {
                patternLIndex = i;
                break;
            }
            mask = mask << 1;
        }

        return new int[]{patternLIndex, mask, setBitCount};
    }
}
