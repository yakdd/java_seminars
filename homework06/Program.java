import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Program {

    static String[] filtersArr = { "бренд (brand)", "процессор (cpu)", "оперативная память (ram)", "объем SSD (ssd)",
            "операционная система (os)", "цена (price)" }; // список возможных фильтров для поиска ноутбука

    static String[] brands = { "ACER", "LENOVO", "HP", "DELL", "APPLE", "ASUS" };
    static String[] operSystems = { "Windows 10", "Windows 11", "Mac OS", "Linux", "FreeOS" };
    static String[] processors = { "Intel Core i3", "Intel Core i5", "Intel Core i7", "Apple M1 Pro 8 core" };

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Set<Notebook> notebookList = new HashSet<>();
        notebookList.add(new Notebook("ACER", "Intel Core i3", 6, 128, "Windows 10", 45000));
        notebookList.add(new Notebook("LENOVO", "Intel Core i7", 8, 256, "Windows 11", 77000));
        notebookList.add(new Notebook("HP", "Intel Core i5", 16, 256, "Windows 11", 82000));
        notebookList.add(new Notebook("DELL", "Intel Core i3", 8, 240, "Windows 10", 54000));
        notebookList.add(new Notebook("DELL", "Intel Core i3", 16, 256, "Windows 10", 115000));
        notebookList.add(new Notebook("APPLE", "Apple M1 Pro 8 core", 16, 512, "Mac OS", 120000));

        String parameter = startSearch(); // выбор критерия для поиска
        searchNotebook(parameter, notebookList); // выбор ноутбука по критерию

        System.out.print("Распечатать весь список ноутбуков? (y/n) ");
        char answer;
        if (scan.hasNextLine()) {
            answer = scan.next().charAt(0);
            if (answer == 'y') {
                System.out.println("\n=============================================");
                printAll(notebookList);
            }
        }

        scan.close();
    }

    private static String startSearch() {
        /** === Начало поска: выбор критерия === */
        Map<Integer, String> filtersMap = new HashMap<>();
        for (int i = 0; i < filtersArr.length; i++) {
            filtersMap.put(i + 1, filtersArr[i]); // записываем в ХэшМап элементы из списока возможных фильтров
        }

        while (true) {
            System.out.println("Введите цифру, соответствующую необходимому критерию поиска:");
            for (var filter : filtersMap.entrySet()) {
                System.out.printf("%d - %s\n", filter.getKey(), filter.getValue());
            }
            System.out.print(">>> ");

            int input = scan.nextInt();
            if (filtersMap.containsKey(input)) { // если такой критерий есть
                String parameter = filtersMap.get(input);
                parameter = parameter.split("[()]")[1]; // извлекаем часть в скобках
                return parameter;
            } else {
                System.out.println("Ошибка ввода! Попробуйте еще раз.");
            }
        }

    }

    private static void searchNotebook(String parameter, Set<Notebook> notebookList) {
        /** === Составление списка вариантов по выбранному критерию === */
        String searchParameter = "";
        int searchRange = 0;
        switch (parameter) {
            case "brand":
                searchParameter = createHashMap(brands);
                break;
            case "os":
                searchParameter = createHashMap(operSystems);
                break;
            case "cpu":
                searchParameter = createHashMap(processors);
                break;
            default:
                if (parameter.equals("ram") || parameter.equals("ssd") || parameter.equals("price")) {
                    searchRange = createRange(parameter);
                } else {
                    searchParameter = "error";
                    System.out.println("непредвиденная ошибка.");
                }
                break;
        }

        boolean find = false;
        for (Notebook notebook : notebookList) {
            /** === сравнение по строковым параматрам === */
            if (notebook.getBrand().equals(searchParameter) ||
                    notebook.getCpu().equals(searchParameter) ||
                    notebook.getOs().equals(searchParameter)) {
                System.out.println(notebook);
                find = true;
            }
        }

        for (Notebook notebook : notebookList) {
            /** === сравнение по числовым параматрам === */
            if ((parameter.equals("ram") && notebook.getRam() >= searchRange) ||
                    (parameter.equals("ssd") && notebook.getSsd() >= searchRange) ||
                    (parameter.equals("price") && notebook.getPrice() <= searchRange)) {
                System.out.println(notebook);
                find = true;
            }
        }

        if (!find) {
            System.out.println("Ничего не найдено.");
        }
    }

    private static int createRange(String parameter) {
        int minimum = 0;
        switch (parameter) {
            case "ram":
                System.out.print("Объем оперативной памяти не менее, чем: ");
                break;
            case "ssd":
                System.out.print("Объем жесткого диска не менее, чем: ");
                break;
            case "price":
                System.out.print("Не дороже, чем: ");
                break;
            default:
                System.out.println("Ошибка ввода");
                break;
        }

        minimum = scan.nextInt();
        return minimum;
    }

    private static String createHashMap(String[] parameter) {
        Map<Integer, String> newHashMap = new HashMap<>();
        for (int i = 0; i < parameter.length; i++) {
            newHashMap.put(i + 1, parameter[i]);
        }
        String choose = takeChoose((HashMap<Integer, String>) newHashMap);
        return choose;
    }

    private static String takeChoose(HashMap<Integer, String> newHashMap) {
        /** === формируем вывод пользователю для выбора из возможных ваиантов === */
        while (true) {
            System.out.println("Введите цифру, соответствующую необходимому критерию поиска:");
            for (var filter : newHashMap.entrySet()) {
                System.out.printf("%d - %s\n", filter.getKey(), filter.getValue());
            }
            System.out.print(">>> ");

            int input = scan.nextInt();
            if (newHashMap.containsKey(input)) {
                return newHashMap.get(input);
            } else {
                System.out.println("Ошибка ввода! Попробуйте еще раз.");
            }
        }
    }

    private static void printAll(Set<Notebook> notebookList) {
        int count = 0;
        for (Notebook notebook : notebookList) {
            System.out.print(++count + ". ");
            System.out.println(notebook);
        }
    }
}