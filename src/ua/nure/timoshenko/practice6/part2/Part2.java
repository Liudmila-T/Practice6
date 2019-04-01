package ua.nure.timoshenko.practice6.part2;

import java.security.SecureRandom;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;


public class Part2 {

    private static final int MAX_ELEMENTS = 10_000;
    private static final int STEP = 4;

    public static long removeByIndex(List<Object> list, final int k) {
        long timeStart = System.currentTimeMillis();
        int count = 0;
        while (list.size() > 1) {
            count += k;
            if (count >= list.size()) {
                count %= list.size();
            }
            list.remove(count);
        }
        return System.currentTimeMillis() - timeStart;
    }

    public static long removeByIterator(List<Object> list, final int k) {
        long timeStart = System.currentTimeMillis();
        int count = 0;
        while (list.size() > 1) {
            ListIterator iterator = list.listIterator(count);
            while (iterator.hasNext()) {
                count += k;
                iterator.next();
                if (count >= list.size()) {
                    count %= list.size();
                }
                iterator.remove();
            }
        }
        return System.currentTimeMillis() - timeStart;
    }

    public static List<Object> init(List<Object> list, int size) {
        Random random = new SecureRandom();
        while (list.size() < size) {
            list.add(random.nextInt());
        }
        return list;
    }

    public static void main(String[] args) {
        List<Object> arrayList = init(new ArrayList<>(), MAX_ELEMENTS);
        List<Object> linkedList = init(new LinkedList<>(), MAX_ELEMENTS);

        System.out.println("=========== Indexed");

        System.out.println("ArrayList#Index: " + removeByIndex(arrayList, STEP) + " ms");

        System.out.println("LinkedList#Index: " + removeByIndex(linkedList, STEP) + " ms");

        System.out.println("=========== Iterable");
        arrayList = init(new ArrayList<>(), MAX_ELEMENTS);
        linkedList = init(new LinkedList<>(), MAX_ELEMENTS);


        System.out.println("ArrayList#Iterator: " + removeByIterator(arrayList, STEP) + " ms");

        System.out.println("LinkedList#Iterator: " + removeByIterator(linkedList, STEP) + " ms");

    }
}
