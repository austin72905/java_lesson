package MutiThread;
import static java.lang.System.*;

public class ThreadExample2 {
    public static void main(String[] args) {
        //也會有重票的問題
        //也有線程安全的問題
        TicketBox2 tb1=new TicketBox2();
        

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
*/

class TicketBox2 implements Runnable{

    //共同賣票 100張
    //這邊就不用加 static 也會共用
    private int ticket =100;

    

    @Override
    public void run() {
        while(true){
            if(ticket>0){
                out.println(Thread.currentThread().getName()+" 窗口，賣票，票号為"+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}