import java.util.ArrayList;
import java.util.LinkedList;

class Seminar40 {
    public static void main(String[] args) {

        int size = 1_000_000;
        long time = System.currentTimeMillis();
        ArrayList<Integer> intArr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            intArr.add((int) (Math.random() * 100));
        }
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();

        LinkedList<Integer> intArr2 = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            intArr2.add((int) (Math.random() * 100));
        }
        System.out.println(System.currentTimeMillis() - time);

    }
}