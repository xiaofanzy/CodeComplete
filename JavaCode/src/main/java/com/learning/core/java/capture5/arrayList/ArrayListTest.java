package com.learning.core.java.capture5.arrayList;

import com.learning.core.java.capture5.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListTest {

    public static void main(String[] args) {

        var staff = new ArrayList<Employee>();

        staff.add(new Employee("cale",25000.0, LocalDate.of(1989,1,1)));
        staff.add(new Employee("cale1",25000.0, LocalDate.of(1989,1,1)));
        staff.add(new Employee("cale1",25000.0, LocalDate.of(1989,1,1)));

        for (Employee e:staff
             ) {
            e.raiseSalary(5);
        }

        for (Employee e:staff
             ) {
            System.out.println("name="+ e.getName() + "salary="+ e.getSalary());

        }

    }
}
