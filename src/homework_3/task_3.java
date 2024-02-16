package homework_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class task_3 {
    public static void main(String[] args) {
            Integer[] arr = {};

            if (args.length == 0) {
                // При отправке кода на Выполнение, вы можете варьировать эти параметры
                arr = new Integer[]{-2, -1, 0, 1, 2, 3, 4, 5};
            }
            else{
                arr = Arrays.stream(args[0].split(", "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
            }

            analyzeNumbers(arr);
    }
    public static void analyzeNumbers(Integer[] arr) {
        List<Integer> list = new ArrayList<>(List.of(arr))
                .stream()
                .sorted()
                .collect(Collectors.toList());

        int[] result = Arrays.stream(arr).mapToInt(i->i).toArray();
        double sum = Arrays.stream(result).sum();

        System.out.println(list);
        System.out.println("Minimum is " + list.get(0));
        System.out.println("Maximum is " + list.get(list.size() - 1));
        System.out.println("Average is = " + sum / list.size());
    }
}