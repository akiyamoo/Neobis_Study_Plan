import java.util.Scanner;


public class Main{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char с = Character.toUpperCase(in.next().charAt(0));
        double[][] a = new double[12][12];
        double sum = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                a[i][j] = in.nextDouble();

            }
            sum += a[i][n];
        }
        if (с == 'M') {
            double s = sum / 12;
            s = Math.round(s * 10.0) / 10.0;
            System.out.println(s);
        }
        else if (с == 'S'){
            System.out.println(sum);
        }
    }
}
