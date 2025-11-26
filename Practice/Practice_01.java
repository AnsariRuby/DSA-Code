package Learn_DSA.Practice;

import java.util.Arrays;

public class Practice_01 {
    // 1. Given a number n, count factor of n.
    public static int factors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }
    public static int countFactors(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    count++;
                }else {
                    count += 2;
                }
            }
        }
        return count;
    }

    // 2. Given a number n, check if number is prime or not?
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isPrimeFast(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    count++;
                }else {
                    count += 2;
                }
            }
            if (count > 2) {
                return false;
            }
        }
        return true;
    }

    // 3. Given an array A. reverse the array.
    // Constraint : 1. Number of iteration allowed is n. 2. Extra array is not allowed
    public static int[] reverseArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        return arr;
    }
    public static int[] reverseArrayFast(int[] arr) {
        int s = 0, e = arr.length - 1;
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
        return arr;
    }

    // 4. Given an array A and starting index 's' and ending index 'e'. Reverse array between 's' to 'e'
    public static int[] reverseArrayInRange(int[] arr, int s, int e) {
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
        return arr;
    }

    // 5. Given an array A and int value K, rotate an array k times from last to first.
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static int[] rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);

        return arr;
    }
    static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};
        System.out.println(Arrays.toString(reverseArrayInRange(arr, 1, 5)));

//        int[] arr = {10, 20, 30, 40, 50, 60};
//        System.out.println(Arrays.toString(reverseArray(arr)));
//        System.out.println(Arrays.toString(reverseArrayFast(arr)));

//        System.out.println(isPrimeFast(33));
//        System.out.println(isPrime(11));

//        System.out.println(countFactors(40));
//        System.out.println(factors(15));

    }
}
