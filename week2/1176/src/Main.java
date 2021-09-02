import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x;
        for (int i = 0; i < n; i++){
            x = scanner.nextInt();
            if(checkPerfectNumber(x))
                System.out.println(x + " eh perfeito");
            else
                System.out.println(x + " nao eh perfeito");
        }
    }

    public static boolean checkPerfectNumber(int n){
        int x = 1;
        int y = 2;
        if (n == 1) return false;
        while (n % y == 0){
                x += n / y + y;
                y *= 2;
        }
        if (x == n) return true;

        return false;
    }
}
