package com.dexter.tong.chapter03;

public class Question01 {

    /**
     * 3.1
     * Describe how you could use a single array to implement three stacks.
     */
    /*
    There are several possible ways to do this, each with their own tradeoffs.
    Let's call the stacks S1, S2, and S3, and the single array, A, with length N
    Also, for all solutions, if we interpret the problem strictly and require that all data must be stored in the array,
    we can reserve some space at the beginning of the array for this, effectively shrinking the space available for
    stack storage.

    1. Interleaved Stacks:
        S1 starts at A[0] and expands to A[3], A[6], ..., A[3i]
        S2 starts at A[1] and expands to A[4], A[7], ..., A[3i+1]
        S3 starts at A[2] and expands to A[5], A[8], ..., A[3i+2]
        .....
        This is probably the simplest method. Each stack is strictly limited to capacity of N/3, with no ability to
        rebalance. O(1) additional space required, to keep track of the current top of the stack. O(1) push/pop. This
        works best when all 3 stacks have similar size requirements at any given time. This solution also is easily
        generalizable to a greater number of stacks, though in practice, the low and fixed stack capacity may make this
        far from ideal.

    2. Floating Stacks:
        S1 starts at A[0] and expands rightwards
        S2 starts at A[N/6] and expands rightwards
        S3 starts at A[N-1] and expands leftwards
        .....
        This is a little more sophisticated than the first one. O(1) additional space required to keep track of both the
        top and bottom of each stack. Rebalancing can be achieved by shifting S2 to the left or right to make more room
        for S1 or S3. Rebalancing is an O(N) operation. O(1) push/pop for all. While this scheme can make optimal use of
        the space in A, push performance as A fills up degenerates to O(N) time as S2 will need to be pushed left and
        right to make space available. This solution could be generalized to a larger number of stacks, but that would
        result in increasing numbers of rebalancing events, driving performance down. But again, this solution makes
        full use of the storage space available in the lone array.

    3. Block Allocation:
        Divide A into K contiguous blocks of size N/K, denote these blocks B1, B2, ..., BK
        Each block will be used to sequentially store the elements of a particular stack
        For each block, reserve an index (let's say the first/0th index) to hold a reference to another block
        This reserved index will point to the "next" block in the stack, i.e. the block containing the elements
        immediately below the elements in the current block for a particular stack
        Keep track of the top of each stack, as a reference to an index within a particular block
        Also keep some kind of list of unallocated blocks
        When a stack fills up a block, "allocate" an unallocated block to that stack
        I've skipped a lot of details, but I think you get the idea by now
        .....
        This is a much more complex solution than either of the above. Push operations are O(1): Go to the top of the
        stack. If this is not the end of the block, then move to the next index and store the object there, update the
        pointer to the top of the stack. If the block is full, then take the next unallocated block, set the "below
        block" reference, and add the object there. Update the stack top pointer as well. Pop operations are also O(1):
        Get the object from the top of the stack. If it is the only element in the block, visit the end of the "below
        block" and set the top of the stack to it. Add the newly vacated block to the list of unallocated blocks. If it
        is not the only element in the block, then just move the stack top pointer.
        With this method, there is no rebalancing: Block (de)allocation is an O(1) operation done during push/pop. By
        using blocks, the worst-case runtime of the floating stacks solution is avoided, at the cost of additional
        storage overhead to keep a small amount of metadata in each block and a list of unallocated blocks. But stacks
        can run out of capacity before the array is completely filled, since other stacks may have non-full blocks
        allocated.
     */
}
