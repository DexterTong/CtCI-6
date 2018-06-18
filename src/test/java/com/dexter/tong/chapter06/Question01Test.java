package com.dexter.tong.chapter06;

import org.junit.Before;
import org.junit.Test;
import com.dexter.tong.chapter06.Question01.PillBottle;

import static org.junit.Assert.*;

public class Question01Test {

    private final int bottleCount = 20;

    @Test
    public void should_find_heavy_bottle_when_pill_counts_unique() {
        final int heavyBottleIndex = 8;
        final int[] pillCounts = new int[]{22, 24, 20, 23, 28, 16, 25, 12, 13, 11, 15, 21, 10, 27, 14, 26, 19, 17, 18, 29};

        PillBottle[] pillBottles = initializePillBottles(pillCounts, heavyBottleIndex, bottleCount);

        assertSame(pillBottles[heavyBottleIndex], Question01.findHeavyBottle(pillBottles));
    }

    @Test
    public void should_find_the_heavy_bottle() {
        final int heavyBottleIndex = 11;
        final int[] pillCounts = new int[]{100, 100, 140, 120, 120, 150, 130, 110, 140, 100, 110, 130, 120, 140, 150, 110, 150, 130, 120, 110};

        PillBottle[] pillBottles = initializePillBottles(pillCounts, heavyBottleIndex, bottleCount);

        assertSame(pillBottles[heavyBottleIndex], Question01.findHeavyBottle(pillBottles));
    }

    private PillBottle[] initializePillBottles(int[] pillCounts, int heavyBottleIndex, int bottleCount) {
        Question01 question01 = new Question01();
        PillBottle[] pillBottles = new PillBottle[bottleCount];

        for(int i = 0; i < bottleCount; i++) {
            double pillWeight = 1.0;
            if(i == heavyBottleIndex)
                pillWeight = 1.1;
            pillBottles[i] =  question01.createPillBottle(pillCounts[i], pillWeight);
        }

        return pillBottles;
    }
}