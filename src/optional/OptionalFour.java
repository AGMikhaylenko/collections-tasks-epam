package optional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
 */
public class OptionalFour {
    private static final String PATH = "data/optional_4.txt";

    public static void main(String[] args) {
        sortStringsFromFiles(PATH).forEach(System.out::println);
    }

    public static List<String> sortStringsFromFiles(String path){
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.lines(Paths.get(path)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(lines, (o1,o2)->o1.length()-o2.length());
        return lines;
    }
}
