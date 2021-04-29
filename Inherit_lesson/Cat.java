package Inherit_lesson;
import static java.lang.System.*;

public class Cat extends Animal{
    int id = 11;
    public void eat(){
        out.println("cat eat");
    }

    public void yield(){
        out.println("cat yield");
    }
}