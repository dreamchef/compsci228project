package adts;

import interfaces.*;
import elements.*;

public class DLList implements ListInterface<Candy> {

	private DLList<E> head = null;
	private DLList<E> tail = null;
	private DLList<E> location = null;
	private DLList<E> forwardIterator = head;
	private DLList<E> backwardIterator = tail;
	private DLList<E> item;
	private int numElements = 0;
	private boolean found;
	private boolean changed = false;
	private E[] findArray = new E[];

	@Override
	public void add(E element) {

		if(numElements == 0) {

			element.setPrev(null);
			element.setNext(null);
			head = element;
			tail = element;

		}

		else {
			element.setPrev(tail);
			element.setNext(null);
			tail = element;

		}

		numElements++;

	}

	@Override
	public boolean remove(E element) {

		find(element);

		if(!(found))
			return false;
		else
			location.getPrev().setNext(location.getNext());
			location.getNext().setPrev(location.getPrev());

			return true;

	}

	@Override
	public int size() {

		return numElements;

	}

	@Override
	public boolean isEmpty() {

		return (numElements == 0);

	}

	@Override
	public boolean contains(E element) {

		find(element);

		return found;

	}

	@Override
	public E get(E element) {

		find(element);

		if(!(found))
			return null;
		else
			return location;

	}

	@Override
	public void resetIterator() {

		forwardIterator = head;

	}

	public void resetBackIterator() {

		backwardIterator = tail;

	}

	@Override
	public E getNextItem() {

		item = forwardIterator;

		if(forwardIterator == tail) {

			forwardIterator = head;
		}

		else {

			forwardIterator = forwardIterator.getNext();
		}

		return item;
	}

	public E getPrevItem() {

		item = backwardIterator;

		if(backwardIterator == head) {

			backwardIterator = tail;

		}

		else {

			backwardIterator = backwardIterator.getPrev();
		}

		return item;

	}

	public void find(E element) {

		found = false;
		location = head;

		for(int i = 0; i < numElements; i++) {

			if(location == element) {
				found = true;
				break;
			}

		}
	}

	public void find2(E element) {




	}

	@Override
	public String toString() {

		String output = "";
		E ptr = head;

		if(numElements <= 1)

			output += ptr.getName();

		else
			for(int i = 0; i < numElements; i++) {

				output += ptr.getName() + "\t";
				ptr = ptr.getNext();

		}

		return output;
	}

}
