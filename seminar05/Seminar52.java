
// Написать метод, определяющий правильность расстановки скобок в выражении.
// Пример 1: a+(d*3) - истина
// Пример 2: [a+(1*3) - ложь
// Пример 3: [6+(3*3)] - истина
// Пример 4: {a}[+]{(d*3)} - истина
// Пример 5: <{a}+{(d*3)}> - истина
// Пример 6: {a+]}{(d*3)} - ложь

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Seminar52 {
    public static void main(String[] args) {
        // String formula = ")(,[<>]{})";
        // String formula = "a+(d*3)";
        // String formula = "[a+(1*3)";
        // String formula = "[6+(3*3)]";
        // String formula = "{a}[+]{(d*3)}";
        String formula = "<{a}+{(d*3)}>";
        // String formula = "{a+]}{(d*3)}";

        System.out.println(isValid(formula));
    }

    private static boolean isValid(String formula) {
        Map<Character, Character> bracketsDict = new HashMap<>();
        bracketsDict.put('(', ')');
        bracketsDict.put('[', ']');
        bracketsDict.put('{', '}');
        bracketsDict.put('<', '>');

        ArrayDeque<Character> brackets = new ArrayDeque<>();
        for (char chr : formula.toCharArray()) {
            if (bracketsDict.containsKey(chr)) { // если chr является открывающей скобкой
                brackets.add(chr);
            } else if (bracketsDict.containsValue(chr)) { // если chr является закрывающей скобкой
                if (brackets.isEmpty())
                    return false;
                char lastOpeningBracket = brackets.removeLast();
                if (bracketsDict.get(lastOpeningBracket) != chr) { // если закр. скобка не соответсвует открыв.
                    return false;
                }
            }
        }
        return brackets.isEmpty(); // если стэк опустошился
    }
}
