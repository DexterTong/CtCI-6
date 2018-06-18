package com.dexter.tong.chapter06;

public class Question02 {

    /**
     * 6.2
     * You have a basketball hoop and someone says that you can play one of two games.
     * Game 1: You get one shot to make the hoop.
     * Game 2: You get three shots and you have to make two of three shots.
     * If p is the probability of making a particular shot, for which values of p should you pick one game
     * or the other?
     */
    public static int whichGameToPlayA(double p) {
        // Assume the player is lazy and that if the probabilities are equal, they would rather shoot just once
        // Floating-point error will probably keep this from happening, though
        return game1WinProbability(p) > game2WinProbability(p) ? 1 : 2;
    }

    private static double game1WinProbability(double p) {
        // Clearly, the probability that you win game 1 is just the probability that you make a shot
        return p;
    }

    private static double game2WinProbability(double p) {
        // Let's call the three shots A, B, and C

        // Consider the probability of making shots A and B, and missing C
        double probabilityOfMakingAandB = p * p * (1-p);

        // Of course, this has the same probability as making only B and C, as well as making only A and C
        // These are the only ways to make exactly two shots
        double probabilityOfMakingExactlyTwoShots = probabilityOfMakingAandB * 3;

        // Finally, we calculate the probability of making all three shots:
        double probabilityOfMakingAllShots = Math.pow(p, 3);

        // Since making exactly 2 shots and making exactly 3 shots are mutually exclusive, they have no intersection
        // to subtract when adding the probabilities

        return probabilityOfMakingAllShots + probabilityOfMakingExactlyTwoShots;
    }

    public static int whichGameToPlayB(double p) {
        /*
        Alternatively, we can just do the math, based on the derivation above.
        Let P be the probability of winning the game, and p the probability of making any particular shot

        Game 1:
            Again, this is just P = p

        Game 2:
            The probability of making 2 specific shots and missing the 3rd is p * p * (1-p)
            And there are 3 ways to do this, so the probability of making exactly 2 shots is 3 * p^2 * (1-p)
            The probability of making all 3 shots and missing none is p * p * p
            Again, these 2 sets of outcomes are mutually exclusive, so we can just add them
            Finally, we get: P = 3 * p^2 * (1-p) + p^3

        The Tipping Point:
            We set up the equation:     p = 3 * p^2 * (1-p) + p^3
            Expand the (1-p) term:      p = 3 * p^2 - 3 * p^3 + p^3
            Make the left side 0:       0 = 3 * p^2 - 2 * p^3 - p
            Rearrange:                  -2p^3 + 3p^2 - p = 0

            Clearly, p = 0 is a root of this equation, so divide it out:
                                        -2p^2 + 3p - 1 = 0
            By inspection, p = 1 is another root, so divide that out too:
                                        -2p + 1 = 0
            Solving for the last root, we get p = 1/2

            So the 3 points at which we have an equal probability of winning either game are p = 0, 0.5, 1
                If 0.5 < p <= 1:
                    By plugging in a number somewhere in this range, we see that game 2 has a higher win probability
                If 0 <= p <= 0.5
                    We know that since the equation above is a cubic, the curve is on the other side of the x-axis here
                    Based on the previous result, this is the range for which game 1 is more likely to result in a win
        Final Note:
            We will not have checking for p = 0 or p = 1 to make it consistent with the other method, due to fp error
         */
        return p > 0.5 ? 2 : 1;
    }
}
