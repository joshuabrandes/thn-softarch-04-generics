package ohm.softa.a04;

import java.lang.management.CompilationMXBean;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public abstract class CollectionsUtility {

    static <E> SimpleList<E> sort(SimpleList<E> list, Comparator<E> comparator) {
        if (list.size() <= 1) return list;

        List<E> sorted = new ArrayList<>();
        for (E e : list) {
            if (sorted.isEmpty()) {
                sorted.add(e);
            } else {
                boolean isSortedIn = false;
                for (int i = 0; i < sorted.size(); i++) {
                    var tmp = sorted.get(index);
                    if (comparator.compare(e, tmp) > 0) {
                        var tmp = new ArrayList<E>()
                    }
                }
            }
        }
    }
}
