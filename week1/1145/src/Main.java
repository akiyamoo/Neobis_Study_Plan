import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt() - 1;
        int y = in.nextInt();
        int j = 0;
        for (int i = 1; i <= y; i++){
            if(j <= x - 1) {
                System.out.print(i + " ");
                j++;
            }
            else if (j == x) {
                System.out.println(i);
                j = 0;
            }
        }
    }
}