package MutiThread;
import static java.lang.System.*;

public class WaitExample {
    public static void main(String[] args) {
        
        RoutePrint r1=new RoutePrint();
        
        Thread t1= new Thread(r1,"線程1");
        Thread t2= new Thread(r1,"線程2");

        t1.start();
        t2.start();
    }
}

/*
    線程通信
    ex : 兩個線程打印 1~100 要交替打印

    使用wait、notify 配合 

    這三個方法都在 Object 類
    1. wait() 調用時，線程阻塞，會釋放鎖 (只能在同步代碼塊、同步方法裡使用)
    2. notify() 會 喚醒 其他 wait() 的線程 (只有兩個線程時使用)
    3. notifyAll() 喚醒 其他 wait() 的線程

    需要是同步監視器調用 (否則報 IllegalMonitorStateException)

*/


class RoutePrint implements Runnable{

    private int number=1;
    @Override
    public void run() {
        
        while(true){

            synchronized(this){

                //喚醒 其他 wait() 的線程 (只有兩個線程時使用)
                notify();

                if(number<=100){

                    //sleep 只是要讓他重票問題明顯一點
                    try {
                        //sleep 會讓線程阻塞，不會釋放鎖
                        Thread.sleep(100);
                    } catch (InterruptedException e ) {
                        e.printStackTrace();
                    }

                    out.println(Thread.currentThread().getName()+" 打印: "+number);
                    number++;


                    //使用wait()
                    try {
                        //this.wait()
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else{
                    break;
                }
            }
        }

        
    }
}