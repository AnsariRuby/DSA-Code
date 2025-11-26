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

    // 3. Equilibrium Index
    // GIen an array A[] of size N, Find the Equilibrium index. i is an equilibrium index when :
    // Sum of all the elements in left side of i  = Sum of all the elements in right side of i
    public static int equilibrium(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int lsum = 0;
            for (int j = 0; j < i; j++) {
                lsum += A[j];
            }
            int rsum = 0;
            for (int j = i + 1; j < n; j++) {
                rsum += A[j];
            }
            if (lsum == rsum) {
                return i;
            }
        }
        return -1;
    }
    public static int equilibriumIndex(int[] A) {
        int n = A.length;
        int[] psum = prefixSum(A);
        for (int i = 0; i < n; i++) {
            int lsum = 0;
            if (i > 0) {
                lsum = psum[i - 1];
            }
            int rsum = psum[n - 1] - psum[i];
            if (lsum == rsum) {
                return i;
            }
        }
        return -1;
    }
    public static int equilibriumIndex2(int[] A) {
        int n = A.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
        }
        int lsum = 0;
        for (int i = 0; i < n; i++) {
            lsum += A[i];
            if (lsum == sum) {
                return i;
            }
            sum -= A[i];
        }
        return -1;
    }

    // 4. Even Number for Q query
    public static int[] evenNumber(int[] A, int[][] B) {
        int q = B.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int s = B[i][0];
            int e = B[i][1];
            int count = 0;
            for (int j = s; j <= e; j++) {
                if (A[j] % 2 == 0) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
    public static int[] prefixCount(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        if (A[0] % 2 == 0) {
            ans[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (A[i] % 2 == 0) {
                ans[i] = ans[i - 1] + 1;
            }else {
                ans[i] = ans[i - 1];
            }
        }
        return ans;
    }
    public static int[] evenNumberQuery(int[] A, int[][] B) {
        int q = B.length;
        int[] ans = new int[q];
        int[] count = prefixCount(A);
        for (int i = 0; i < q; i++) {
            int s = B[i][0];
            int e = B[i][1];
            if (s == 0) {
                ans[i] = count[e];
            }else {
                ans[i] = count[e] - count[s-1];
            }
        }
        return ans;
    }
    static void main(String[] args) {
//        int[] A = {3, 5, 8, 9, 16, 14, 13, 12};
//        int[][] B = {{1, 5}, {2, 6}, {4, 5}, {4, 4}, {3, 6}};
//        System.out.println(Arrays.toString(evenNumber(A, B)));
//        System.out.println(Arrays.toString(evenNumberQuery(A, B)));

//        int[] arr = {-7, 5, 1, 2, -4, 3, 0};
//        System.out.println(equilibrium(arr));
//        int[] A = {1, 2, 3};
//        System.out.println(equilibrium(A));
//        System.out.println(equilibriumIndex(arr));
//        System.out.println(equilibriumIndex(A));
//        System.out.println(equilibriumIndex2(arr));
//        System.out.println(equilibriumIndex2(A));

//        int[] arr = {3, 4, -2, 6, 8, 10, 13, 1};
//        int[][] Q = {{1, 3}, {2, 6}, {5, 5}, {0, 3}};
//        System.out.println(Arrays.toString(rangeSum(arr, Q)));
//        System.out.println(Arrays.toString(rangeSumQueries(arr, Q)));

//        int[] A = {2, 4, 5, -3, 17, 8};
//        System.out.println(Arrays.toString(prefixSum(A)));
//        int[] B = {2, 9, -3, 5, 1};
//        System.out.println(Arrays.toString(prefixSum(B)));

    }
}
