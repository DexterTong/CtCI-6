package com.dexter.tong.chapter06;

import java.util.HashMap;

public class Question01 {

    /**
     * 6.1
     * You have 20 bottles of pills. 19 bottles have 1.0 gram pills, but one has pills of weight
     * 1.1 grams. Given a scale that provides an exact measurement, how would you find the heavy bottle?
     * You can only use the scale once.
     */
    public static PillBottle findHeavyBottle(PillBottle[] bottles) {

        HashMap<Integer, PillBottle> bottleHashMap = new HashMap<>(bottles.length);
        int[] removedPills = new int[bottles.length];
        int totalPillCount = 0;

        // Take pills out of bottles as necessary to guarantee unique weights, supposing that all pills weigh 1.0g
        // If there aren't enough pills in the bottles to create uniqueness, then we have a problem
        // Also count the total number of pills to get the expected weight, supposing all pills weigh 1.0g
        for(int i = 0; i < bottles.length; i++) {
            if(bottleHashMap.containsKey(bottles[i].pillCount)) {
                while(bottleHashMap.containsKey(bottles[i].pillCount)) {
                    if(bottles[i].pillCount < 0)
                        throw new RuntimeException("Ran out of pills to set aside for uniqueness");
                    bottles[i].pillCount--;
                    removedPills[i]++;
                }
                bottleHashMap.put(bottles[i].pillCount, bottles[i]);
                totalPillCount += bottles[i].pillCount;
            } else {
                bottleHashMap.put(bottles[i].pillCount, bottles[i]);
                totalPillCount += bottles[i].pillCount;
            }
        }

        // Use the difference between actual and expected weight to figure out the number of pills in the heavy bottle
        // Since the number of pills in a bottle is unique, we can unambiguously identify the heavy bottle
        double totalWeight = weighBottles(bottles);
        double difference = totalWeight - totalPillCount;

        PillBottle heavyBottle = bottleHashMap.get((int) (difference * 10));

        // Put the removed pills back
        for(int i = 0; i < bottles.length; i++)
            bottles[i].pillCount += removedPills[i];

        return heavyBottle;
    }

    private static double weighBottles(PillBottle[] bottles) {
        double weight = 0;
        for(PillBottle bottle : bottles)
            weight += bottle.pillCount * bottle.pillWeight;
        return weight;
    }

    public PillBottle createPillBottle(int pillCount, double pillWeight) {
        return new PillBottle(pillCount, pillWeight);
    }

    public class PillBottle {
        private double pillWeight;
        private int pillCount;

        public PillBottle(int pillCount, double pillWeight) {
            this.pillCount = pillCount;
            this.pillWeight = pillWeight;
        }

        public void setPillWeight(double pillWeight) {
            this.pillWeight = pillWeight;
        }
    }
}
