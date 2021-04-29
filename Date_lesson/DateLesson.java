package Date_lesson;
import static java.lang.System.*;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Date;

public class DateLesson {
    public static void main(String[] args) {
        long time = currentTimeMillis(); //1970~now 的毫秒
        out.println(time);

        Date date1 =new Date();
        out.println(date1.toString()); //Mon Mar 15 15:21:41 CST 2021
        out.println(date1.getTime()); // 1970~now 的毫秒
        Date date2 =new Date(1615792943445L);
        out.println(date2.toString());

        //date 轉 sql.date
        java.sql.Date date3 =new java.sql.Date(date1.getTime());
        out.println(date3.toString()); //2021-03-15

        //SimpleDateFormat
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String timeFormat =sdf.format(date2);
        out.println(timeFormat);

        //Calender
        Calendar cla = Calendar.getInstance();
        
        //get
        int days= cla.get(Calendar.DAY_OF_MONTH);
        out.println(days);

        //set
        cla.set(Calendar.DAY_OF_MONTH, 22);
        //add
        cla.add(Calendar.DAY_OF_MONTH, 3);
        //getTime
        Date date4 =cla.getTime();
        out.println(date4.toString()); //Thu Mar 25 15:53:49 CST 2021
        //setTime
        cla.setTime(date4);
        int days2= cla.get(Calendar.DAY_OF_MONTH);
        out.println(days2); //25


        //JDK8 以後
        out.println("***** after JDK8 *****");
        LocalDate dtnow = LocalDate.now();
        LocalTime tmnow = LocalTime.now();
        LocalDateTime dttmnow = LocalDateTime.now();

        out.println(dtnow); //2021-03-15
        out.println(tmnow); //17:03:58.648
        out.println(dttmnow); //2021-03-15T17:03:58.648

        // of 方法
        LocalDate someday =LocalDate.of(2019,10,16);
        out.println(someday); //2019-10-16

        //getXxx
        out.println(someday.getDayOfWeek());//WEDNESDAY

        //withXxx : 設置相關屬性
        LocalDate someday1 =someday.withDayOfMonth(11);
        out.println(someday1); //2019-10-11

        //plus
        LocalDate someday2 =someday1.plusMonths(4);
        out.println(someday2); //2020-02-11

        //minor
        LocalDate someday3 =someday1.minusDays(4);
        out.println(someday3); //2019-10-07

        out.println("****** instant ******");
        Instant inst = Instant.now();
        out.println(inst); //2021-03-15T09:18:16.382Z  會早8小時

        //根據時區添加偏移量
        OffsetDateTime offsetdate= inst.atOffset(ZoneOffset.ofHours(8)); //2021-03-15T17:21:05.143+08:00
        out.println(offsetdate);

        // 獲取對應的毫秒數
        long tims=inst.toEpochMilli();
        out.println(tims); //1615800247885

        Instant inst1 =Instant.ofEpochMilli(1615800247885L);
        out.println(inst1);

        //DataTimeFormatter
        out.println("*********** DataTimeFormatter  **********");

        DateTimeFormatter formattm =DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String formatTmStr =formattm.format(LocalDateTime.now());
        out.println(formatTmStr); //2021-03-15 05:42:13

        
    }
}

/*
    JDK 8 以前
    System.currentTimeMillis

    util.Date
    兩個構造器
    1. new Date();
    2. new Date(long 時間戳(豪秒));
    兩個方法
    1. toString() : 顯示 年月日時分秒
    2. getTime() : 對應的時間戳

    date 轉 sql.date

    SimpleDateFormat : 格式化日期

    Calender


    JDK 8
    //時間修改為不可變性，凡是對時間的操作，都要用變數去接
    新增了 time 包
    LocalDate
    LocalTime
    LocalDateTime

    (類似於 Calender)

    now() 方法
    of() : 指定時間

    Instant : 時間戳上的一個瞬間點
    類似於 Date 類

    DataTimeFormatter

*/