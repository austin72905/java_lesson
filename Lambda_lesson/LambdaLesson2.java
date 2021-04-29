package Lambda_lesson;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaLesson2 {
    public static void main(String[] args) {
        consumerTest(500, money -> out.println("borrow me " + money)); // borrow me 500.0
        // money-> out.println("borrow me " + money) 就是override 抽象方法 accept

        // 過濾字串
        List<String> list = Arrays.asList("台北", "台中", "高雄", "雲林");
        List<String> filterRes = filterStr(list, s -> s.contains("台")); // 前面的參數s 是要 傳給 pre.test(s) 的參數
        // 其實 抽象方法 pre.test(s) 裡面就是執行s.contains("台")

        out.println(filterRes);
    }

    // 把 @FunctionalInterface 當作方法的參數
    // @FunctionalInterface 裡面只有一個虛擬方法
    // 藉由使用匿名類實體化，實作抽象方法時
    // 達到跟 函數式編成一樣的效果 (把函數當成參數)
    public static void consumerTest(double money, Consumer<Double> consume) {
        consume.accept(money);
    }

    // 過濾字串
    public static List<String> filterStr(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();

        // 遍例傳進來的字串
        for (String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }

        return filterList;
    }

}

/*
 * JAVA內建的四大函數式接口 抽象方法 變形 抽象方法 1. Consumer<T> accept(T args) 2. Supplier<T> T
 * get() 3. Function<T,R> R apply(T args) BiFunction<T,U,R> R apply(T arg1,U
 * arg2) 4. Predicate<T> boolean test(T args) BiPredicate<T,U> boolean test(T
 * arg1,U arg2)
 * 
 */