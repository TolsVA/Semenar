package homevork_3;

import java.util.Arrays;

public class Task_1 {
    public static void main(String[] args) {
        Task_1 hom = new Task_1();
        System.out.println(Arrays.toString(hom.mergeSort(new int[]{9, 4,23, 45, 67,3, 4, 6, 5})));
    }

    public int[] mergeSort(int[] arr){
        if (arr == null) return null;
        if (arr.length < 2) return arr;

        int[] arrLeft = new int[arr.length / 2];
        System.arraycopy(arr, 0, arrLeft, 0, arr.length / 2);

        int[] arrRight = new int[arr.length - arr.length / 2];
        System.arraycopy(arr, arr.length / 2, arrRight, 0, arr.length - arr.length / 2);

        arrLeft = mergeSort(arrLeft);
        arrRight = mergeSort(arrRight);

        return mergeArray(arrLeft, arrRight);
    }

    public static int[] mergeArray(int[] arrLeft, int[] arrRight) {
        int l = arrLeft.length;
        int r = arrRight.length;
        int[] res = new int[l + r];

        int i = 0, j = 0, k = 0;

        while (i < l && j < r) {
            if (arrLeft[i] <= arrRight[j]) {
                res[k] = arrLeft[i];
                i++;
            } else {
                res[k] = arrRight[j];
                j++;
            }
            k++;
        }

        while (i < l) {
            res[k] = arrLeft[i];
            i++;
            k++;
        }

        while (j < r) {
            res[k] = arrRight[j];
            j++;
            k++;
        }

        return res;
    }
}
