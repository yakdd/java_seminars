// Вывести все простые числа от 1 до 1000

public class TaskDz2 {
    public static void main(String[] args) {

        System.out.printf("%d, %d, ", 1, 2);

        int limit = 1000;
        for (int i = 3; i < limit + 1; i += 2) {
            boolean prime = true;
            for (int j = 3; j < i - 1; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime)
                System.out.printf("%d, ", i);
        }
    }
}