package MutiThread;
import static java.lang.System.*;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableLesson {
    public static void main(String[] args) {
        NewCount nc=new NewCount();
        FutureTask<Integer> fs =new FutureTask<>(nc);

        Thread t1 =new Thread(fs,"線程1");

        t1.start();

        //獲取值
        //是用 FutureTask 獲取值
        try {
            Integer sum = fs.get();
            out.println("總和為"+sum);
        } catch (Exception e) {
            
        }
       
    }
}

/*
    Callable 
    1. 與 Runnable 相比，可以有返回值
    2. 需要藉助FutureTask 類
    3. 可拋異常
    4. 支持泛型返回值

    FutureTask 是 Runnable、Future 介面的實現類
     

    1. 創建 Callable 的實現類
    2. 實現 Callable 裡的 call 方法
    3. 將Callable 的實現類 的實例， 傳入 FutureTask 實例
    4. 創建一個Thread 實例
    5. get() 返回 call 的返回值


    ex 線程 加到100 並有返回值
*/

class NewCount implements Callable<Integer>{

    //重寫 call
    @Override
    public Integer call() throws Exception {

        int sum=0;
        for(int i=1;i<=100;i++){
            out.println(i);
            sum+=i;

        }
        return sum;
    }
}