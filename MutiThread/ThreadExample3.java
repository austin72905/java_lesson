package MutiThread;
import static java.lang.System.*;

public class ThreadExample3 {
    public static void main(String[] args) {
        TicketBox3 tb1=new TicketBox3();
        

        Thread t1=new Thread(tb1,"窗口1");
        Thread t2=new Thread(tb1,"窗口2");
        Thread t3=new Thread(tb1,"窗口3");

        

        t1.start();
        t2.start();
        t3.start();
    }
}


/*
    ex: 練習 創建三個窗口賣票， 總票數為100張，以實現 Runnable 接口方式
    通過 同步機制，解決線程安全問題

    方法一
    同步代碼塊
    synchronized(同步監視器){
        //需要被同步的代碼
    }

    說明: 
    1. 操作共享數據的代碼(多線程同步操作的變量)
    2. 同步監視器 (鎖): 任何類的對象都可以充當鎖
       要求:多個線程要共用同一把鎖，可用 this 

    方法二
    同步方法
    如果操作共享數據的代碼完整聲明在一個方法，可以用同步方法
    在方法前面加上 synchronized

    說明:
    1. 使用同步方法不用顯示聲明 同步監視器(鎖)
       (1) 非靜態方法: 鎖 this

       (2) 靜態方法: 鎖 類本身
*/

class TicketBox3 implements Runnable{

    //共同賣票 100張
    //這邊就不用加 static 也會共用
    private int ticket =100;
    //多個線程要共用同一把鎖
    //所以這個obj 不能在run 裡 new
    //位置放錯，代碼不會報錯，但是結果會有bug
    Object obj =new Object();

    @Override
    public void run() {
        while(true){
            //代碼裡面會變成單線程，其他線程需要等，所以效率會降低
            //想像成 裡面的代碼要搶這個鎖，搶到了可以執行，有點像關住廁所門，其他人要等
            //也可用 this 
            synchronized(obj){
                if(ticket>0){

                    //sleep 只是要讓他重票問題明顯一點
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
    
                    out.println(Thread.currentThread().getName()+" 窗口，賣票，票号為"+ticket);
                    ticket--;
                }else{
                    break;
                }
            }
            
        }
    }
}