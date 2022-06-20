import java.io.*;
import java.util.Scanner;


public class BuseShop {

    static class Buse {
        public Buse(String model, int radius, int size, int price, int quantity) {
            this.quantity = quantity;
            this.model = model;
            this.size = size;
            this.price = price;
            this.radius = radius;
        }

        public int radius;
        public int quantity;
        public String model;
        public int size;
        int price;
    }

    static Buse createBuse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название модели: ");
        String model = scanner.nextLine();
        System.out.println("Введите радиус шины: ");
        int radius = scanner.nextInt();                                     //создание новой шины
        System.out.println("Введите типоразмер шины: ");
        int size = scanner.nextInt();
        System.out.println("Введите цену за 1 шину: ");
        int price = scanner.nextInt();
        System.out.println("Введите количество остатка шин на складе: ");
        int quantity = scanner.nextInt();
        return new Buse(model, radius, size, price, quantity);
    }

    static Buse[] createArrayBuses() {
        return new Buse[0];                                                 //создание пустого массива под данные
    }

    static Buse[] addBuseInArray(Buse[] buses, Buse insertBuse) {
        Buse[] tempBuses = new Buse[buses.length + 1];
        for (int i = 0; i < buses.length; i++) {
            tempBuses[tempBuses.length - 1] = insertBuse;
            return tempBuses;
        }
        return tempBuses;
    }

    static void printlnHaders() {
        System.out.println(String.format("%-10s%-7s%-10s%-8s%-18s", "МОДЕЛЬ", "РАДИУС", "ТИПОРАЗМЕР", "ЦЕНА", "ОСТАТОК НА СКЛАДЕ"));
    }

    static void printlnBuseAddTable(Buse buse) {
        System.out.println(String.format("%-10s%-7s%-10s%-8s%-18s", buse.model, buse.radius, buse.size, buse.price, buse.quantity));
    }

    static void printlnBuse(Buse[] buses) {
        if (buses.length == 0) {
            System.out.println("Список пуст");
            return;
        }
        for (int i = 0; i < buses.length; i++) {
            printlnBuseAddTable(buses[i]);
        }
        System.out.println("В списке шин - " + buses.length + "элементов");
    }

    static void printRazdel() {
        System.out.println("-".repeat(18));
    }

    static void printlnMenu() {
        System.out.println("Меню");
        System.out.println("Что вы хотите сделать?");
        System.out.println("1.Добавить шину");
        System.out.println("2.Сохранить в файл");
        System.out.println("3.Загрузить файл");
        System.out.println("4.Продать шину");
        System.out.println("0.Выход из программы");
    }

    static void saveBusesTxt(String filename, Buse[] buses) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(Integer.toString(buses.length));
        bufferedWriter.newLine();

        for (int i = 0; i < buses.length; i++) {
            bufferedWriter.write(Integer.toString(buses[i].quantity));
            bufferedWriter.newLine();

            bufferedWriter.write(buses[i].model);
            bufferedWriter.newLine();

            bufferedWriter.write(Integer.toString(buses[i].radius));
            bufferedWriter.newLine();

            bufferedWriter.write(Integer.toString(buses[i].size));
            bufferedWriter.newLine();

            bufferedWriter.write(Integer.toString(buses[i].price));
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();

        }
    }

    static Buse[] loadBuseTxt(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int buseslangth = Integer.parseInt(bufferedReader.readLine());
        Buse[] buses = new Buse[buseslangth];

        for (int i = 0; i < buses.length; i++) {
            int radius = Integer.parseInt(bufferedReader.readLine());
            String model = bufferedReader.readLine();
            int price = Integer.parseInt(bufferedReader.readLine());
            int size = Integer.parseInt(bufferedReader.readLine());
            int quantity = Integer.parseInt(bufferedReader.readLine());

            buses[i] = new Buse(radius, model, price, quantity, size);                                  //В ЧЕМ ПРОБЛЕМА???
        }
        bufferedReader.close();
        fileReader.close();

        return buses;
    }

    static String inputString(String message) {
        boolean isValidInput;
        String output = "";
        do {
            try {
                isValidInput = true;
                Scanner scanner = new Scanner(System.in);

                System.out.print(message);
                output = scanner.nextLine();
            } catch (Exception e) {
                isValidInput = false;
                System.out.println("Ошибка ввода. Пожалуйста повторите ввод");
            }

        } while (isValidInput == false);

        return output;
    }

    static int inputInt(String message, int min, int max) {
        boolean isValidInput;
        int output = 0;
        do {
            try {
                isValidInput = true;
                Scanner scanner = new Scanner(System.in);

                System.out.print(message);
                output = scanner.nextInt();

                if (output < min || output > max) {
                    System.out.println("Ошибка ввода. Вы вышли за границы диапазона от " + min + " до " + max);
                    throw new Exception();
                }

            } catch (Exception e) {
                isValidInput = false;
                System.out.println("Ошибка ввода. Пожалуйста повторите ввод");
            }

        } while (isValidInput == false);

        return output;
    }


    public static void main(String[] main) throws IOException {
        Buse[] buses = createArrayBuses();
        while (true) {


            printlnHaders();
            printlnBuse(buses);
            printRazdel();
            printlnMenu();
            int menuPoint = inputInt("Введите номер пункта", 0, 4);
            switch (menuPoint) {

                case 1: {
                    Buse addsBuse = createBuse();
                    buses = addBuseInArray(buses, addsBuse);
                }
                break;
            }
        }
    }
}