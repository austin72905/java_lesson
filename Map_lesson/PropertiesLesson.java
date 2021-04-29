package Map_lesson;

import java.io.FileInputStream;
import java.util.Properties;
import static java.lang.System.*;

public class PropertiesLesson {
    public static void main(String[] args)  throws Exception {
        Properties props = new Properties();

        //使用 file 的 非正式寫法
        FileInputStream fis =new FileInputStream("C:\\Users\\JIN78\\Desktop\\littleBlackWindows\\java_lesson\\Map_lesson\\Test.properties");

        props.load(fis);

        String name = props.getProperty("name");
        String pass = props.getProperty("password");
        out.println("name = "+name+",passowrd = "+pass);

        fis.close();

    }
}

/*
    Properties : 主要處理屬性文件

    //文件裡的= 不要有空格

    load(IO流)

    getProperty(key)  : 取值
*/