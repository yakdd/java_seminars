import java.time.LocalDate;

/**
 * 1. Продумайте структуру класса Кот. Какие поля и методы будут актуальны для
 * приложения, которое является
 * а) информационной системой ветеринарной клиники
 * б) архивом выставки котов
 * в) информационной системой Театра кошек Ю. Д. Куклачёва
 * Можно записать в текстовом виде, не обязательно реализовывать в java.
 */

public class Seminar62 {
    public static void main(String[] args) {
        Vaccination vaccin = new Vaccination(LocalDate.of(2020, 10, 15), "Barmaley", "Stolbnyak");
        System.out.println(vaccin);

        // vaccin.setDate(LocalDate.of(2021, 12, 30));
        System.out.println(vaccin.getDate());

        Cat cat = new Cat("Гюльчатай", "Денис", "экзот", "тигриный",
                LocalDate.of(2019, 2, 15));
        cat.addVaccinationt(vaccin);
        cat.addVaccinationt(new Vaccination(LocalDate.of(2022, 12, 10), "Barmaley", "Sputnik"));

        System.out.println(cat);
    }
}
