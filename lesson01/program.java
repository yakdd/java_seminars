public class program {
    public static void main(String[] args) {
        String first = null;
        String second = "2 2 2";
        String third; // эту переменную испльзовать нельзя, т.к. оне не инициализирована
        System.out.println(first);
        System.out.println(second);
        // System.out.println(third);
        System.out.println("--------------");

        // Целочисленный тип данных:
        short age = 10;
        int salary = 1234567890;
        System.out.println(age);
        System.out.println(salary);
        System.out.println("--------------");

        // Вещественный тип данных:
        float e = 2.7f;
        double pi = 3.1415; // есть необязательный ссуфкс D
        System.out.println(e);
        System.out.println(pi);
        System.out.println("--------------");

        // Тип данных char:
        char ch = '1';
        System.out.println(Character.isDigit(ch));
        ch = 'a';
        System.out.println(Character.isDigit(ch));
        System.out.println("--------------");

        // Логический тип данных:
        boolean flag1 = 123 <= 234;
        System.out.println(flag1); // true
        boolean flag2 = 123 >= 234 || flag1;
        System.out.println(flag2); // true
        boolean flag3 = flag1 ^ flag2; // разделительная дизъюнкция
        System.out.println(flag3); // false
        System.out.println("--------------");

        // Строковый тип данных:
        String msg = "Hello world";
        System.out.println(msg);
        System.out.println("--------------");

        // Неявная типизация:
        var i = 123;
        System.out.println(i); // 123
        System.out.println(getType(i)); // Integer

        var d = 123.456;
        System.out.println(d); // 123
        System.out.println(getType(d)); // Double
        d = 1022;
        System.out.println(d); // 1022.0
        System.out.println(getType(d)); // Double
        // d = "mistake";
        // error: incompatible types: String cannot be converted to double
    }

    static String getType(Object o) {
        return o.getClass().getSimpleName();
    }
}

/*
 * комментарии
 * 
 */
// one-string comment
