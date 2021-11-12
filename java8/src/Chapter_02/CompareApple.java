package Chapter_02;

import Chapter_01.Apple;
import Chapter_01.AppleTest1;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class CompareApple {

    public static void main(String[] args) {

        Apple apple = new Apple(100,"红富士","green");
        Apple apple1 = new Apple(100,"红富士","bulue");
        Apple apple2 = new Apple(100,"红富士","red");
        List<Apple> inventory = Arrays.asList(apple,apple1,apple2);

        //List<Apple> redAndHeavyApple = filterApples(inventory,new AppleRedAndHeavrPredicate());
        List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());

        prettyPrintApple(inventory,new AppleFancyFormatter());


        // 第五次，匿名内部类
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }

        });

        // 第六次 lambda表达式
        List<Apple> result = filterApples(inventory,(Apple a) -> "red".equals(a.getColor()));

        //第七次 List类型抽象化
        List<Apple> redAppless = filter(inventory,(Apple a) -> "red".equals(a.getColor()));


    }


    //方法1 ，查看苹果
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();

        for (Apple apple:inventory
             ) {
            if ("green".equals(apple.getColor())){
                result.add(apple);
            }
        }

        return  result;
    }

    //方法2 将颜色作为参数传递
    public static List<Apple> filterGreenApplesByColor(List<Apple> inventory,String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory
             ) {
            if(color.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    //方法3
    //定义一个接口
    public interface ApplePredicate{
        boolean test(Apple apple);
    }

    //将删选标准作为布尔值传递
    public class AppleHeavyWeightPredicate implements ApplePredicate{

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    public class AppleGreenColorPredicate implements ApplePredicate{

        @Override
        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }

    //继承不如把方法当作参数传过去
    public static  List<Apple> filterApples(List<Apple> inventory,ApplePredicate p){
        List<Apple> result = new ArrayList<>();

        for (Apple apple: inventory) {
            if (p.test(apple)){
                result.add(apple);
            }
        }

        return  result;

    }


    static class AppleRedAndHeavyPredicate implements ApplePredicate{
        public boolean test(Apple apple){
            return "red".equals(apple.getColor())
                    && apple.getWeight() > 150;
        }
    }

    public interface AppleFormatter {
        String accept(Apple a);
    }

    static class AppleFancyFormatter implements AppleFormatter{

        @Override
        public String accept(Apple a) {
            String characteristic = a.getWeight() > 150 ? "heavy" : "light";
            return "A " + characteristic + " " + a.getColor() + " apple.";
        }
    }

    class AppleSimpleFormatter implements AppleFormatter{

        @Override
        public String accept(Apple a) {
            return "An apple of " + a.getWeight() + " g.";
        }
    }

    public static void prettyPrintApple(List<Apple> inventory,AppleFormatter formatter){

        for (Apple apple : inventory
        ) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }


    //第五次，匿名内部类


    // 第七次，将类型抽象化，利用泛型
    public static <T>  List<T> filter(List<T> list , Predicate<T> p){
        List<T> result = new ArrayList<>();

        for (T e:list
             ) {
            if (p.test(e)){
                result.add(e);
            }
        }

        return result;
    }







}
