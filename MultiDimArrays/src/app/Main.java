package app;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /*int[][] array = new int[][] {
                {1, 24, 17, 2},
                {4, 26, 35, 14},
                {42, 12, 9, 19},
                {21, 34, 49, 13}
        };*/

        // Магічний квадрат - для тесту
        int[][] array = new int[][] {
                {4, 14, 15, 1},
                {9, 7, 6, 12},
                {5, 11, 10, 8},
                {16, 2, 3, 13}
        };

        printArray(array);

        int rowsNumber = rowsNumber(array);
        int columnsNumber = columnsNumber(array);

        // Сума елементів
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < columnsNumber; j++) {
                if (i % 2 == 0) {
                    sumEven += array[i][j];
                } else {
                    sumOdd += array[i][j];
                }
            }
        }

        System.out.println("Сума елементів у парних рядках: " + sumEven);
        System.out.println("Сума елементів у непарних рядках: " + sumOdd);


        // Добуток елементів
        long multiplyEven = 1;
        long multiplyOdd = 1;
        for (int j = 0; j < columnsNumber; j++) {
            for (int i = 0; i < rowsNumber; i++) {
                if (j % 2 == 0) {
                    multiplyEven *= array[i][j];
                } else {
                    multiplyOdd *= array[i][j];
                }
            }
        }

        System.out.println("Добуток елементів у парних стовпцях: " + multiplyEven);
        System.out.println("Добуток елементів у непарних стовпцях: " + multiplyOdd);
        System.out.println();


        // Магічний квадрат
        boolean isMagicRectangle = isMagicRectangle(array);
        if (isMagicRectangle) {
            System.out.println("Матриця є магічним квадратом");
        } else {
            System.out.println("Матриця не є магічним квадратом");
        }

    }

    static void printArray(int[][] array) {
        System.out.println("Матриця 4x4");

        int rowsNumber = rowsNumber(array);
        int columnsNumber = columnsNumber(array);
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < columnsNumber; j++ ) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }

    static boolean isMagicRectangle(int[][] array) {
        int rowsNumber = rowsNumber(array);
        int columnsNumber = columnsNumber(array);

        // Якщо кількість рядків і стовпчиків не співпадає - то матриця не є магічним квадратом
        if (rowsNumber != columnsNumber) {
            return false;
        }

        // Перевіряємо чи є хоч один елемент менше 1. Якщо так, повертаємо false - матриця не є магічним квадратом
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < columnsNumber; j++) {
                if (array[i][j] < 1) {
                    return false;
                }
            }
        }


        // Беремо за основу суму елементів в першому рядку і будемо порівнювати всі інші рядки, стовпчики і діагоналі з цим числом
        int base = 0;

        int[] firstRow = array[0];
        for (int element : firstRow) {
            base += element;
        }


        // Порівнюємо суму всіх рядків з основою (base)
        // Якщо знаходимо першу невідповідність сум - завершуємо пошук і повертаємо false
        for (int i = 0; i < rowsNumber; i++) {
            int rowSum = 0;
            for (int j = 0; j < columnsNumber; j++) {
                rowSum += array[i][j];
            }

            if (rowSum != base) {
                return false;
            }
        }


        // Порівнюємо суму всіх стовбців з основою (base)
        // Якщо знаходимо першу невідповідність сум - завершуємо пошук і повертаємо false
        for (int j = 0; j < columnsNumber; j++) {
            int colSum = 0;
            for (int i = 0; i < rowsNumber; i++) {
                colSum += array[i][j];
            }

            if (colSum != base) {
                return false;
            }
        }


        // Порівнюємо суму діагоналей з основою (base)
        // Перша діагональ
        int diagonalSum = 0;
        for (int i = 0; i < rowsNumber; i++) {
            diagonalSum += array[i][i];
        }

        if (diagonalSum != base) {
            return false;
        }

        // Друга діагональ
        diagonalSum = 0;
        for (int i = 0; i < rowsNumber; i++) {
            diagonalSum += array[i][rowsNumber - 1 - i];
        }

        if (diagonalSum != base) {
            return false;
        }

        return true;
    }

    // Повертає кількість рядків
    static int rowsNumber(int[][] array) {
        return array.length;
    }

    // Повертає кількість стовпчиків
    static int columnsNumber(int[][] array) {
        return array[0].length;
    }


}
