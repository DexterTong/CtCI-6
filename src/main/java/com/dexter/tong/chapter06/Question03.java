package com.dexter.tong.chapter06;

public class Question03 {
    /**
     * 6.3
     * There is an 8x8 chessboard in which two diagonally opposite corners have been cut off.
     * You are given 31 dominos, and a single domino can cover exactly two squares. Can you use the 31
     * dominos to cover the entire board? Prove your answer (by providing an example or showing why
     * it's impossible).
     */
    /*
    No method here, since this is all logic-based, no code involved.
    Each square of a chessboard is either black or white, and color is selected such that black squares can only be
    diagonally adjacent to each other, and likewise for white squares:

        B W B W B W B W
        W B W B W B W B
        B W B W B W B W
        W B W B W B W B
        B W B W B W B W
        W B W B W B W B
        B W B W B W B W
        W B W B W B W B

    There are exactly 32 white squares, and 32 black squares on an 8x8 chessboard
    Note that diagonally opposite corners have the same color:
        Top left and bottom right are black, top right and bottom left are white
    So by removing opposite corners, we either have 30 W and 32 B, or 32 W and 30 B squares
    Each domino, when placed, must cover exactly 1 black, and exactly 1 white square, due to the layout mentioned above
    So 31 dominos must cover 31 white and 31 black squares, but we have 1 fewer of one color, and 1 more of the other
    Therefore it is impossible
     */
}
