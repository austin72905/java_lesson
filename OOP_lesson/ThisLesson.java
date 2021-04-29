package OOP_lesson;

public class ThisLesson {
    public static void main(String[] args) {
        Car myCar =new Car("benz",10);
        System.out.println(myCar.getBrand());
    }
}

// this 
// 1. 在"方法"內使用， 表這個方法所屬對象的引用
// 2. 在"構造器"， 表正在初始化的對象

//參數跟屬性同名時就可以用 (this.name = name )

// 有多個 構造器 時 可以用 this( 參數 ) 調用 其他的構造器

class Car{
    //java 參數不能像C# 給預設值...........
    private String brand ;
    private int years ;

    //構造器
    public Car(){
        System.out.println("use constructor");
    }

    public Car(String brand){
        this();
        this.setBrand(brand);
        System.out.println("use 1 params constructor");
    }

    public Car(String brand,int years){
        this(brand);
        this.setYears(years);
        System.out.println("use 2 params constructor");
    }

    public String getBrand(){
        return this.brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public int getYears(){
        return this.years;
    }

    public void setYears(int years){
        this.years = years;
    }

}