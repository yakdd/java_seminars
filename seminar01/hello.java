
// package seminar01; если открыта не текущая папка
// import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Hello {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss; dd.MM.YYYY");
        System.out.println(formatter.format(now));
    }
}