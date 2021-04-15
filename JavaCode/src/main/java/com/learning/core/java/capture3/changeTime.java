package com.learning.core.java.capture3;

public class changeTime {

    public static void main(String[] args) {
        int i = 12;
        //得到0-12内的整数
        int t = Math.floorMod(i,12);

        System.out.println(t);

        // TT近似值
        System.out.println(Math.PI);
        // E常量近似值
        System.out.println(Math.E);

        int tt = Math.multiplyExact(i*100000000,3);
        System.out.println(tt); //integer overflow integer溢出
    }
}
