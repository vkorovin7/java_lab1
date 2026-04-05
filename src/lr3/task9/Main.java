package lr3.task9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        final int N = 1000000; // Количество элементов в коллекциях

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arrayDeque.add(i);
            linkedList.add(i);
            arrayList.add(i);
        }

        // Измерение времени выполнения операций
        long startTime = System.nanoTime();
        arrayDeque.addFirst(-1);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время добавления в начало ArrayDeque: " + duration + " мс");

        startTime = System.nanoTime();
        linkedList.addFirst(-1);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время добавления в начало LinkedList: " + duration + " мс");

        startTime = System.nanoTime();
        arrayList.add(0, -1);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время добавления в начало ArrayList: " + duration + " мс");

        startTime = System.nanoTime();
        arrayDeque.addLast(N);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время добавления в конец ArrayDeque: " + duration + " мс");

        startTime = System.nanoTime();
        linkedList.addLast(N);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время добавления в конец LinkedList: " + duration + " мс");

        startTime = System.nanoTime();
        arrayList.add(N);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время добавления в конец ArrayList: " + duration + " мс");

        startTime = System.nanoTime();
        linkedList.add(N / 2, -1);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время добавления в середину LinkedList: " + duration + " мс");

        startTime = System.nanoTime();
        arrayList.add(N / 2, -1);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время добавления в середину ArrayList: " + duration + " мс");

        startTime = System.nanoTime();
        arrayDeque.removeFirst();
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время удаления из начала ArrayDeque: " + duration + " мс");

        startTime = System.nanoTime();
        linkedList.removeFirst();
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время удаления из начала LinkedList: " + duration + " мс");

        startTime = System.nanoTime();
        arrayList.remove(0);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время удаления из начала ArrayList: " + duration + " мс");

        startTime = System.nanoTime();
        arrayDeque.removeLast();
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время удаления из конца ArrayDeque: " + duration + " мс");

        startTime = System.nanoTime();
        linkedList.removeLast();
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время удаления из конца LinkedList: " + duration + " мс");

        startTime = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время удаления из конца ArrayList: " + duration + " мс");

        startTime = System.nanoTime();
        linkedList.remove(N / 2);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время удаления из середины LinkedList: " + duration + " мс");

        startTime = System.nanoTime();
        arrayList.remove(N / 2);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время удаления из середины ArrayList: " + duration + " мс");

        startTime = System.nanoTime();
        linkedList.get(N / 2);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время получения элемента по индексу LinkedList: " + duration + " мс");

        startTime = System.nanoTime();
        arrayList.get(N / 2);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время получения элемента по индексу ArrayList: " + duration + " мс");
    }
}
