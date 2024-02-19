package homework_5.task_3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] initArray;

        if (args.length == 0) {
//            initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, -7, 64, 1};
            initArray = new int[]{2, 4, 3, 8, 6, 1, 7, -2};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        HeapSort heapSort = new HeapSort();

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        heapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));

    }
}
