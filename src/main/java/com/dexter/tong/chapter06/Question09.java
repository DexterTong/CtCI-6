package com.dexter.tong.chapter06;

public class Question09 {
    /**
     * 6.9
     * There are 100 closed lockers in a hallway. A man begins by opening all 100 lockers.
     * Next, he closes every second locker. Then, on his third pass, he toggles every third locker (closes it if
     * it is open or opens it if it is closed). This process continues for 100 passes, such that on each pass i,
     * the man toggles every ith locker. After his 100th pass in the hallway, in which he toggles only locker
     * #100, how many lockers are open?
     */
    /*
    By the way the question is worded, I will assume it works like so:
    The lockers are labeled 1 through 100, and all start closed
    On pass N, he counts by N's and toggles each Nth locker
    So on pass 1, he toggles each locker, opening them
    On pass 2, he toggles lockers 2, 4, 6, ..., 100
    On pass 3, he toggles lockers 3, 6, 9, ..., 99
    ...
    On day 100, he toggles locker 100

    One way to solve this is by brute force: simulate the 100 days of opening and closing lockers, and count them up

    Another way is to find all the factors of each locker number, that will tell how many times it gets toggled
    Expanding on this, we know that locker 1 is toggled once, since 1 is the only factor of 1
    Most lockers will be toggled an even number of times. Each factor of a number is paired with a factor of the
    number. The only time when a factor is paired with itself is when the number is a square. Only the square numbers
    will have an odd number of factors. So since the lockers start closed, our answer is the number of lockers that get
    toggled an odd number of times, i.e. the lockers with a square number.
    Since our lockers are numbered 1 to 100, inclusive, and we know that 100 = 10^2, the answer is 10
    (1^2, 2^2, ..., 10^2 are all in the range 1 to 100)
     */
    public static int howManyLockersOpen(int lockerCount) {
        return (int) Math.sqrt(lockerCount);
    }
}
