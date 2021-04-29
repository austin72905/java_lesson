package MutiThread;
import static java.lang.System.*;

public class ThreadExample4 {
    public static void main(String[] args) {
        TicketBox4 tb1=new TicketBox4("窗口1");
        TicketBox4 tb2=new TicketBox4("窗口2");
        TicketBox4 tb3=new TicketBox4("窗口3");

        tb1.start();
        tb2.start();
        tb3.start();
    }
}


/*
    ex: 練習 創建三個窗口賣票， 總票數為100張
    synchronized 解決重票問題
    監視器 : 可以用 TicketBox4.class 充當

*/

class TicketBox4 extends Thread{

    //共同賣票 100張
    private static int ticket =100;

    //需要static 
    //因為是創建3個 TicketBox4 實例，如果 obj 不是static 
    //會各自有一份
    static Object obj = new Object();
    //給線程名字
    public TicketBox4(String name){
        super(name);
    }

    @Override
    public void run() {
        while(true){
            //這邊監視器不能用this
            //可以用 TicketBox4.class 充當 (類也是對象，類只會加載一次) 
            synchronized(obj){
                if(ticket>0){

                

                    //sleep 只是要讓他重票問題明顯一點
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
    
                    out.println(getName()+" 窗口，賣票，票号為"+ticket);
                    ticket--;
                }else{
                    break;
                }
            }
            
        }
    }
}