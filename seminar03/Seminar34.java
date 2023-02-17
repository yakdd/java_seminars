
/**
 * Создать список типа ArrayList<String>.
 * Поместить в него как строки, так и целые числа.
 * Пройти по списку, найти и удалить целые числа.
 */
import java.util.ArrayList;

public class Seminar34 {
    public static void main(String[] args) {
        ArrayList mixedList = new ArrayList<String>(); // стирание типа: слева <нет>, справа <есть>
        mixedList.add("hello");
        mixedList.add("chicas");
        mixedList.add(12);
        mixedList.add(13);
        mixedList.add(0);
        mixedList.add(0.2);

        System.out.println(mixedList);

        for (int i = 0; i < mixedList.size(); i++) {
            if (mixedList.get(i) instanceof Integer) {
                mixedList.remove(i);
                i--;
            }
        }

        System.out.println(mixedList);
    }
}
