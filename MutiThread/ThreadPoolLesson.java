package MutiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static java.lang.System.*;

public class ThreadPoolLesson {
    public static void main(String[] args) {
        ExecutorService serv=Executors.newFixedThreadPool(10);

        //設置線程池屬性
        //用這個實現類才可設置屬性
        ThreadPoolExecutor service = (ThreadPoolExecutor) serv;
        service.setCorePoolSize(15);
        //service.setKeepAliveTime(time, unit);
        //service.setMaximumPoolSize(maximumPoolSize);

        service.execute(new CountNum()); // 適用於 實現 Runnable 的實例
        //service.submit(new CountNum()); // 適用於 Callable

        service.execute(new CountNum1());

        //關閉線程池
        service.shutdown();
    }
}

/*
    線程池
    預先造好一堆線程，放入線程池，使用時獲取，用完放回池中，避免頻繁創建跟銷毀
    需要用到 
    
    ExecutorService 接口
    1. excute() : 適用於 實現 Runnable 的實例會幫忙執行 run 方法
    2. submit() : 適用於 實現 Callable 的實例會幫忙執行 call 方法

    Executors 工具類
    1. newCachedThreadPool : 創建一個可根據需要創建新線程的pool   
    2. newFixedThreadPool : 創建固定線程的pool  (最常用)
    3. newSingleThreadExecutor : 創建一個只有一個線程的pool
    4. newScheduledThreadPool : 創建一個定時延遲後運行or 定期執行的pool

*/


class CountNum implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            if(i%2==1){
                out.println(Thread.currentThread().getName()+"  "+i);
            }
            
        }
    }
}

class CountNum1 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            if(i%2==0){
                out.println(Thread.currentThread().getName()+"  "+i);
            }
            
        }
    }
}