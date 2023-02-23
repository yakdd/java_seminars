import java.util.LinkedList;
import java.util.Scanner;

// Реализовать консольное приложение, которое:
// 1. Принимает от пользователя строку вида text~num
// 2. Нужно рассплитить строку по ~, сохранить text в связный список (LinkedList) на позицию num.
// 3. Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.

public class Seminar41 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();

        String text = "";
        while (!text.equals("q")) {

            System.out.println("Введите строку: ");
            String input = scan.nextLine();

            String[] elem = input.split("~");
            text = elem[0];
            int pos = Integer.parseInt(elem[1]);
            if (elem[0].equalsIgnoreCase("print")) {
                System.out.println(list.get(pos));
                list.remove(pos);
                System.out.println(list);
            } else {
                list.add(pos, elem[0]);
                System.out.println(list);
            }
        }

        System.out.println(list);
        scan.close();
    }
}
