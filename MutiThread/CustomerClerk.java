package MutiThread;
import static java.lang.System.*;

public class CustomerClerk {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer producer =new Producer(clerk);
        Customer1 customer = new Customer1(clerk);
        Thread t1 = new Thread(producer,"生產者");
        Thread t2 = new Thread(customer,"顧客");

        t1.start();
        t2.start();
    }
}

/*
    ex:
    生產者(P)
    店員(Clerk)
    消費者(C)

    產品數量 20

    超過 20 Clerk 會跟 P 說不要生產
    低於 0  Clerk 會跟 C 說等一下
    有產品  Clerk  會跟 C 說來取走商品

    

*/

class Clerk{
    int productNum=0;

    public synchronized void produceProduct(){
        if(productNum<20){
            productNum++;
            out.println(Thread.currentThread().getName() +"開始生產，數量: "+productNum);
            notifyAll();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void buyProduct(){
        if(productNum>0){        
            out.println(Thread.currentThread().getName() +"開始消費，數量: "+productNum);
            productNum--;
            notifyAll();
        }else{

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }

}

class Producer implements Runnable{

    Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        out.println("生產者開始生產");

        while(true){

            //sleep 只是要讓他重票問題明顯一點
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            clerk.produceProduct();
        }

        
        
    }
}


class Customer1 implements Runnable{

    Clerk clerk;

    public Customer1(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        out.println("顧客開始消費");

        while(true){

            //sleep 只是要讓他重票問題明顯一點
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            clerk.buyProduct();
        }
        
    }
}