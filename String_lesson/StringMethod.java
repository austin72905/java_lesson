package String_lesson;
import static java.lang.System.*;

import java.util.Arrays;

public class StringMethod {
    public static void main(String[] args) {
        String hello = "hello";

        out.println(hello.charAt(0));

        //hello = null;
        out.println(hello.isEmpty()); //NullPointerException

        String hellp =  "hellp";
        out.println(hello.compareTo(hellp)); // -1

        String num ="123";
        int num1 = Integer.parseInt(num);
        String num2=String.valueOf(num1);
        out.println(num == num2); //false
        byte[] numb= num.getBytes(); // 漢字 會佔 3位 (預設邊碼 UTF-8)
        out.println(Arrays.toString(numb));
        String num3 =new String(numb); // new string ( 可傳 char[]、bytes[])
        out.println(num3); 
    }
}

/*
    string 常用方法

    charAt(索引)
    isEmpty() 是否是空字串
    compareTo : 比較字串大小 => 會從頭字母逐一比較(轉成Acsii) <0 代表調用者小
    基本數據轉換 與 string.valueOf

    string => byte getbytes() //acsii


*/