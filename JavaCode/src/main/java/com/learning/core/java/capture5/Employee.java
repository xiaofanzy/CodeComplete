package com.learning.core.java.capture5;

import java.time.LocalDate;

/**
 * final继承的类不允许被继承，方法也是如此，这叫做阻止继承；
 * 如果一个类被申明成final之后，则所有的方法都是final修饰的，但是实例字段不是；
 */
public /*final*/ class Employee {



    private String name;
    private Double salary;
    private LocalDate hireDay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public Employee(String name, Double salary, LocalDate hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public Employee(String name, double salary, int year, int month , int day){

        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
