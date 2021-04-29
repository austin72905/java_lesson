import java.util.Arrays;

public class ArrayLesson2 {
    public static void main(String[] args) {
        checkEqual();
    }

    private static void checkEqual(){
        int[] arr = new int[]{1,2,3};
        int[] arr2 = new int[]{1,2,3};
        int[] arr3 =new int[]{-8,2,-45,65,33,77};
        boolean isEqual =Arrays.equals(arr, arr2); //檢查兩個陣列是否相等  (不是比地址)
        System.out.println(isEqual);
        System.out.println(Arrays.toString(arr)); //可以把整個陣列連同元素搞出來
        Arrays.fill(arr, 10); // 把所有元素 改成指定值
        System.out.println(Arrays.toString(arr));
        //sort 排序
        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3));
        // 二元搜尋 尋找元素的索引 ， <0 表沒找到
        int index = Arrays.binarySearch(arr3, 33);
        System.out.println(index);
    }
}

