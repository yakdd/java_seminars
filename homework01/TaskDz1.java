
// Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
import java.util.Scanner;

public class TaskDz1 {
    public static void main(String[] args) {

        System.out.println("Введите целое число: ");
        Scanner myScan = new Scanner(System.in);
        int number = myScan.nextInt();

        int summ = progression(number);
        System.out.printf("Сумма чисел от 1 до %d = %d\n", number, summ);

        long factorial = factorial(number);
        System.out.printf("Произведение чисел от 1 до %d = %d\n", number, factorial);

        myScan.close();
    }

    static int progression(int num) {
        return (num + 1) * num / 2;
    }

    static long factorial(int num) {
        long fact = 1;
        while (num != 0) {
            fact *= num;
            num--;
        }
        return fact;
    }
}