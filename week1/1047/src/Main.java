import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int s1 = in.nextInt();
        int s2 = in.nextInt();
        int temp;
        int tempMin;
        if (n1 == s1 && n2 == s2)
            System.out.println("O JOGO DUROU 24 HORA(S) E 0 MINUTO(S)");
        else if (n1 == s1 && n2 > s2) {
            System.out.println("O JOGO DUROU 23 HORA(S) E " + (60 - (n2 - s2)) + " MINUTO(S)");
        }
        else if (n1 == s1 && n2 < s2){
            System.out.println("O JOGO DUROU 0 HORA(S) E " + (s2 - n2) + " MINUTO(S)");
        }
        else if (n1 > s1){
            temp = 24 - (n1 - s1);
            if (n2 > s2){
                temp--;
                tempMin = 60 - (n2 - s2);
            }
            else {
                tempMin = s2 - n2;
            }
            System.out.println("O JOGO DUROU " + temp + " HORA(S) E " + tempMin + " MINUTO(S)");
        }
        else {
            temp = s1 - n1;
            if (n2 > s2){
                temp--;
                tempMin = 60 - (n2 - s2);
            }
            else {
                tempMin = s2 - n2;
            }
            System.out.println("O JOGO DUROU " + temp + " HORA(S) E " + tempMin + " MINUTO(S)");
        }
    }
}