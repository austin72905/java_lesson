package MutiThread;
import static java.lang.System.*;

public class RunnableLesson {
    public static void main(String[] args) {
        NewThread3 nwt3 =new NewThread3();

        Thread t1=new Thread(nwt3);
        //thread.run 在 有傳 Runnable 時，會調用 Runnable 裡的run 方法
        t1.start();
    }
}

class NewThread3 implements Runnable{

    
    @Override
    public void run() {
        for(int i=0 ;i<100;i++){
            out.println(i+Thread.currentThread().getName());
            
        }
        
    }
}

/*
    兩種創建線程方式的差異
    優先選擇Runnable，
    1. 實現方式不受類只能單繼承侷限
    2. 適和處理多個線程共享數據
*/