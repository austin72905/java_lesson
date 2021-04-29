public class ArrayLesson {
    public static void main(String[] args) {
        //陣列在內存中的位置
        int[] arr = new int[]{1,2,3}; // stack 存放 arr 變數，heap 存放new 出來的 {1,2,3} ， arr 變數 存放{1,2,3}  的地址
        arr = new int[4]; // arr 指向了一個 新的 {0,0,0,0} 的地址， 原本的 {1,2,3}  因為沒人指向被GC
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }

    // main 方法 執行完 stack 裡面 arr 變數 被拋出 ， heap 中 沒人指向 {0,0,0,0} ， 也被 GC
    //整個內存被清空
}

//內存

// (棧)stack : 局部變量 
//(堆)heap : new 出來的結構、 對像、陣列
//(方法區) 裡面有 常量池、靜態域


