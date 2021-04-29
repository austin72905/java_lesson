package MutiThread;
import static java.lang.System.*;

public class ThreadMethod {
    public static void main(String[] args) {
        NewThread2 nwt=new NewThread2();
        nwt.setName("myThread 1");
        //設定線程優先級
        nwt.setPriority(Thread.MAX_PRIORITY);
        nwt.start();

        //給主線程命名
        Thread.currentThread().setName("main thread");
       
        for(int i=0;i<100;i++){
            out.println(i+"***** main()  ****"+Thread.currentThread().getPriority());
            //主線程執行到50
            //讓nwt.join()，主線程被阻塞，等nwt執行完
            if(i==50){
                try {
                    nwt.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
           
        }
        //看調用的線程是否還活著
        out.println(nwt.isAlive());
    }

    
}

class NewThread2 extends Thread{
    @Override
    public void run() {
        for(int i=0 ;i<100;i++){
            out.println(i+Thread.currentThread().getName());
            //暫時中止此線程的執行權，讓其他線程有機會搶到
            if(i==20){
                yield();
            }
            if(i==50){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        }
    }

    //也可用構造器命名
    // public NewThread2(String name){
    //     //調用父類的一參構造器
    //     super(name);
    // }
}