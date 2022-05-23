import java.util.Random;
import java.util.Scanner;

public class Rascheska {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int min = 1, max = 999;
        System.out.println("Ввести кол-во элементов в массиве(от 1 до 999): ");
        int arrayCount = scan.nextInt();
        int [] array = new int[arrayCount];
        System.out.println("Вывод массива: ");
        for (int i = 0; i < array.length ; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
            System.out.print(array[i] + " ");
        }
        System.out.println();


        //sorting Сначала идет расческа, потом пузырьком


        int gap = array.length; // интервал
        boolean isSorted = false; // подобие пузырьковой сорт
        while (!isSorted || gap != 1){ //Цикл будет идти пока sorted не станет else или пока интервал не равен 1
            if (gap>1){ //если интервал больше 1
                gap = gap*10/13; // Формула с интернета(уменьшенеие инетрвала на 1, пока есть куда уменьшать)
            }else{
                gap = 1; // интервал 1 это алгоритм пузырьком.
            }
            isSorted = true;
            for (int i = gap; i < array.length ; i++) {
                if (array[i-gap]>array[i]){ //уменьшение интервала
                    int temp =array[i];  // алгоритм пузырьковой сортировки
                    array[i] = array[i-1];
                    array[i-1] = temp;
                    isSorted = false;
                }
            }
        }
    }
}
