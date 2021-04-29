package Abstract_lesson;
import static java.lang.System.*;

public class AbstractLesson {
    public static void main(String[] args) {

        //匿名子類
        //抽象類原本不能覆寫， 但可透過 覆寫 內部的抽象方法 ， 達成一個匿名子類的效果
        Person p = new Person(){
            @Override
            public void eat(){
                out.println("I like to eat");
            };
        };

        p.eat();
        //作用就只是省事
        //不用在 extends 寫一堆
        runEat(new Person(){
            @Override
            public void eat(){
                out.println("I like to eat2");
            };
        });

    }

    public static void runEat(Person p){
        p.eat();
    }


}

/*  
    abstract

    可用來修飾 class  method

    class
    1. 還是有構造器， 要給子類調

    method

    1. 沒有方法體 ，只有方法的聲明
    2. 其屬於的class 一定是abstract 
    3. 若子類 重寫父類所有抽像方法，才可實體化 ， 不然就要把子類聲明為abstract (...怎麼有點像interface)
    4. 不能修飾private 、static 、 final (不然不能重寫)

    匿名子類
    作用: 只使用一次，省事
*/


abstract class Person{

    public abstract void eat();
}