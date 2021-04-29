package MutiThread;

import static java.lang.System.*;

public class ThreadExample6 {
    public static void main(String[] args) {
        TicketBox6 tb1=new TicketBox6("窗口1");
        TicketBox6 tb2=new TicketBox6("窗口2");
        TicketBox6 tb3=new TicketBox6("窗口3");

        tb1.start();
        tb2.start();
        tb3.start();
    }
}

/*
    ex: 練習 創建三個窗口賣票， 總票數為100張 
    使用同步方法 解決 重票問題
*/

class TicketBox6 extends Thread {

    // 共同賣票 100張
    private static int ticket = 100;

    // 給線程名字
    public TicketBox6(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            sellTicket();

            if(ticket==0){
                break;
            }
        }
    }

    //把操作共享數據的代碼以同步方式呈現
    public static synchronized void sellTicket(){ //鎖 為 TicketBox6.class
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