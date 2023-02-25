
/**
 * Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.
 * Вычислить запись если это возможно.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Homework44 {

    public static void main(String[] args) {
        // String infixExpr = "1 + 2 * 3";
        String infixExpr = "(1 + 2) * 3";
        System.out.printf("Инфиксная запись: %s \n", infixExpr);
        infixExpr = infixExpr.replace(" ", "");

        ArrayList<String> substrings = new ArrayList<>();
        if (infixExpr.contains("(")) {
            int indexOpen = infixExpr.indexOf("(");
            int indexClose = infixExpr.indexOf(")");

            String subExpr0 = infixExpr.substring(0, indexOpen);
            substrings.add(subExpr0);
            String subExpr1 = infixExpr.substring(++indexOpen, indexClose);
            substrings.add(subExpr1);
            String subExpr2 = infixExpr.substring(++indexClose, infixExpr.length());
            substrings.add(subExpr2);
        } else {
            substrings.add(infixExpr);
        }

        ArrayDeque<ArrayDeque<Character>> expression = new ArrayDeque<>();
        for (String substring : substrings)
            if (substring.length() != 0)
                expression.add(createDeque(substring));

        String postfixExp = "";
        for (ArrayDeque<Character> arrayDeque : expression) {
            for (char el : arrayDeque) {
                postfixExp += el + " ";
            }
        }

        System.out.printf("Постфиксная запись: %s \n", postfixExp);
    }

    private static ArrayDeque<Character> createDeque(String expression) {
        ArrayDeque<Character> numbers = new ArrayDeque<>();
        ArrayDeque<Character> symbols = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            char el = expression.charAt(i);
            if (Character.isDigit(el))
                numbers.addLast(el);
            else
                symbols.push(el);
        }

        ArrayDeque<Character> mergeDeque = mergeDeque(numbers, symbols);
        return mergeDeque;
    }

    private static ArrayDeque<Character> mergeDeque(ArrayDeque<Character> numbers, ArrayDeque<Character> symbols) {
        for (Character character : symbols)
            numbers.addLast(character);
        return numbers;
    }
}
