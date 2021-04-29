package Collection_lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.*;

public class ListLesson {
    public static void main(String[] args) {
        listMethod();
    }

    public static void listMethod(){
        ArrayList<Object> arrlist =new ArrayList<Object>();
        arrlist.add(123);
        arrlist.add("abc");
        arrlist.add(1,"ggg");
        out.println(arrlist);

        List<Object> list2 = Arrays.asList(1,56,93);
        arrlist.addAll(list2);
        out.println(arrlist);

        // 刪除 會返回被刪除的元素
        arrlist.remove(0);
        

        out.println(arrlist);

        // 改值
        arrlist.set(0, 556);
        out.println(arrlist);

        //sublist
        // 子 list
        List<Object> arrlist2= arrlist.subList(1, 3);
        out.println(arrlist2);

    }
}