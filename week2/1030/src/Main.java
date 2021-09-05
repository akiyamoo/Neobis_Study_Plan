import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> listKill = new ArrayList<>();
        ListIterator<Integer> iterator;
        int n, k, kill = 0, l = 1;

        int nc = in.nextInt();

        for (int i = 1; i <= nc; i++){

            n = in.nextInt();
            k = in.nextInt();

            for (int j = 1; j <= n; j++){
                listKill.add(j);
            }

            iterator = listKill.listIterator();

            while (listKill.size() > 1){

                kill++;

                if (!iterator.hasNext()) {
                    while (iterator.hasPrevious()){
                        iterator.previous();
                    }
                }

                iterator.next();

                if (kill == k){
                    iterator.remove();
                    kill = 0;
                }
            }
            System.out.println("Case " + l + ": "+ listKill.get(0));
            l++;
            listKill.remove(0);
        }
    }
}
