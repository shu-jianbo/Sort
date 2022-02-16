package Sort.BubbleSort;

/* 排序算法.冒泡排序：通过相邻两个元素之间的比较和交换，
   使较大的元素逐渐从前面移向后面（升序），
   就像水底下的气泡一样逐渐向上冒泡，所以被称为“冒泡”排序
    时间复杂度：O(n^2)
    空间复杂度：O(1)
    稳定性：稳定
*/
public class BubbleSort {
    public static void main(String[] args) {
        // 定义需排序的数组
        int[] arr = {4, 6, 11, 23, 1, 45, 12, 99, 5, 78};
        for(int i=0;i<arr.length-1;i++){
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        printArray(arr);
    }
    // 打印数组
    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // 交换数组中两个数，注意要将交换后的数组作为参数输入，要不然arr不变化
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
