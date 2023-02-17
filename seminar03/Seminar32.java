import java.util.ArrayList;
import java.util.Random;

/**
 * Заполнить список десятью случайными числами.
 * Отсортировать список методом sort() и вывести его на экран.
 */

public class Seminar32 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rnd = new Random();
        for (int index = 0; index < 10; index++) {
            list.add(rnd.nextInt(0, 11));
        }

        System.out.println(list);
        // list.sort(null);
        list.sort(new MyComparator());
        System.out.println(list);
    }
}
