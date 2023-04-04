package ohm.softa.a04;

import java.util.function.Function;

public interface SimpleList<E> extends Iterable<E> {
    /**
     * Add a given object to the back of the list.
     */
    void add(E e);

    /**
     * @return current size of the list
     */
    int size();

    /**
     * Generate a new list using the given filter instance.
     *
     * @return a new, filtered list
     */
    default SimpleList<E> filter(SimpleFilter<E> filter) {
        try {
            SimpleList<E> result = this.getClass()
                    .getDeclaredConstructor().newInstance();
            for (E e : this) {
                if (filter.include(e)) {
                    result.add(e);
                }
            }
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return this;
        }
    }

	default <T> SimpleList<T> map(Function<E, T> transform) {
        SimpleList<T> result;
        try {
            result = (SimpleList<T>) getClass()
                    .getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new SimpleListImpl<>();
        }

        for (E e : this) {
            result.add(transform.apply(e));
        }
        return result;
    }

    default void addDefault(Class<E> clazz) {
        try {
            this.add(clazz.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
