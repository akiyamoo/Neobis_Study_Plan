import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int length;
        String str1, str2;
        StringBuilder answer = new StringBuilder();
        while (n > 0) {
            str1 = in.next();
            str2 = in.next();
            length = Math.max(str1.length(), str2.length());
            for (int i = 0; i < length; i++) {
                if (i < str1.length()) {
                    answer.append(str1.charAt(i));
                }

                if (i < str2.length()) {
                    answer.append(str2.charAt(i));
                }

            }
            System.out.println(answer);
            answer.delete(0, answer.length());
            n--;
        }
    }
}
