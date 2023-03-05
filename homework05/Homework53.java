
/**
 * Реализовать алгоритм пирамидальной сортировки (HeapSort)
 */

import java.util.Arrays;
import java.util.Random;

public class Homework53 {

    static int size = 10, min = 0, max = 20;
    static Random rnd = new Random();

    public static void main(String[] args) {

        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(min, max);
        }
        System.out.println(Arrays.toString(array));

        int iteration = 0;
        int[] sortedArray = heapSort(array, iteration);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] heapSort(int[] array, int iteration) {

        int newLength = array.length - iteration;
        int finishElement = newLength - 1;
        if (finishElement == 0) {
            return array;
        }

        int lastParent = newLength / 2 - 1; // индекс последнего "родителя" в массиве

        for (int i = lastParent; i >= 0; i--) {
            int firstChild = 2 * i + 1; // индекс первого "ребенка"
            int secondChild = 2 * i + 2; // индекс второго "ребенка"
            int indChange;
            if (secondChild > finishElement) {
                indChange = firstChild;
            } else {
                indChange = array[firstChild] > array[secondChild] ? firstChild : secondChild;
            }

            if (array[indChange] > array[i]) {
                int temp = array[indChange];
                array[indChange] = array[i];
                array[i] = temp;
            }
        }

        int temp2 = array[0];
        array[0] = array[finishElement];
        array[finishElement] = temp2;
        iteration++;

        return heapSort(array, iteration);
    }
}