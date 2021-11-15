package Chapter_03;

import Chapter_01.Apple;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaDemo2 {

    public static void main(String[] args) {

        int number = 1337;
        Runnable r = () -> System.out.println(number);
        //如果Lambda表达式捕获到了局部变量，那么局部变量一定是final的，换句话说，如果一个变量被lambda表达式引用，那么这个变量的值就默认是final的了；不允许被修改了；
        /**
         * 原因式局部变量保存在栈中，而实例变量保存在堆中，lambda表达式实际上访问的式实例变量的副本，而不是访问原始变量，当处于该线程的变量被回收之后，那么下次再去访问变量的地址，指向的就不是原本的值了；
         */
        //number = 1338;

        /**
         * 方法引用；
         *
         */

        Apple apple = new Apple(100,"红富士","green");
        Apple apple1 = new Apple(100,"红富士","bulue");
        Apple apple2 = new Apple(100,"红富士","red");
        List<Apple> inventory = Arrays.asList(apple,apple1,apple2);

        inventory.sort((Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        //方法引用
        inventory.sort(Comparator.comparing(Apple::getWeight));
        /**
         * 1.指向静态方法的引用 Integer::parseInt
         * 2.指向任意类型实例方法的方法引用    String::length
         * 3.指向现有对象的实例方法的方法引用   expensiveTransaction::getValue;
         */
        BiPredicate<List<String>,String> contains = List::contains;

        /**
         * 构造函数引用：
         */

        Supplier<Apple> c1 = Apple::new;    //调用的是无参构造器
        Apple a1 = c1.get();

        Function<Integer,Apple> c2 = Apple::new;    //调用的是有参构造器，这个构造器接受一个Integer参数
        Apple a2 = c2.apply(110);

        List<Integer> weights = Arrays.asList(7,3,4,10);
        List<Apple> apples = map(weights,Apple::new);

        //如果是有参构造器，这个构造器接受颜色，返回一个数量；
        //注意，这个是传入颜色和数量，然后返回一个apple;所以应该是 T,U -> R的格式
        BiFunction<String,Integer,Apple> c3 = Apple::new;

        /**
         * 测试构造函数调用；
         */
        TriFunction<Integer,Integer,Integer, Color> colorFactory = Color::new;

    }

    @FunctionalInterface
    public interface TriFunction<T,U,V,R>{
        R apply(T t,U u,V v);
    }


    static Map<String,Function<Integer,Apple>> map1 = new HashMap<>();



    public static List<Apple> map(List<Integer> list,Function<Integer,Apple> f){

        List<Apple> result = new ArrayList<>();
        for (Integer e:list
             ) {
            result.add(f.apply(e));
        }

        return result;
    };
}
