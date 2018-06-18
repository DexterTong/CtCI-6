package com.dexter.tong.chapter06;

public class Question08 {
    /**
     * 6.8
     * There is a building of 100 floors. If an egg drops from the Nth floor or
     * above, it will break. If it's dropped from any floor below, it will not break. You're given two eggs. Find
     * N, while minimizing the number of drops for the worst case.
     */
    /*
    Since we have 2 eggs, if we break the first egg, we have to linearly search floor-by-floor upwards with the second
    So suppose we drop the first egg from floor A
    If the egg breaks, we must drop the second from floor 1 to floor A-1 (worst case A-1 drops for egg 2)
        So in total, A drops
    If the egg does not break, we select a higher floor B to drop it from
    Now if the egg breaks on floor B, we must search from floor A+1 to B-1 (B-A-2 drops in the worst case)
        In total, this is 1 + 1 + B - A - 2 = B - A drops
    Suppose the egg does not break, we select a higher floor C to drop from
    If the egg breaks, we search from floor B+1 to C-1 (C-B-2 drops at worst)
        In total, this is 1 + 1 + 1 + C - B - 2 = C - B + 1 drops

    We can achieve the minimal worst case by making sure that these drop totals are all as close as possible, let's call
    this minimum Y

    So on the first drop, we drop the egg from floor Y. If it breaks, we try the Y-1 floors below, giving at most Y drops.
    If it doesn't break, we try floor 2Y-1. If it breaks, we search from floor Y+1 to 2Y-2. This is 1+1+Y-2=Y total drops.
    Else, we move on to 3Y-2. If breaks, we check 2Y to 3Y-3
    Etc.
    Each time we choose a floor to drop egg 1 from, we increment by 1 less than before, i.e. we are dropping from Y,
    then Y + (Y-1), Y + (Y -1) + (Y-2), ...
    So to minimize Y, we need to find the smallest number for which sum(1, Y) >= 100
    The sum of integers from 1 to N is N(N+1)/2, so we want 200 <= Y(Y+1)
    So Y = 14
     */
    public static int findEggDropHeight(boolean[] floors) {
        // This initialized to be the same as the worst case number of drops
        int floor = (int) Math.sqrt(floors.length * 2);
        int increment = floor;
        int max = floors.length - 1;
        int min = 0;

        while(min < max) {
            if(drop(floors, floor)) {
                max = floor - 1;
                return linearSearchDrop(floors, min + 1);
            } else {
                min = floor;
            }
            increment--;
            floor += increment;
        }
        return min;
    }

    // True if the egg breaks, false otherwise
    public static boolean drop(boolean[] floors, int floor) {
        return floors[floor];
    }

    public static int linearSearchDrop(boolean[] floors, int floor) {
        if(drop(floors, floor))
            return floor - 1;
        else
            return linearSearchDrop(floors, floor + 1);
    }
}
