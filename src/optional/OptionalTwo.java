package optional;

import java.util.Stack;

/**
 * Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке
 */
public class OptionalTwo {
    public static void main(String[] args) {
        System.out.println(reverseInt(123));
    }

    public static int reverseInt(int number) {
        Stack<Character> stack = new Stack<>();
        for (char c : String.valueOf(number).toCharArray())
            stack.push(c);
        int result = 0;
        while (!stack.isEmpty()) {
            result += Integer.valueOf(String.valueOf(stack.pop())) * Math.pow(10, stack.size());
        }
        return result;
    }
}
