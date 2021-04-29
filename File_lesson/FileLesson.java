package File_lesson;

import java.io.File;
import static java.lang.System.*;

public class FileLesson {
    public static void main(String[] args) {
        //createFile();
        //fileMd();
        //fileMd2();
        fileMd3();
    }

    public static void createFile(){
        //將文件 轉成內存的一個對象

        //構造器1
        File file1 =new File("C:\\Users\\JIN78\\Desktop\\littleBlackWindows\\java_lesson\\File_lesson\\test.txt"); // 絕對路徑
        File file2 =new File("test.txt"); //相對路徑

        //路徑可已是目錄
        out.println(file1); //C:\Users\JIN78\Desktop\littleBlackWindows\java_lesson\File_lesson\test.txt
        out.println(file2); // test.txt 

        //構造器2
        //File(parent,child)
        File file3 = new File("C:\\Users\\JIN78\\Desktop\\littleBlackWindows\\java_lesson", "File_lesson"); // 可以把路徑分成 父、子 路徑
        out.println(file3); //C:\Users\JIN78\Desktop\littleBlackWindows\java_lesson\File_lesson

        //構造器3
        //File(child,pathname);
        File file4 = new File(file3, "test.txt");
        out.println(file4); //C:\Users\JIN78\Desktop\littleBlackWindows\java_lesson\File_lesson\test.txt

        // 通用分割常量符
        File file5 =new File("C:"+File.separator+"JIN78"+"Desktop"+File.separator+"littleBlackWindows"+File.separator+"java_lesson"+File.separator+"File_lesson");
        out.println(file5); //C:\JIN78Desktop\littleBlackWindows\java_lesson\File_lesson

    }

    public static void fileMd(){
        File file1 =new File("C:\\Users\\JIN78\\Desktop\\littleBlackWindows\\java_lesson\\File_lesson");
        //決對路徑
        out.println(file1.getAbsolutePath()); //C:\Users\JIN78\Desktop\littleBlackWindows\java_lesson\File_lesson
        out.println(file1.getPath()); //C:\Users\JIN78\Desktop\littleBlackWindows\java_lesson\File_lesson
        out.println(file1.getName()); //File_lesson
        out.println(file1.getParent()); //C:\Users\JIN78\Desktop\littleBlackWindows\java_lesson
        out.println(file1.length()); //0
        //最後修改時間
        out.println(file1.lastModified()); //1616046141230

        //list() 可以打印目錄下有哪些文件 (String)
        String[] list= file1.list();
        for( String s : list){
            out.println(s);
        }

        //listFiles() 可以打印目錄下有哪些文件 (File)
        File[] list1= file1.listFiles();
        for( File f : list1){
            out.println(f);
        }

        File file3 =new File("C:\\Users\\JIN78\\Desktop\\littleBlackWindows\\java_lesson\\File_lesson\\test.txt");
        File file4 =new File("C:\\Users\\JIN78\\Desktop\\littleBlackWindows\\java_lesson\\File_lesson\\test1.txt");
        // 返回 true 代表改名成功
        boolean renameSus =file3.renameTo(file4);
        out.println(renameSus);
    }

    public static void fileMd2(){
        File file1 =new File("C:\\Users\\JIN78\\Desktop\\littleBlackWindows\\java_lesson\\File_lesson\\test1.txt");
        out.println(file1.isDirectory());
        out.println(file1.isFile());
        out.println(file1.exists());
        out.println(file1.canRead());
        out.println(file1.canWrite());
        out.println(file1.isHidden());
    }

    public static void fileMd3(){
        
        File file1 =new File("C:\\Users\\JIN78\\Desktop\\littleBlackWindows\\java_lesson\\File_lesson\\test2.txt");

        if(!file1.exists()){
            try{
                //建立新文件
                file1.createNewFile();
            } catch(Exception ex){

            }  
            
        }else{
            //刪除文件
            file1.delete();
        }

        //mkdir 創立目錄
        //mkdirs  上層目錄不存在也會創件
    }
}

/*
    java 裡有區分很多流

    File 類

    1. 路徑分割符 :  再不同操作系統有差異 
        (1) win \\
        
        (2) unix /

        (3) url /

        (4) 可以使用內建的常量，會幫你判斷 (把分割符換成 File.separator)

    2. 三種構造器方法
        (1) File(pathname)
        
        (2) File(parent,child) : 可以把路徑分成 父、子 路徑

        (3) File(child,pathname)
*/