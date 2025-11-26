package Learn_DSA.Practice;

import static Learn_DSA.Practice.Practice_03.prefixSum;

public class Practice_04 {
    // 1. Subarray from s to e
    public static void printSubarray(int[] arr, int s, int e) {
        for (int i = s; i <= e; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // 2. Print All Subarrays
    // Given an array arr[], print all the subarrays possible in array arr
    public static void printAllSubarray(int[] arr) {
        int n = arr.length;
        System.out.println("[");
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("[");
                for (int k = i; k <= j; k++) {
                    if (k != j) {
                        System.out.print(arr[k] + ", ");
                    }else {
                        System.out.print(arr[k]);
                    }
                }
                System.out.println("]");
            }
        }
        System.out.println("]");
    }

    // 3. Sum of every subarray
    // Given an array arr[], print sum of every possible subarray
    public static void printSumOfEverySubarray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                System.out.print(sum + " ");
            }
        }
        System.out.println();
    }
    public static void sumOfEverySubarray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                System.out.print(sum + " ");
            }
        }
        System.out.println();
    }
    public static void sumOfEverySubarray2(int[] arr) {
        int n = arr.length;
        int[] psum = prefixSum(arr);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == 0) {
                    System.out.print(psum[j] + " ");
                }else {
                    System.out.print((psum[j] - psum[i - 1]) + " ");
                }
            }
        }
    }
    static void main(String[] args) {
        int[] arr = {3, -1, 4};
//        printSumOfEverySubarray(arr);
//        sumOfEverySubarray(arr);
        sumOfEverySubarray2(arr);

//        int[] arr = {3, -1, 2};
//        printAllSubarray(arr);
//        printSumOfEverySubarray(arr);

//        int[] A = {2, 3, 9, 4, -5, 6, 7, 9, 10};
//        printSubarray(A, 3, 5);

    }
}
