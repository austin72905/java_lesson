package Inherit_lesson;
import static java.lang.System.*;


public class Dog extends Animal{
    int id = 12;
    public void eat(){
        out.println("dog eat");
    }

    public void yield(){
        out.println("dog yield");
    }

    public void bark(){
        out.println("dog bark");
    }
}