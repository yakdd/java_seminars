
/**
 * В файле содержится строка с исходными данными в такой форме:
 * {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 * Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
 * SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
 * Для разбора строки используйте String.split.
 * Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.
 */

import java.util.Scanner;
import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
// import java.io.FileNotFoundException;
// import java.io.IOException;

class TaskDz21 {
    public static void main(String[] args) throws Exception {
        try {
            FileReader fr = new FileReader("file_1.txt");
            Scanner scan = new Scanner(fr);
            fr = new FileReader("file_1.txt");
            String data = scan.nextLine();

            ArrayList<String> dataElements = new ArrayList<String>();
            dataElements = parseString(data, dataElements);

            String part1 = "SELECT * FROM students WHERE name = ";
            String part2 = " AND country = ";
            String part3 = " AND city = ";
            String[] sqlElements = { part1, part2, part3 };

            String result = createSQL(dataElements, sqlElements);
            System.out.println(result);

            fr.close();
            scan.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Не удается найти указанный файл");
        }
    }

    private static ArrayList<String> parseString(String data, ArrayList<String> dataElements) {
        data = data.replaceAll("[ {}]", "");

        String[] arrData = new String[4];
        arrData = data.split(",");
        for (String elem : arrData) {
            String[] elements = new String[2];
            elements = elem.split(":");
            dataElements.add(elements[1]);
        }
        return dataElements;
    }

    private static String createSQL(ArrayList<String> dataElements, String[] sqlElements) {

        StringBuilder sqlRequest = new StringBuilder();
        for (int i = 0; i < sqlElements.length; i++) {
            sqlRequest.append(sqlElements[i] + dataElements.get(i));
        }
        sqlRequest.append(";");
        return sqlRequest.toString();
    }
}