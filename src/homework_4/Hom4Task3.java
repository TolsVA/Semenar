package homework_4;

import java.util.*;
import java.util.function.Predicate;

public class Hom4Task3 {
    public static void main(String[] args) {
        int a;
        int b;
        int d;
        char op;
        char op2;
        char undo;

        int c;
        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '+';
            b = 7;
            c = 4;
            op2 = '+';
            d = 7;
            undo = '<';
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
            c = Integer.parseInt(args[3]);
            op2 = args[4].charAt(0);
            d = Integer.parseInt(args[5]);
            undo = args[6].charAt(0);
        }

        Calculator calculator = new Calculator();
        double result = calculator.calculate(op, a, b);
        System.out.println(result);
        double result2 = calculator.calculate(op2, c, d);
        System.out.println(result2);
        double prevResult = calculator.calculate(undo, 0, 0);
        System.out.println(prevResult);

        HashMap<String, String> hashMap = new HashMap<>();
        System.out.println(hashMap);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("E");
        arrayList.add("C");
        arrayList.add("E");
        arrayList.add("D");
        // Создаем class SamplePredicate<T> implements Predicate<T> создаем в нем
        // переменную T elements; и переопределяем метод test(T vars) для того чтобы
        // можно было удалять все элементы в arrayList.removeIf(predicate) которые
        // раны predicate
        SamplePredicate<String> predicate = new SamplePredicate<>();
        predicate.elements = "E";
        arrayList.removeIf(predicate);
        System.out.println(arrayList);

        String[] strings = arrayList.toArray(new String[0]);
        System.out.println(Arrays.toString(strings));
    }
}

class SamplePredicate<T> implements Predicate<T> {
    T elements;
    public boolean test(T vars){
        return elements.equals(vars);
    }
}
// Complexity is 3 Everything is cool - Сложность 3 Все круто
//Complexity is 14 You must be kidding - Сложность 14. Ты, должно быть, шутишь.

class Calculator {
    Deque<Double> deque = new ArrayDeque<>();
    @SuppressWarnings({"unchecked", "rawtypes"})
    public double calculate(char op, int a, int b) {
        MyInterfaceCalculate method = null;
        switch (op) {
            case '+' -> method = (x, y) -> (double) x + (double) y;
            case '-' -> method = (x, y) -> (double) x - (double) y;
            case '*' -> method = (x, y) -> (double) x * (double) y;
            case '<' -> deque.pop();
        }
        if (method != null) deque.push(mySuperMethodCalculate(method, (double) a, (double) b));
        if (!deque.isEmpty()) return deque.peek();
        return 0;
    }

    @FunctionalInterface
    private interface MyInterfaceCalculate<T> {
        T arithmeticExpression(T a, T b);
    }

    private <T> T mySuperMethodCalculate(MyInterfaceCalculate<T> method, T a, T b){
        return method.arithmeticExpression(a, b);
    }
}
