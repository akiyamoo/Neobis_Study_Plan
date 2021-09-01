import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        double temp;
        boolean f = true;

        if (c > b){
            temp = b;
            b = c;
            c = temp;
        }
        if (b > a){
            temp = a;
            a = b;
            b = temp;
        }

        if (a >= b + c) {
            System.out.println("NAO FORMA TRIANGULO");
            f = false;
        }
        //
        else if (pow(a, 2) == pow(b, 2) + pow(c, 2))
            System.out.println("TRIANGULO RETANGULO");
        //
        else if (pow(a, 2) > pow(b, 2) + pow(c, 2))
            System.out.println("TRIANGULO OBTUSANGULO");
        //
        else if (pow(a, 2) < pow(b, 2) + pow(c, 2))
            System.out.println("TRIANGULO ACUTANGULO");
        //

        if (f)
            if (a == b && b == c)
                System.out.println("TRIANGULO EQUILATERO");
            else if (a == b || b == c || a == c)
                System.out.println("TRIANGULO ISOSCELES");
    }
}
