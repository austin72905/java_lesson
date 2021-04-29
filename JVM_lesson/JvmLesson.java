package JVM_lesson;

public class JvmLesson {
    public static void main(String[] args) {
        
    }
}

/*

    JVM 內存
    1. stack

    2. heap (堆)
        (1) 新生區
            (A) 伊甸園區 : 對象都在這被 new 出來
                  Minor GC : 伊甸園滿了，會把沒被引用的對象銷毀，剩餘的往倖存區移動 (逐步往 養老區塞 ， 倖存區滿了 也會執行 Minor GC)

            (B) 倖存區
                (a) 0 區

                (b) 1 區
 
        (2) 養老區
            Major GC : 養老區滿了，執行FULL GC ， 如果內存溢出， 會報  OutOfMemoryError : Java heap space

    3. 方法區 (永久代、元區) PermGen space

        (1) 常量池 : 字符串 

*/