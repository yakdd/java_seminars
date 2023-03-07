
/**
 * 1. Создайте HashSet, заполните его: {1, 2, 3, 2, 4, 5, 6, 3}.
 * Распечатайте содержимое данного множества.
 * 2. Создайте LinkedHashSet, заполните: {1, 2, 3, 2, 4, 5, 6, 3}.
 * Распечатайте содержимое данного множества.
 * 3. Создайте TreeSet, заполните: {1, 2, 3, 2, 4, 5, 6, 3}.
 * Распечатайте содержимое данного множества.
 */
import java.util.*;

public class Seminar60 {
    public static void main(String[] args) {
        // Создаем HashMap так, если значения заранее неизвестны:
        // Set<Integer> hashSet = new HashSet<>();
        // hashSet.addAll(List.of(1, 2, 3, 2, 4, 4, 3, 6, 5, 6, 3));

        // Либо так:
        Set<Integer> hashSet = new HashSet<>(List.of(404, 505, 606, 101, 202, 303));
        System.out.println(hashSet);
        // HashSet - 'произвольный' порядок вставки

        Set<Integer> linkedHashSet = new LinkedHashSet<>(List.of(404, 505, 606, 101, 202, 303));
        System.out.println(linkedHashSet);
        // LinkedHashSet - соблюдает порядок вставки

        Set<Integer> treeSet = new TreeSet<>(List.of(404, 505, 606, 101, 202, 303));
        System.out.println(treeSet);
        // TreeSet - сортирует по ключу
    }
}