
/**
Пусть дан произвольный список целых чисел. Удалить из него чётные числа.
*/

import java.util.ArrayList;
import java.util.Random;

public class Homework32 {
    static int size = 15;
    static int min = 0;
    static int max = 50;

    public static void main(String[] args) {
        ArrayList<Integer> listInt = new ArrayList<>();
        fillRandomList(listInt);
        System.out.println(listInt);
        deleteEvenElements(listInt);
        System.out.println(listInt);
    }

    private static void fillRandomList(ArrayList<Integer> list) {
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(min, max + 1));
        }
    }

    private static void deleteEvenElements(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
    }
}