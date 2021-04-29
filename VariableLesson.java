public class VariableLesson {
    public static void main(String[] args) {
        byte a =12;
        System.out.println(a);

        short b =18;
        System.out.println(b);

        long c = 3554l;
        System.out.println(c);

        double d = 132.3;
        System.out.println(d);

        float e = 132.3f;
        System.out.println(e);

        char f ='a'; // \n 、\r 、中文、unicode 都可以
        System.out.println(f);

        boolean g =true;
        System.out.println(g);

    }
}

//java 字串 在class 裡 是引用類型
// class
// interface
// []


// 其他都是基本數據類型
// 整型 byte / short / int / long      => short 2(byte)字節
//    (1) byte -128 ~ 127
//    (2) long 需要以 l or L 結尾
// 浮點數 float /double
//    (1) float 4(byte)字節、單精度， 需以 f or F 結尾 (只能精算到7位) ， 範圍比long 還大
//    (2) double 8(byte)字節、雙精度 (通常用此類)
// 字符型 char
//    (1) char  2(byte)字節，都用''，只能寫一個字符
// 布林  boolean