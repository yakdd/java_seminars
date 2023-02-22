
/**
 * Реализовать алгоритм сортировки слиянием.
 */

import java.util.ArrayList;
import java.util.Random;

public class Homework31 {
    static int size = 15, min = -10, max = 10;
    static Random rnd = new Random();

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        while (size > 0) {
            array.add(rnd.nextInt(min, max));
            size--;
        }
        System.out.println(array);
        ArrayList<Integer> sortArray = separateArray(array);
        System.out.println(sortArray);
    }

    private static ArrayList<Integer> separateArray(ArrayList<Integer> array) {
        if (array.size() <= 1) {
            return array;
        }

        int middle = (int) (array.size() / 2);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 0; i < middle; i++)
            left.add(array.get(i));
        for (int i = middle; i < array.size(); i++)
            right.add(array.get(i));

        left = separateArray(left);
        right = separateArray(right);
        return mergeArray(left, right);
    }

    private static ArrayList<Integer> mergeArray(ArrayList<Integer> left, ArrayList<Integer> right) {

        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        int leftSize = left.size(), rightSize = right.size();

        while (i < leftSize && j < rightSize) {
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        while (i < leftSize) {
            result.add(left.get(i));
            i++;
        }
        while (j < rightSize) {
            result.add(right.get(j));
            j++;
        }
        return result;
    }
}