package com.dexter.tong.chapter06;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question08Test {

    private boolean[] floors;

    @Before
    public void initialize() {
        floors = new boolean[100];
    }

    @Test
    public void should_return_max_egg_drop_floorA() {
        setMaxDropHeight(58);
        assertEquals(58, Question08.findEggDropHeight(floors));
    }
    @Test
    public void should_return_max_egg_drop_floorB() {
        setMaxDropHeight(27);
        assertEquals(27, Question08.findEggDropHeight(floors));
    }

    private void setMaxDropHeight(int floor) {
        for(int i = floor + 1; i < floors.length; i++) {
            floors[i] = true;
        }
    }
}