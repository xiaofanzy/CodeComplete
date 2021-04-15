package com.learning.core.java.capture3;

import java.util.Arrays;

public class ForEachMethod {

    /**
     * for each循环
     * @param args
     */
    public static void main(String[] args) {

        //基本格式
        /**
         * colleciton 必须是一个实现了Iterable接口的对象；
         *
         * for ecah 对象遍历的是数组里面的多个元素，而不是下标值，for循环则是通过下标去获取对象；
         * 更简单的是使用Arrays
         */
        //for (uarialbe : colleciton) statement;
       int[] a = {1,2};
        for (int element:a
             ) {
            System.out.println(element);
        }

        System.out.println(Arrays.toString(a));
        
    }
}
