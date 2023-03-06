
/**
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один
 * человек может иметь несколько телефонов.
 */
import java.util.*;
import java.util.Scanner;

public class Homework51 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, LinkedList<String>> phoneBook = new HashMap<>();

        while (true) {
            System.out.print("Добавить абонента? (y/n) ");
            String answer = scan.nextLine();
            if (answer.equals("y"))
                fillBook(phoneBook);
            else
                break;
        }

        printBook(phoneBook);

    }

    private static void fillBook(Map<String, LinkedList<String>> phoneBook) {
        LinkedList<String> numbers = new LinkedList<>();

        System.out.print("Введите имя: ");
        String name = scan.nextLine();

        while (true) {
            System.out.print("Добавить номер телефона? (y/n) ");
            String answer = scan.nextLine();
            if (answer.equals("y")) {
                int index = numbers.size() + 1;
                System.out.printf("%d-й номер: ", index);
                String number = scan.nextLine();
                numbers.add(number);
            } else
                break;
        }
        phoneBook.put(name, numbers);
    }

    private static void printBook(Map<String, LinkedList<String>> phoneBook) {
        for (var item : phoneBook.entrySet()) {
            System.out.println(item.getKey() + ":");
            for (String number : item.getValue()) {
                System.out.println("\t" + number);
            }
        }
    }
}