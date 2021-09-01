import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double s = in.nextDouble();
        double ans = s;

        int n = (int) s;
        s = s - n;
        int n2 = (int)(Math.round(s * 100.0) / 100.0 * 100);

        //100 banknotes
        int hundred = (n - (n % 100)) / 100;
        n -= hundred * 100;

        //50 banknotes
        int fifty = (n - n % 50) / 50;
        n -= fifty * 50;

        //20 banknotes
        int twenty = (n - n % 20) / 20;
        n -= twenty * 20;

        //10 banknotes
        int ten = (n - n % 10) / 10;
        n -= ten * 10;


        //5 banknotes
        int five = (n - n % 5) / 5;
        n -= five * 5;

        //2 banknotes
        int two = (n - n % 2) / 2;
        n -= two * 2;

        //1 moeda
        int one = (n - n % 1) / 1;
        //n -= one * 1;

        //0.5 moeda
        int fiftyCent = (n2 - n2 % 50) / 50;
        n2 -= fiftyCent * 50;

        //0.25 moeda
        int twentyFiveCent = (n2 - n2 % 25) / 25;
        n2 -= twentyFiveCent * 25;

        //0.10 moeda
        int tenCent = (n2 - n2 % 10) / 10;
        n2 -= tenCent * 10;

        //0.05 moeda
        int fiveCent = (n2 - n2 % 5) / 5;
        n2 -= fiveCent * 5;

        //0.01 moeda
        int oneCent = (n2 - n2 % 1) / 1;
        //n2 -= fiveCent * 5;

        System.out.println("NOTAS:");
        System.out.println(hundred + " nota(s) de R$ 100.00");
        System.out.println(fifty + " nota(s) de R$ 50.00");
        System.out.println(twenty + " nota(s) de R$ 20.00");
        System.out.println(ten + " nota(s) de R$ 10.00");
        System.out.println(five + " nota(s) de R$ 5.00");
        System.out.println(two + " nota(s) de R$ 2.00");
        System.out.println("MOEDAS:");
        System.out.println(one + " moeda(s) de R$ 1.00");
        System.out.println(fiftyCent + " moeda(s) de R$ 0.50");
        System.out.println(twentyFiveCent + " moeda(s) de R$ 0.25");
        System.out.println(tenCent + " moeda(s) de R$ 0.10");
        System.out.println(fiveCent + " moeda(s) de R$ 0.05");
        System.out.println(oneCent + " moeda(s) de R$ 0.01");
        //System.out.println(n2);
    }
}