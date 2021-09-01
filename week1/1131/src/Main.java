import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b, inter = 0, gremio = 0, count = 0, draws = 0;
        while (true){
            a = in.nextInt();
            b = in.nextInt();
            if (a > b) inter++;
            else if (b > a) gremio++;
            else draws++;
            count++;
            System.out.println("Novo grenal (1-sim 2-nao)");
            a = in.nextInt();
            if (a != 1) break;
        }
        System.out.println(count + " grenais");
        System.out.println("Inter:" + inter);
        System.out.println("Gremio:" + gremio);
        System.out.println("Empates:" + draws);
        if (inter > gremio)
            System.out.println("Inter venceu mais");
        else if (gremio > inter)
            System.out.println("Gremio venceu mais");
        else
            System.out.println("Não houve vencedor");
    }
}