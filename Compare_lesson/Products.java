package Compare_lesson;

//Comparable is a raw type. References to generic type Comparable<T> should be parameterized
//解決 : https://www.quora.com/When-use-comparable-in-Java-why-the-Comparable-is-a-raw-type-References-to-generic-type-Comparable-T-should-be-parameterized-information-show-up
// 實作 : Comparable 必須用這種寫法，讓他在編譯時就檢查型別是否錯誤，不能只實現 Comparable 接口
public class Products implements Comparable<Products>{
    String name;
    int price;

    public Products(){

    }

    public Products(String name,int price){
        this.name =name;
        this.price =price;
    }

    // 自訂義排序方法

    // @Override
    // public int compareTo(Object obj){
    //     if(obj instanceof Products){
    //         Products pro =(Products)obj;
    //         if(this.price > pro.price){
    //             return 1;
    //         }else if(this.price < pro.price){
    //             return -1;
    //         }else{
    //             return 0;
    //         }

    //         //方式2 跟上面那串效果一樣
    //         //return Double.compare(this.price, pro.price);
    //     }

    //     throw new RuntimeException("傳入數據不一致");
    // }

    //新版實現 Comparable 寫法
    @Override
    public int compareTo(Products obj){
        
        Products pro =(Products)obj;
        if(this.price > pro.price){
            return 1;
        }else if(this.price < pro.price){
            return -1;
        }else{
            return 0;
        }

        //方式2 跟上面那串效果一樣
        //return Double.compare(this.price, pro.price);
        
    }

    @Override
    public String toString(){
        return "name :"+this.name +" prcie :"+this.price;
    }
}