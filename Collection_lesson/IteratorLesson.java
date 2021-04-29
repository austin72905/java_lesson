package Collection_lesson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static java.lang.System.*;

public class IteratorLesson {
    public static void main(String[] args) {
        iteratorArr();
    }

    public static void iteratorArr(){
        Collection<Object> col =new ArrayList<Object>();
        col.add(123);
        col.add("abc");
        col.add("abc");
        col.add("bcd");

        //遍例
        Iterator<Object> iter = col.iterator(); // 每次調用 col.iterator() 會產生一個 新的 迭代器對象
        while(iter.hasNext()){  // 不要寫程  iter.next() !=null   這樣指針會直接下移，而漏打印
            out.println(iter.next());
        }

       
        
        iter = col.iterator();
        while(iter.hasNext()){
            Object obi =iter.next();
            if(obi.equals("abc")){
                iter.remove();
            }else{
                out.println(obi);
            }

        }

    }
}

/*
    Iterator(迭代器) 用於歷遍 Collection

    指針往下移，就不會回來了

    hasNext
    next ( 1. 指針下移， 2. 然後把下移後位置的元素返回)

    remove 是在 迭代器 裡刪除元素

*/