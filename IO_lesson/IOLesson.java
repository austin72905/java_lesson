package IO_lesson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.System.*;

public class IOLesson {
    public static void main(String[] args) {
        //readFile();
        //readFile2();
        //writeFile();
        copyFile();
    }

    public static void readFile() {

        // 標準的 IO 流寫法 (要很多層try catch)

        FileReader reader = null;

        try {

            File file = new File("C:\\Users\\JIN78\\Desktop\\littleBlackWindows\\java_lesson\\IO_lesson\\test.txt");
            reader = new FileReader(file);

            // 返回獨到的字符，如果達到文件末尾，返回-1
            int content = reader.read();

            while (content != -1) {
                out.println((char) content);
                // 不斷往下一個字符讀
                content = reader.read();
            }

        } catch (IOException e) {

        } finally {

            try {
                // 確定有找到文件，才需要關閉IO
                if (reader != null) {
                    reader.close();
                }

            } catch (Exception e) {

            }

        }

    }

    public static void readFile2() {

        // 分段讀取的方法

        // 1. File 類的 實例化

        // 2. FileReader 實例化

        // 3. 讀的操作

        // 4. 關閉

        FileReader reader = null;
        try {
            File file = new File("C:\\Users\\JIN78\\Desktop\\littleBlackWindows\\java_lesson\\IO_lesson\\test.txt");
            reader = new FileReader(file);

            //定義一次要讀幾個
            char[] readChar = new char[2];

            int len = reader.read(readChar);
            while (len != -1) {
                for (int i = 0; i < len; i++) {
                    out.println(readChar[i]);
                }
                len = reader.read(readChar);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {

            }

        }
    }


    public static void writeFile(){

        //寫入的檔案不存在，會幫你創建

        //指名寫入的目標文件

        //FileWirter 實例化 ， append 設為 true， 就會繼續寫，而不覆蓋

        //寫

        //關閉

        FileWriter writer =null;

        try {
            File file = new File("C:\\Users\\JIN78\\Desktop\\littleBlackWindows\\java_lesson\\IO_lesson\\test.txt");
            
            writer=new FileWriter(file,true);
            writer.write("aaa");

        } catch (Exception e) {
            
        }finally{
            try {
                if(writer!=null){
                    writer.close();
                }
            } catch (Exception e) {
                
            }
        }

    }

    public static void copyFile(){

        FileReader reader=null;
        FileWriter writer=null;

        try {
            //1. 創建File對象，指名讀入、寫出文件
            File srcFile=new File("C:\\Users\\JIN78\\Desktop\\littleBlackWindows\\java_lesson\\IO_lesson\\test.txt");

            File targetFile=new File("C:\\Users\\JIN78\\Desktop\\littleBlackWindows\\java_lesson\\IO_lesson\\test1.txt");
            //2. 創建輸出流、輸入流的對象
            reader = new FileReader(srcFile);

            writer =new FileWriter(targetFile);

            //3. 數據的讀入和寫出操作
            char[] readChar = new char[2];

            int len = reader.read(readChar);
            while (len != -1) {
                for (int i = 0; i < len; i++) {
                    out.println(readChar[i]);
                }
                //每次寫len 個字符
                writer.write(readChar,0,len);
                len = reader.read(readChar);
            }    
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //4. 關閉流
            try {
                if(reader!=null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //上面關閉流時拋EX，下面還是會執行

            try {
                if(writer!=null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        
        }

        

        
    }
}

/*
 * java 裡有區分很多流 四個流的基礎抽象類 Input、Output、Reader、Wirter
 */