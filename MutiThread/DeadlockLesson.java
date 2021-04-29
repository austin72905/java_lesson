package MutiThread;

import static java.lang.System.*;

import java.util.concurrent.locks.ReentrantLock;

public class DeadlockLesson {
    public static void main(String[] args) {
        TicketBoxlock tb1 = new TicketBoxlock();

        Thread t1 = new Thread(tb1, "窗口1");
        Thread t2 = new Thread(tb1, "窗口2");
        Thread t3 = new Thread(tb1, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

/*
    死鎖

    原因 : 不同的線程，分別占用對方需要的同步資源不放棄，都在等待對方放棄自己需要的同步資源
    出現死鎖後，不會出現異常，不會出現提示，只是所有的線程都處於阻塞狀態，無法繼續
 
    使用 synchronized 時要避免死鎖

    如果避免: 
    1. 避免使用同步 
    2. 避免同嵌套 
    3. 避免同步(搭配 sleep 很容易)
 
 
    lock 介面 可使用他的實現類 ReentrantLock，顯示當作 同步監視器 (鎖)


    與 synchronized 的差異
    1. synchronized : 執行完代碼塊後，自動釋放 鎖
    2. lock : 需要手動加鎖、解鎖，加鎖如果忘記解鎖會變成同步的代碼

    建議順序
    lock => 同步代碼塊 => 同步方法
*/

/*
     ex: 練習 創建三個窗口賣票， 總票數為100張，以實現 Runnable 接口方式 
     以lock 顯式當作同步監視器 (鎖)，解決重票問題
     1. 建立一個lock 對象
     2. 鎖定方法
     3. 解鎖
*/

class TicketBoxlock implements Runnable {

    // 共同賣票 100張
    // 這邊就不用加 static 也會共用
    private int ticket = 100;

    // 建立一個lock 對象
    private ReentrantLock lock = new ReentrantLock(); // 裡面帶true 先進先出

    @Override
    public void run() {
        while (true) {

            try {
                //鎖定方法
                lock.lock();
                if (ticket > 0) {

                    // sleep 只是要讓他重票問題明顯一點
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    out.println(Thread.currentThread().getName() + " 窗口，賣票，票号為" + ticket);
                    ticket--;
                } else {
                    break;
                }

            } finally {
                //解鎖
                lock.unlock();
            }

        }
    }
}