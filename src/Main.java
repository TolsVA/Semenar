import test1.Bar;
import test1.Par;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Main {

    public BinaryOperator<Integer> sum = Integer::sum;
    public BinaryOperator<Integer> min = (o1, o2) -> o1 - o2;
    public BinaryOperator<Integer> multi = (o1, o2) -> o1 * o2;
    public BinaryOperator<Integer> div = (o1, o2) -> o1 / o2;


    public static void main(String[] args) {
        Main main = new Main();
        {
            int x = 5;
            int y = 5;

            System.out.println(main.sum.apply(x, y));
            System.out.println(main.min.apply(x, y));
            System.out.println(main.multi.apply(x, y));
            System.out.println(main.div.apply(x, y));
        }

        {
            int a = 12;
            System.out.println(main.minus(a--, --a));
        }

        {
            int a = 4, b = 3;
            Far far = new FarBuilder()
                    .factor(5)
                    .exponentiation(a, b)
                    .build();


            System.out.printf(
                    "Факториал числа %d -> %d\nВозведение числа %d в степень %d -> %d\n",
                    a,
                    far.getFactorial(),
                    a,
                    b,
                    far.getExponent()
            );
        }

        {
            ImplAdder implAdder = new ImplAdder();

            System.out.println(implAdder.add(5, 9, "2", 5));
            System.out.println(implAdder.multiply(Main::reverse, "Пупка"));


            main.test1(new Bar(), "Привет Медвед");
            main.test1(new Par());
        }

        {
            List<String> list1 = List.of("1", "22", "333", "4444");
            List<String> filteredList1 = main.filterList(list1, x -> x.length() >= 3);
            System.out.println(filteredList1); // => [333, 4444]

            List<Integer> list2 = List.of(1, 2, 3, 4);
            List<Integer> filteredList2 = main.filterList(list2, x -> x >= 3);
            System.out.println(filteredList2); // => [3, 4]
        }


        {
            String b = "пухляк"; // пухляк
            System.out.println(b.toUpperCase()); // => ПУХЛЯК
            // передадим стандартный метод и слово
            main.superMethod(String::toUpperCase, b); // => ПУХЛЯК
            // передадим лямбда-функцию и слово
            main.superMethod(s -> s + "!", b); // => пухляк!
            // передадим собственный метод и слово
            main.superMethod(Main::reverse, b);  // => кялхуп
        }

        {
            int m = 5, n = 10, c = 20;
            int sum = Arrays.stream(new int[]{m, n, c}).reduce(Integer::sum).getAsInt();
            System.out.println(sum);
        }

        {
            int g = 5, h = 8, j = 5;

            MyInterface[] method = {
                    (i, l, k) -> i * l * k,
                    (i, l, k) -> i * l - k
            };


            main.superMethodInterface(method[0], g, h, j);
            main.superMethodInterface((i, l, k) -> i * l - k, g, h, j);

            main.superMethodInterface1((m, n) -> m * n, g, h, j, 2, 3);
        }


        {
            Method method;

            try {
                method = Integer.class.getDeclaredMethod("max", int.class, int.class);
                main.superMethodReflection(null, method); // => 20

                method = Integer.class.getDeclaredMethod("sum", int.class, int.class);
                main.superMethodReflection(null, method); // => 30

                method = Main.class.getDeclaredMethod("concat", int.class, int.class);
                main.superMethodReflection(main, method); // => 1020
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        String l = "Кук";
        String w = "Макук";
        Scanner scanner = new Scanner(System.in);
        boolean flag = scanner.hasNextInt();

        if (flag) { // Проверка валидности данных введенных пользованелем
            int scInt = scanner.nextInt();
            System.out.printf("%s, %d, %s\n", l, scInt, w);
//            scanner.close();
        }

        System.out.println("после");

        char op = '/';
        int a = 7, b = 8;
        System.out.println(main.calculate(op, a, b));

        System.out.println("Решение через switch");

        System.out.println(main.calculateSwitch(op, a, b));



        main.run(() -> System.out.println("Здесь был Пупка"));
        Consumer<Object> print = System.out::println;
        print.accept("Привет Пупка");
        print.accept("Сам Пупенка");


        System.out.println("Для создания массива введите числа через пробел");
        scanner = new Scanner(System.in);
        String[] strings = (scanner.nextLine()).split(" ");
        int[] ints = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

        scanner.close();
        int sum = 0;
        for (int sd : ints){
            sum += sd;
            System.out.print(sd + " ");
        }
        System.out.println();
        System.out.println(sum);
    }

    private void run(Runnable r) {r.run();}

    @FunctionalInterface
    private interface MyInterfaceCalculate<T> {
        T arithmeticExpression(T a, T b);
    }

    private double mySuperMethodCalculate(MyInterfaceCalculate<Double> method, double a, double b){
        return method.arithmeticExpression(a, b);
    }

    private double calculateSwitch(char op, double a, double b) {
        double result = 0;
        switch (op) {
            case '+' -> result = mySuperMethodCalculate(Double::sum, a, b); //  mySuperMethodCalculate((m, n) -> m - n, a, b);
            case '-' -> result = mySuperMethodCalculate((m, n) -> m - n, a, b);
            case '*' -> result = mySuperMethodCalculate((m, n) -> m * n, a, b);
            case '/' -> {
                if (b != 0) result = mySuperMethodCalculate((m, n) -> m / n, a, b);
                else System.out.println("Делить на ноль нельзя");
            }
            default -> System.out.printf("Некорректный оператор: '%s'\n", op);
        }
        return result;
    }
    private double calculate(char op, int a, int b) {
        if(isOp(op)){
            if(op == '+') return a + b;
            if(op == '-') return a - b;
            if(op == '/') {
                if(b != 0) return (double) a / b;
                System.out.println("Делить на ноль нельзя");
            }
            if(op == '*') return a * b;
        } else {
            System.out.printf("Некорректный оператор: '%s'\n", op);
        }

        return 0;
    }

    private boolean isOp(char op){
        boolean isOp = false;
        for (char thisOp : new char[] {'+', '-', '*', '/'}) isOp = isOp ^ (thisOp == op);
        return isOp;
    }

    private int minus(int x, int y) {
        return x - y;
    }

    private void test1(Bar bar, String message) { //метод принимает клас Bar реализующий интерфейс Foo
        bar.print(message); //и вызывает его, будет вызвана функция print() реализующего класса.
    }
    private void test1(Par par) { //метод принимает интерфейс
        par.print("Привет совсем Медвед"); //и вызывает его, будет вызвана функция print() реализующего класса.
    }

    private  <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    private static String reverse(String str) {
        StringBuilder builder = new StringBuilder();
        builder.append(str);
        return builder.reverse().toString();
    }

    private void superMethod(UnaryOperator<String> method, String str) {
        test1(new Bar(), method.apply(str));
    }
    @FunctionalInterface  // у фунцианального интерфейса должен быть всего 1 метод анатация это проверяет
    public interface MyInterface {
        int count(int a, int b, int c);
    }
    @FunctionalInterface  // у фунцианального интерфейса должен быть всего 1 метод анатация это проверяет
    public interface MyInterface1 {
        int count(int a, int b);
    }

    private void superMethodInterface(MyInterface method, int a, int b, int c) {
        int result = method.count(a, b, c);
        System.out.printf("Результат работы метода superMethodInterface -> %d\n",result);
    }

    private void superMethodInterface1(MyInterface1 method, int... arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = method.count(result, arr[i]);
        }
        System.out.println(result);
    }

    private void superMethodReflection(Object object, Method method) throws Exception {
        int a = 10;
        int b = 20;
        int result = (int) method.invoke(object, a, b);
        System.out.println(result);
    }

    private int concat(int a, int b) {
        return Integer.parseInt("" + a + b);
    }
}