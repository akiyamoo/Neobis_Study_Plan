import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            String compare;
            int length, lowIndex = 0, maxLength = 0;

            if (str1.equals(str2)) {
                System.out.println(str1.length());
                continue;
            }
            if (str1.length() > str2.length())
                length = str1.length();
            else
                length = str2.length();

            for (int i = 1; i <= length; i++) {
                if (str1.length() < i)
                    break;
                compare = str1.substring(lowIndex, i);
                if (str2.contains(compare)) {
                    if (maxLength < i - lowIndex) {
                            maxLength = i - lowIndex;
                    }
                } else
                    lowIndex++;
            }
            System.out.println(maxLength);
            maxLength = lowIndex = length = 0;
        }
    }
}
