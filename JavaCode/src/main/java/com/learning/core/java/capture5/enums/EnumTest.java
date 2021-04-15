package com.learning.core.java.capture5.enums;

import java.util.Scanner;

public class EnumTest {

    public static void main(String[] args) {

        var in = new Scanner(System.in);

        System.out.println("Enter a size :(s--Ex)");

        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("abbreviation =  " +size.getAbbreviation());

        if (size == Size.EXTRA_LAGER){
            System.out.println("Good job you paid attention to the ");
        }


    }
}

enum Size{
    SMALL("s"),MEDIUM("M"),LAGER("L"),EXTRA_LAGER("XL");

    private Size(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    private String abbreviation;
}
