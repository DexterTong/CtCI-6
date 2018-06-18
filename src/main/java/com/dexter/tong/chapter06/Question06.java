package com.dexter.tong.chapter06;

public class Question06 {
    /**
     * 6.6
     * A bunch of people are living on an island, when a visitor comes with a strange
     * order: all blue-eyed people must leave the island as soon as possible. There will be a flight out at
     * 8:00 pm every evening. Each person can see everyone else's eye color, but they do not know their
     * own (nor is anyone allowed to tell them). Additionally, they do not know how many people have
     * blue eyes, although they do know that at least one person does. How many days will it take the
     * blue-eyed people to leave?
     */
    /*
    Suppose only 1 person had blue eyes. They would note that everyone else has brown eyes, conclude that they must be
    the blue-eyed person, and then leave. This would take 1 day.

    Now suppose only 2 people have blue eyes. Either of them would see 1 person with blue eyes, and neither would leave
    on day 1, leading each to conclude that there must be 1 other person with blue eyes, (i.e. themself), or else the
    blue-eyed person they saw would have left on day 1. Then both of them would leave on day 2.

    Suppose 3 people are blue-eyed. Any one of those 3 will see 2 people with blue eyes. Nobody leaves on day 1, because
    each concludes that they may not be one of the at least 1 person with blue eyes. On day 2, again, nobody leaves.
    All of the blue-eyed people individually conclude that there must be 3 blue-eyed people (themself being the 3rd),
    since nobody left on day 2.

    This generalizes, so for N blue-eyed people in the population, they will realized on the Nth day that nobody has
    left yet, so they must be one of the N blue-eyed people. Then they all leave together on the Nth day.
     */
}
