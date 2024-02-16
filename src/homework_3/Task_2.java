package homework_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// [1, 2, 3, 4, 5, 6, 7, 8, 9] - Исходный
// [1, 3, 5, 7, 9]
class Answer {
    public static void removeEvenNumbers(Integer[] arr) {
        // Введите свое решение ниже
        List<Integer> list = new ArrayList<>(List.of(arr));
        Predicate<Integer> predicate = x -> x % 2 != 0;
        list = list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
public class Task_2 {
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }
        Answer.removeEvenNumbers(arr);
    }
}
