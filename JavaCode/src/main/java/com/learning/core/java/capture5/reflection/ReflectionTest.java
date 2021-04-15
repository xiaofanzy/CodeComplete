package com.learning.core.java.capture5.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {

    public static void main(String[] args) throws Exception {
        String name;

        if (args.length >0 ){
            name = args[0];
        }else {
            var in = new Scanner(System.in);
            System.out.println("Enter class name (e.g java.util.Date): ");
            name = in.next();
        }

        Class cl = Class.forName(name);
        Class supercl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        if (modifiers.length()>0) {
            System.out.print(modifiers+" ");
        }

        System.out.print("Class "+ name);

        if (supercl != null  && supercl != Object.class){
            System.out.println("Extends "+ supercl.getName());
        }

        System.out.print("\n{\n");



    }

    public static void printConstructors(Class cl){

        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c: constructors
             ) {
            String name = c.getName();
            System.out.println("     ");

           String modifier =  Modifier.toString(c.getModifiers());
            if (modifier.length() >0) {
                System.out.print(modifier + " ");
            }
            System.out.println(name +"(");

            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i <paramTypes.length ; i++) {

                if (i == 0) {
                    System.out.print(",");
                    System.out.print(paramTypes[i].getName());
                }
            }
            System.out.println(");");
        }
    }

}


