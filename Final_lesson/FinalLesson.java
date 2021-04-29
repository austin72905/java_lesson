package Final_lesson;

public class FinalLesson {
    public static void main(String[] args) {
        
    }
}

final class NoChick{

    final String ID = "9527";

    public final void cry(){

    }
}

/*
    final

    1. 可用於 class 、 method、 變數

    2. 用於 class : 此class 不能被其他繼承 ex: String、 System

    3. 用於 method : 不可被重寫 ex: Obeject 的 getclass()

    4. 用於 變量 : 代表他是"常數"

    5. 無法 在 方法中 給 final 的屬性 賦值 ， 通過對象調用方法，前提是對象已經實體化， 這時 屬性早就必須有值

    6. static final 修飾屬性: 全局變量

    native 代表 使用 C/C++ 代碼
 */