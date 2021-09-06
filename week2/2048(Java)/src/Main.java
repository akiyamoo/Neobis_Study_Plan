import java.util.Scanner;

public class Main {
    static int a[][] = new int[4][4];
    static int check[][] = new int[4][4];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                a[i][j] = in.nextInt();

        int n = in.nextInt();

        switch (n){
            case 0: null0(); break;
            case 1: null1(); break;
            case 2: null2(); break;
            case 3: null3(); break;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 3) {
                    System.out.println(a[i][j]);
                    continue;
                }
                System.out.print(a[i][j] + " ");
            }
           // System.out.println();
        }

    }

    public static void null0(){
        int i = 0;
        int j = 3;
        while (i < 4) {
            while (j > 0) {
                if (a[i][j - 1] == 0) {
                    a[i][j - 1] = a[i][j];
                    a[i][j] = 0;
                } // if
                if (a[i][2] != 0 && a[i][1] == 0) j = 2;
                else if (a[i][3] != 0 && a[i][2] == 0) j = 3;
                else if (a[i][1] != 0 && a[i][0] == 0) j = 1;
                else j--;
            }// for vt1
            j = 0;
            while (j < 3) {
                if (a[i][j + 1] == a[i][j] && check[i][j] == 0 && check[i][j + 1] == 0) {
                    a[i][j] += a[i][j + 1];
                    a[i][j + 1] = 0;
                    check[i][j + 1] = 0;
                    check[i][j] = 1;
                } // if
                else if (a[i][j + 1] != 0 && a[i][j] == 0) {
                    a[i][j] = a[i][j + 1];
                    a[i][j + 1] = 0;
                    if (check[i][j + 1] == 1) {
                        check[i][j] = 1;
                        check[i][j + 1] = 0;
                    }
                } // if
                j++;
            } // for vt2
            j = 3;
            while (j > 0) {
                if (a[i][j - 1] == 0) {
                    a[i][j - 1] = a[i][j];
                    a[i][j] = 0;
                } // if
                if (a[i][2] != 0 && a[i][1] == 0) j = 2;
                else if (a[i][3] != 0 && a[i][2] == 0) j = 3;
                else if (a[i][1] != 0 && a[i][0] == 0) j = 1;
                else j--;
            }// for vt1
            j = 0;
            while (j < 3) {
                if (a[i][j + 1] == a[i][j] && check[i][j] == 0 && check[i][j + 1] == 0) {
                    a[i][j] += a[i][j + 1];
                    a[i][j + 1] = 0;
                    check[i][j + 1] = 0;
                    check[i][j] = 1;
                } // if
                else if (a[i][j + 1] != 0 && a[i][j] == 0) {
                    a[i][j] = a[i][j + 1];
                    a[i][j + 1] = 0;
                    if (check[i][j + 1] == 1) {
                        check[i][j] = 1;
                        check[i][j + 1] = 0;
                    }
                } // if
                j++;
            } // for vt2
            i++;
            j = 3;
        } // for vn
    }

    public static void null1(){
        int i = 0;
        int j = 3;
        while (i < 4) {
            while (j > 0) {
                if (a[j - 1][i] == 0) {
                    a[j - 1][i] = a[j][i];
                    a[j][i] = 0;
                } // if
                if (a[2][i] != 0 && a[1][i] == 0) j = 2;
                else if (a[3][i] != 0 && a[2][i] == 0) j = 3;
                else if (a[1][i] != 0 && a[0][i] == 0) j = 1;
                else j--;
            }// for vt1
            j = 0;
            while (j < 3) {
                if (a[j + 1][i] == a[j][i] && check[j][i] == 0 && check[j + 1][i] == 0) {
                    a[j][i] += a[j + 1][i];
                    a[j + 1][i] = 0;
                    check[j + 1][i] = 0;
                    check[j][i] = 1;
                } // if
                else if (a[j + 1][i] != 0 && a[j][i] == 0) {
                    a[j][i] = a[j + 1][i];
                    a[j + 1][i] = 0;
                    if (check[j + 1][i] == 1) {
                        check[j][i] = 1;
                        check[j + 1][i] = 0;
                    }
                } // if
                j++;
            } // for vt2
            j = 3;
            while (j > 0) {
                if (a[j - 1][i] == 0) {
                    a[j - 1][i] = a[j][i];
                    a[j][i] = 0;
                } // if
                if (a[2][i] != 0 && a[1][i] == 0) j = 2;
                else if (a[3][i] != 0 && a[2][i] == 0) j = 3;
                else if (a[1][i] != 0 && a[0][i] == 0) j = 1;
                else j--;
            }// for vt1;
            j = 0;
            while (j < 3) {
                if (a[j + 1][i] == a[j][i] && check[j][i] == 0 && check[j + 1][i] == 0) {
                    a[j][i] += a[j + 1][i];
                    a[j + 1][i] = 0;
                    check[j + 1][i] = 0;
                    check[j][i] = 1;
                } // if
                else if (a[j + 1][i] != 0 && a[j][i] == 0) {
                    a[j][i] = a[j + 1][i];
                    a[j + 1][i] = 0;
                    if (check[j + 1][i] == 1) {
                        check[j][i] = 1;
                        check[j + 1][i] = 0;
                    }
                } // if
                j++;
            } // for vt2
            i++;
            j = 3;
        } // for vn
    }

    public static void null2(){
        int i = 0;
        int j = 0;
        while (i < 4) {
            while (j < 3) {
                if (a[i][j + 1] == 0) {
                    a[i][j + 1] = a[i][j];
                    a[i][j] = 0;
                } // if
                if (a[i][1] != 0 && a[i][2] == 0) j = 1;
                else if (a[i][2] != 0 && a[i][3] == 0) j = 2;
                else if (a[i][0] != 0 && a[i][1] == 0) j = 0;
                else j++;
            }// for vt1
            j = 3;
            while (j > 0) {
                //println("${a[3][1]} + ${a[3][2]} c = ${check[3][1]} c2 = ${check[3][2]}")
                if (a[i][j] == a[i][j - 1] && check[i][j] == 0 && check[i][j - 1] == 0) {
                    a[i][j] += a[i][j - 1];
                    a[i][j - 1] = 0;
                    check[i][j - 1] = 0;
                    check[i][j] = 1;
                } // if
                else if (a[i][j] == 0 && a[i][j - 1] != 0) {
                    a[i][j] = a[i][j - 1];
                    a[i][j - 1] = 0;
                    if (check[i][j - 1] == 1) {
                        check[i][j] = 1;
                        check[i][j - 1] = 0;
                    }
                } // if
                j--;
            } // for vt2
            j = 0;
            while (j < 3) {
                if (a[i][j + 1] == 0) {
                    a[i][j + 1] = a[i][j];
                    a[i][j] = 0;
                } // if
                if (a[i][1] != 0 && a[i][2] == 0) j = 1;
                else if (a[i][2] != 0 && a[i][3] == 0) j = 2;
                else if (a[i][0] != 0 && a[i][1] == 0) j = 0;
                else j++;
            }// for vt1;
            j = 3;
            while (j > 0) {
                //println("${a[3][1]} + ${a[3][2]} c = ${check[3][1]} c2 = ${check[3][2]}")
                if (a[i][j] == a[i][j - 1] && check[i][j] == 0 && check[i][j - 1] == 0) {
                    a[i][j] += a[i][j - 1];
                    a[i][j - 1] = 0;
                    check[i][j - 1] = 0;
                    check[i][j] = 1;
                } // if
                else if (a[i][j] == 0 && a[i][j - 1] != 0) {
                    a[i][j] = a[i][j - 1];
                    a[i][j - 1] = 0;
                    if (check[i][j - 1] == 1) {
                        check[i][j] = 1;
                        check[i][j - 1] = 0;
                    }
                } // if
                j--;
            } // for vt2
            i++;
            j = 0;
        } // for vn
    }

    public static void null3(){
        int i = 0;
        int j = 0;
        while (i < 4) {
            while (j < 3) {
                if (a[j + 1][i] == 0) {
                    a[j + 1][i] = a[j][i];
                    a[j][i] = 0;
                } // if
                if (a[1][i] != 0 && a[2][i] == 0) j = 1;
                else if (a[2][i] != 0 && a[3][i] == 0) j = 2;
                else if (a[0][i] != 0 && a[1][i] == 0) j = 0;
                else j++;
            }// for vt1
            j = 3;
            while (j > 0) {
                if (a[j][i] == a[j - 1][i] && check[j][i] == 0 && check[j - 1][i] == 0) {
                    a[j][i] += a[j - 1][i];
                    a[j - 1][i] = 0;
                    check[j - 1][i] = 0;
                    check[j][i] = 1;
                } // if
                else if (a[j][i] == 0 && a[j - 1][i] != 0) {
                    a[j][i] = a[j - 1][i];
                    a[j - 1][i] = 0;
                    if (check[j - 1][i] == 1) {
                        check[j][i] = 1;
                        check[j - 1][i] = 0;
                    }
                } // if
                j--;
            } // for vt2
            j = 0;
            while (j < 3) {
                if (a[j + 1][i] == 0) {
                    a[j + 1][i] = a[j][i];
                    a[j][i] = 0;
                } // if
                if (a[1][i] != 0 && a[2][i] == 0) j = 1;
                else if (a[2][i] != 0 && a[3][i] == 0) j = 2;
                else if (a[0][i] != 0 && a[1][i] == 0) j = 0;
                else j++;
            }// for vt1
            while (j > 0) {
                if (a[j][i] == a[j - 1][i] && check[j][i] == 0 && check[j - 1][i] == 0) {
                    a[j][i] += a[j - 1][i];
                    a[j - 1][i] = 0;
                    check[j - 1][i] = 0;
                    check[j][i] = 1;
                } // if
                else if (a[j][i] == 0 && a[j - 1][i] != 0) {
                    a[j][i] = a[j - 1][i];
                    a[j - 1][i] = 0;
                    if (check[j - 1][i] == 1) {
                        check[j][i] = 1;
                        check[j - 1][i] = 0;
                    }
                } // if
                j--;
            } // for vt2
            i++;
            j = 0;
        } // for vn
    }

}
