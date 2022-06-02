public class Main3 {

    static int[] createEmptyArray() {
        return new int[0];
    }

    static int[] addNewValueToEnd(int[] array, int value) {
        int[] tempArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }
        tempArray[tempArray.length - 1] = value;

        return tempArray;
    }

    static void updateValueByIndex(int[] array, int index, int value) {
        if (index > array.length - 1 || index < 0) {
            System.out.println("index out of array bound");
            return;
        }
        array[index] = value;
    }

    static int[] deleteValueByIndex(int[] array, int index) {
        if (index > array.length - 1 || index < 0) {
            System.out.println("Index out of bound array");
            return array;
        }
        int[] tempArray = new int [array.length-1];
        int tempArayIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (i!= index){
                tempArayIndex++;
                tempArray[tempArayIndex] = array[i];
            }
        }
        return tempArray;
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    static String convertArrayToString(int[] array, char delimiter) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                stringBuilder.append(array[i] + Character.toString(delimiter));
            } else {
                stringBuilder.append(array[i]);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int array[] = createEmptyArray();
        array = addNewValueToEnd(array, 10);
        array = addNewValueToEnd(array, 15);
        array = addNewValueToEnd(array, 20);
        printArray(array);
        updateValueByIndex(array, 0, 100);
        array = deleteValueByIndex(array, 1);
        String arrayInString = convertArrayToString(array, ',');
        System.out.println(arrayInString);
    }
}
