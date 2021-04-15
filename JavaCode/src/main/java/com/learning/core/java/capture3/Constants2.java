package com.learning.core.java.capture3;

import javax.management.MBeanAttributeInfo;

/**
 * 类常量
 */
public class Constants2 {

    public static final double CM_PER_INCH = 2.54;

    public static void main(String[] args) {
        double pagerHight = 8.5;
        double pagerWidth = 11;
        System.out.println("pager size "+ pagerHight*CM_PER_INCH+pagerWidth*CM_PER_INCH);
    }
}
