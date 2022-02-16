package Sort.MergeSort;
/*
归并排序：先分解要排序的序列，从1分成2，2分成4，依次分解，
当分解到只有1个一组的时候，就可以排序这些分组，
然后依次合并回原来的序列中，这样就可以排序所有数据。
    时间复杂度：O(nlogn)
    空间复杂度：O(1)
    稳定性：不稳定
 */

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // 定义需要排序的数组
        int[] arr = {4, 6, 11, 23, 1, 45, 12, 99, 5, 78};
        System.out.println("排序前");
        printArray(arr);
        System.out.println();
//        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0, arr.length);
        System.out.println("排序后");
        printArray(arr);
//        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr, int left, int right) {
        // 左闭右开区间
        if (right == left+1) {   // 递归退出条件，如：[1,2) 递归就应退出
            return;
        }
        int mid = (right+left) >> 1;   // 计算出中间位置
        mergeSort(arr, left, mid);    // 将数组分成左右两边进行处理
        mergeSort(arr, mid, right);

        int[] temp = new int[right-left];

        int i = left;   // 指向左半部分的第一个位置
        int j = mid;   // 指向右半部分的第一个位置
        int k = 0;      // 指向temp数组的第一个位置
        while (i < mid && j < right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i<mid) temp[k++] = arr[i++];
        while (j < right) temp[k++] = arr[j++];

        // 将arr数组用有序的temp更新
        for (int l = 0; l < (right - left); l++) {
            arr[left + l] = temp[l];
        }


    }
    // 打印数组
    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
