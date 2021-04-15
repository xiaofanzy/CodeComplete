package com.learning.core.java.capture3;

import java.util.Scanner;

public class Retirement {

    public static void main(String[] args) {

        /**
         * 退休金
         */

        Scanner in = new Scanner(System.in);

        //退休时间
        System.out.println("多少退休金？");
        int money = in.nextInt();
        System.out.println("期望多大利润");
        double goal = in.nextDouble();

        double balance = 0;
        int years = 0;

        while (balance<goal){
            balance += money;

        }

        System.out.println("-------");
    }
}
