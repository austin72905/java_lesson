//引入包
//讀取鍵盤input
import java.util.Scanner;



public class ScannnerLesson {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int num= scan.nextInt(); // 讀取 int
        System.out.println(num);

        String name =scan.next(); //讀取 string
        System.out.println(name);

        // char 無法， 只能獲取字串

    }
}