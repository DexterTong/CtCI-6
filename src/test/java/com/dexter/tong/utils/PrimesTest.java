package com.dexter.tong.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimesTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_max_is_negative() {
        Primes.getPrimes(-2);
        fail("IllegalArgumentException should have been thrown");
    }

    @Test
    public void should_return_empty_when_max_is_0_or_1() {
        assertArrayEquals(new int[0], Primes.getPrimes(1));
    }

    @Test
    public void should_return_2_when_max_is_2() {
        assertArrayEquals(new int[]{2}, Primes.getPrimes(2));
    }

    @Test
    public void should_return_primes_when_max_is_odd_prime() {
        assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13}, Primes.getPrimes(13));
    }

    @Test
    public void should_return_primes_when_max_is_greater_than_2() {
        assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13, 17, 19}, Primes.getPrimes(20));
    }
}