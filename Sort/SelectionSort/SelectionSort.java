package Sort.SelectionSort;
/*  排序算法.选择排序：每一趟从待排序的数据元素中选择 最小（或最大）的一个元素作为首元素，直到所有元素排完为止
时间复杂度O(n^2)
空间复杂度O(1)
稳定性：不稳定
 */

public class SelectionSort {
    public static void main(String[] args){
        // 定义需要排序的数组
        int[] arr = {4, 6, 11, 23, 1, 45, 12, 99, 5, 78};
        
        for(int i =0; i<arr.length-1;i++) {
            int startPoint = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[startPoint]) {
                    startPoint = j;
                }
            }
                // 交换位置
            swap(arr, startPoint, i);

        }
        // 打印数组
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
