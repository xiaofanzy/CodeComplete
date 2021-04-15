package com.learning.core.java.capture3;

import javax.management.MBeanRegistration;
import java.util.Scanner;

/**
 * 多重选择：switch语句
 */
public class SwitchMethod {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("you chile in (1,2,3,4,5)");
        int i = scanner.nextInt();

        //switch语句：
        switch (i){
            case 1:
                System.out.println("shabi");
                break;
            case 2:
                System.out.println("fuck");
                break;
            case 3:
                System.out.println("xi-ba");
                break;
            default:
                System.out.println("傻逼");
                break;
        }
    }
}
