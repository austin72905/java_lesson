package Compare_lesson;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.*;

public class CompareLesson {
    public static void main(String[] args) {
        //sortProducts();
        sortProductsDesc();

        
    }

    public static void sortProducts(){
        Products[] arr = new Products[]{
            new Products("紅茶",34),
            new Products("綠茶",30),
            new Products("冬瓜茶",20),
            new Products("麥茶",45),
        };

        Arrays.sort(arr);
        out.println(Arrays.toString(arr));
        
    }

    public static void sortProductsDesc(){
        String[] arr =new String[]{"city","amount","record","bank","attach","memberid"};
        //自訂義排序方式 ex: 倒敘
        // java 的接口 可以 new...
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String str1,String str2){
                return - str1.compareTo(str2); // 負號 代表到序 
            }
        });
        out.println(Arrays.toString(arr));
    }

}

/*
    java 比較器

    讓對象比大小(排序)
    使用 Compareable (自然排序)、 Comparator (訂製排序) 接口
    重寫了 compareTo 方法
    規則: 
    > 返回 正數
    < 返回 負數
    = 返回 零

    Compareable 一勞永逸
    Comparator  臨時比較

    
*/