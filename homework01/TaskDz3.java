import java.util.Scanner;

public class TaskDz3 {
    static Scanner clacScan = new Scanner(System.in);

    public static void main(String[] args) {

        double num_1 = getNumber();
        String op = getOperation();
        double num_2 = getNumber();
        double[] result = calculator(num_1, num_2, op);
        System.out.printf("%.0f %s %.0f = %.2f", num_1, op, result[0], result[1]);

    }

    public static double getNumber() {
        System.out.print("Введите число: ");
        double number = clacScan.nextDouble();
        return number;
    }

    public static String getOperation() {
        System.out.print("Введите символ операции (+ - * /): ");
        String operation = clacScan.next();
        return operation;
    }

    public static double[] calculator(double first, double second, String operation) {
        double[] result = new double[2];

        switch (operation) {
            case "+":
                result = new double[] { second, first + second };
                return result;
            case "-":
                result = new double[] { second, first - second };
                return result;
            case "*":
                result = new double[] { second, first * second };
                return result;
            case "/":
                String divisor = String.valueOf(second);
                System.out.println(divisor);
                switch (divisor) {
                    case "0.0":
                        System.out.println("Делить на ноль нельзя! Введите второе число повторно.");
                        second = getNumber();
                        result = calculator(first, second, operation);
                        return result;
                    default:
                        result = new double[] { second, first / second };
                        return result;
                }
            default:
                break;
        }
        return result;
    }
}