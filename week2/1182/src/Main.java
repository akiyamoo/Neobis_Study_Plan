import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String string;
        StringBuilder stringBuilder = new StringBuilder();
        char c;
        int x;
        while (n > 0) {

            string = in.next();
            stringBuilder.append(string);
            x = in.nextInt();

            for (int i = 0; i < stringBuilder.length(); i++){
                c = stringBuilder.charAt(i);

                if((int) c - x < 65)
                    c = (char)((int) c + 26);

                c = (char)((int) c - x);

                stringBuilder.setCharAt(i, c);
            }

            System.out.println(stringBuilder);
            stringBuilder.delete(0, stringBuilder.length());
            n--;

        }
        //System.out.println((int)'A');
    }
}
