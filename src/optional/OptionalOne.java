package optional;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;

/**
 * Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
 */

public class OptionalOne {

    private static final String PATH = "data/optional_1.txt";

    public static void main(String[] args) {
        String s = readFile(PATH);
        writeFile(reverseLines(s), PATH);
    }

    public static String readFile(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            Files.lines(Paths.get(path)).forEach(value -> sb.append(value + "\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String reverseLines(String text) {
        String[] lines = text.split("\n");
        Stack<String> stack = new Stack<>();
        for (String s : lines) {
            if (!"".equals(s))
                stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop() + "\n");
        return sb.toString();
    }

    public static void writeFile(String text, String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)))) {
            bw.write(text);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
