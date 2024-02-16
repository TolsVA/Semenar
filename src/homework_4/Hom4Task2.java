package homework_4;

import java.util.LinkedList;

public class Hom4Task2 {
    public static void main(String[] args) {
        MyQueue<Integer> queue;
        queue = new MyQueue<>();

        queue.enqueue(1);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(5);

        System.out.println(queue.getElements());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(queue.getElements());

        System.out.println(queue.first());
    }
}

class MyQueue<T> {
    // Напишите свое решение ниже
    private final LinkedList<T> list = new LinkedList<>();
    public void enqueue(T element) {
        list.addLast(element);
    }

    public T dequeue() {
        return list.removeFirst();
    }

    public T first() {
        return list.getFirst();
    }

    public LinkedList<T> getElements() {
        return list;
    }
}