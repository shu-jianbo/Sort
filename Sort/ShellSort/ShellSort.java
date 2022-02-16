package Sort.ShellSort;
/*  希尔排序：（改进的插入排序）先将整个待排元素序列分割成若干个子序列（由相隔某个“增量”的元素组成的）分别进行直接插入排序，然后依次缩减增量再进行排序，
待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序。
    时间复杂度：O(n^s) 1<s<2
    空间复杂度：O(1)
    稳定性：不稳定
 */
public class ShellSort {
    public static void main(String[] args) {
        // 定义需要排序的数组
        int[] arr = {4, 6, 11, 23, 1, 45, 12, 99, 5, 78};

        shellSort(arr);
    }

    public static void shellSort(int[] arr) {
        // 使用Knuth序列
        int h = 1;
        while (h <= arr.length / 3) {
            h = 3 * h + 1;
        }
        for (int gap = h; gap > 0; gap = (gap-1) / 3) {  // 改变间隔
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > 0; j -= gap) {   // 往前比较
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j, j-gap);
                    }
                }
            }
        }
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
