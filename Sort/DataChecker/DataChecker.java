package Sort.DataChecker;

import Sort.QuickSort.QuickSort;

/*
通过生成随机的数组，进行排序，并与调用Java自身的排序包结果进行对比，验证排序算法的正确性
 */

import java.util.Arrays;
import java.util.Random;

public class DataChecker {
    public static void main(String[] args) {
        check();
    }
    public static void check() {
        int[] arr = getRandomArray();
        int[] copyArr = arr;
//        System.out.print("排序之前的数组：");
//        printArray(arr);

//        System.out.println("官方sort排序的结果");
        Arrays.sort(copyArr);

//        System.out.println("测试排序算法程序的结果");
        QuickSort.quickSort(arr,0,arr.length-1);   // 于此替换其他需要核验的排序程序
//        printArray(arr);

        boolean same = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != copyArr[i]) same = false;
        }
        System.out.println(same ? "right" : "wrong");
    }

    public static int[] getRandomArray() {
        int[] arr = new int[10000];      // 创建随机测试数组大小
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);   // 随机地创建小于10000的整数作为测试数组元素
        }
        return arr;
    }
    // 打印数组
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
