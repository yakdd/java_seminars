
/**
 * Пусть дан список сотрудников: Иван, Пётр, Антон и так далее.
 * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
 * Отсортировать по убыванию популярности.
 */
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Homework52 {
    public static void main(String[] args) {
        String[] staff = {
                "Антон",
                "Пётр", "Пётр",
                "Иван", "Иван", "Иван",
                "Сергей",
                "Дмитрий", "Дмитрий", "Дмитрий" };

        Map<String, Integer> frequencyList = createHashMap(staff);
        Map<String, Integer> sortedList = sortingList(frequencyList);
        printStaffList(sortedList);
    }

    private static Map<String, Integer> createHashMap(String[] staff) {
        // создаем на основе массива имен HashMap<Имя, Частота>:
        Map<String, Integer> frequencyList = new HashMap<>();
        for (String name : staff) {
            frequencyList.putIfAbsent(name, 0);
            frequencyList.computeIfPresent(name, (key, value) -> value += 1);
        }
        return frequencyList;
    }

    private static Map<String, Integer> sortingList(Map<String, Integer> frequencyList) {
        // на основе набора значений создаем массив и сортируем его по убыванию:
        int[] numbers = new int[frequencyList.size()];
        int k = 0;
        for (int num : frequencyList.values())
            numbers[k++] = num;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        // строим на основе отсортированного массива LinkedHashMap<Имя, Частота>:
        Map<String, Integer> sortedList = new LinkedHashMap<>();
        for (int count : numbers) {
            for (var employee : frequencyList.entrySet())
                if (employee.getValue() == count)
                    sortedList.put(employee.getKey(), employee.getValue());
        }
        return sortedList;
    }

    private static void printStaffList(Map<String, Integer> list) {
        for (var employee : list.entrySet())
            System.out.printf("%s - %d \n", employee.getKey(), employee.getValue());
    }
}
