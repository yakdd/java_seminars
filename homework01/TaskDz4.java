
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class TaskDz4 {
    public static void main(String[] args) {
        System.out.print("Введите уравнение: ");
        Scanner strScan = new Scanner(System.in);
        String equation = strScan.nextLine();
        equation = equation.replaceAll("\\s", "");
        strScan.close();

        parserInput(equation);
    }

    // ?? + 1? = 69
    // ?2 + 5? = 89
    // ?2 + 75 = ??
    public static void parserInput(String equation) {
        String[] expr = new String[2];
        expr = equation.split("[+=]");

        int[] first = parseElement(expr[0]);
        int[] second = parseElement(expr[1]);
        int[] result = parseElement(expr[2]);

        // Диапазон возможных значений первого слагаемого:
        ArrayList<Integer> firstRange = new ArrayList<Integer>();
        firstRange = createRange(first);

        // Диапазон возможных значений второго слагаемого:
        ArrayList<Integer> secondRange = new ArrayList<Integer>();
        secondRange = createRange(second);

        // Диапазон возможных значений результата:
        ArrayList<Integer> resultRange = new ArrayList<Integer>();
        resultRange = createRange(result);

        boolean flag = true;
        for (int num1 : firstRange) {
            for (int num2 : secondRange) {
                int res = num1 + num2;
                if (resultRange.contains(res)) {
                    flag = false;
                    System.out.printf("%d + %d = %d \n", num1, num2, res);
                }
            }
        }
        if (flag) {
            System.out.println("Нет решений");
        }
    }

    public static int[] parseElement(String elem) {
        int bool_flag = 1;
        int number = 0;
        int k = 10;

        for (int i = 0; i < elem.length(); i++) {
            String pos = "" + elem.charAt(i);
            try {
                int num = Integer.parseInt(pos);
                num *= k;
                number += num;
                k /= 10;
            } catch (NumberFormatException e) {
                int num = 0;
                number += num;
                k /= 10;
                bool_flag = 0;
            }
        }
        return new int[] { number, bool_flag };
    }

    public static ArrayList<Integer> createRange(int[] number) {

        ArrayList<Integer> numberRange = new ArrayList<Integer>();
        if (number[1] == 1) {
            numberRange.add(number[0]);
        } else if (number[1] == 0) {

            int begin = 0;
            int end = 0;
            int step = 0;

            if (number[0] == 0) {
                begin = 0;
                end = 100;
                step = 1;
            } else if (number[0] < 10) {
                begin = 10 + number[0];
                end = 91 + number[0];
                step = 10;
            } else if (number[0] >= 10) {
                begin = number[0];
                end = number[0] + 10;
                step = 1;
            }

            for (int i = begin; i < end; i += step) {
                numberRange.add(i);
            }
        }
        return numberRange;
    }
}
