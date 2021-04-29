package Inherit_lesson;
import static java.lang.System.*;

public class ObjectLesson {
    public static void main(String[] args) {
        Order order =new Order();
        // 反射  獲取父類
        out.println(order.getClass().getSuperclass()); //class java.lang.Object

        
        
    }
}

class Order{

}

/*
    Object

    1. 只有一個 空參構造器

    方法
    1. clone 可以複製一個新的物件  =>要實作 cloneable
    2. equals 
    3. finalize 當沒有任何引用指向他，就會調用他，讓他GC (不要主動調，讓系統自己回收)   另一個 System.gc() 強制釋放空間
    4. getClass 獲取當前對象所屬類
    5. toString
    6. hashCode


    equals 跟 == 差異

    == 
    1. 是一個運算符
    2. 在基本數據類型， 比較的是保存的數據是否相同， 類型不一定要相同
    3. 引用類型: 比較的是地址值

    equals

    1. 是一個方法
    2. 不能使用於 基本數據類型
    3. 內部還是調用 ==  
    4. String、Date、File 都重寫過 equals ， 不再是比較地址，而是比較實體內容 (所以要比較值最好用equals)

    toString

    1. 當輸出一個對象的引用， 實際會調用 toString 
    2. String、 Date、 File 都重寫了 toString 的方法
    3. 自訂義類也可以覆寫toString

*/