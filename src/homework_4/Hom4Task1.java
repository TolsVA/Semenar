package homework_4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Hom4Task1 {
    public static void main(String[] args) {
        LinkedList<Object> ll = new LinkedList<>();
        ll.add(1);
        ll.add("One");
        ll.add(2);
        ll.add("Two");

        System.out.println(ll);
        List<Object> reversedList = revert(ll);
        System.out.println(reversedList);
    }

    public static List<Object> revert(List<Object> ll) {
        Deque<Object> deque = new ArrayDeque<>();
        for (Object o : ll)
            deque.push(o);
        return new LinkedList<>(deque);
    }
}
