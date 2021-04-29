package Generic_lesson;

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.*;

public class GenericIfce {
    public static void main(String[] args) {
        Person1<Integer> per =new Person1<>("austin",10,10388);
        Integer[] arr = new Integer[]{1,2,3,4};
        List<Integer> aa= per.converArrToList(arr);
        out.println(aa);
    }
}

/*
    泛型接口 .. 跟類差不多，差再不能實體化

    泛型方法
    1. 不是參數有 t 就是范型方法 (不一定所屬的類要是泛型)
    2. 泛型參數與類的參數沒有關係
    3. 需要在方法前面加上 <T> ,編譯器才知道這是一個泛型方法
    4. 可以加 static
*/

class Person1<T>{
    String name;
    int age;
    T orderId;

    //這個要寫 不然子類會報 
    //Implicit super constructor Person<String>() is undefined for default constructor. Must define an explicit constructorJava
    public Person1(){

    }

    public Person1(String name,int age,T orderId){
        this.name = name;
        this.age =age;
        this.orderId = orderId;
    }

    //泛型方法
    public <C> List<C> converArrToList(C[] arr){
        ArrayList<C> list =new ArrayList<C>();

        for(C val : arr){
            list.add(val);
        }

        return list;
    }
}