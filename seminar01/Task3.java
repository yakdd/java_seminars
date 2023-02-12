// Дан массив nums = [3,2,2,3] и число val = 3.
// Если в массиве есть числа, равные заданному, нужно перенести
// эти элементы в конец массива.
// Таким образом, первые несколько (или все) элементов массива
// должны быть отличны от заданного, а остальные - равны ему.

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 3, 2, 3, 3, 1, 2, 3, 3, 1, 4, 3 };
        int val = 3;
        int pos = nums.length - 1;
        for (int i = 0; i < pos; i++) {
            if (nums[i] == val) {
                while (nums[pos] == val && pos > i) {
                    pos--;
                }
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
                pos--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}