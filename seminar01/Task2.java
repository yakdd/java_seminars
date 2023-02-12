public class Task2 {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 1, 0, 1, 1, 1 };
        int count = 0;
        int maxLength = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) { // если элемент = 1: увеличиваем счетчик
                count++;
            } else {
                if (count > maxLength) { // если текущая цепочка больше максимальной
                    maxLength = count; // запонить ее
                }
                count = 0;
            }
        }
        if (count > maxLength)
            maxLength = count; // если текущая цепочка больше максимальной
        System.out.println(maxLength);
    }
}

// Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное
// количество подряд идущих 1.
