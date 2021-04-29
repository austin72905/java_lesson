package MutiThread;
import static java.lang.System.*;

public class ThreadExample {
    public static void main(String[] args) {

        //這樣會有重票的問題
        //要解決線程安全問題
        TicketBox tb1=new TicketBox("窗口1");
        TicketBox tb2=new TicketBox("窗口2");
        TicketBox tb3=new TicketBox("窗口3");

        tb1.start();
        tb2.start();
        tb3.start();
    }
}

/*
    ex: 練習 創建三個窗口賣票， 總票數為100張
*/

class TicketBox extends Thread{

    //共同賣票 100張
    private static int ticket =100;

    //給線程名字
    public TicketBox(String name){
        super(name);
    }

    @Override
    public void run() {
        while(true){
            if(ticket>0){
                out.println(getName()+" 窗口，賣票，票号為"+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}