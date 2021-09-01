import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int pa, pb;
        double g1, g2;
        double res;
        int j = 0;

        for (int i = 0; i < t; i++){
            pa = in.nextInt();
            pb = in.nextInt();
            g1 = in.nextDouble();
            g2 = in.nextDouble();

            while (pa <= pb) {
                pa += (pa * g1 / 100);
                pb += (pb * g2 / 100);
                j++;
                if (j > 100){
                    System.out.println("Mais de 1 seculo.");
                    break;
                }
            }
            if (j <= 100)
                System.out.println(j + " anos.");
            j = 0;
        }
    }
}
