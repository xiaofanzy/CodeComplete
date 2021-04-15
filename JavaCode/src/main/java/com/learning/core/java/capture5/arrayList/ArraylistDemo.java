package com.learning.core.java.capture5.arrayList;

import com.learning.core.java.capture5.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class ArraylistDemo {

    public static void main(String[] args) {

        var staff = new ArrayList<Employee>();

        // 如果能够估计数量的话，可以使用ensureCapacity方法，减小开销，如果超过也会扩容
        //staff.ensureCapacity(100);

        var staff2 = new ArrayList<Employee>(100);

        //数组列表和数组的区别
        //数组列表里面定义的数组个数大小，代表的事容量大小为数组个数的数组列表，可以扩大，列表中不包含任何元素；
        //而数组里面则是定义了数组个数的空槽，空位置槽的个数确定了；
        var employees = new ArrayList<>(100);   //数组列表
        var emplpyees2 =  new Employee[100]; //数组

        //返回个数
        var emSiz = employees.size();

        //trimToSize锁定列表大小；
        //employees.trimToSize();

        //set 方法是替换数组列表元素，add方法是增加数组列表的元素
        //add方法在添加的时候，不会出错，就是不是找个类型的也没问题；
        staff.add(new Employee("name",12.0, LocalDate.of(1998,1,1)));
        for (Employee e:staff
             ) {
            System.out.println(e.getName());
        }
        System.out.println("----------");
        staff.set(0,new Employee("name1",12.0, LocalDate.of(1998,1,1)));
        for (Employee e:staff
        ) {
            System.out.println(e.getName());
        }

        //使用get来获取元素
        System.out.println(staff.get(0));



    }
}
