
/**
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после
 * каждой итерации запишите в лог-файл.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class TaskDz22 {
    public static void main(String[] args) throws IOException {

        int[] array = new int[] { 7, 5, 1, 3, 4, 2, 1, 8, 3, 6, 0 };
        System.out.println(Arrays.toString(array));

        int iter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    iter++;

                    // строка для логгирования:
                    StringBuilder iteration = new StringBuilder();
                    String part1 = iter + "перестановка: ";
                    iteration.append(part1);
                    String part2 = Arrays.toString(array);
                    iteration.append(part2);
                    writeLog(iteration.toString());
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }

    private static void writeLog(String array) throws IOException {
        try (FileWriter log = new FileWriter("log.txt", true)) {
            log.append(array + "\n");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
