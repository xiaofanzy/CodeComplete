package com.learning.core.java.capture5;

import java.util.ArrayList;

public class ManagerTest {

    public static void main(String[] args) {


        var boss = new Manager("Carl Cracker",80000,1987,12,15);
        //方法调用
        /**
         * 1. 编译器查看对象的声明及方法；
         * 2. 编译器要确定方法调用中的参数类型；查找一个与所提供类型完全匹配的方法的过程，这个过程叫做重载解析；
         *      1.方法签名：
         * 3. 如果是Private、static、final方法或者构造器，那么编译器可以准确的知道调用什么方法； 这个叫静态绑定；
         *  在我们的实例中，动态绑定调用一个f(String）的指令；
         *  4. 动态绑定调用方法的时候，必须调用隐式对象调用方法所指向的对象的具体方法，如果在这个对象里面找不到，则会往他的超类查找；
         *    1.首先类在预先加载的时候，计算了一个方法表，然后通过方法和类型去匹配查找这个表就行了；
         *
         *  --- 方法的覆盖：子类的方法不能低于超类方法的可见性；
         *
         *   ---
         *   1. 获取boss类型的方法表；
         *   2.查找定义了getSalary()的方法；
         *   3.虚拟机调用这个方法；
         *
         */
        boss.setBonus(0);

        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker",50000,1989,10,1);
        staff[1] = new Employee("Tommy Tester",40000,1900,3,15);
        staff[2] =boss;

        var elemnt = new ArrayList<>();

        //是否包含关系；
        /**
         * 只有在继承层次内进行强制类型转换
         * 2.超类往子类转换的时候，就是父类--》子类的时候，需要进行Instanceof检查，子类往超类则不需要；
         *
         * x instanceif c 当c为Null的时候，也会放回false ,因为null没有指向任何对象；
         */
        if (staff[1] instanceof Manager) {
            Manager bossss = (Manager)staff[1];
        }
        Manager bosss = (Manager)staff[0];

        //多态：一个对象变量可以指示多种实际类型的现象叫做多态；
        // 在运行时候能够自动选择适当的方法，叫做动态绑定；
        //一个对象的多种方式叫做多态；
        for (Employee e:staff
             ) {
            System.out.println(e.getSalary());
        }
    }
}
