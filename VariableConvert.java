public class VariableConvert {
    public static void main(String[] args) {
        GetNum();
    }


    private static void GetNum(){
        byte num1=2;
        int num2 =129;
        int total1 = num1 + num2;
        System.out.println(total1);

        byte num3 = 25;
        short num4 =(short)num3;
        System.out.println(num4);

        //大轉換小的時候，會把多的內存空間卡掉
        //精度損失特殊
        int num5=128;
        byte num6 =(byte)num5;
        System.out.println(num6); //-128   => byte 最多127

        // long 沒有加上L 會自動把他看成int
        // float 一定要加
    }

}


//自動類型轉換
//   (範圍)小的可用(範圍)大的變數裝
//   byte => short、char => int => long => float => double
//   轉換到小數點的會幫你加個.0
//強制類型轉換
//   自動類型轉換的 逆運算
//   變數前 加上 (類型)
//   強制轉換可能導致精度損失