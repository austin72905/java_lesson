package MutiThread;
import static java.lang.System.*;

public class ThreadLesson {
    public static void main(String[] args) {

        NewThread myt =new NewThread();
        //調用start() 方法
        //其實是調用父類Thread裡 start()
        //這個線程跟 主線程 main() 是不同的
        myt.start(); //會調用 當前線程裡面的 run 方法
        //如果直接調myt.run() 就不是開一個新的線程了，而是都在主線程中執行
        //要開一個新線程，要再實例化一個新對象
        countTo1000();
    }

    public static void countTo1000(){
        for(int i=0;i<1000;i++){
            out.println(i+"***** main()  ****");
        }
    }
    
}

/*
    線程、進程、程序
    併行、併發
   

    線程
    進程裡面的某個執行路徑

    * (棧)stack、程序計數器，是每個線程 都有一份
    * 堆(heap)、方法區 => 是共用的 (存放new 對象、static 對象的地方是共用)

    1. 創建(2kind)、使用
       (1)Thread 類，子類繼承他，需要override 他的run 方法， 實例化子類，調用start() 方法
       (1-1) 使用Runable 接口，需要override 他的run 方法， 實例化子類，將子類傳入new Thread(參數) 構造器參數，調用start() 方法
       (2) 常用方法
           a. start()
           b. run()
           c. getName()
           d. setName() 改名(要再start前)
           e. currentThread() : 靜態，返回當前代碼的線程
           f. yield() 線程止步
           g. join() 當前線程先阻塞，讓join() 進來的線程先執行
           h. sleep() 讓線程暫時停止對CPU的控制，讓其他線程有機會被執行; 有異常會拋出InterruptedException
           i. stop() 強制線程生命週期結束(不推薦)過時勿用
           j. isAlive() 判斷線程是否還活著
       (3) 線程的調度
           a. 時間片方式: 一下執行A 線程 一下  執行B 線程
           b. 搶占式: 高优先級線程搶佔CPU  (高優先級只是有叫高概率搶占道CPU資源，不代表高優先級執行完，才執行低優先級)
       (4) 優先級(10級)，一般都5級
           a. MAX_PRIORITY  (10) 
           b. MIN_PRIORITY  (1)
           c. NORM_PRIORITY (5)
       (5) 獲取、設置優先級
           a. getPriority
           b. setPriority

    2. 生命週期 Thread.State
       (1) NEW
       (2) RUNNABLE : 調完start
       (3) BLOCKED : 阻塞
           a. sleep()
           b. join()
           c. 等待同步鎖
           d. wait()
           e. suspend() 過時了
       (4) WAITING
       (5) TIMED_WAITING
       (6) TERMINATED : 死亡
    3. 線程的同步 (解決線程安全問題)

    4. 線程的通信
    5. JDK5 新增線程創建方式(2kind)
       (1) Callable
       (2) 


    一個JAVA.exe 程序，至少有個三個線程 main()主線程、gc()、義常處理


    進程
    1. 正在運行的一個程序 (動態代碼，有自己的生命周期)
    2. 是資源分配的單位

    程序
    由某種語言編寫的一組指令，一段靜態的代碼

    併行
    多CPU 執行多個任務

    併發
    一個CPU同時執行多個任務

    
*/

class NewThread extends Thread{

    //子類繼承他，需要override 他的run 方法
    @Override
    public void run() {
        for(int i=0 ;i<1000;i++){
            out.println(i+Thread.currentThread().getName());
        }
    }
}