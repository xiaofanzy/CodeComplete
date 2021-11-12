package Chapter_01;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AppleTest1{

    public static void main(String[] args) {
        Apple apple = new Apple(100,"红富士","green");
        Apple apple1 = new Apple(100,"红富士","bulue");
        Apple apple2 = new Apple(100,"红富士","red");
        List<Apple> apples = Arrays.asList(apple,apple1,apple2);

        // java8之后，测试重量和颜色
        filterApples(apples,AppleTest1::isGreenApple);
        filterApples(apples,AppleTest1::isHeavyApple);

        filterApples(apples,(Apple a) -> "green".equals(a.getColor()));
        filterApples(apples,(Apple a) -> a.getWeight()>150);

        //进一步
        //filter(apples, (Apple a) -> a.getWeight()>150);








    }

    //java8之前
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();

        for (Apple app:inventory
             ) {
            if ("Green".equals(app.getColor())){
                result.add(app);
            }
        }
        return result;
    };

    //查看150克重量；
    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();

        for (Apple app:inventory){
            if (app.getWeight()>150){
                result.add(app);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight()>150;
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for (Apple app:inventory
             ) {
            if (p.test(app)){
                result.add(app);
            }
        }

        return result;
    }

}
