
/**
 * В калькулятор добавьте возможность отменить последнюю операцию.
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class Homework43 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayDeque<Double> results = new ArrayDeque<>();
        double number = getNumber();
        boolean stop = false;
        results.add(number);

        while (true) {
            char oper = getOperation();
            if (oper == '=') {
                stop = true;
                showResult(results, stop);
                break;
            } else if (oper == 'c') {
                results.removeFirst();
                showResult(results, stop);
                oper = getOperation();
            }

            double nextNum = getNumber();

            if (nextNum == 0 && oper == '/') {
                System.out.println("Ошибка операции: деление на ноль.");
            } else {
                double lastResult = results.peek();
                number = calculator(lastResult, nextNum, oper);
                results.push(number);
                showResult(results, stop);
            }
        }
        scan.close();
    }

    private static void showResult(ArrayDeque<Double> results, boolean stop) {
        double result = results.peek();
        System.out.println("Результат = " + result);
        if (!stop) {
            System.out.println("   > для отмены последнего действия нажмите 'c'");
            System.out.println("   > для завершения вычислений нажмите '='");
        }
    }

    private static int getNumber() {
        System.out.print("Введите число: ");
        int number;
        if (scan.hasNextInt()) {
            number = scan.nextInt();
        } else {
            System.out.println("Ошибка ввода.");
            scan.next();
            number = getNumber();
        }
        return number;
    }

    private static char getOperation() {
        System.out.print("Введите операцию: ");
        char oper;
        if (scan.hasNextLine()) {
            oper = scan.next().charAt(0);
        } else {
            System.out.println("Ошибка ввода.");
            scan.next();
            oper = getOperation();
        }
        return oper;
    }

    private static double calculator(double first, double second, char oper) {
        double result;
        switch (oper) {
            case '+':
                result = first + second;
                break;
            case '-':
                result = first - second;
                break;
            case '*':
                result = first * second;
                break;
            case '/':
                result = first / second;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calculator(first, second, getOperation());
                break;
        }
        return result;
    }
}
