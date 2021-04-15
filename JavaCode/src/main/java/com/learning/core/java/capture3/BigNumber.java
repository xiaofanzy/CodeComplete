package com.learning.core.java.capture3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.BiFunction;

public class BigNumber {

    //BigInteger 可以实现任意精度的整数运算 BigDecimal 可以实现任意精度的浮点数计算
    public static void main(String[] args) {
        BigInteger bigInteger = BigInteger.valueOf(100);
        BigInteger zero = BigInteger.ZERO;
        System.out.println(zero);

        //BigInteger 和 BigDecimal 不能使用+/-方法，只能使用add 或者 multiply(积)
        BigInteger sum = BigInteger.ONE.add(BigInteger.TWO);    //和
        BigDecimal multiply = BigDecimal.TEN.multiply(BigDecimal.ONE);  //积
        BigInteger subtract = BigInteger.ONE.subtract(BigInteger.ZERO);//差
        BigInteger divide = BigInteger.TEN.divide(BigInteger.TWO);  //除
        BigInteger mod = BigInteger.TEN.mod(BigInteger.TWO);
        System.out.println(sum);
        System.out.println(multiply);
        System.out.println(subtract);
        System.out.println(divide);
        System.out.println(mod);





    }
}
