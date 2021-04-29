package Generic_lesson;
import static java.lang.System.*;

import java.util.ArrayList;
import java.util.List;

public class GenericMuti {
    public static void main(String[] args) {
        allFit();
    }

    public static void allFit(){
        List<Object> list1 =new ArrayList<>();
        List<String> list2 =new ArrayList<>();
        //list1=list2; 會報錯

        //通配符
        List<?> list3 =new ArrayList<>();

        list1.add(1);
        list1.add(1);
        list1.add(1);
        //? 可以接納 所有類型
        list3= list1;
        list3=list2;

        out.println(list3);
        //? 不能向內添加數據，除了null

        //只允許讀， 類型為 Object;
        Object val= list1.get(0);
        out.println(val);

    }

    public static void limitFit(){

        //Dog < Animal <Object

        List<? extends Animal> list1 =new ArrayList<>(); // 只能容納 Animal 跟他的子類
        List<? super Animal> list2 =new ArrayList<>(); // 只能容納 Animal 跟他的父類(最大Object)


        //比較組
        List<Object> listO =new ArrayList<>();
        List<Dog> listDog =new ArrayList<>();
        List<Animal> listAnimal =new ArrayList<>();


        //list1 = listO; 會報錯

        list1 = listDog;

        list1 = listAnimal;

        //-------------------
        list2 = listO;

        //list2 = listDog; 會報錯

        list2 = listAnimal;

        out.println(list1);
        out.println(list2);

        //讀取數據
        //型別變成會有限制
        //Animal o = list1.get(0);
        
        //寫入數據
        //list1.add(new Animal()); // 無法寫入， 因為 list1 最大只能裝Animal
        list2.add(new Animal()); 
        

    }
}

/*
    通配符 ?
    
    作用: List<Object>  List<String> 不具有父子關係，這樣如果會需要寫很多的重載方法，為了實現泛型的多態性
        ， 可以用 ? 

    1. 不能向內添加數據，除了null

    限制條件 加上 extends、 super  (不只? 可以加 T 一般泛型也可以加 限制條件)

    1. extends 某類 : T 只能是 某類 跟他的子類

    2. super 某類  : T 只能是 某類 跟他的父類

*/ 

class Animal{

}

class Dog extends Animal{

}