package Wrapper_lesson;
import static java.lang.System.*;

public class ConvertLesson {
    public static void main(String[] args) {

        
        int a =10;
        Integer a1 =new Integer(a); // 可以傳字串 ， 但如果不是純數字會報錯
        out.println(a1.toString());

        //bool 包 比較特別 ， 只要傳的是 true (忽略大小寫) => true
        // 其他都是 false
        Boolean b  =new Boolean("dss"); //false
        out.println(b);

        // 如果在 class 裡面 使用包裝類  預設值是null

        // 包裝類 => 基本數據類型 xxxValue
        int a2 =a1.intValue();
        out.println(a2+1);

        //自動裝箱功能、拆箱 不用 new 跟 xxxValue
        Integer b2 =a2;  //自動裝箱
        out.println(b2);
        int a3 =b2; //自動拆箱
        out.println(a3);

        //String 類型的轉換
        String c =String.valueOf(a3);
        out.println(c);

        // string 轉 基本數據
        //無法強轉，因為不是父子類
        int a4 =Integer.parseInt(c);
        out.println(a4);

        //bool 轉換 只要不是傳 true 都會轉換成 false

        //三元運算式 
        // 編譯時 會要求 前後型別一致 Integer、Double
        // 雖然最後是 1 ， 但是會因為後面比較的是Double
        // 結果變成1.0
        Object myobj = a4 ==10 ? new Integer(1) : new Double(2.0);
        out.println(myobj); //1.0
    }
}

// 基本數據類型 型轉不方便 (沒辦法直接toString)

// 有提供各種基本數據的包裝類 (大寫開頭)

// 包裝類 沒辦法 +-*/

// 包裝類 => 基本數據類型 xxxValue

// 自動裝箱功能

//String 類型的轉換