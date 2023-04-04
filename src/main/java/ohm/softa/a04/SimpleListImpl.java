package ohm.softa.a04;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl<E> implements SimpleList<E> {

	private ListElement<E> head;
	private int size;

	public SimpleListImpl() {
		head = null;
	}

	/**
	 * Add an object to the end of the list
	 * @param e e to add
	 */
	public void add(E e){
		/* special case empty list */
		if(head == null){
			head = new ListElement<>(e);
		}else {
			/* any other list length */
			var current = head;
			while (current.getNext() != null){
				current = current.getNext();
			}
			current.setNext(new ListElement<>(e));
		}
		size++;
	}

	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		ListElement<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.getItem();
	}


	/**
	 * @return size of the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Get a new SimpleList instance with all items of this list which match the given filter
	 * @param filter SimpleFilter instance
	 * @return new SimpleList instance
	 */
	public SimpleList<E> filter(SimpleFilter<E> filter){
		SimpleList<E> result = new SimpleListImpl<>();
		for(E e : this){
			if(filter.include(e)){
				result.add(e);
			}
		}
		return result;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public Iterator<E> iterator() {
		return new SimpleIterator();
	}

	/**
	 * Helper class which implements the Iterator interface
	 * Has to be non static because otherwise it could not access the head of the list
	 */
	private class SimpleIterator implements Iterator<E> {

		private ListElement<E> current = head;

		/**
		 * @inheritDoc
		 */
		@Override
		public boolean hasNext() {
			return current != null;
		}

		/**
		 * @inheritDoc
		 */
		@Override
		public E next() {
			E tmp = current.getItem();
			current = current.getNext();
			return tmp;
		}
	}

	/**
	 * Helper class for the linked list
	 * can be static because the ListElement does not need to access the SimpleList instance
	 */
	private static class ListElement<E> {
		private E e;
		private ListElement<E> next;

		ListElement(E e) {
			this.e = e;
			this.next = null;
		}

		/**
		 * @return get object in the element
		 */
		public E getItem() {
			return e;
		}

		/**
		 * @return successor of the ListElement - may be NULL
		 */
		public ListElement<E> getNext() {
			return next;
		}

		/**
		 * Sets the successor of the ListElement
		 * @param next ListElement
		 */
		public void setNext(ListElement<E> next) {
			this.next = next;
		}
	}

}
