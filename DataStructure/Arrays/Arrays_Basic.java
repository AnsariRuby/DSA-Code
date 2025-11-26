package Learn_DSA.DataStructure.Arrays;

import java.util.*;

public class Arrays_Basic {
    // 1. Print Alternate elements of an array
    // Given an array arr[], the task is to print every alternate element of the array starting from the first element.
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i += 2) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    static void printArray(int[] arr, int index) {
        if (index >= arr.length) {
            return;
        }
        System.out.print(arr[index] + " ");
        printArray(arr, index + 2);
    }

    // 2. Leaders in an array
    // Given an array arr[] of size n, the task is to find all the Leaders in the array.
    // An element is a Leader if it is greater than or equal to all the elements to its right side.
    // Note: The rightmost element is always a leader.
    static void leaderInArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j;
            for (j = i + 1; j < n; j++) {
                if(arr[i] < arr[j]) {
                    break;
                }
            }
            if (j == n) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
    static ArrayList<Integer> leadersInArray(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        int max = arr[n - 1];
        list.add(max);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                list.add(max);
            }
        }
        Collections.reverse(list);
        return list;
    }

    // 3. Check if an Array is Sorted
    // Given an array arr[], check if it is sorted in ascending order or not.
    // Equal values are allowed in an array and two consecutive equal values are considered sorted.
    static boolean isSorted(int[] arr, int index) {
        if (index == arr.length) {
            return true;
        }
        if (arr[index] < arr[index - 1]) {
            return false;
        }
        return isSorted(arr, index + 1);
    }
    static boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // 4. Remove Duplicates from Sorted Array
    // Given a sorted array arr[] of size n, the goal is to rearrange the array so that all distinct elements appear at the beginning in sorted order.
    // Additionally, return the length of this distinct sorted subarray.
    static ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int ele : arr) {
            set.add(ele);
        }
        return new ArrayList<>(set);
    }
    static int removeDuplicateElement(int[] arr) {
        int n = arr.length;
        int index = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[index++] = arr[i];
            }
        }
        return index;
    }
    // 5. Generate all Subarrays
    static void printAllSubarray(int[] arr) {
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

    // 6. Reverse an Array
    // Reverse an array arr[]. Reversing an array means rearranging the elements such that the first element becomes the last,
    // the second element becomes second last and so on.
    static int[] reverseArray(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[n - 1 - i];
        }
        for(int i = 0; i < n; i++){
            arr[i] = temp[i];
        }
        return arr;
    }
    static int[] reverseArray2(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
        return arr;
    }
    static int[] reverseArray3(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        return arr;
    }

    // 7. Rotate an Array -  Clockwise or Right
    // i. Right Rotation (or Clockwise)
    static int[] rightRotate(int[] arr, int d) {
        int n = arr.length;
        for (int i = 0; i < d; i++) {
            int temp = arr[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[0] = temp;
        }
        return arr;
    }
    static int[] rightRotateArray(int[] arr, int d) {
        int n = arr.length;
        int[] temp = new int[n];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[n - d + i];
        }
        for (int i = d; i < n; i++) {
            temp[i] = arr[i - d];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }
    static int[] rightRotation(int[] arr, int d) {
        int n = arr.length;
        d = d % n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);

        return arr;
    }

    // ii. 2. Left Rotation (Or Counter Clockwise)
    static int[] leftRotate(int[] arr, int d) {
        int n = arr.length;
        for (int i = 0; i < d; i++) {
            int temp = arr[0];
            for (int j = 1; j < n; j++) {
                arr[j - 1] = arr[j];
            }
            arr[n - 1] = temp;
        }
        return arr;
    }
    static int[] leftRotateArray(int[] arr, int d) {
        int n = arr.length;
        int[] temp = new int[n];
        for (int i = 0; i < n - d; i++) {
            temp[i] = arr[i + d];
        }
        for (int i = n - d; i < n; i++) {
            temp[i] = arr[i - (n - d)];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }
    static int[] leftRotation(int[] arr, int d) {
        int n = arr.length;
        d = d % n;

        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);

        return arr;
    }
    // 8. Move all Zeros to End of Array
    // Given an array of integers arr[], move all the zeros to the end of the array while maintaining the relative order of all non-zero elements.
    static int[] moveAllZeros(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp[j++] = arr[i];
            }
        }
        while (j < n) {
            temp[j++] = 0;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }
    static int[] moveAllZeros2(int[] arr) {
        int n = arr.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[j++] = arr[i];
            }
        }
        while (j < n) {
            arr[j++] = 0;
        }
        return arr;
    }
    static int[] moveAllZeros3(int[] arr) {
        int i = 0, j = 0;
        while (j < arr.length) {
            if (arr[j] == 0) {
                j++;
            }else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
        return arr;
    }

    // 9. Min Increments to Make Equal
    // You are given an array of n-elements, you have to find the number of operations needed to make all elements of array equal.
    // Where a single operation can increment an element by k. If it is not possible to make all elements equal print -1.
    static int minOps(int[] arr, int k) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if ((max - arr[i]) % k != 0) {
                return -1;
            }else {
                ans += (max - arr[i]) / k;
            }
        }
        return ans;
    }

    // 10. Minimum cost to make array size 1 by removing larger of pairs
    // Given an array of n integers. We need to reduce size of array to one. We are allowed to select a pair of integers
    // and remove the larger one of these two. This decreases the array size by 1. Cost of this operation is equal to value of smallest one.
    // Find out minimum sum of costs of operations needed to convert the array into a single element.
    static int minCost(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
        }
        return min * (n - 1);
    }

    // 11. Print 1D Array
    static void print(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    static void reverse(int[] arr, int s, int e) {
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }

    static void main(String[] args) {
//        int[] arr = {4, 3, 2};
//        System.out.println(minCost(arr));
//        int[] arr2 = {3, 4};
//        System.out.println(minCost(arr2));

//        int[] arr = {4, 7, 19, 16};
//        System.out.println(minOps(arr, 3));
//        int[] arr2 = {4, 2, 6, 8};
//        System.out.println(minOps(arr2,3));

//        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
//        System.out.println(Arrays.toString(moveAllZeros(arr)));
//        System.out.println(Arrays.toString(moveAllZeros2(arr)));
//        System.out.println(Arrays.toString(moveAllZeros3(arr)));

//        int[] arr = {1, 2, 3, 4, 5, 6};
//        System.out.println(Arrays.toString(leftRotate(arr, 2)));
//        System.out.println(Arrays.toString(leftRotateArray(arr, 2)));
//        System.out.println(Arrays.toString(leftRotation(arr, 2)));

//        System.out.println(Arrays.toString(rightRotate(arr, 2)));
//        System.out.println(Arrays.toString(rightRotateArray(arr, 2)));
//        System.out.println(Arrays.toString(rightRotation(arr, 2)));

//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println(Arrays.toString(reverseArray(arr)));
//        System.out.println(Arrays.toString(reverseArray2(arr)));
//        System.out.println(Arrays.toString(reverseArray3(arr)));

//        int[] arr =  {1, 2, 3};
//        printAllSubarray(arr);

//        int[] arr = {2, 2, 2, 2, 2};
//        System.out.println(removeDuplicates(arr));
//        int[] arr2 = {1, 2, 2, 3, 4, 4, 4, 5, 5};
//        System.out.println(removeDuplicates(arr2));
//        print(arr, removeDuplicateElement(arr));
//        print(arr2, removeDuplicateElement(arr2));

//        int[] arr = {10, 20, 30, 40, 50};
//        System.out.println(isSorted(arr, 1));
//        System.out.println(isSorted(arr));
//        int[] arr2 = {90, 80, 100, 70, 40, 30};
//        System.out.println(isSorted(arr2, 1));
//        System.out.println(isSorted(arr2));

//        int[] arr = {16, 17, 4, 3, 5, 2};
//        leaderInArray(arr);
//        System.out.println(leadersInArray(arr));

//        int[] arr = {10, 20, 30, 40, 50};
//        printArray(arr);
//        printArray(arr, 0);
    }
}
