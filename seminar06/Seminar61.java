
/**
 * 1. Напишите метод, который заполнит массив из 1000 элементов случайными
 * числами от 0 до 24.
 * Создайте метод, в который передайте заполненный выше массив,
 * и с помощью Set вычислите процент уникальных значений в данном массиве,
 * и верните его в виде числа с плавающей запятой.
 * Для вычисления процента используйте формулу:
 * процент уникальных чисел = количество уникальных чисел * 100 / общее
 * количество чисел в массиве.
 */
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Seminar61 {
    static Random rnd = new Random();

    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(25);
        }
        System.out.println(percentUnique(array));
    }

    private static float percentUnique(int[] array) {
        Set<Integer> unique = new HashSet<>();
        for (Integer num : array) {
            unique.add(num);
        }
        return unique.size() * 100f / array.length; // 100f - перевод расчета в тип float
    }
}
