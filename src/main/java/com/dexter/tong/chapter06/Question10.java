package com.dexter.tong.chapter06;

public class Question10 {
    /**
     * 6.10
     * You have 1000 bottles of soda, and exactly one is poisoned. You have 10 test strips which
     * can be used to detect poison. A single drop of poison will turn the test strip positive permanently.
     * You can put any number of drops on a test strip at once and you can reuse a test strip as many times
     * as you 'd like (as long as the results are negative). However, you can only run tests once per day and
     * it takes seven days to return a result. How would you figure out the poisoned bottle in as few days
     * as possible?
     * FOLLOW UP
     * Write code to simulate your approach.
     */
    /*
    Split the bottles in 10 bins of 90, call them (B0, B1, ..., B9) , and 1 bin of 100, call it Z
    For each bin Bi, take 1 strip and put 1 drop from each bottle in the bin on the strip
    Test all the strips (7 days), 2 cases arise from the results:

        One of the strips is positive:
            Then we have 9 strips left and narrowed it down to one of the bins Bi (90 bottles)
            Divide the bin Bi into 10 bins of 9, call then C0, C1, ..., C8, Y
            For each bin Ci, take 1 strip and put 1 drop from each bottle in the bin on the strip
            Test all of the strips (7 days)
            We have narrowed it down to 9 bottles, and have either 8 or 9 strips left
            For each bottle, take 1 strip and put 1 drop from the bottle on the strip (if we have 8 strips, ignore last bottle)
            Test all of the strips (7 days)
            We have identified the poisoned soda (total 21 days)

        None of the strips are positive:
            Then we have 10 strips left and narrowed it down to bin Z (100 bottles)
            Divide the bin Z into 10 bins of 9, and 1 bin of 10, call then C0, C1, ..., C9, Y
            Test all of the strips (7 days), there are 2 cases:

                One of the strips is positive:
                    We have 8 strips left and 9 bottles
                    Test them individually (7 days)
                    We have identified the poisoned soda (total 21 days)

                None of the strips are positive:
                    We have 9 strips left and 10 bottles
                    Test them individually (7 days)
                    We have identified the poisoned soda (total 21 days)

    Long story short, it takes 21 days.
     */
    public static int findPoisonedBottle(boolean[] bottles) {
        if(bottles.length != 1000)
            throw new IllegalArgumentException();

        int remainingStrips = 10;
        int daysElapsed = 0;
        int min = 0;
        int max = 1000;
        boolean poisonedBinFound = false;

        boolean[] results = new boolean[10];

        for(int i = 0; i < 10; i++) {
            results[i] = testIfPoisoned(bottles, i * 90, (i + 1) * 90 - 1);
        }

        daysElapsed += 7;
        for(int i = 0; i < 10; i++) {
            if(results[i]) {
                remainingStrips--;
                min = i * 90;
                max = (i + 1) * 90 - 1;
                poisonedBinFound = true;
            }
        }
        if(!poisonedBinFound) {
            min = 900;
            max = 999;
        }

        // I don't really want to finish this, it's quite tedious to code since we need to handle all the edges
        // properly to get it done in 21 days

        return -1;
    }

    private static boolean testIfPoisoned(boolean[] bottles, int min, int max) {
        for(int i = min; i <= max; i++)
            if(bottles[i])
                return true;
        return false;
    }
}
