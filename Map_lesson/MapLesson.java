package Map_lesson;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static java.lang.System.*;

public class MapLesson {
    public static void main(String[] args) {
        //mapMd();
        //treeMapMd();
        treeMapMdSf();
    }

    public static void mapMd(){
        Map<Object,Object> map1 =new HashMap<>();
        //添加元素
        // KV 可為 null
        // set 存 key ==> key 所在的 類 要重寫 equals 、 hashcod'
        //collection 存 value  ==> value所在的 類 要重寫 equals
        // entry 存放 KV
        
        map1.put(null, null);
        map1.put("AA", 123);

        // 如果之後 put 同個 key， 會蓋掉前面的

        Map<Object,Object> map2 =new HashMap<>();
        map2.put("AAa", 123);
        map2.putAll(map1);
        out.println(map2);

        //移除 ， 返回被移除的數據
        map2.remove("AA");
        out.println(map2);

        // 清空數據， 非指null
        map2.clear();
        out.println(map2.size());

        map2.put("AA", "AS");
        map2.put("BB", "DF");
        map2.put("CC", "AAS");

        // 遍例 : 拿到Set 存放的 keys 
        Set<Object> keysets= map2.keySet();
        Iterator<Object> itr =keysets.iterator();
        //可打印所有的key
        while(itr.hasNext()){
            out.println(itr.next());
        }

        out.println("**********");

        //遍例 :  拿到 Collection 存放的 values
        Collection<Object> values = map2.values();
        for(Object o : values){
            out.println(o);
        }

        //遍例 拿到 entry 存放的KV
        //Map.Entry
        Set<Map.Entry<Object,Object>> entrySet =map2.entrySet();

        for(Map.Entry<Object,Object> o : entrySet){
            out.println(o); //AA=AS 
            out.println(o.getKey()+" => " +o.getValue()); //AA => AS
        }

        // 取某值的方法
        Object someval = map2.get("AA");
        out.println(someval);


    }

    public static void treeMapMd(){
        TreeMap<User,Integer> map = new TreeMap<>();

        User u1 =new User("Xma",15);
        User u2 =new User("Jimmy",26);
        User u3 =new User("Oscar",14);
        User u4 =new User("Stanly",35);

        map.put(u1, 90);
        map.put(u2, 83);
        map.put(u3, 75);
        map.put(u4, 86);

        // 打印會依照自訂義User 的 comparTo 方式 排序
        out.println(map);
    }

    //自訂義排序
    public static void treeMapMdSf(){
        TreeMap<User,Integer> map = new TreeMap<>(new Comparator<User>(){
            //想要 年零 由大到小
            @Override
            public int compare(User u1,User u2){
                return -Integer.compare(u1.age, u2.age);
            }
        });

        User u1 =new User("Xma",15);
        User u2 =new User("Jimmy",26);
        User u3 =new User("Oscar",14);
        User u4 =new User("Stanly",35);

        map.put(u1, 90);
        map.put(u2, 83);
        map.put(u3, 75);
        map.put(u4, 86);

        // 打印會依照自訂義User 的 comparTo 方式 排序
        out.println(map);
    }
}



/*
    Map (C# 的 dic)
            (1) HashMap : 主要實現類 => 效率高、線程不安全 : 存 null 的 KV  (底層使用紅黑樹)

                (a) LinkedHashMap : 可以按照添加順序遍例，對於頻繁遍例的，效率較高
            
            (1-1) CurrentHashMap : 分段鎖， 讓多線程訪問Map

            (2) TreeMap : 可以按照key 去排序(自然、訂製) (底層使用紅黑樹)

            (3) Hashtable : 古老實現類

                (a) Properties : 常用來處理配置文件 KV 都是 String


    如果之後 put 同個 key， 會蓋掉前面的

    TreeMap 必須是同個類創建的對象
    只能按照key 排序
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