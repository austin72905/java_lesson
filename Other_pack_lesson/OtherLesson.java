package Other_pack_lesson;
import static java.lang.System.*;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OtherLesson {
    public static void main(String[] args) {
        //systemMethod();
        mathMethod();
    }

    public static void systemMethod(){
        String jverison = System.getProperty("java.version"); //1.8.0_152
        out.println("java Version :"+jverison);

        String jhome = System.getProperty("java.home"); //C:\Program Files\Java\jdk1.8.0_152\jre
        out.println("java Home :"+jhome);

        String osname = System.getProperty("os.nmae");
        out.println("os Name :"+osname);

        String osverison = System.getProperty("os.version"); //10.0
        out.println("os Version :"+osverison); 

        String username = System.getProperty("user.name");
        out.println("user Name :"+username);

        String userhome = System.getProperty("user.home");
        out.println("user Home :"+userhome);

        String userdir = System.getProperty("user.dir"); //C:\Users\JIN78\Desktop\littleBlackWindows\java_lesson
        out.println("user Dir :"+userdir);



    }

    public static void mathMethod(){
        BigInteger bigInt =new BigInteger("13456465321");
        BigDecimal bigDecimal = new BigDecimal("456231.46");

        BigDecimal divideNum = new BigDecimal("15");
        
        out.println(bigInt);
        // 除數 只能是 BigDecimal
        //最後的常數要指定，否則除不進會報錯
        out.println(bigDecimal.divide(divideNum,BigDecimal.ROUND_HALF_UP)); // 四捨五入
        out.println(bigDecimal.divide(divideNum,10,BigDecimal.ROUND_HALF_UP)); // 保留小數點後幾位
    }
}

/*
    System
    Math
    BigInt
    BigDecimal
*/