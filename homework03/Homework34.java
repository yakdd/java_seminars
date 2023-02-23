
/**
Даны два ArrayList из целых чисел. Написать функции, которые вычисляют разницу коллекций:
Разность:
A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
B - A = все числа из второй коллекции, которые не содержатся в первой
Симметрическая разность:
A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой
*/

import java.util.ArrayList;
import java.util.Random;

public class Homework34 {
    static int size = 5;
    static int min = 0;
    static int max = 10;

    public static void main(String[] args) {
        ArrayList<Integer> arrA = new ArrayList<>();
        ArrayList<Integer> arrB = new ArrayList<>();
        fillRandomList(arrA);
        fillRandomList(arrB);
        System.out.println("Массив А: " + arrA);
        System.out.println("Массив В: " + arrB);

        ArrayList<Integer> diffAB = differenceArray(arrA, arrB);
        System.out.println("A - B: " + diffAB);
        ArrayList<Integer> diffBA = differenceArray(arrB, arrA);
        System.out.println("B - A: " + diffBA);
        ArrayList<Integer> diffABBA = simmetricDifferenceArrays(arrA, arrB);
        System.out.println("A ^ B: " + diffABBA);
    }

    private static void fillRandomList(ArrayList<Integer> list) {
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(min, max + 1));
        }
    }

    private static ArrayList<Integer> differenceArray(ArrayList<Integer> first, ArrayList<Integer> second) {
        ArrayList<Integer> copy = new ArrayList<>(first);
        for (int i = 0; i < copy.size(); i++) {
            if (second.contains(copy.get(i))) {
                copy.remove(i);
                i--;
            }
        }
        return copy;
    }

    private static ArrayList<Integer> simmetricDifferenceArrays(ArrayList<Integer> first, ArrayList<Integer> second) {
        ArrayList<Integer> diffAB = differenceArray(first, second);
        ArrayList<Integer> diffBA = differenceArray(second, first);

        ArrayList<Integer> diffABBA = new ArrayList<>();
        diffABBA.addAll(diffAB);
        diffABBA.addAll(diffBA);

        return diffABBA;
    }
}