package Sort.InsertSort;

/*
插入排序：每一步都将一个待排数据按其大小插入到已经排序的数据中的适当位置，直到全部插入完毕。
    时间复杂度：O(n^2)
    空间复杂度：O(1)
    稳定性：稳定
 */
public class InsertSort {
    public static void main(String[] args) {
        // 定义需要排序的数组
        int[] arr = {4, 6, 11, 23, 1, 45, 12, 99, 5, 78};
        for (int i = 1; i < arr.length; i++) {//从下标为i=1的开始，也就是第二个元素开始
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {//判断是否交换
                swap(arr, j, j + 1);
            }
        }
        printArray(arr);
    }
    // 交换数组中的两个元素
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // 打印数组
    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
