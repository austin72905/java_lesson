package Collection_lesson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.System.*;

public class SetLesson {
    public static void main(String[] args) {
        //setMethod();
        //linkedHashSetMd();
        //treeSetMd();
        treeSetMd2();
    }

    public static void setMethod(){
        ArrayList<Integer> arrlist =new ArrayList<Integer>();

        arrlist.add(123);
        arrlist.add(123);
        arrlist.add(456);
        arrlist.add(789);
        out.println(arrlist);
        //幫你去重複值
        Set<Integer> set1 =new HashSet<Integer>(); // 底層用HashMap 實現

        set1.addAll(arrlist);
        out.println(set1);
    }

    public static void linkedHashSetMd(){
        Set<Object> set1 = new LinkedHashSet<Object>();
        set1.add(11);
        set1.add(55);
        set1.add(3);

        for(Object o : set1){
            // c
            out.println(o);
        }
    }

    public static void treeSetMd(){
        //需要是同個類的對象的
        Set<Integer> set =new TreeSet<Integer>();
        set.add(11);
        set.add(55);
        set.add(3);

        for(Integer val : set){

            //從小到大排
            out.println(val);
        }

        Set<User> set1 =new TreeSet<User>();
        set1.add(new User("Jerry",15));
        set1.add(new User("Austin",10));
        set1.add(new User("Merry",24));
        set1.add(new User("Alen",18));
        set1.add(new User("Alen",20));

        for(User val : set1){

            //從名字小到大排
            out.println(val);
        }


    }

    public static void treeSetMd2(){

        Comparator<User> com = new Comparator<User>(){
            @Override
            public int compare(User user1,User user2){
                return Integer.compare(user1.age, user2.age);
            }
        };

        //訂製排序
        
        Set<User> set1 =new TreeSet<User>(com); // 裡面帶Comparator 參數代表要用訂製排序
        set1.add(new User("Jerry",15));
        set1.add(new User("Austin",10));
        set1.add(new User("Merry",24));
        set1.add(new User("Alen",18));
        set1.add(new User("Alen",20));

        for(User val : set1){

            //從age小到大排
            out.println(val);
        }
    }
}

/*
    Set : 無序、不可重複的數據

    1. 無序性，不代表隨機 (以hashSet為例， 並非以索引，而是hash值)

    LinkedHashSet : 可以依造添加的順序遍例 (頻繁的遍例，效率較高)

    TreeSet : 可以按照添加對象的指定屬性，進行排序 (這個判斷元素是否一樣變成看自訂義的compareTo 方式 ，不再是他底層的equals) (以紅黑樹存的)
        


*/

class User implements Comparable<User> {
    String name;
    int age;

    public User(String name,int age){
        this.name =name;
        this.age=age;
    }

    //自然排序
    @Override
    public int compareTo(User user){
        // 以名字比較
        int result =this.name.compareTo(user.name);
        //如果名字一樣就比年紀
        if(result ==0){
            return Integer.compare(this.age, user.age);
        }

        return result;
    }

    @Override
    public String toString(){
        return "User {"+"name ="+this.name+" ,age ="+this.age+"}";
    }
}