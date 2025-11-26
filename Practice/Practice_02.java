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
    static void main(String[] args) {
        char[] ch = {'b', 'a', 'a', 'g', 'd', 'c', 'a', 'g'};
        System.out.println(countPair(ch));
        char[] ch2 = {'a', 'd','g', 'a', 'g', 'a', 'g', 'f', 'g'};
        System.out.println(countPair(ch2));
        System.out.println(countPair2(ch));
        System.out.println(countPair2(ch2));
    }
}
