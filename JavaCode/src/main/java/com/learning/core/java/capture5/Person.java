package com.learning.core.java.capture5;

import java.time.LocalDate;

/**
 * 抽象类，用abstract修饰的类，叫做抽象类
 */
public abstract class Person {

    private String  name ;
    private double salary;

    private int age;
    private LocalDate hireDay;

    //抽象方法修饰的类不能有方法体
    public abstract void raiseSalary(double byPercent);

    //构造方法不允许抽象关键词修饰；
    public  Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }
}
