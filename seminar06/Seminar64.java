
/**
 * 1. Создайте множество, в котором будут храниться экземпляры класса Cat -
 * HashSet<Cat>. Поместите в него некоторое количество объектов.
 * 2. Создайте 2 или более котов с одинаковыми параметрами в полях.
 * Поместите их во множество. Убедитесь, что все они сохранились во множество.
 * 3. Создайте метод public boolean equals(Object o) Пропишите в нём логику
 * сравнения котов по параметрам, хранимым в полях. То есть, метод должен
 * возвращать true,
 * только если значения во всех полях сравниваемых объектов равны.
 * 4. Выведите снова содержимое множества из пункта 2, убедитесь, что
 * дубликаты удалились.
 */
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Seminar64 {
    public static void main(String[] args) {
        Set<Cat> myCats = new HashSet<>();

        myCats.add(new Cat("Rika", "Olga", "simple", "black_withe",
                LocalDate.of(2009, 5, 10)));
        myCats.add(new Cat("Rika", "Olga", "simple", "black_withe",
                LocalDate.of(2009, 5, 10)));
        myCats.add(new Cat("Mersik", "Andrew", "Siberian", "tiger",
                LocalDate.of(2012, 9, 4)));
        myCats.add(new Cat("Chuncha", "Denis", "Exzot", "tiger",
                LocalDate.of(2019, 2, 15)));
        myCats.add(new Cat("Knopka", "Anna", "Crazy", "rad",
                LocalDate.of(2022, 4, 20)));

        System.out.println(myCats);
    }
}
