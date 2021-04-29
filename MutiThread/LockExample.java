package MutiThread;
import static java.lang.System.*;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {
        Account account =new Account(0);

        Customer cuns=new Customer(account);

        Thread t1=new Thread(cuns,"甲");
        Thread t2=new Thread(cuns,"乙");

        t1.start();
        t2.start();
    } 
}

/*
    ex 有一個帳戶，兩個人分別存錢，每次存1000，存3次，每次存完打印帳戶餘額

    1. 是否是多線程?
       A: 有，有兩個存戶
    2. 是否有共享數據?
       A: 有，帳戶
    3. 是否有線程安全問題?
       A: 有
    4. 如何解決?
       A: 使用同步機制

*/

class Account{
    double balance;

    public Account(double balance){
        this.balance=balance;
    }

    public void saveMoney(double money){
        if(money>0){
            balance+=money;

            //sleep 只是要讓他重票問題明顯一點
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            out.println(Thread.currentThread().getName()+" 存錢成功。 餘額為"+balance);
        }
    }
}

class Customer implements Runnable{

    Account account;

    //如果是用 extends Thread 要記得加 鎖要記得加static
    private ReentrantLock lock =new ReentrantLock();

    public Customer(Account account){
        this.account=account;
    }

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            try{
                lock.lock();
                account.saveMoney(1000);
            }finally{
                lock.unlock();
            }
            
            
        }
        
        
    }
}