package com.learning.core.java.capture5.equals;

import com.learning.core.java.capture5.Manager;

import java.util.Objects;

public class Mananger extends Employee {

    private  double bouns;



    public double getBouns() {
        return bouns;
    }

    public void setBouns(double bouns) {
        this.bouns = bouns;
    }

    public Mananger(String name, double salary, int year, int mounth, int day) {
        super(name, salary, year, mounth, day);
        bouns = 0;
    }

    public String toString(){
        return super.toString() + "bonus+"+bouns+"]";
    }


   /* public boolean equals(Object otherObject){
        var other = (Manager)otherObject;
        return  bouns == other.setBonus(100);
    }*/
}
