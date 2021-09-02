import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x;
        boolean f = true;
        for (int i = 0; i < n; i++){
            x = scanner.nextInt();
            f = true;
            if (x == 1) {
                System.out.println(x + " eh primo");
                continue;
            }
            int sqrt = (int) Math.sqrt(x);
            for (int j = 2; j < sqrt + 1; j++){
                if (x % j == 0){
                    System.out.println(x + " nao eh primo");
                    f = false;
                    break;
                }
            }
            if (f){
                System.out.println(x + " eh primo");
            }
        }
    }
}
