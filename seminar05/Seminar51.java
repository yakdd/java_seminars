
// Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными и false, если нет.
// Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву во втором слове,
// при этом повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка следования.
// (Например, add - egg изоморфны) буква может не меняться, а остаться такой же. (Например, note - code)

import java.util.HashMap;
import java.util.Map;

public class Seminar51 {
    public static void main(String[] args) {
        String first = "assa";
        String second = "egge";
        // String second = "egget";
        // String second = "eggr";
        System.out.println(isIsomorph(first, second));
    }

    private static boolean isIsomorph(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            if (pairs.containsKey(first.charAt(i))) {
                if (pairs.get(first.charAt(i)) != second.charAt(i)) {
                    return false;
                }
            } else {
                pairs.put(first.charAt(i), second.charAt(i));
            }
        }
        return true;
    }
}
