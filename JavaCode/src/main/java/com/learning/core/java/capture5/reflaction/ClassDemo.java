package com.learning.core.java.capture5.reflaction;

import com.learning.core.java.capture5.Employee;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

public class ClassDemo {

    public static void main(String[] args) throws Exception {
        //声明class类的三种方式
        Class c1 = int.class;

        //第二种；

        //String cl2 = "java.util.Random";
       /* try {
            Class cl2 = Class.forName("java.util.Random");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        //第三种
        Employee e = new Employee("tom",1900D, LocalDate.of(1999,1,1));
        Class cl3 = e.getClass();

        /*if (e.getClass() == Employee.class){
            //这个测试通过的条件是 e的类型是Employee,当e为employee的子类的时候，则这个测试不会通过；
            var i = 1;
        }*/

        //可以通过class对象来构建类的实例；
       /* Class cl4 = Class.forName("java.util.Random");
        //newInstance方法会把异常包装到一个InvocationTargetException中；
        Object obj = cl4.getConstructor().newInstance();*/





    }
}
