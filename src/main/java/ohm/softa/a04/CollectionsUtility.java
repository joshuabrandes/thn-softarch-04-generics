package ohm.softa.a04;

import java.lang.management.CompilationMXBean;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public abstract class CollectionsUtility {

    public static <E> SimpleList<E> bubbleSort(SimpleList<E> list, Comparator<E> comparator) {
        int size = list.size();
        E head = list.get(0);

        for (int i = 0; i < size - 1; i++) {
            E current = head;
            E next = ;
            E previous = null;

            for (int j = 0; j < size - 1 - i; j++) {
                if (comparator.compare(current, next.data) > 0) {
                    if (previous != null) {
                        previous.next = next;
                    } else {
                        head = next;
                    }
                    current.next = next.next;
                    next.next = current;

                    previous = next;
                    next = current.next;
                } else {
                    previous = current;
                    current = current.next;
                    next = current.next;
                }
            }
        }
    }


}
