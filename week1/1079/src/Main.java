import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++){
            double a = in.nextDouble() * 2;
            double b = in.nextDouble() * 3;
            double c = in.nextDouble() * 5;
            System.out.println(Math.round(((a + b + c) / 10) * 10.0) / 10.0);
        }
    }
}