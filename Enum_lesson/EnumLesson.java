package Enum_lesson;
import static java.lang.System.*;

public class EnumLesson {
    public static void main(String[] args) {
        out.println(Person.SUCCESS);
        out.println(Person.LSDSD); //LSDSD
        out.println(Person.LSDSD.getVal());
        out.println(Person.class.getSuperclass()); //父類 class java.lang.Enum

        out.println("******* enum method ******");

        out.println("x");
        
    }
}

//他的父類 不是 Object
enum Person {
    // 方法1
    //默認 tostring 打印對象的名字
    Kasi(0) ,
    LSDSD(1),
    WEFSA(2){
        // 也可以在這實作接口
    };

    private final int value;

    //私有構造器給上面對像賦值
    private Person(int value){
        this.value =value;
    }
    //取值
    public int getVal(){
        return value;
    }

    // 方法2
    //比較簡單的用法
    public static final int SUCCESS=0;
    public static final int FAIL=1;
    public static final int SYS_ERR=-1;
}
/*
    enum 類方法

    values() : 返回所有枚舉名稱 的 []
    valueOf("名稱") : 找指定名對象

*/