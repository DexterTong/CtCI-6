package com.dexter.tong.chapter07.Question01;

import java.awt.*;

public enum Suit {
    SPADES("SPADES", "♠", "BLACK", Color.black),
    HEARTS("HEARTS", "♥", "RED", Color.red),
    CLUBS("CLUBS", "♣", "BLACK", Color.black),
    DIAMONDS("DIAMONDS", "♦", "RED", Color.red);

    private final String name;
    private final String symbol;
    private final String color;
    private final Color colorCode;

    Suit(String name, String symbol, String colorName, Color color) {
        this.name = name;
        this.symbol = symbol;
        this.color = colorName;
        this.colorCode = color;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getColor() {
        return color;
    }

    public Color getColorCode() {
        return colorCode;
    }
}
