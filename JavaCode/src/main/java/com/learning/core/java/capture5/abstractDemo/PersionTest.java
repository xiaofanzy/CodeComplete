package com.learning.core.java.capture5.abstractDemo;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PersionTest {



    public static void main(String[] args) {

        var persion = new Persion[2];

        persion[0] = new Employee("tom",200, LocalDate.of(1989,10,1));
        persion[1] = new Students("tom","Computer science");

        //数组对象调用toString方法的时候,使用Arrays.toString， 如果是多层数组则使用Arrays.deepToString()
        System.out.println(persion.toString());
        System.out.println("----------");
        System.out.println(Arrays.toString(persion));

        for (Persion p: persion
             ) {
            // 这时候的 p 变量虽然是Persion 类型的，但是它调用的方法是引用它的子类对象，而不是由Persion里面定义的抽象方法；
            System.out.println(p.getName() + p.getDescription());
        }
    }


}
