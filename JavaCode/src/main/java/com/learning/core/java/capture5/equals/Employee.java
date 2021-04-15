package com.learning.core.java.capture5.equals;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {

    private String name;
    private double salary;
    private LocalDate localDate;

    public Employee(String name, double salary,int year,int mounth,int day) {
        this.name = name;
        this.salary = salary;
        this.localDate = LocalDate.of(year,mounth,day);
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

    public LocalDate getLocalDate(int year,int mounth,int day) {
        return LocalDate.of(year,mounth,year);
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void raiseSalary( double byPercent){

        this.salary += this.salary*(1 + byPercent/100);
    }

    //判断是否相等的方法；
    public boolean equals(Object otherObject){

        if (this == otherObject){
            return false;
        }

        if (otherObject == null){
            return  false;
        }

        if (this.getClass() != otherObject.getClass()){
            return false;
        }

        var other = (Employee)otherObject;

        return  Objects.equals(name,other.name) && salary == other.salary && Objects.equals(this.localDate,other.localDate);
    }

    public  int hashCode(){
        return Objects.hashCode(name);
    }

    public String toString(){
        return this.getClass().getName() +"[name="+name+",salary= "+salary +",hiarday=" +this.localDate+"]";
    }
}
