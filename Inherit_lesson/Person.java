package Inherit_lesson;
import static java.lang.System.*;

public class Person {
    String name;
    int age;

    public Person(){
        out.println("person created");
    }

    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public void eat(){
        out.println("p like eat");
    }

    public void sleep(){
        out.println("p like sleep");
    }

    public void haveSex(){
        out.println("Person想愛愛");
    }
}