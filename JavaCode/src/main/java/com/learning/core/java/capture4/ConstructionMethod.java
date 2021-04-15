package com.learning.core.java.capture4;

public class ConstructionMethod {

    public static void main(String[] args) {

        // 无参构造
        //当类没有构造器的时候，会自动生成一个无参构造器，当类有构造器的情况下，需要显式的生成无参构造器；

        // 显式字段初始化；
        //每个实例字段都需要设置一个有意义的初始值，可以是值，也可以是方法；
        var emplpyees = new Employee();
      //  emplpyees.assignId();
        System.out.println(emplpyees.getId());

        
    }
}

class Employee{
    private static int nextId;
    //private  int id = assignId();

    private int id;

    {
        id = nextId;
        nextId++;
    }



   /* public int assignId(){
        var r = nextId;
        nextId++;
        return r;
    }*/

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
