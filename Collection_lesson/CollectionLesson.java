package Collection_lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.lang.System.*;

public class CollectionLesson {
    public static void main(String[] args) {
        collectionMethod();
    }

    public static void collectionMethod(){
        Collection col =new ArrayList();

        col.add("aa");
        col.add(123);
        out.println(col.size());

        Collection col1 =new ArrayList();
        col1.add(true);

        // 新增集合
        col1.addAll(col);
        out.println(col1);

        // 清空集合 不是變成 null
        //col1.clear();

        //out.println(col1.isEmpty());

        //hashcode
        out.println(col1.hashCode());

        //toArray  集合 ==> 陣列
        Object[] arr =col1.toArray();
        out.println(Arrays.toString(arr));
        // 陣列 ==> 集合
        List<String> list = Arrays.asList(new String[]{"cc","aa","vv"});
        out.println(list);

        //List list2 =Arrays.asList(new int[]{123,456}); => 這樣寫會被視為一個元素，不要這樣寫
        
        

    }
}

/*
    
    Collection
        1. List : 存有序、可重複的
            (1) ArrayList : List 主要實現類 => 效率高 ，線程不安全，底層是 Object[]

            (2) LinkedList : 底層是雙向鏈表，頻繁的插入、刪除，效率比上面高

            (3) Vector : 古老的List 實現類

        2. Set : 存無序、不可重複的
            (1) HashSet : Set 主要實現類 ， 可以存null、 線程不安全

                (a) LinkedHashSet :  遍例其內部時，可以按照添加的順序遍例

            (3) TreeSet : 可以按添加對象的指定屬性進行排序


    Map (C# 的 dic)
            (1) HashMap

                (a) LinkedHashMap

            (2) TreeMap

            (3) Hashtable

                (a) Properties
*/