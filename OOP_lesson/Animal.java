package OOP_lesson;

public class Animal {
    public static void main(String[] args) {
        Ani aa =new Ani();
        Ani aa2 =new Ani();
        aa.setName("da");
        aa2.setName("da2");
        String aaName =aa.getName();
        String aaName2 =aa2.getName();
        System.out.println(aaName);
        System.out.println(aaName2);
    }
}

//沒有加 修铈符  就是同個包 都能訪問

class Ani{
    //java 沒有 C# 的 get 、set 語法糖，只能將 field 設為 private 然後用 public 方法 給值、訪問 來封裝
    private String name;
    private int age;

    //一旦提供顯示的構造器，  系統就不字提供默認的空參數構造器

    public String getName(){
        return name;
    }

    public void setName(String name){
        // this 是指向?
        this.name =name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age) {
        this.age =age;
    }

}

// 如果一個類是 
//1. public
//2. 有無參數的功用構造器
//3. 有屬性、且有對應的get、set 方法

// => 就是一個javabean
//有點像 C# 的 model