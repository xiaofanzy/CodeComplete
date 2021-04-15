package com.learning.core.java.Capture6.interfaces;

import java.math.BigDecimal;
import java.util.Arrays;

public class EmployeeTest {

    public static void main(String[] args) {

        var staff = new Employee[3];

        staff[0] = new Employee("Harry",35000);
        staff[1] = new Employee("Carl",75000);
        staff[2] = new Employee("Tony",38000);

        Arrays.sort(staff);

        //查看类是否实现了某一接口
        System.out.println(staff[0] instanceof Comparable);

       /* for (Employee e:staff
             ) {
            System.out.println("name="+e.getName());
        }*/

        //测试bigDecimal案例
        BigDecimal bigDecimal = new BigDecimal("1.0");
        BigDecimal bigDecimal1 = new BigDecimal("1.00");
        System.out.println(bigDecimal.compareTo(bigDecimal1));
        System.out.println(bigDecimal.equals(bigDecimal1));


    }
}
