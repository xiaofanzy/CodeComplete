package Chapter_03;

import Chapter_01.Apple;
import Chapter_02.CompareApple;

import java.beans.Customizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.*;
import java.util.stream.Stream;

public class LambdaDemo1 {

    public static void main(String[] args) throws IOException {

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

        //函数式接口作用；允许以内连的方式为函数式接口的抽象方法提供实现，并将整个表达式作为函数时接口的实例，就是函数式接口的唯一一个具体类的实现；
        //匿名内部类的方式也可以实现同样的操作，但是比较笨拙；
        //Runnable 不接受参数，不返回结果；
        //！！！只要是接收lambda表达式或者接收一个函数式接口作为参数的方法。都可以作为Lambda表达hi是的载体；
        Runnable r1 = () -> System.out.println("Hello world 1");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world 2");
            }
        };

        //测试
        process(r1);
        process(r2);
        process(() -> System.out.println("Hello world 3"));

        //实例的例子中只能读取一行，如果读取两行，可以使用Lambda表达式；因为将操作作为参数化传递；
        String result = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        //如果处理一行
        result = processFile((BufferedReader br) -> br.readLine());


        //函数式接口介绍
        /**
         * predicate 接收一个T类型的对象，返回一个boolean；
         * filter 接受的是T类型的参数，然后接受一个pridicate的参数，这个参数接受一个T类型的对象，然后返回一个布尔值；
         */
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        //List<String> nonEmpty = filter(lissOfString,nonEmptyStringPredicate);

        /**
         * Consumer 接受一个T类型的对象，没有返回值
         */
        forEach(Arrays.asList(1,2,3,4,5),(Integer i) -> System.out.println(i));

        /**
         * Function 接受一个泛型T的对象，并返回一个泛型R的对象
         */
         List<Integer> l = map(Arrays.asList("lambda","in","Action"),(String s) -> s.length());

        //特例，什么是特例，就是将常用的数据类型，为了避免装箱发生的开销，则复写了这个方法；
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;   //这种不需要装箱操作；
        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;  //装箱

        /**
         * 总结：
         * Consumer<T>      接受一个T类型的对象，返回一个void;
         * Function<T,R>    接受一个T类型的对象，返回一个R类型的对象
         * Predicate<T>    接受一个T类型的对象，返回一个boolean类型的对象
         * Supplier<T>     不接受参数，返回一个T类型的对象；
         * UnaryOperation<T>    接受一个参数，返回一个同类型的参数；
         * BinaryOperation<T>   接受两个同类型的参数，返回一个同类下的参数 <T,T> -> <T>
         * BiPredicate<L,R>      接受两个对象<L,R>,返回一个boolean类型的对象；
         * BiConsumer<T,U>      接受两个对象<T,U> ,不反悔参数
         * BiFunction<T,U,R>    接受两个参数，返回一个R类型的参数；
         */

        //异常的情况，如果有存在异常的情况，但是默认的函数式接口没有throws 或者trycatch方法，所以可以包一层
        Function<BufferedReader,String> f = (BufferedReader s) -> {
            try {
                return s.readLine();
            } catch (IOException e) {
               throw new RuntimeException(e);
            }
        };

        /**
         * 类型检查，类型推断和类型限制；
         *
         * 1.类型检查：
         *
         */
         List<Apple> heavierThan150g = filter(inventory,(Apple a) -> a.getWeight()>150);

         //同样的lambda,不同的函数时接口；
        Callable<Integer> c = () -> 42;
        PrivilegedAction<Integer> p = () -> 42;

        Comparator<Apple> c1 = (a1,a2) -> a1.getWeight().compareTo(a2.getWeight());
        ToIntBiFunction<Apple,Apple> c2 = (a1,a2) -> a1.getWeight().compareTo(a2.getWeight());
        BiFunction<Apple,Apple,Integer> c3 = (a1,a2) -> a1.getWeight().compareTo(a2.getWeight());

        //特殊的void兼容规则
        //Predicate<String> p1 = s -> list.add(s);  主体返回boolean
        //Consumer<String> b = s -> list.add(s);    主体返回void

        //其实本质上，就是如果一个函数式接口，符合lambda表达式的返回值类型，就可以套用lambda表达式，特殊的情况是一个返回值的和没有返回值的可以公用一个lambda表达式
        Runnable o = () -> System.out.println("Hello,My world");

        /**
         * 类型推断：就是可以省略类型名；
         */

        List<Apple> greenApplees = filter(inventory,a -> "green".equals(a.getColor()));

        /**
         * 使用局部变量
         */
        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);



    }

    public static void process(Runnable r){
        r.run();
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

    //实例，环绕执行模式
    public static String processFile() throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return br.readLine();
        }
    }

    //定义了一个函数式接口，这个接口的作用就是读一行数据
    @FunctionalInterface
    public interface BufferReaderProcess{
        String process(BufferedReader b) throws IOException;
    }


    //定义了一个方法，接收函数式接口；输出读一行数据的值；
    public static String processFile(BufferReaderProcess p) throws  IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return  p.process(br);
        }

    }

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for (T i: list
             ) {
            c.accept(i);
        }
    }

    public static <T,R>  List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for (T s:list
             ) {
            result.add(f.apply(s));
        }
        return result;
    }
}
