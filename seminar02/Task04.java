import java.io.File;

/**
 * Напишите метод, который определит тип (расширение) файлов из текущей папки и
 * выведет в консоль результат вида
 * 1 Расширение файла: txt
 * 2 Расширение файла: pdf
 * 3 Расширение файла:
 * 4 Расширение файла: jpg
 */

public class Task04 {
    public static void main(String[] args) {
        File dir = new File(".");
        printExtension(dir.list());
    }

    private static void printExtension(String[] fileNames) {
        for (int i = 0; i < fileNames.length; i++) {
            int point = fileNames[i].lastIndexOf('.');
            if (point == -1) {
                System.out.println();
                continue;
            }
            System.out.println(fileNames[i].substring(point + 1));
        }
    }
}