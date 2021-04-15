package com.learning.core.java.capture5.wapper;

import java.util.ArrayList;

public class wapperCLassDemo {

    public static void main(String[] args) {

        //包装类的类型：Integer Long Float Double Byte Short Boolean Charactre
        /**
         * 包装类是final修饰的，不允许有派生类
         */
        //但是一般来说，int[] 数组的使用频率大于数组列表；
        var List = new ArrayList<Integer>();//不允许基本数据类型在数组对象类型中，必须要通过包装类的方式；
        //自动装箱
        List.add(3); //-->会自动装箱程 list .add(Ingeger(3));
        //自动拆箱
        int i = List.get(0);

        //自动拆箱和自动装箱集合
        Integer in  = 3;
        in++;   //想自动拆箱，拆成int理想的，然后在自动装箱；

        Integer in2 = 3;
        if (in == in2) System.out.println("cceshi ");   //false 比较的是内存地址；

        //当包装器为空的时候，可以抛出异常
        Integer t = null;
        //System.out.println(2*t);//  装箱过程会异常   java.lang.NullPointerException
        System.out.println(t);

        // 混合使用的情况，会出现类型提升的现象，
        Double tt = 3.0;
        System.out.println(tt+in2);//in2 先拆箱， 然后提升到double ,然后再装箱；

        //包装类的对象都是不可变的，包装在包装器中的对象内容不会改变，不能使用主席包装器类创建修改数值参数的方法；
        //Ingeger 作为形参参与运算的时候，和Intl类型一致，都不会导致形参发生改变，因为Java是按值传递的，所以形参副本参与运算，而形参本身没有参运算；



    }
}
