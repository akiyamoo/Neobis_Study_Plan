import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : string.toCharArray()) {
            switch (c) {
                case 'a': case 'e':
                case 'u': case 'i': case 'o':
                    stringBuilder.append(c);
                    break;
            }
        }
        string = stringBuilder.toString();
        stringBuilder.reverse();
        int i = 0;
        for (char c : stringBuilder.toString().toCharArray()) {
            if (c != string.charAt(i)) {
                System.out.println("N");
                return;
            }
            i++;
        }
        System.out.println("S");
/*        System.out.println(string);
        System.out.println(stringBuilder);*/
    }
}
