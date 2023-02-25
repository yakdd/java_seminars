
// Пусть дан LinkedList с несколькими элементами.
// Реализуйте метод, который вернет “перевернутый” список.

// import java.net.SocketTimeoutException;
import java.util.LinkedList;

public class Homework41 {
    public static void main(String[] args) {
        String[] str = { "aaa", "bbb", "ccc", "ddd", "eee" };
        LinkedList<String> list = new LinkedList<>();
        for (String string : str) {
            list.add(string);
        }
        System.out.println(list);

        list = reverseList(list);
        System.out.println(list);
    }

    private static LinkedList<String> reverseList(LinkedList<String> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            int changePos = list.size() - 1 - i;
            String changeElem = list.get(changePos);
            String temp = list.get(i);
            list.set(i, changeElem);
            list.set(changePos, temp);
        }
        return list;
    }
}