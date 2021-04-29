package MutiThread;
import static java.lang.System.*;

public class ThreadExample5 {
    public static void main(String[] args) {
        TicketBox5 tb1=new TicketBox5();
        

        Thread t1=new Thread(tb1,"窗口1");
        Thread t2=new Thread(tb1,"窗口2");
        Thread t3=new Thread(tb1,"窗口3");

        

        t1.start();
        t2.start();
        t3.start();
    }
}

/*
     ex: 練習 創建三個窗口賣票， 總票數為100張
     同步方法解決重票問題
*/

class TicketBox5 implements Runnable{

    //共同賣票 100張
    //這邊就不用加 static 也會共用
    private int ticket =100;

    

    @Override
    public void run() {
        while(true){
            sellTicket();

            if(ticket==0){
                break;
            }
        }
    }

    //把操作共享數據的代碼以同步方式呈現
    public synchronized void sellTicket(){ //鎖 為 this
        if(ticket>0){

            //sleep 只是要讓他重票問題明顯一點
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            out.println(Thread.currentThread().getName()+" 窗口，賣票，票号為"+ticket);
            ticket--;
        }

    } 

}