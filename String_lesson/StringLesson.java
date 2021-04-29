package String_lesson;
import static java.lang.System.*;

public class StringLesson {
    public static void main(String[] args) {
        String a="abc"; // 字面量 定義方式 (沒用 new)
        String b="abc";

        out.println(a == b); // 實際上指向同個地址  方法區裡 (字符串 常量池)
        a="aaa"; // 重新指向 方法區裡 (字符串 常量池) 的 "aaa" 的地址 

        String c =a;
        out.println(c); //aaa
        a="bbb"; //就算這邊 a 的值換了 ， c 一樣指向原本的方法區裡 (字符串 常量池) 的 "aaa" 的地址
        out.println(c); //aaa
        String d =a;
        out.println(d);
        a+="cc"; // a 變成 bbbcc ， 不能在原有的 bbb 改成 bbbcc ， 因為是 final 具有不可變性 ， 需要重新指定內存地址， 重新賦一個值bbbcc
        out.println(d);
        out.println(a);
        String e= a.replace('c', 'g');
        out.println(a); //a 不會變
        out.println(e);

        //new 創建的 string
        String f =new String("bbb");  // 是在堆空間 ， 裡面的value 屬性 ， 指向 方法區裡 (字符串 常量池) 的 "bbb" 的地址
        out.println(f);
        out.println(d ==f); //false  //d 地址: 字符串 常量池 的地址  ;  f 地址: 堆空間的地址

        f="ccc";
        out.println(f);


        //test
        out.println("********  test  *********");
        String s1 = "hello";
        String s2 = "world";
        String s3 = "hello" + "world";
        String s4 = s1+"world"; //s4 指向 堆 的地址
        String s5 = s1+s2; //s5 指向 堆 的地址
        String s6 = (s1+s2).intern(); // 返回值 在常量池中
        String s7 = "helloworld";

        out.println(s3 == s4); //false
        out.println(s3 == s5); //false
        out.println(s4 == s5); //false
        out.println(s3 == s6); //true
        out.println(s3 == s7); //true

        //只要有涉及 變數+拼接 操作的，代表用 new 在"堆"開啟內存

        //string 當作參數 
        out.println("********  test2 *********");
        String str ="good"; // 用new 建一個也是一樣
        char[] cc ={'t','e','s','t'};
        change(str,cc);
        out.println(str); //good
        out.println(cc); //best

    }


    //string 當作參數時，因為其不可變性， 在methd 裡重新賦值，不會改變外面的值
    public static void change(String input ,char c[]){
        input = "job";
        String tepint =input;
        out.println("tepint ? "+ (tepint == input)); //ture
        out.println("tepint : "+ tepint ); //job
        input ="cook";
        out.println("tepint : "+ tepint ); //job
        c[0]='b';
    }
}

/*
    string

    1. 是 final 類 ， 不可變的字符序列 (不可變性)

    2. 方法區裡 (字符串 常量池)， 不會存放相同字串

    3. 使用 string xx = new string() 是存在"堆" !!!

    4. 拼接: 只要有涉及變數操作的 s1 = s2+1  就會代表用 new 在"堆"開啟內存
 
*/
