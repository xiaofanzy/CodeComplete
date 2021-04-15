package com.learning.core.java.capture5;

import java.time.LocalDate;

public class Students1 extends Person {

    private double salary;



    public Students1(String name,double salary1) {
        super(name);
        this.salary = salary1;
    }

    @Override
    public void raiseSalary(double byPercent) {
        this.salary = super.getSalary()*(1+byPercent/100);
    }

    public static void main(String[] args) {
        //抽象类不能被实例化；
        //var persion = new Person();
        //但是可以定义一个抽象类的对象变量 但是抽象类不能被实例化；
        Person p = new Students1("ceshi",200);
    }
}
