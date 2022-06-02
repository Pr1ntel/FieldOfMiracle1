import java.util.Random;
import java.util.Scanner;

public class KrestAndNull {
    /*1) инициализация переменных.
    2) Приветствие игроков.
    3) Ввод размеров поля.
    4) Рандом выбор кто первым ходит.
    5) Вывод поля для игроков.
    6) Игровой процесс.
    7) Проверка на победу.
    8) Меню если никто не победил. Сделать кноку возвращения на 3 позицию.
    9) Вывод победителя
     */
    public enum Player {
        PlayerOne("Первый игрок"),
        PlayerTwo("Второй игрок"),
        NONE("Тут будет победитель");

        private String value;

        Player(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum FieldCell {
        KREST('X'),
        NULL('0'),
        EMPTY('*');

        private char value;

        FieldCell(char value) {
            this.value = value;
        }

        public char getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        //region Переменные
        FieldCell[][] gameField;
        int fieldSize = 0;
        boolean playGame = true;
        Player currentPlayer, WinPlayer = Player.NONE;

        //endregion
        //region приветствие
        System.out.println("Привет! Эта игра - крестики нолики.");
        System.out.println("Правила: набрать в ряд 3 крестика или 3 нолика для победы.");
        //region Рандом кто первый ходит
        if (random.nextInt(1000 + 1) > 500) {
            currentPlayer = Player.PlayerOne;
            System.out.println("первым ходит игрок 1 (X - крестик)");
        } else {
            currentPlayer = Player.PlayerTwo;
            System.out.println("первым ходит игрок 2 (0 - нолик)");
        }
        System.out.println("Для продолжения нажмите <Enter>");
        new Scanner(System.in).nextLine();
        //endregion
        boolean inputResult;
        do {
            System.out.println("Введите размер поля игры (3х3) или (5х5)!");
            inputResult = true;

            try {
                Scanner scanner = new Scanner(System.in);
                fieldSize = scanner.nextInt();

                if (fieldSize != 3 && fieldSize != 5) {
                    throw new Exception();
                }
            } catch (Exception e) {
                inputResult = false;
                System.out.println("Ошибка! Введите числа 3 или 5");
            }
        } while (inputResult == false);
        //endregion
        //region Вывод поля игры

        gameField = new FieldCell[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                gameField[i][j] = FieldCell.EMPTY;
            }
        }
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                System.out.print(gameField[i][j].getValue());
            }

            System.out.println();

        }
        //endregion
        //region Игоровой процесс
        while (playGame == true) {
            if (currentPlayer == Player.PlayerOne) {
                System.out.println("Ход игрока 1 (X).");

                Scanner scanner = new Scanner(System.in);
                int gorizont, vertikal;
                System.out.print(String.format("введите строчку от %d до %d: ", 1, fieldSize));
                gorizont = scanner.nextInt() - 1;

                System.out.print(String.format("введите столбец от %d до %d: ", 1, fieldSize));
                vertikal = scanner.nextInt() - 1;

                if (gameField[gorizont][vertikal] == FieldCell.EMPTY) {
                    gameField[gorizont][vertikal] = FieldCell.KREST;
                    currentPlayer = Player.PlayerTwo;
                }


                System.out.println("Поле игры");
                for (int i = 0; i < fieldSize; i++) {
                    for (int j = 0; j < fieldSize; j++) {
                        System.out.print(gameField[i][j].getValue());
                    }
                    System.out.println();
                }
            } else if (currentPlayer == Player.PlayerTwo) {

                System.out.println("Ход игрока 2 (0).");

                Scanner scanner = new Scanner(System.in);
                int gorizont, vertikal;
                System.out.print(String.format("введите строчку от %d до %d: ", 1, fieldSize));
                gorizont = scanner.nextInt() - 1;

                System.out.print(String.format("введите столбец от %d до %d: ", 1, fieldSize));
                vertikal = scanner.nextInt() - 1;

                if (gameField[gorizont][vertikal] == FieldCell.EMPTY) {
                    gameField[gorizont][vertikal] = FieldCell.NULL;
                    currentPlayer = Player.PlayerOne;
                }

                System.out.println("Поле игры");
                for (int i = 0; i < fieldSize; i++) {
                    for (int j = 0; j < fieldSize; j++) {
                        System.out.print(gameField[i][j].getValue());
                    }
                    System.out.println();


                }
            }
            if (Player.PlayerOne )
                //region проверка на победу
                if (gameField[0][0] == FieldCell.KREST && gameField[0][1] == FieldCell.KREST && gameField[0][2] == FieldCell.KREST ||//горизонт
                        gameField[1][0] == FieldCell.KREST && gameField[1][1] == FieldCell.KREST && gameField[1][2] == FieldCell.KREST || //горизонт 1
                        gameField[2][0] == FieldCell.KREST && gameField[2][1] == FieldCell.KREST && gameField[2][2] == FieldCell.KREST || //горизонт 2
                        gameField[3][0] == FieldCell.KREST && gameField[3][1] == FieldCell.KREST && gameField[3][2] == FieldCell.KREST || //горизонт 3
                        gameField[4][0] == FieldCell.KREST && gameField[4][1] == FieldCell.KREST && gameField[4][2] == FieldCell.KREST || //горизонт 4
                        gameField[0][1] == FieldCell.KREST && gameField[0][2] == FieldCell.KREST && gameField[0][3] == FieldCell.KREST || //горизонт 5
                        gameField[0][2] == FieldCell.KREST && gameField[0][3] == FieldCell.KREST && gameField[0][4] == FieldCell.KREST || //горизонт 6
                        gameField[1][1] == FieldCell.KREST && gameField[1][2] == FieldCell.KREST && gameField[1][3] == FieldCell.KREST || //горизонт 7
                        gameField[1][2] == FieldCell.KREST && gameField[1][3] == FieldCell.KREST && gameField[1][4] == FieldCell.KREST || // горизонт 8
                        gameField[2][1] == FieldCell.KREST && gameField[2][2] == FieldCell.KREST && gameField[2][3] == FieldCell.KREST || //горизонт 9
                        gameField[2][2] == FieldCell.KREST && gameField[2][3] == FieldCell.KREST && gameField[2][4] == FieldCell.KREST || // горизонт 10
                        gameField[3][1] == FieldCell.KREST && gameField[3][2] == FieldCell.KREST && gameField[3][3] == FieldCell.KREST || //горизонт 11
                        gameField[3][2] == FieldCell.KREST && gameField[3][3] == FieldCell.KREST && gameField[3][4] == FieldCell.KREST || //горизонт 12
                        gameField[4][1] == FieldCell.KREST && gameField[4][2] == FieldCell.KREST && gameField[4][3] == FieldCell.KREST || //горизонт 13
                        gameField[4][2] == FieldCell.KREST && gameField[4][3] == FieldCell.KREST && gameField[4][4] == FieldCell.KREST || //горизонт 14
                        gameField[0][0] == FieldCell.KREST && gameField[1][1] == FieldCell.KREST && gameField[2][2] == FieldCell.KREST || // \ - выбор 1 слева на право вниз
                        gameField[0][1] == FieldCell.KREST && gameField[1][2] == FieldCell.KREST && gameField[2][3] == FieldCell.KREST || // \ - выбор 2
                        gameField[0][2] == FieldCell.KREST && gameField[1][3] == FieldCell.KREST && gameField[2][4] == FieldCell.KREST || // \ - выбор 3
                        gameField[1][0] == FieldCell.KREST && gameField[2][1] == FieldCell.KREST && gameField[3][2] == FieldCell.KREST || // \ - выбор 4
                        gameField[1][1] == FieldCell.KREST && gameField[2][2] == FieldCell.KREST && gameField[3][3] == FieldCell.KREST || // \ - выбор 5
                        gameField[1][2] == FieldCell.KREST && gameField[2][3] == FieldCell.KREST && gameField[3][4] == FieldCell.KREST || // \ - выбор 6
                        gameField[2][0] == FieldCell.KREST && gameField[3][1] == FieldCell.KREST && gameField[4][2] == FieldCell.KREST || // \ - выбор 7
                        gameField[2][1] == FieldCell.KREST && gameField[3][2] == FieldCell.KREST && gameField[4][3] == FieldCell.KREST || // \ - выбор 8
                        gameField[2][2] == FieldCell.KREST && gameField[3][3] == FieldCell.KREST && gameField[4][4] == FieldCell.KREST || // \ - выбор 9
                        gameField[0][2] == FieldCell.KREST && gameField[1][1] == FieldCell.KREST && gameField[2][0] == FieldCell.KREST || // / - выбор 1 справо на лево вниз
                        gameField[0][3] == FieldCell.KREST && gameField[1][2] == FieldCell.KREST && gameField[2][1] == FieldCell.KREST || // / - выбор 2
                        gameField[0][4] == FieldCell.KREST && gameField[1][3] == FieldCell.KREST && gameField[2][2] == FieldCell.KREST || // / - выбор 3
                        gameField[1][2] == FieldCell.KREST && gameField[2][1] == FieldCell.KREST && gameField[3][0] == FieldCell.KREST || // / - выбор 4
                        gameField[1][3] == FieldCell.KREST && gameField[2][2] == FieldCell.KREST && gameField[3][1] == FieldCell.KREST || // / - выбор 5
                        gameField[1][4] == FieldCell.KREST && gameField[2][3] == FieldCell.KREST && gameField[3][2] == FieldCell.KREST || // / - выбор 6
                        gameField[2][2] == FieldCell.KREST && gameField[3][1] == FieldCell.KREST && gameField[4][0] == FieldCell.KREST || // / - выбор 7
                        gameField[2][3] == FieldCell.KREST && gameField[3][2] == FieldCell.KREST && gameField[4][1] == FieldCell.KREST || // / - выбор 8
                        gameField[2][4] == FieldCell.KREST && gameField[3][3] == FieldCell.KREST && gameField[4][2] == FieldCell.KREST || // / - выбор 9
                        gameField[0][0] == FieldCell.KREST && gameField[1][0] == FieldCell.KREST && gameField[2][0] == FieldCell.KREST || //вертикаль 1
                        gameField[1][0] == FieldCell.KREST && gameField[2][0] == FieldCell.KREST && gameField[3][0] == FieldCell.KREST || //вертикаль 2
                        gameField[2][0] == FieldCell.KREST && gameField[3][0] == FieldCell.KREST && gameField[4][0] == FieldCell.KREST || //вертикаль 3
                        gameField[0][1] == FieldCell.KREST && gameField[1][1] == FieldCell.KREST && gameField[2][1] == FieldCell.KREST ||//вертикаль 4
                        gameField[1][1] == FieldCell.KREST && gameField[2][1] == FieldCell.KREST && gameField[3][1] == FieldCell.KREST || // 5
                        gameField[2][1] == FieldCell.KREST && gameField[3][1] == FieldCell.KREST && gameField[4][1] == FieldCell.KREST ||// 6
                        gameField[1][2] == FieldCell.KREST && gameField[2][2] == FieldCell.KREST && gameField[3][2] == FieldCell.KREST ||// 7
                        gameField[0][2] == FieldCell.KREST && gameField[1][2] == FieldCell.KREST && gameField[2][2] == FieldCell.KREST ||// 7
                        gameField[2][2] == FieldCell.KREST && gameField[3][2] == FieldCell.KREST && gameField[4][2] == FieldCell.KREST ||// 8
                        gameField[0][3] == FieldCell.KREST && gameField[1][3] == FieldCell.KREST && gameField[2][3] == FieldCell.KREST ||// 9
                        gameField[1][3] == FieldCell.KREST && gameField[2][3] == FieldCell.KREST && gameField[3][3] == FieldCell.KREST ||//10
                        gameField[2][3] == FieldCell.KREST && gameField[3][3] == FieldCell.KREST && gameField[4][3] == FieldCell.KREST ||//11
                        gameField[0][4] == FieldCell.KREST && gameField[1][4] == FieldCell.KREST && gameField[2][4] == FieldCell.KREST ||//12
                        gameField[1][4] == FieldCell.KREST && gameField[2][4] == FieldCell.KREST && gameField[3][4] == FieldCell.KREST ||//13
                        gameField[2][4] == FieldCell.KREST && gameField[3][4] == FieldCell.KREST && gameField[4][4] == FieldCell.KREST ||
                        gameField[0][0] == FieldCell.NULL && gameField[0][1] == FieldCell.NULL && gameField[0][2] == FieldCell.NULL ||//горизонт
                        gameField[1][0] == FieldCell.NULL && gameField[1][1] == FieldCell.NULL && gameField[1][2] == FieldCell.NULL || //горизонт 1
                        gameField[2][0] == FieldCell.NULL && gameField[2][1] == FieldCell.NULL && gameField[2][2] == FieldCell.NULL || //горизонт 2
                        gameField[3][0] == FieldCell.NULL && gameField[3][1] == FieldCell.NULL && gameField[3][2] == FieldCell.NULL || //горизонт 3
                        gameField[4][0] == FieldCell.NULL && gameField[4][1] == FieldCell.NULL && gameField[4][2] == FieldCell.NULL || //горизонт 4
                        gameField[0][1] == FieldCell.NULL && gameField[0][2] == FieldCell.NULL && gameField[0][3] == FieldCell.NULL || //горизонт 5
                        gameField[0][2] == FieldCell.NULL && gameField[0][3] == FieldCell.NULL && gameField[0][4] == FieldCell.NULL || //горизонт 6
                        gameField[1][1] == FieldCell.NULL && gameField[1][2] == FieldCell.NULL && gameField[1][3] == FieldCell.NULL || //горизонт 7
                        gameField[1][2] == FieldCell.NULL && gameField[1][3] == FieldCell.NULL && gameField[1][4] == FieldCell.NULL || // горизонт 8
                        gameField[2][1] == FieldCell.NULL && gameField[2][2] == FieldCell.NULL && gameField[2][3] == FieldCell.NULL || //горизонт 9
                        gameField[2][2] == FieldCell.NULL && gameField[2][3] == FieldCell.NULL && gameField[2][4] == FieldCell.NULL || // горизонт 10
                        gameField[3][1] == FieldCell.NULL && gameField[3][2] == FieldCell.NULL && gameField[3][3] == FieldCell.NULL || //горизонт 11
                        gameField[3][2] == FieldCell.NULL && gameField[3][3] == FieldCell.NULL && gameField[3][4] == FieldCell.NULL || //горизонт 12
                        gameField[4][1] == FieldCell.NULL && gameField[4][2] == FieldCell.NULL && gameField[4][3] == FieldCell.NULL || //горизонт 13
                        gameField[4][2] == FieldCell.NULL && gameField[4][3] == FieldCell.NULL && gameField[4][4] == FieldCell.NULL || //горизонт 14
                        gameField[0][0] == FieldCell.NULL && gameField[1][1] == FieldCell.NULL && gameField[2][2] == FieldCell.NULL || // \ - выбор 1 слева на право вниз
                        gameField[0][1] == FieldCell.NULL && gameField[1][2] == FieldCell.NULL && gameField[2][3] == FieldCell.NULL || // \ - выбор 2
                        gameField[0][2] == FieldCell.NULL && gameField[1][3] == FieldCell.NULL && gameField[2][4] == FieldCell.NULL || // \ - выбор 3
                        gameField[1][0] == FieldCell.NULL && gameField[2][1] == FieldCell.NULL && gameField[3][2] == FieldCell.NULL || // \ - выбор 4
                        gameField[1][1] == FieldCell.NULL && gameField[2][2] == FieldCell.NULL && gameField[3][3] == FieldCell.NULL || // \ - выбор 5
                        gameField[1][2] == FieldCell.NULL && gameField[2][3] == FieldCell.NULL && gameField[3][4] == FieldCell.NULL || // \ - выбор 6
                        gameField[2][0] == FieldCell.NULL && gameField[3][1] == FieldCell.NULL && gameField[4][2] == FieldCell.NULL || // \ - выбор 7
                        gameField[2][1] == FieldCell.NULL && gameField[3][2] == FieldCell.NULL && gameField[4][3] == FieldCell.NULL || // \ - выбор 8
                        gameField[2][2] == FieldCell.NULL && gameField[3][3] == FieldCell.NULL && gameField[4][4] == FieldCell.NULL || // \ - выбор 9
                        gameField[0][2] == FieldCell.NULL && gameField[1][1] == FieldCell.NULL && gameField[2][0] == FieldCell.NULL || // / - выбор 1 справо на лево вниз
                        gameField[0][3] == FieldCell.NULL && gameField[1][2] == FieldCell.NULL && gameField[2][1] == FieldCell.NULL || // / - выбор 2
                        gameField[0][4] == FieldCell.NULL && gameField[1][3] == FieldCell.NULL && gameField[2][2] == FieldCell.NULL || // / - выбор 3
                        gameField[1][2] == FieldCell.NULL && gameField[2][1] == FieldCell.NULL && gameField[3][0] == FieldCell.NULL || // / - выбор 4
                        gameField[1][3] == FieldCell.NULL && gameField[2][2] == FieldCell.NULL && gameField[3][1] == FieldCell.NULL || // / - выбор 5
                        gameField[1][4] == FieldCell.NULL && gameField[2][3] == FieldCell.NULL && gameField[3][2] == FieldCell.NULL || // / - выбор 6
                        gameField[2][2] == FieldCell.NULL && gameField[3][1] == FieldCell.NULL && gameField[4][0] == FieldCell.NULL || // / - выбор 7
                        gameField[2][3] == FieldCell.NULL && gameField[3][2] == FieldCell.NULL && gameField[4][1] == FieldCell.NULL || // / - выбор 8
                        gameField[2][4] == FieldCell.NULL && gameField[3][3] == FieldCell.NULL && gameField[4][2] == FieldCell.NULL || // / - выбор 9
                        gameField[0][0] == FieldCell.NULL && gameField[1][0] == FieldCell.NULL && gameField[2][0] == FieldCell.NULL || //вертикаль 1
                        gameField[1][0] == FieldCell.NULL && gameField[2][0] == FieldCell.NULL && gameField[3][0] == FieldCell.NULL || //вертикаль 2
                        gameField[2][0] == FieldCell.NULL && gameField[3][0] == FieldCell.NULL && gameField[4][0] == FieldCell.NULL || //вертикаль 3
                        gameField[0][1] == FieldCell.NULL && gameField[1][1] == FieldCell.NULL && gameField[2][1] == FieldCell.NULL ||//вертикаль 4
                        gameField[1][1] == FieldCell.NULL && gameField[2][1] == FieldCell.NULL && gameField[3][1] == FieldCell.NULL || // 5
                        gameField[2][1] == FieldCell.NULL && gameField[3][1] == FieldCell.NULL && gameField[4][1] == FieldCell.NULL ||// 6
                        gameField[1][2] == FieldCell.NULL && gameField[2][2] == FieldCell.NULL && gameField[3][2] == FieldCell.NULL ||// 7
                        gameField[0][2] == FieldCell.NULL && gameField[1][2] == FieldCell.NULL && gameField[2][2] == FieldCell.NULL ||// 7
                        gameField[2][2] == FieldCell.NULL && gameField[3][2] == FieldCell.NULL && gameField[4][2] == FieldCell.NULL ||// 8
                        gameField[0][3] == FieldCell.NULL && gameField[1][3] == FieldCell.NULL && gameField[2][3] == FieldCell.NULL ||// 9
                        gameField[1][3] == FieldCell.NULL && gameField[2][3] == FieldCell.NULL && gameField[3][3] == FieldCell.NULL ||//10
                        gameField[2][3] == FieldCell.NULL && gameField[3][3] == FieldCell.NULL && gameField[4][3] == FieldCell.NULL ||//11
                        gameField[0][4] == FieldCell.NULL && gameField[1][4] == FieldCell.NULL && gameField[2][4] == FieldCell.NULL ||//12
                        gameField[1][4] == FieldCell.NULL && gameField[2][4] == FieldCell.NULL && gameField[3][4] == FieldCell.NULL ||//13
                        gameField[2][4] == FieldCell.NULL && gameField[3][4] == FieldCell.NULL && gameField[4][4] == FieldCell.NULL) {//14

                }
                //endregion


        }
    }
}