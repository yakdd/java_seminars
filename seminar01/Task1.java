import java.util.Scanner;

class Task1 {
    public static void main(String[] args) {
        System.out.println("Введите имя:");
        Scanner iScan = new Scanner(System.in, "cp866"); // cp866 для ввода русских букв
        String name = iScan.nextLine();
        System.out.printf("Привет, %s!, как дела, %s?\n", name, name);
        // System.out.println(String.format("Привет, %s!", name));
        iScan.close();
    }
}
// Написать программу, которая запросит пользователя ввести <Имя> в консоли.
// Получит введенную строку и выведет в конс
