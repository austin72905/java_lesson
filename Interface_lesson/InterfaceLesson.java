package Interface_lesson;

import static java.lang.System.*;

public class InterfaceLesson {
    public static void main(String[] args) {
        Airplain ap =new Airplain();
        Airplain.flow();
        Flyable.flow();


        ap.shoot(); // 類 沒有定義， 但因為定義為 default ，可以通過類 去調用 接口的方法
    }
}


/*
    interface

    1. 如果class 沒有實現 接口所有的方法 ， 該 class 還是個 抽象類
    2. interface 可以繼承多個 interface
    3. 跟abstract class 一樣可以用 匿名接口實現類

    JDK7 以前: 只能定義全局變量、 抽像方法

    (修飾字可以省略)
    1. public static final
    2. public abstract

    JDK 8 : 可以定義靜態方法、默認方法

    1. static : 可以有方法體
    2. default : 可以有方法體， 跟 實現類  裡一般方法一樣... 超沒必要...
    3. 如果繼承的父類 跟 街口 有同名同參數的 方法， 會以 父類优先 (類優先原則)
*/

interface Flyable{
    public static final int MAX_SPEED =60;
    int MIN_SPEED =10 ; //跟上面效果是一樣的

    public abstract void speedUp();

    void speedDown();  //跟上面效果是一樣的

    //JDK8

    // 讓接口更接近類 ...(超奇怪)
    //靜態方法一定要有方法體...
    //只能透過接口調，不是要給你覆寫的
    public static void flow(){
        out.println("I cna flow");
    };

    //默認方法也要有方法體
    public default void shoot(){
        out.println("I cna shoot");
    };
}

class Airplain implements Flyable{
    
    @Override
    public void speedUp(){

    };
    @Override
    public void speedDown(){

    };

    public static void flow(){
        out.println("I cna fly");
    };

    //可以覆寫掉 default
    // public void shoot(){
    //     out.println("plane cna shoot");
    // };
}

