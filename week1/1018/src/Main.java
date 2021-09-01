import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = n;

        //100
        int hundred = (n - (n % 100)) / 100;
        n -= hundred * 100;

        //50
        int fifty = (n - n % 50) / 50;
        n -= fifty * 50;

        //20
        int twenty = (n - n % 20) / 20;
        n -= twenty * 20;

        //10
        int ten = (n - n % 10) / 10;
        n -= ten * 10;


        //5
        int five = (n - n % 5) / 5;
        n -= five * 5;

        //2
        int two = (n - n % 2) / 2;
        n -= two * 2;

        //1
        int one = (n - n % 1) / 1;
        n -= one * 1;

        System.out.println(ans); 
        System.out.println(hundred + " nota(s) de R$ 100,00");
        System.out.println(fifty + " nota(s) de R$ 50,00");
        System.out.println(twenty + " nota(s) de R$ 20,00");
        System.out.println(ten + " nota(s) de R$ 10,00");
        System.out.println(five + " nota(s) de R$ 5,00");
        System.out.println(two + " nota(s) de R$ 2,00");
        System.out.println(one + " nota(s) de R$ 1,00");
    }
}