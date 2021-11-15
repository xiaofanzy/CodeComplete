package Chapter_03;

import Chapter_01.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CompareApple {

    public static void main(String[] args) {

        Apple apple = new Apple(100,"红富士","green");
        Apple apple1 = new Apple(100,"红富士","bulue");
        Apple apple2 = new Apple(100,"红富士","red");
        List<Apple> inventory = Arrays.asList(apple,apple1,apple2);

        //方案1
        inventory.sort(new AppleComparator());

        //方案2；
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        //方案3；
        //lambda表达式
        inventory.sort((Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight()) );

        //lambda表达式简化；
        inventory.sort(Comparator.comparing(Apple::getWeight));


        /**
         *   复合lambda表达式的写法
         */

        Comparator<Apple> c = Comparator.comparing(Apple::getWeight);

        //逆序 reversed
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());

        //比较器链  thenComparing 在比较
        inventory.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getVariety));

        //复合写法
        // 1. negate 反转
        List<Apple> a = inventory.stream().filter((Apple a1) -> "red".equals(a1.getColor())).collect(Collectors.toList());
        Predicate<Apple> redApple = (Apple a3)-> "red".equals(a3.getColor());
        Predicate<Apple> notRedApple = redApple.negate();

        //2and 又
        Predicate<Apple> redAndHeavyApple = redApple.and((Apple a4) -> a4.getWeight()>150);

        //3.或者
        //要么是150以上的红苹果，要么是绿苹果
        Predicate<Apple> redAndHeavyOrGreenApple = redApple.and((Apple a5) -> a5.getWeight()>150).or((Apple a6) -> "green".equals(a6.getColor()));

        //函数复合  andThen先算f再算g   compose 先算g后算f
        Function<Integer,Integer> f = x -> x + 1;
        Function<Integer,Integer> g = x -> x * 2;
        int result = f.andThen(g).apply(1); // g(f(x))  先加1 后乘2             //4
        int result2 = f.compose(g).apply(1);   // f(g(x))      先乘2 后加1     //3


        Function<String ,String > addHeader = Letter::addHeader;
        //先做拼写检查，在写角标
        Function<String,String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);

        //这一行就不做拼写检查，只加抬头落款
        transformationPipeline = addHeader.andThen(Letter::addFooter);





    }

    //方案1
     static class AppleComparator implements Comparator<Apple>{

        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    }

    static class Letter{
         static String addHeader(String text){
            return "From Raoul,Mario and Alan: " + text;
        }

        static String addFooter(String text){
             return text +"Kind regrads";
        }

        static String checkSpelling(String text){
             return text.replaceAll("labda","lambda");
        }
    }

}
