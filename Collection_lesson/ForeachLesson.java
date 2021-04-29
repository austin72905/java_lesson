package Collection_lesson;

import java.util.ArrayList;
import java.util.Collection;
import static java.lang.System.*;

public class ForeachLesson {
    public static void main(String[] args) {
        foreachMethod();
    }

    public static void foreachMethod(){
        Collection<Object> col =new ArrayList<Object>();
        col.add(123);
        col.add("abc");
        col.add("abc");
        col.add("bcd");

        // 好用 就用他吧
        
        for(Object obj : col){
            
            out.println(obj);
        }

        String[] arr =new String[]{"a","ss","vv"};
        // 這種方法沒辦法改變值 
        for(String i : arr){
            i = "sdasd";
        }

        for(int i=0;i<arr.length;i++){
            out.println(arr[i]);
        }
    }
}

/*
    Foreach 可以用來遍例

    底層還是調用 Iterator
*/