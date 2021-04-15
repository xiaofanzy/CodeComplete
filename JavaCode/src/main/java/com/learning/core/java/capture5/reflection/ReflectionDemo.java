package com.learning.core.java.capture5.reflection;

import com.learning.core.java.capture5.equals.Employee;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;

public class ReflectionDemo {

    public static void main(String[] args) throws Exception {
        /**
         * 如果我们需要知道字段的值，可以使用反射的内容
         * 1.获得class对象，然后调用getDeclaeredField方法获得一个Field对象的值；    填入的是形参；
         * 2. 通过调用field里面的get方法获得字段的值；
         */
        Employee harry = new Employee("Harry", 5000, 1990, 10, 1);

        Class cl = harry.getClass();

        Field f = cl.getDeclaredField("name");
        f.setAccessible(true);      //设置这个属性去覆盖私有属性，不然会报错；
        Object v = f.get(harry);        //Harry
        System.out.println(v);

    }


    public Object getFieldValue(Object obj, String fieldName, MethodHandles.Lookup lookup) throws NoSuchFieldException, IllegalAccessException {

        Class<?> cl = obj.getClass();
        Field field = cl.getDeclaredField(fieldName);

        //可变句柄
        VarHandle handle = MethodHandles.privateLookupIn(cl,lookup).unreflectVarHandle(field);
        return handle.get(obj);
    }
}
