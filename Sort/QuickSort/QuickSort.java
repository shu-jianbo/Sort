package Sort.QuickSort;
/*
快速排序: 说白了就是给基准数据找其正确索引位置的过程，把小于基准位置的数放到左边，把大于基准位置的数放到右边，移动的次数较少
          然后对左边的区间做一次快排，右边做一次快排
    时间复杂度：O(nlogn)
    空间复杂度：O(1)
    稳定性：不稳定
 */

import javax.swing.plaf.basic.BasicSplitPaneUI;

public class QuickSort {
    public static void main(String[] args) {
        // 定义需要排序的数组
        int[] arr = {4, 6, 11, 23, 1, 45, 12, 99, 5, 78,5, 78};
//        int[] arr = {5, 4};
        System.out.println("排序前");
        printArray(arr);
        System.out.println();
//        System.out.println(Arrays.toString(arr));
        quickSort(arr,0, arr.length-1);
        System.out.println("排序后");
        printArray(arr);

    }
    public static void quickSort(int[] arr, int leftBound, int rightBound) {
        // 递归退出条件
        if (leftBound >= rightBound) {  // 到最后只剩下一个元素需要排序，退出递归
            return;
        }

        int mid = pivotPosition(arr, leftBound, rightBound);

        quickSort(arr, leftBound, mid-1);   // 左边部分递归快排
        quickSort(arr, mid+1, rightBound);   // 右边部分递归快排
    }

    public static int pivotPosition(int[] arr, int leftBound, int rightBound) {   // 返回pivot在数组中的位置

        int leftPoint = leftBound;
        int rightPoint = rightBound - 1;

        int pivot = arr[rightBound];
        while (leftPoint <= rightPoint ) {
            while (leftPoint <= rightPoint && arr[leftPoint] <= pivot) {   // 这个while循环退出，leftPoint指向大于pivot的数组元素
                leftPoint++;
            }
            while (leftPoint <= rightPoint && arr[rightPoint] > pivot) {  // 这个while循环退出，rightPoint指向小于或等于pivot的数组元素
                rightPoint--;
            }
            if(leftPoint < rightPoint) swap(arr, leftPoint, rightPoint); // 此时，leftPoint指向大于pivot的数组元素，rightPoint指向小于等于pivot的数组元素
        }
        // 循环结束，leftPoint可能大于或者等于rightPoint
//        if (leftPoint >= rightPoint) {
        swap(arr, leftPoint, rightBound);
//        }
        return leftPoint;
    }
//    public static void quickSort(int[] arr, int leftBound, int rightBound) {
//        int leftPoint = leftBound;     // 左指针
//        int rightPoint = rightBound;  // 右指针
//
//        int pivot = arr[(rightBound + leftBound) >> 1]; // 中轴值
//
//        while (leftPoint < rightPoint) {
//            // 从左边开始一直找小于pivot值的元素，直到大于等于时，退出
//            while (arr[leftPoint] < pivot) {
//                leftPoint++;
//            }
//            // 从右边开始一直找大于pivot值的元素，直到小于等于时，退出
//            while (arr[rightPoint] > pivot) {
//                rightPoint--;
//            }
//            // 如果leftPoint >= rightPoint，说明左右两边分好了
//            if (leftPoint >= rightPoint) {
//                break;
//            }
//            // 交换两边的值
//            swap(arr, leftPoint, rightPoint);
//
//            // 如果leftPoint等于rightPoint
//            if (arr[leftPoint] == pivot) {
//                rightPoint--;
//            }
//            if (arr[rightPoint] == pivot) {
//                leftPoint++;
//            }
//        }
//        // 如果leftPoint == rightPoint，lP++，rP--，否则栈溢出
//        if (leftPoint == rightPoint) {
//            leftPoint++;
//            rightPoint--;
//        }
//
//        // 向左递归
//        if (leftBound < rightPoint) {
//            quickSort(arr, leftBound, rightPoint);
//        }
//
//
//
//    }

    // 打印数组
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    // 交换数组中的两个元素
//    public static void swap(int[] arr, int i, int j){   // 前提是保证需要交换的两个数不是同一个内存地址，这里如果i=j，结果会变成0
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
//    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

