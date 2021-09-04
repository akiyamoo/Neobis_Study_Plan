    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            String password;
            char c;
            boolean upperCase = false, digit = false, lowerCase = false, check = false;

            while (in.hasNext()){

                password = in.nextLine();

                for (int i = 0; i < password.length(); i++) {

                    c = password.charAt(i);
                    if (!upperCase)
                        upperCase = Character.isUpperCase(c);
                    if (!lowerCase)
                        lowerCase = Character.isLowerCase(c);
                    if (!digit)
                        digit = Character.isDigit(c);
                    check = !Character.isLetterOrDigit(c);
                    if (check) break;

                }


                if (    upperCase
                        && password.length() >= 6 && password.length() <= 32
                        && !check
                        && !password.contains(" ")
                        && lowerCase
                        && digit
                    ) {
                    System.out.println("Senha valida.");
                }
                else
                    System.out.println("Senha invalida.");

                upperCase = digit = lowerCase = check = false;

            }
        }
    }
