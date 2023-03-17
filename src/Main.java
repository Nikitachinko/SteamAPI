import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Main {
    public static void main(String[] args) {
        Stream<Integer> stream = new ArrayList<>(Arrays.asList(8, 2, 3, 22, 8, 13, 21)).stream();
        findMinMax(
                stream,
                Integer::compareTo,
                (x, y) -> System.out.printf("min: %s, max: %s%n", x, y)
        );

        List<Integer> list = new ArrayList<>(Arrays.asList(4,5,4,2,6,3,10));
        evenNumbers(list);

    }
    /*
     * Напишите метод public static void findMinMax, который будет находить в стриме минимальный и максимальный элементы
     * в соответствии с порядком, заданным Comparator.
     */
    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.sorted(order).collect(Collectors.toList());
        if (!list.isEmpty()) {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }
    /*
     * Реализуйте метод, который принимает на вход список целых чисел,
     * определяет в списке количество четных чисел и выводит их в консоль.
     * Решите задание именно с применением Stream API.
     */

    public static void evenNumbers(List<Integer> list) {
        long numberOfEvens = list.stream()
                .filter(number -> number % 2 == 0)
                .count();
        List<Integer> listOfEvens = list.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Четные числа: " + listOfEvens.toString().replace("[", "").replace("]", ""));
        System.out.println("Количество четных чисел в списке: " + numberOfEvens);
    }
}