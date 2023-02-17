
/**
 * Напишите метод, который принимает на вход строку (String)
 * и определяет является ли строка палиндромом (возвращает boolean значение).
 */
import java.util.Scanner;;

public class Task02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print(">>>");
        String palindrome = scan.nextLine();
        boolean yes = isPalindrome(palindrome);

        System.out.println(yes);

        scan.close();
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() - i; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
