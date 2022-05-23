import java.util.Scanner;

public class Pole {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final char CONST_HIDDEN_LETTER = '*';
        char[] originalWord;
        String question;
        char[] guessword;

        boolean isGuessed;

        System.out.print("Введите загадку:");
        question = scan.nextLine();

        System.out.print("Введите загаданное слово:");
        originalWord = scan.nextLine().toCharArray();

        guessword = new char[originalWord.length];

        for (int i = 0; i < guessword.length; i++) {
            guessword[i] = CONST_HIDDEN_LETTER;
        }
        do {
            // clear strok
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }

            System.out.println(question);
            System.out.println("Отгаданное слово");
            for (int i = 0; i < guessword.length; i++) {
                System.out.print(guessword[i] + " ");
            }
            System.out.println();

            System.out.println("Введите предполагаемую букву или слово целиком: ");
            String inputLine = scan.nextLine();
            if (inputLine.length() == 1) {
                char inputLatter =inputLine.charAt(0);
                boolean isFound = false;
                for (int i = 0; i < originalWord.length; i++) {
                    if (originalWord[i] == inputLatter) {
                        guessword[i] = inputLatter;
                        isFound = true;
                    }
                }
                if (isFound == true) {
                    System.out.println("Поздравляю такая буква есть!");
                } else {
                    System.out.println("Такой буквы нет!");
                }
                System.out.println("Для продолжения нажать <Enter>");
                scan.nextLine();
                isGuessed = true;
                for (int i = 0; i < guessword.length; i++) {
                    if (guessword[i] == CONST_HIDDEN_LETTER) {
                        isGuessed = false;
                        break;
                    }
                }
            }else{
                isGuessed = true;
                char[] inputWord = inputLine.toCharArray();
                if (originalWord.length != inputWord.length){
                    isGuessed = false;
                }else{
                    for (int i = 0; i < originalWord.length; i++) {
                        if (originalWord[i] != inputWord[i]){
                            isGuessed = false;
                        }
                    }
                }
                if (isGuessed == true){
                    for (int i = 0; i < inputWord.length; i++) {
                        guessword[i] = inputWord[i];
                    }
                }
            }
        } while (isGuessed == false);
        // clear strok
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("Вы отгадали! Исходное слово: ");
        for (int i = 0; i < guessword.length; i++) {
            System.out.print(guessword[i]);
        }
    }
}
