import java.io.FileWriter;
import java.io.IOException;
// import java.io.OutputStreamWriter;

/**
 * Напишите метод, который составит строку, состоящую из 100 повторений слова
 * TEST
 * и метод, который запишет эту строку в простой текстовый файл, обработайте
 * исключения.
 */

public class Task03 {
    public static void main(String[] args) {
        String test = "TEST.";
        int num = 10;

        writeLogg(repeateString(test, num));
    }

    private static String repeateString(String str, int num) {
        StringBuilder strBuild = new StringBuilder();
        for (int i = 0; i < num; i++) {
            strBuild.append(str);
        }
        return strBuild.toString();
    }

    private static void writeLogg(String str) {
        FileWriter file = null;
        try {
            file = new FileWriter("text.txt");
            file.append(str);
            System.out.println("Файл успешно создан");
        } catch (IOException ex) {
            System.err.println("Ошибка: " + ex);
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException ex) {
                    System.err.println("Ошибка: " + ex);
                }
            }
        }
    }
}
