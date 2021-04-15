package com.learning.core.java.capture3;

import java.util.Scanner;

public class Retirement2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //期望年金
        System.out.println("How much money will you contribute every year?");
        double payment = scanner.nextDouble();

        //利率
        System.out.println("Interest rate in %:");
        double interestRate = scanner.nextDouble();

        //余额
        double balance = 0;

        // 年限
        int year = 0;

        // 是否退休
        String input;

        do {
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;

            year++;

            //经过多少年，你的收益是：
            System.out.printf("Afert year %d,you balance is %,.2f$n,",year,balance);

            System.out.println("Ready to Retire? ");
            input = scanner.next();
        }while (input.equals("N"));
    }
}
