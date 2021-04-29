public class OperatorLesson {
    public static void main(String[] args) {

        // 當 福号左邊是 false ， 單個| & ，右邊會繼續運算
        getAnd();
        getDoubleAnd();
    }

    private static void getAnd(){
        boolean b1 = true;
        b1=false; // 當b1 是 false 時  ，單個&  num1++ 會執行
        int num1 =10;
        if(b1 & (num1++>0)){
            System.out.println("aa");
        }else{
            System.out.println("bb");
        }

        System.out.println(num1); 

    }

    private static void getDoubleAnd(){
        boolean b1 = true; // num1 無差異
        b1=false; // 當b1 是 false 時  ，雙個&&  num1++ 不會執行
        int num1 =10;
        if(b1 && (num1++>0)){
            System.out.println("aa2");
        }else{
            System.out.println("bb2");
        }

        System.out.println(num1);
    }

}

//  &  與 && 差異

// && 會短路


//位移 運算符 之 後看 day3  15