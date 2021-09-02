import java.util.Scanner;

public class Main {
    static long arr[] = new long[61];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n;
        for (int i = 0; i < t; i++){
            n = scanner.nextInt();
            System.out.println("Fib(" + n + ") = " + arr[n]);
        }
    }

    static {
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
    }
}