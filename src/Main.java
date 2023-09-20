import java.util.Scanner;

class MatrixCalculator {
    private int[][] matrix;
    private int size;

    public MatrixCalculator(int size) {
        this.size = size;
        this.matrix = new int[size][size];
    }

    public void inputMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("Элемент [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public double calculateMainDiagonalAverage() {
        double mainDiagonalSum = 0;
        for (int i = 0; i < size; i++) {
            mainDiagonalSum += matrix[i][i];
        }
        return mainDiagonalSum / size;
    }

    public double calculateSecondaryDiagonalAverage() {
        double secondaryDiagonalSum = 0;
        for (int i = 0; i < size; i++) {
            secondaryDiagonalSum += matrix[i][size - 1 - i];
        }
        return secondaryDiagonalSum / size;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите размер матрицы (n): ");
            int size = scanner.nextInt();

            MatrixCalculator calculator = new MatrixCalculator(size);
            calculator.inputMatrix();

            double mainDiagonalAverage = calculator.calculateMainDiagonalAverage();
            double secondaryDiagonalAverage = calculator.calculateSecondaryDiagonalAverage();

            System.out.println("Среднее значение на главной диагонали: " + mainDiagonalAverage);
            System.out.println("Среднее значение на побочной диагонали: " + secondaryDiagonalAverage);

            double ratio = mainDiagonalAverage / secondaryDiagonalAverage;
            System.out.println("Отношение среднего значения на главной диагонали к среднему значению на побочной диагонали: " + ratio);

            System.out.print("Хотите продолжить (1 - да, 0 - нет)? ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
        }

        scanner.close();
    }
}
