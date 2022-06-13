import java.util.Scanner;

public class main4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLatter;
        int key;
        int choice;
        String fullAlf = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        fullAlf = new String(fullAlf.toCharArray());
        for (int i = 0; i < fullAlf.length(); i++) {
            System.out.print(fullAlf.charAt(i) + " ");
        }
        System.out.println("Введите русские буквы для зашифровки/расшифровки");
        inputLatter = scan.next();
        inputLatter = new String(inputLatter.toCharArray());
        for (int i = 0; i < fullAlf.length(); i++) {
            System.out.print(fullAlf.charAt(i) + " ");
        }

        System.out.println();
        System.out.println("Что сделать? 1 - зашифровать. 2 - расшифровать.");
        choice = scan.nextInt();
        System.out.println("Выбрать шаг шифровки.");
        key = scan.nextInt();
        if (choice == 1) {
            for (int i = 0; i < inputLatter.length(); i++) {
                for (int j = 0; j < fullAlf.length(); j++) {
                    if (inputLatter.charAt(i) == fullAlf.charAt(j)) {
                        System.out.print(fullAlf.charAt(j + key));
                    }
                }
            }
        } else if (choice == 2) {
            for (int i = 0; i < inputLatter.length(); i++) {
                for (int j = 0; j < fullAlf.length(); j++) {
                    if (inputLatter.charAt(i) == fullAlf.charAt(j)) {
                        System.out.print(fullAlf.charAt(j - key));
                    }
                }
            }
        }
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

