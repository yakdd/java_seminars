
/**
 * Реализуйте очередь с помощью LinkedList со следующими методами:
 * enqueue() - помещает элемент в конец очереди,
 * dequeue() - возвращает первый элемент из очереди и удаляет его,
 * first() - возвращает первый элемент из очереди, не удаляя.
 */

import java.util.LinkedList;

public class Homework42 {
    static LinkedList<String> list = new LinkedList<>();

    public static void main(String[] args) {
        String[] str = { "aaa", "bbb", "ccc", "ddd", "eee" };
        for (String string : str) {
            list.add(string);
        }
        System.out.println(list);

        String newElement = "null";
        enqueue(newElement);
        System.out.printf("\nДобавляем элемент в конец списка: %s \n", newElement);
        System.out.println(list);

        String firstElement = first();
        System.out.printf("\nПервый элемент списка: %s \n", firstElement);
        System.out.println(list);

        String deleteFirstElement = dequeue();
        System.out.printf("\nУдаляем первый элемент списка: %s \n", deleteFirstElement);
        System.out.println(list);
    }

    private static void enqueue(String element) {
        list.add(element);
    }

    private static String first() {
        return list.get(0);
    }

    private static String dequeue() {
        String element = list.get(0);
        list.remove(0);
        return element;
    }
}
