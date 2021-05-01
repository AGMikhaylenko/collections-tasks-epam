package optional;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Создать список из элементов каталога и его подкаталогов
 */
public class OptionalThree {

    private static final String PATH = "D:/Education";

    public static void main(String[] args) {
        getListOfFiles(new File(PATH)).forEach(x->System.out.println(x.getName()));
    }

    public static List<File> getListOfFiles(File path) {
        List<File> list = new ArrayList<>();
        List<File> files = Arrays.asList(path.listFiles());
        files.stream().filter(x -> !x.isDirectory()).forEach(x -> list.add(x));
        files.stream().filter(x -> x.isDirectory()).forEach(x -> list.addAll(getListOfFiles(x)));
        return list;
    }
}
