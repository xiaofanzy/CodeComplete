package com.learning.core.java.capture3;

public class StrictClassMethod {

    //严格的计算
    public static strictfp void main(String[] args) {

        double i = 5.1;
        double l = 5;
        System.out.println(l/i);    //0.9803921568627452  0.9803921568627452

    }
}

