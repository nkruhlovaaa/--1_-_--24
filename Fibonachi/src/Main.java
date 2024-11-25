import java.util.ArrayList;
import java.util.Scanner;

/**
 * Клас для обчислення і зберігання чисел Фібоначчі.
 */
class FibonacciNumber {
    private int index; // Індекс числа в послідовності Фібоначчі
    private long value; // Значення числа Фібоначчі

    /**
     * Конструктор для ініціалізації об'єкта числа Фібоначчі.
     *
     * @param index Індекс числа.
     * @param value Значення числа Фібоначчі.
     */
    public FibonacciNumber(int index, long value) {
        this.index = index;
        this.value = value;
    }

    /**
     * Повертає індекс числа Фібоначчі.
     *
     * @return Індекс числа.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Повертає значення числа Фібоначчі.
     *
     * @return Значення числа.
     */
    public long getValue() {
        return value;
    }

    /**
     * Статичний метод для обчислення числа Фібоначчі за індексом.
     *
     * @param n Індекс числа в послідовності.
     * @return Значення числа Фібоначчі.
     */
    public static long calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    /**
     * Метод для перевірки, чи можна число представити як w^3 - 1.
     *
     * @param value Значення числа.
     * @return true, якщо число можна представити як w^3 - 1, false в іншому випадку.
     */
    public static boolean isOneLessThanCube(long value) {
        long cubeRoot = Math.round(Math.cbrt(value + 1)); // Округлення кубічного кореня
        return cubeRoot * cubeRoot * cubeRoot == value + 1; // Перевірка, чи є число на 1 менше ніж куб
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

// Введення кількості чисел Фібоначчі N
        System.out.println("Введіть кількість чисел Фібоначчі (N): ");
        int N = scanner.nextInt();

        ArrayList<FibonacciNumber> fibonacciNumbers = new ArrayList<>();

// Обчислення і збереження чисел Фібоначчі в об'єкти
        for (int i = 0; i < N; i++) {
            long value = FibonacciNumber.calculateFibonacci(i);
            fibonacciNumbers.add(new FibonacciNumber(i, value));
        }

// Виведення результатів
        System.out.println("Числа Фібоначчі та перевірка на w^3 - 1:");
        for (FibonacciNumber num : fibonacciNumbers) {
            System.out.println("Число " + num.getIndex() + ": " + num.getValue() +
                    (FibonacciNumber.isOneLessThanCube(num.getValue()) ? " (На 1 менше ніж куб)" : ""));
        }

        scanner.close();
    }
}

