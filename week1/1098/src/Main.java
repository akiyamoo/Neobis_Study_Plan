public class Main{
    public static void main(String[] args) {
        int i = 0, i2 = 0, j = 1;
        while (i < 3 && i2 < 11){
            for (j = 1; j < 4; j++) {
                if (i2 == 0)
                    System.out.println("I=" + i + " J=" + (j + i));
                else if(i != 2) 
                    System.out.println("I=" + i + "." + i2 + " J=" + (j + i) + "." + i2);
            }
            i2 += 2;
            if (i2 == 10) {
                i2 = 0;
                i++;
            }
            if (i == 3) break;
        }
    }
}
