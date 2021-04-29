package Inherit_lesson;
import static java.lang.System.*;

public class InheritLesson {
    public static void main(String[] args) {
        Student stu =new Student("austin",26,"math");
        out.println(stu.name);
        stu.haveSex();
        stu.exam();

        //多態性
        Animal dog1 =new Dog();  // 雖然聲明為 父類 Animal ， 但運行時實際是執行子類
        dog1.eat(); //dog eat 
        Animal cat1 =new Cat();
        cat1.eat(); //cat eat

        //作用: 減少多載的使用
        //方法參數定為 Animal ， DOG、 CAT 都能使用，會各自執行 自己的 eat、yield 方法
        func(dog1);
        func(cat1);

        //多態不適用於 屬性
        out.println(dog1.id); // 10  都是訪問到 Animal 的 id 
        out.println(cat1.id); // 10

        // instanceof
        //如何才能調用子類? (強制型轉) 使用時要注意 可能出現異常 ，要看原本 new 哪個子類
       // 如何判斷是哪個子類? instanceof
        if(dog1 instanceof Dog){
            Dog dog2=(Dog)dog1;
            dog2.bark();
        }
        
    }

    // 可以依照傳入的參數 類型(dog、cat)， 決定要執行的方法
    public static void func(Animal animal) {
        animal.eat();
        animal.yield();
    }

}

class Student extends Person{
    String major;

    public Student(){

    }

    public Student(String name,int age,String major){
        // 就算不寫 super() 他也會偷偷調用
        this.name=name;
        this.age=age;
        this.major=major;
    }

    public void study(){
        out.println("s like study");
    }

    // @Override 可加可不加 ，加了 編譯器會幫你檢查 是否有正確的重寫了父類
    @Override
    public void haveSex(){
        out.println("Student想愛愛");
    }

    public void exam(){
        out.println("Student exam");
        super.haveSex();
    }
}

/*
    繼承
    1. 父類宣告為private 的屬性、方法 ， 子類能獲取， 但是 沒辦法直接調用
    2. 無法多重繼承
    3. 所有的class 都繼承  java.lang.Object 類


    重寫
    1. 當實體化 子類， 當子類調用父類中同名同參數方法時，實際執行的是子類覆寫的方法
    2. 修飾符 不能小於 父類 (private => 沒寫 => protected => public)
    3. 返回值
       (1) 父類 void : 子類也只能是void
       (2) 父類 返回是 A class : 子類只能是 A or A 的子類
       (3) 父類 返回是 基本數據類型 : 子類 只能是 相同的數據類型   (double 不是 int 的子類 !! 是並列關係) 
       (4) 子類 重寫的 throws 異常的類型， 不能大於 父類拋出的異常類型
       (5) 非 static 才能重寫 
    4. 屬性不存在重寫
    
    super

    1. 可以調用父類的 方法 、屬性
    2. 跟 C# 的 base 一樣
    3. 屬性不存在重寫
    4. super(參數) 可以調用 父類的構造器
    5. 跟this() 一樣須聲名在子構造器的首行 ， 不能this()、 super() 同時出現 
    6. 沒有顯示聲明時， 默認調用 父類的 空參 構造器 super()
    
    
    子類對象實體化過程
    1. 為什麼可以獲取 父類屬性? (因為 子類實體化會默認調用 super())， 雖然調用super()，但只有創造一個對象
    2. 調用完 會加載所有父類中聲明的屬性


    多態性

    1. 聲明 父類 xxx = new 子類();
    2. 雖然聲明為 父類 ， 但運行時實際是執行子類 "重寫" 父類的方法 --- 虛擬方法調用
    3. 作用: 可以減少重載的使用
    4. 使用多態性前提
       (1) 子類要重寫父類的方法
    5. 多態不適用於 屬性

    6. 內存 父類 xxx = new 子類();  
       stack : 父類 xxx  
       heap  :　new 子類　， 所以內從 也有 子類的屬性跟方法 
       但因為聲明的 xxx 為父類 ， 所以 heap 裡 子類的資訊被屏蔽掉，不能調用
       如何才能調用子類? (強制型轉) 使用時要注意 可能出現異常 ，要看原本 new 哪個子類
       如何判斷是哪個子類? instanceof

    虛擬方法

    1. 子類定義了與父類同名同參數的方法 ， 在多態情形下 ， 將此時父類的方法稱為虛擬方法 (寫的是他，IDE 提示也是調用他，但運行時是運行子類的)

    instanceof 檢驗 是否是 某類 (return bool)
       
*/