package Inherit_lesson;


import static java.lang.System.*;

public class Animal {
    String name ;
    int id = 10;
    int age;
    public void eat(){
        out.println("animal eat");
    }

    public void yield(){
        out.println("animal yield");
    }

    //equals 的從寫
    //重寫成 比較 內部的值，而不是比較地址
    @Override
    public boolean equals(Object obj){

        //如果是同個對象(地址相同) ，返回true
        if(this == obj){
            return true;
        }

        
        if(obj instanceof Person){
            //先型轉才比較
            Person temp =(Person) obj;

            //如果是比較string 要用 equals ， 用 == 會變成比地址
            return this.age == temp.age && this.name.equals(temp.name);
        }
        return false;
    }
    //eclipse 可自動生成equals
}