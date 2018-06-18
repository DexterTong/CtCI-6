package com.dexter.tong.chapter07.Question01;

public enum Value {
    ACE("ACE", 'A', 1),
    TWO("TWO", '2', 2),
    THREE("THREE", '3', 3),
    FOUR("FOUR", '4', 4),
    FIVE("FIVE", '5', 5),
    SIX("SIX", '6', 6),
    SEVEN("SEVEN", '7', 7),
    EIGHT("EIGHT", '8', 8),
    NINE("NINE", '9', 9),
    TEN("TEN", 'T', 10),
    JACK("JACK", 'J', 11),
    QUEEN("QUEEN", 'Q', 12),
    KING("KING", 'K', 13),
    JOKER("JOKER", '*', 99);    // '*' for star

    private final String name;
    private final char initial;
    private int value;

    Value(String value, char initial, int number) {
        this.name = value;
        this.initial = initial;
        this.value = number;
    }

    public String getName() {
        return name;
    }

    public char getInitial() {
        return initial;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Character.toString(initial);
    }
}
