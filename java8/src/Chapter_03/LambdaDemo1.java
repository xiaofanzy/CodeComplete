package Chapter_03;

import Chapter_01.Apple;
import Chapter_02.CompareApple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaDemo1 {

    public static void main(String[] args) {

        //lambda表达式初探
        /**
         * 特点：
         * 1.匿名
         * 2.函数 参数列表 函数主体，返回类型
         * 3.传递 作为参数传递给方法或者存储在变量中
         * 4.间接 无需匿名些代码模板
         */

        //可以作为lambda表达式的返回值类型；
        /**
         * 1.布尔表达式 () -> list.isEmpty();
         * 2.创建对象 () -> new Apple(10);
         * 3.消费一个对象 () -> System.out.println(a.getWeight);
         * 4.调用一个对象的方法 () -> s.length();
         * 5.组合两个值 (a,b) -> a+b;
         * 6. 比较两个对象 (Apple a,Apple b) -> (a.length().compareTo(b.length()));
         */

        Apple apple = new Apple(100,"红富士","green");
        Apple apple1 = new Apple(100,"红富士","bulue");
        Apple apple2 = new Apple(100,"红富士","red");
        List<Apple> inventory = Arrays.asList(apple,apple1,apple2);

        //
        List<Apple> greenApples = filter(inventory, (Apple a) -> "green".equals(a.getColor()));

        //函数式接口作用；

    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    interface ApplePredicate{
        public boolean test(Apple a);
    }
}
