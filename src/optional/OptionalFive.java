package optional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец, а положительные — в начало списка
 */
public class OptionalFive {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, -9, 8, 5, -3, 4, -8, 9);
        sort(list).forEach(x -> System.out.print(x + " "));
    }

    public static List<Integer> sort(List<Integer> list) {
//        Collections.sort(list, (o1, o2) -> o2 - o1);

        List<Integer> result = list.stream().filter(x->x>=0).collect(Collectors.toList());
        result.addAll(list.stream().filter(x->x<0).collect(Collectors.toList()));
        return result;
    }
}
