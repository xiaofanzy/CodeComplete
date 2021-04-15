package com.learning.core.java.capture5.obectAnalyzer;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class objectAnalyzer {

    private ArrayList<Object> visited = new ArrayList<>();

    private String  toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (visited.contains(obj)) {
            return "...";
        }
        visited.add(obj);
        Class<?> cl = obj.getClass();

        if (cl == String.class) {
            return (String) obj;
        }

        if (cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {

                if (i > 0) {
                    r += ",";
                }
                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive()) {
                    r += val;
                } else {
                    r += toString(val);
                }
            }

            return r + "}";
        }

        String r = cl.getName();

        do {
            r += "{";
            Field[] fields = cl.getDeclaredFields();
        } while (r.equals(null));

        return null;

    }

}
