package Lambda_lesson;

import static java.lang.System.*;

import java.util.Comparator;

public class LambdaLesson {
    public static void main(String[] args) {

        // 匿名物件 實作 介面
        Operate op = new Operate() {
            @Override
            public void printMyName() {
                out.println(" I love big class");
            }
        };
        op.printMyName();

        // Lambda (函數式街口的實例)
        // "接口"的實例 ... 跟其他語言不一樣

        // 類型1 不用參數
        // 如果只有一個語句，後面{} 可省
        // 只有 return ， return 也可省
        Operate op1 = () -> out.println(" I love big class");
        op1.printMyName();

        // 類型2 有參數
        Plus<String> pl = (String co) -> out.println(" I love big" + co);
        pl.printMyName("gigi"); // I love biggigi

        // 類型3 參數類型推斷
        Plus<String> pl2 = (co) -> out.println(" I love big" + co);
        pl2.printMyName("lanpa"); // I love biglanpa

        // 類型4 只需要一個參數時 ， 參數小誇号可省
        Plus<String> pl3 = co -> out.println(" I love big" + co);
        pl3.printMyName("nene"); // I love bignene

        // 類型5 執行不只一個語句，且有返回值
        Comparator<Integer> cp = (num1, num2) -> {
            out.println(num1);
            out.println(num2);
            out.println(" who is bogger");
            return num1.compareTo(num2);
        };

        out.println(cp.compare(2, 3));
    }
}

/*
    JDK8
  
    jjs js文件 => 可以在JVM上跑JS 代碼
  
  
    Lambda 箭頭涵式 
    1. 使用方法: ()-> 
    2. 其他語言Lambda 是匿名函數，JAVA裡面是 "接口"的實例 
    3. 參數類型他會自行推斷，可省
    4. 限制: 使用的接口只能有"一個"抽象方法 (也稱函數是接口) @FunctionalInterface
    

    

    方法引用 ::
  
*/
@FunctionalInterface
interface Operate {

    public abstract void printMyName();
}
@FunctionalInterface
interface Plus<T> {

    public abstract void printMyName(T args);
}