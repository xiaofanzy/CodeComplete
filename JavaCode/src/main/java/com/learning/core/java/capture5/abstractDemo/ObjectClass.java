package com.learning.core.java.capture5.abstractDemo;

import java.time.LocalDate;

/**
 * object类
 */
public class ObjectClass {

    public static void main(String[] args) {

        //object对象可以引用任何类型的变量
        Object object = new Employee("Harry",200, LocalDate.of(1981,1,1));



    }
}
