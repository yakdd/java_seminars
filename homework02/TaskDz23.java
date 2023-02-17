
/**
 В файле содержится строка с данными:
    [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
    {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
     {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
    Студент Иванов получил 5 по предмету Математика.
    Студент Петрова получил 4 по предмету Информатика.
    Студент Краснов получил 5 по предмету Физика.
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskDz23 {
    public static void main(String[] args) throws Exception {
        try {
            FileReader fr = new FileReader("file_3.txt");
            Scanner scan = new Scanner(fr);
            String data = scan.nextLine();

            ArrayList<String> dataElements = new ArrayList<String>();
            dataElements = parseData(data, dataElements);
            for (String str : dataElements) {
                System.out.println(str);
            }

            scan.close();
            fr.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    private static ArrayList<String> parseData(String data, ArrayList<String> dataElements) {

        String[] pattern = { "Студент ", " получил ", " по предмету " };

        String[] dataLines = data.split("},");
        for (String line : dataLines) {
            StringBuilder resultLine = new StringBuilder();
            line = line.replaceAll("[\\[\\]\"{} ]", "");
            for (int i = 0; i < pattern.length; i++) {
                resultLine.append(pattern[i]);
                String[] lineElement = line.split(",");
                String input = lineElement[i].split(":")[1];
                resultLine.append(input);
            }
            String addToData = resultLine.toString() + ".";
            dataElements.add(addToData);
        }
        return dataElements;
    }
}
