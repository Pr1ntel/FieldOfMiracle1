import java.util.Random;

public class reversMas {
    public static void main(String[] args) {
        Random random = new Random();
        int min = 1, max = 5;
        int n = 4, m = 4;
        int mas[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {


                mas[i][j] = random.nextInt(max - min + 1) + min;
                System.out.print( mas[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
            int temp = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n / 2; j++) {
                    temp = mas[i][j];
                    mas[i][j] = mas[i][n - j - 1];
                    mas[i][n - j - 1] = temp;
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(mas[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

