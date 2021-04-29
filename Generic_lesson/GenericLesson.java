package Generic_lesson;
import static java.lang.System.*;

public class GenericLesson {
    public static void main(String[] args) {

        // 在使用時，沒有指名類型 ， 會預設變成 Object
        Person<String> per =new Person<String>("Austin",12,"ads");
        out.println(per.orderId);

    }
}

/*
    泛型
    1. 可能有多個參數 可以用 , 分開 <T,T2,T3>
    2. 構造器不用加<>
    3. 泛型不同的引用，不能相互賦值 List<String> xx 不能 賦值給  List<Integer> xx   (兩者不是父子關係，就算是List<Object>)
    3-1. A類 是 B 類 父類 ， A<T>  與  B<T> 具有父子關係
    4. java 的泛型 是假泛型，只有編譯時有用，運行時會擦除
    5. 如果不指定類型， 會被當作 Object
    6. 不能使用基本數據類型(請用包)
    7. 靜態方法中，不能使用類的泛型
    8. 異常類，不能聲明為泛型類


    使用時機
    ex : SQL ORM　一張表對應一個class ，裡面有增刪改查(共同行為) ，就可以用 ， 可以把共同方法用一個 class 管理 ，再個別繼承

*/

//泛型類
//有
class Person<T>{
    String name;
    int age;
    T orderId;

    //這個要寫 不然子類會報 
    //Implicit super constructor Person<String>() is undefined for default constructor. Must define an explicit constructorJava
    public Person(){

    }

    public Person(String name,int age,T orderId){
        this.name = name;
        this.age =age;
        this.orderId = orderId;
    }
}

//子類繼承 帶泛型的父類，如果有指定型別，則實例化子類時，不需再指名泛型

class SubPer0 extends Person<String>{
    public SubPer0(String name,int age,String orderId){
        this.name = name;
        this.age =age;
        this.orderId = orderId;
    }
}

class SubPer<T> extends Person<T>{

    public SubPer(String name,int age,T orderId){
        this.name = name;
        this.age =age;
        this.orderId = orderId;
    }
}
