package com.learning.core.java.capture3;

import java.util.Scanner;

public class BreakMethod {

    /**
     * 中断控制流程
     */

    public static void main(String[] args) {
        System.out.println("测试是否到这");
        lable2: //需要紧跟着while ,然后后面带一个冒号
        while (1<10){
            if (1<2){
                break lable2;
            }
            System.out.println("Test");
        }

        //countinue
        System.out.println("测试countine");
        Scanner in = new Scanner(System.in);
        int sum = 0;
        int goal = 0;
        while (sum<goal){
            if(sum<20){
                continue;
            }
        }
    }
}

