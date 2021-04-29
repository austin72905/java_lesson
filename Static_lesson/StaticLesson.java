package Static_lesson;
import static java.lang.System.*;

public class StaticLesson {
    public static void main(String[] args) {

        //class 被調用時會載入， 執行 static 代碼塊裡的代碼
        Person.breath(); 
        //對象被創建時， 會調用代碼塊裡的代碼
        Person pp = new Person(); //如果上面那行註解調 ， 他也會執行 static 代碼塊裡的代碼
        pp.eat();
        Person.breath(); // 只有第一次載入時，static 代碼塊裡的代碼 才會執行
    }
}

/*
    static 修飾屬性 : 所有對象都共用 ， 存在方法區的靜態域
    早於對象的創建 


    代碼塊 (其實用構造器就好了...)
    1. static : class 被載入時(ex: 有人執行其靜態方法、實體化對象)會執行 裡面的程式碼 (只有第一次載入時)
       (1) 只能調用靜態的屬性、方法

    2. 非靜態: 對象被載入時 會執行 裡面的程式碼
       (1) 不管靜態非靜態都可調用

    3. 可以定義多個， 依先後值型


    對屬性賦值的先後順序

    1. 默認初始化
    2. 顯示初始化 / 在代碼塊中賦值
    3. 構造器中初始化
    4. 有了對象後，通過對象.屬性 進行賦值


*/

class Person{

    // static 代碼塊
    static {
        //作用: 可以初始化class的訊息
        out.println("static block");
    }

    // 代碼塊
    {
        //作用: 可以初始化對象的訊息
        out.println("block Area");
    }

    public void eat(){
        out.println("people like to eat");
    }

    public static void breath(){
        out.println("people like to breath");
    }
}