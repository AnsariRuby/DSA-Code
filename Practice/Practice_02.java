package Learn_DSA.Practice;

public class Practice_02 {
    // 1. Given a char ch[] of size N, calculate number of pairs indices = i, j such that i < j && ch[i] == 'a && ch[j] == 'g'.
    // All characters in array are in lowercase.
    public static int countPair(char[] arr) {
        int count = 0;
        int n =  arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == 'a' && arr[j] == 'g') {
                    count++;
                }
            }
        }
        return count;
    }
    public static int countPair2(char[] arr) {
        int count = 0;
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'a') {
                count++;
            }else if (arr[i] == 'g') {
                ans += count;
            }
        }
        return ans;
    }

    // 2. Leaders in an Array
    // Given an array arr[] of size n, you have to find leaders in arr.
    // Note 1: arr[i] is said leader if it is greater than max of all elements from left side [0, i - 1]
    // Note 2: arr[0] is considered as leader
    public static int leadersInArray(int[] arr) {
        int count = 1;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int max = arr[0];
            for (int j = 0; j < i; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            if (arr[i] > max) {
                count++;
            }
        }
        return count;
    }
    public static int leaders(int[] arr) {
        int n = arr.length;
        int count = 1;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                count++;
            }
        }
        return count;
    }

    // 3. Given n bulbs and their initial states, each bulb has a switch associated to it. If we click on switch :
    // Every bulb on RIGHT including current bulb is flipped. Min number of time we have to click on bulb so that every bulb will 'ON'
    public static int bulbClickCount(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count++;
                arr[i] = 1;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] == 1) {
                        arr[j] = 0;
                    }else {
                        arr[j] = 1;
                    }
                }
            }
        }
        return count;
    }
    public static int bulbCount(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0 && count % 2 == 0) {
                count++;
            }else if (arr[i] == 1 && count % 2 != 0) {
                count++;
            }
        }
        return count;
    }
    static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 0};
//        System.out.println(bulbClickCount(arr));
        System.out.println(bulbCount(arr));

//        int[] arr = {3, 2, 4, 5, 2, 7, 1, 15};
//        System.out.println(leadersInArray(arr));
//        System.out.println(leaders(arr));

//        char[] ch = {'b', 'a', 'a', 'g', 'd', 'c', 'a', 'g'};
//        System.out.println(countPair(ch));
//        char[] ch2 = {'a', 'd','g', 'a', 'g', 'a', 'g', 'f', 'g'};
//        System.out.println(countPair(ch2));
//        System.out.println(countPair2(ch));
//        System.out.println(countPair2(ch2));
    }
}
