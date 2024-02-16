package abstractClasses;

import java.util.*;

public class Program {
    public static void main(String[] args) {
//        MyInterfaceActions cat = new Cat();
//        MyInterfaceActions dog = new Dog();
//        cat.operations();
//        dog.operations();

/*        // Сравниваем скорость добавления элементов в разные колекции
        workingHours();*/
    }

    private static void workingHours() {
        long startTime = System.nanoTime();

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10_000_000; i++){
            list.add(i);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("LinkedList: " + duration);

        startTime = System.nanoTime();

        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++){
            list2.add(i);
        }

        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("ArrayList: " + duration);

//        LinkedList: 1490044100
//        ArrayList:  630558000 capacities по умолчанию
//        LinkedList: 1521097900
//        ArrayList: 453849900 capacities 10_000_000
    }
}
