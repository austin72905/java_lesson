package Collection_lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static java.lang.System.*;

public class CollectionUtil {
    public static void main(String[] args) {
        collectionsMd();
    }

    public static void collectionsMd(){
        List<Integer> list =new ArrayList<>();
        list.add(132);
        list.add(562);
        list.add(12);
        list.add(1);

        out.println(list);
        //反轉
        Collections.reverse(list);
        out.println(list);

        //隨機排序
        Collections.shuffle(list);
        out.println(list);

        //元素戶換
        Collections.swap(list, 1, 2);
        out.println(list);

        //元素出現次數
        int time = Collections.frequency(list, 1);
        out.println(time);

        //copy
        //確保目標 list 長度足夠
        List<Integer> targetList = Arrays.asList(new Integer[list.size()]);
        Collections.copy(targetList, list);
        out.println(targetList);

        //可以轉成線程安全的list
        List<Integer> safeList=Collections.synchronizedList(targetList);
        out.println(safeList);
    }
}

/*
    Collections 工具類 可以 操作 Collection、 Map

    reverse : 反轉
    shuffle : 隨機排序
    sort
    swap : 元素戶換
    max : 返回最大元素
    min
    frequenct : 元素出現次數
    copy(目標,來源)  //目標長度不能比來源小
*/