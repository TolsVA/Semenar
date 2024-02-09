package homevork_3;

import java.util.Arrays;

public class Hom_3 {
    public static void main(String[] args) {

        Hom_3 hom = new Hom_3();

        System.out.println(Arrays.toString(hom.mergeSort(new int[]{9, 4,23, 45, 67,3, 4, 6, 5})));

    }
    public int[] mergeSort(int[] arr){
        if (arr == null) {
            return null;
        }

        if (arr.length < 2) {
            return arr;
        }

        int [] arrOne = new int[arr.length / 2];
        System.arraycopy(arr, 0, arrOne, 0, arr.length / 2);

        int [] arrTwo = new int[arr.length - arr.length / 2];
        System.arraycopy(arr, arr.length / 2, arrTwo, 0, arr.length - arr.length / 2);

        arrOne = mergeSort(arrOne);
        arrTwo = mergeSort(arrTwo);

        return mergeArray(arrOne, arrTwo);
    }

    public static int[] mergeArray(int[] a1, int[] a2) {
        int[] res = new int[a1.length + a2.length];
        int n = a1.length;
        int m = a2.length;
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (a1[i] <= a2[j]) {
                res[k] = a1[i];
                i++; }
            else {
                res[k] = a2[j];
                j++; }
            k++; }
        while (i < n) {
            res[k] = a1[i];
            i++;
            k++; }
        while (j < m) {
            res[k] = a2[j];
            j++;
            k++; }
        return res;
    }
}
