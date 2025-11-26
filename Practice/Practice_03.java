package Learn_DSA.Practice;

import java.util.Arrays;

public class Practice_03 {
    // Prefix Sum Array
    // 1. Given an Array, create and return prefix sum array where psum[i] = A[0] + A[1] + A[2] + ..... +  A[i]
    public static int[] prefixSum(int[] arr) {
        int n = arr.length;
        int[] psum = new int[n];
        psum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            psum[i] = psum[i - 1] + arr[i];
        }
        return psum;
    }

    // 2. Range Sun Queries
    // Given an array A[] of size N and Q queries. Find the answer all queries in the given range.
    public static int[] rangeSum(int[] A, int[][] B) {
        int q = B.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int s = B[i][0];
            int e = B[i][1];
            int sum = 0;
            for (int j = s; j <= e; j++) {
                sum += A[j];
            }
            ans[i] = sum;
        }
        return ans;
    }
    public static int[] rangeSumQueries(int[] A, int[][] B) {
        int q = B.length;
        int[] ans = new int[q];
        int[] psum = prefixSum(A);
        for (int i = 0; i < q; i++) {
            int s = B[i][0];
            int e = B[i][1];
            if (s == 0) {
                ans[i] = psum[i];
            }else {
                ans[i] = psum[e] - psum[s - 1];
            }
        }
        return ans;
    }
    static void main(String[] args) {
        int[] arr = {3, 4, -2, 6, 8, 10, 13, 1};
        int[][] Q = {{1, 3}, {2, 6}, {5, 5}, {0, 3}};
        System.out.println(Arrays.toString(rangeSum(arr, Q)));
        System.out.println(Arrays.toString(rangeSumQueries(arr, Q)));

//        int[] A = {2, 4, 5, -3, 17, 8};
//        System.out.println(Arrays.toString(prefixSum(A)));
//        int[] B = {2, 9, -3, 5, 1};
//        System.out.println(Arrays.toString(prefixSum(B)));

    }
}
