import java.io.*;
import java.util.Scanner;

public class main4 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String inputLatter = bufferedReader.readLine();
        int key = Integer.parseInt(bufferedReader.readLine());
        int choice = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();
        fileReader.close();
        String fullAlf = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        fullAlf = new String(fullAlf.toCharArray());
        for (int i = 0; i < fullAlf.length(); i++) {
            System.out.print(fullAlf.charAt(i) + " ");
        }
       // System.out.println("Введите русские буквы для зашифровки/расшифровки");

        inputLatter = new String(inputLatter.toCharArray());
        for (int i = 0; i < fullAlf.length(); i++) {
            System.out.print(fullAlf.charAt(i) + " ");
        }

        System.out.println();
       // System.out.println("Что сделать? 1 - зашифровать. 2 - расшифровать.");
       // choice = scan.nextInt();
        //System.out.println("Выбрать шаг шифровки.");
       // key = scan.nextInt();
        FileWriter fileWriter = new FileWriter("output.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        if (choice == 1) {
            for (int i = 0; i < inputLatter.length(); i++) {
                for (int j = 0; j < fullAlf.length(); j++) {
                    if (inputLatter.charAt(i) == fullAlf.charAt(j)) {
                       bufferedWriter.write(fullAlf.charAt(j + key));
                    }
                }
            }
        }
        else if (choice == 2) {

            for (int i = 0; i < inputLatter.length(); i++) {
                for (int j = 0; j < fullAlf.length(); j++) {
                    if (inputLatter.charAt(i) == fullAlf.charAt(j)) {
                       bufferedWriter.write(fullAlf.charAt(j - key));
                    }
                }
            }
        }
        bufferedWriter.close();
        fileWriter.close();
    }

}

/* if (fullAlf.indexOf(inputLatter) != -1){
            return fullAlf.charAt((fullAlf.indexOf(inputLatter)+key)%fullAlf);
        }*/

       /* for (int i = 0; i < inputLatter.length(); i++) {
            for (int j = 0; j < fullAlf.length(); j++) {
                if (i==j){
                    inputLatter[i]==fullAlf.
                }
            }*/

