package Homework2;

public class Homework2 {
    public static void main(String[] args) {
        /*1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
         */
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.print("Задание 1. Задан массив:       [ 1 1 0 0 1 0 1 1 0 0 ]");
        System.out.print("\nМассив с измененными элементами: ");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (arr1[i] == 0) ? 1 : 0;
            System.out.print(arr1[i] + " ");
        }

        /*2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
         */
        int[] arr2 = new int[8];

        System.out.print("\n\nЗадание 2. Задан массив: ");

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 3;
            System.out.print(arr2[i] + " ");
        }

        /*3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом, и числа, меньшие 6, умножить на 2;
         */
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        System.out.print("\n\nЗадание 3. Задан массив       [ 1 5 3 2 11 4 5 2 4 8 9 1 ]\nМассив после выполнения цикла: ");

        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) arr3[i] *= 2;
            System.out.print(arr3[i] + " ");
        }

        /*4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами;*/

        int[][] arr4 = new int[4][4];

        System.out.print("\n\nЗадание 4. Массив:\n");

        for (int i = 0, j = arr4.length - 1; i < arr4.length; i++, j--) {
            arr4[i][i] = 1;
            arr4[i][j] = 1;

            for (int k : arr4[i]) {
                System.out.print(arr4[i][k] + " ");
            }

            System.out.println();
        }

        /* 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета); */

        int[] arr5 = {1, 5, 3, 2, 11, 0, 5, 2, 4, 8, 9, 1 };
        int min = 0;
        int max = 0;

        if (arr5[0] > arr5[1]) min = 1;
        else max = 1;

        for (int i = 2; i<arr5.length; i++) {
            if (arr5[i] > arr5[max]) max = i;
            if (arr5[i] < arr5[min]) min = i;
        }

        System.out.print("\n\nЗадание 5. Задан массив:  ");

        for (int i:arr5) {
            System.out.print(arr5[i] + " ");
        }

        System.out.print("\nЗначение максимального элемента массива: " + arr5[max]);
        System.out.print("\nЗначение минимального элемента массива: " + arr5[min]);

/*6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
если в массиве есть место, в котором сумма левой и правой части массива равны.
Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят;*/

        int[] arr6 = {1, 11, 3, 1, 5, 3};
        System.out.print("\n\nЗадача 6.");
        System.out.print("\nРезультат метода: " + checkBalance(arr6));
    }

    static boolean checkBalance(int[] arr) {
        int leftSum = 0;
        int rightSum = 0;
        boolean result = false;

        for (int i = 1; i < arr.length; i++) {

            for (int j = 0; j < i; j++) {   //Считаем сумму слева
                leftSum += arr[j];
            }
            System.out.print("\nШаг " + i + ". Cумма левые/правые: " + leftSum + " / ");

            for (int k = i; k < arr.length; k++) {  // Считаем сумму справа
                rightSum += arr[k];
            }
            System.out.print(rightSum);

            if (leftSum == rightSum) result = true;

            leftSum = 0;
            rightSum = 0;
        }
        return result;
    }
}
