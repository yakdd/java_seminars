import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// Реализовать консольное приложение, которое:
// 1. Принимает от пользователя и “запоминает” строки.
// 2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
// 3. Если введено revert, удаляет предыдущую введенную строку из памяти

public class Seminar42 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<String> stack = new ArrayDeque<>();
        String comm = "";

        while (true) {
            System.out.print("Введите строку: ");
            comm = scan.nextLine();

            if (comm.equalsIgnoreCase("q")) {
                break;
            } else if (comm.equalsIgnoreCase("print")) {
                for (String string : stack) {
                    System.out.printf("  %s\n", string);
                }
            } else if (comm.equalsIgnoreCase("revert")) {
                stack.pop();
                System.out.println(stack);
            } else {
                stack.push(comm);
                System.out.println(stack);
            }
        }
        System.out.println(stack);
        scan.close();
    }
}
