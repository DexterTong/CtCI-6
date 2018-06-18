package com.dexter.tong.chapter06;

public class Question07 {
    /**
     * 6.7
     * In the new post-apocalyptic world, the world queen is desperately concerned
     * about the birth rate. Therefore, she decrees that all families should ensure that they have one girl or
     * else they face massive fines. If all families abide by this policy-that is, they have continue to have
     * children until they have one girl, at which point they immediately stop-what will the gender ratio
     * of the new generation be? (Assume that the odds of someone having a boy or a girl on any given
     * pregnancy is equal.) Solve this out logically and then write a computer simulation of it.
     */
    /*
    Probability of first child being a girl: 0.5
    Probability of first child being a boy and second child being a girl: 0.5 * 0.5
    2 boys, 1 girl: 0.5^3
    ...
    N-1 boys, 1 girl: 0.5^N

    As these are mutually exclusive outcomes, we need to add up the number of boys and girls each possibility adds to
    the generation times the probability of each occurring. Note that each outcome adds exactly 1 girl, so whatever
    the expected number of boys is, we compare to 1 girl

        Boys:
        0 * 0.5         = 0
        1 * 0.25        = 0.25
        2 * 0.125       = 0.25
        3 * 0.0625      = 0.1875

    As a summation, this is sum(i=0, inf)(i/(2*2^i))
    Or, 1/2 * sum(i=0, inf)(i/2^i)
    This is 1/2 * 2 = 1
    We can do this either by summing the first 10 or so terms of the summation (and seeing that it seems to approach 2)
    Or by solving it explicitly, and you'll see that it's 2.
    So since the expected value is 1 boy [for every 1 girl], the gender ratio of the new generation is 1:1
     */

    // Simulate the gender ratio as boys : girls, for some family count
    public static String simulateGeneration(int familyCount) {
        int girls = 0;
        int boys = 0;

        for(int i = 0; i < familyCount; i++) {
            boys += simulateFamily();
            girls++;
        }

        return String.format("Boys:  %d\nGirls: %d\nRatio: %f", boys, girls,  boys / (double) girls);
    }

    // Number of boys birthed before a girl is born
    private static int simulateFamily() {
        int boys = 0;
        while(true) {
            if(Math.random() > 0.5)
                boys++;
            else
                return boys;
        }
    }
}
