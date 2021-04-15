package com.learning.core.java.capture5;

import java.time.LocalDate;

public  class Manager extends  Employee {

    private double bonus;


    public Manager(String name, Double salary, LocalDate hireDay) {
        super(name, salary, hireDay);
    }

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public Double getSalary(){

        Double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
