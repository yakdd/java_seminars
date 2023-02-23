
/**
 * Задан целочисленный список ArrayList.
 * Найти минимальное, максимальное и среднее арифметичское этого списка.
 */
import java.util.ArrayList;
import java.util.Random;

public class Homework33 {
    static int size = 7;
    static int min = 0;
    static int max = 15;

    public static void main(String[] args) {
        ArrayList<Integer> listInt = new ArrayList<>();
        fillRandomList(listInt);
        System.out.println(listInt);

        String type = "";
        int extremal = 0;
        // Минимальный элемент:
        type = "Минимальный";
        extremal = findExtremal(listInt, type);
        System.out.printf("%s элемент: %d\n", type, extremal);

        // Максимальный элемент:
        type = "Максимальный";
        extremal = findExtremal(listInt, type);
        System.out.printf("%s элемент: %d\n", type, extremal);

        // Среднее арифметическое:
        double average = avg(listInt);
        System.out.printf("Среднее арифметическое: %.3f\n", average);
    }

    private static void fillRandomList(ArrayList<Integer> list) {
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(min, max + 1));
        }
    }

    private static int findExtremal(ArrayList<Integer> list, String type) {
        int extremal = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (type.equals("Минимальный")) {
                if (list.get(i) < extremal) {
                    extremal = list.get(i);
                }
            } else if (type.equals("Максимальный")) {
                if (list.get(i) > extremal) {
                    extremal = list.get(i);
                }
            }
        }
        return extremal;
    }

    private static double avg(ArrayList<Integer> list) {
        double summ = 0;
        for (Integer elem : list) {
            summ += elem;
        }
        double count = list.size();
        return summ / count;
    }
}
