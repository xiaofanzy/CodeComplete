package com.learning.core.java.capture5.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {

    public static void main(String[] args) {

        int[] a = {1,2,3};
        a = (int[]) goodCopyOf(a,10);
        System.out.println(Arrays.toString(a));

        String[] b = {"tom","Dick","harry"};
        b = (String[]) goodCopyOf(b,10);
        System.out.println(Arrays.toString(b));

        System.out.println("the following call will generate an exception");
        b = (String[])  badCopyof(b,10);

    }

    public static Object goodCopyOf(Object a,int newLength){
        Class cl = a.getClass();
        if (cl.isArray()) {
            return null;
        }

        Class componentType = cl.getComponentType();
        int length = Array.getLength(cl);

        Object newArray = Array.newInstance(componentType, length);
        System.arraycopy(cl,0,newArray,0,Math.min(length,newLength));

        return newArray;
    }

    public static Object[] badCopyof(Object[] a,int newlength){
        var newArray = new Object[newlength];
        System.arraycopy(a,0,newArray,0,Math.min(a.length,newlength));
        return newArray;
    }
}
