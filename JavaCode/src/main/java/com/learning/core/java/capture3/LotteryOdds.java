package com.learning.core.java.capture3;

import java.util.Scanner;

/**
 * 中奖概率
 */
public class LotteryOdds {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //你希望有多少个球？
        System.out.println("how many number do you need to draw");
        int k = scanner.nextInt();

        //最大值是什么？
        System.out.println("What is the highest number you can dram?");
        int n = scanner.nextInt();

        int lotteryOdds = 1;

        for (int i = 1; i <= k ; i++) {
            lotteryOdds = lotteryOdds * (n-i+1)/i;
        }

        System.out.println("you are the 1 in "+ lotteryOdds + " good luck");
    }

}
