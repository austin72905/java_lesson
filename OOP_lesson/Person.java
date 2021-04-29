package OOP_lesson;

public class Person {
    public static void main(String[] args) {
        System.out.println("x");
        PersonModel aaa =new PersonModel();
        aaa.name="aus";
        aaa.age=10;
        aaa.say();

        PersonModel aaa2 =aaa; // 這樣 兩個 變數指向的都是同個地址
        aaa2.age=15; //也會修改到aaa
        System.out.println(aaa2.age);
        aaa2.show("asas","ddd","aaa");
    }
}

class PersonModel{
    String name ;
    int age ;

    public void say(){
        System.out.println("hi");
    }

    //可變參數
    //必須聲明在末尾  跟 String[] 差不多
    public void show(String ... args){
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
    }
}