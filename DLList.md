package adts;

import interfaces.*;
import elements.*;

public class DLList implements ListInterface<Candy> {

	private Candy head = null;
	private Candy tail = null;
	private Candy location = null;
	private Candy forwardIterator = head;
	private Candy backwardIterator = tail;
	private Candy item;
	private int numElements = 0;
	private boolean found;
	private boolean changed = false;
	private E[] findArray = new E[];

	@Override
	public void add(Candy element) {

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
	public boolean remove(Candy element) {

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
	public boolean contains(Candy element) {

		find(element);

		return found;

	}

	@Override
	public Candy get(Candy element) {

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
	public Candy getNextItem() {

		item = forwardIterator;

		if(forwardIterator == tail) {

			forwardIterator = head;
		}

		else {

			forwardIterator = forwardIterator.getNext();
		}

		return item;
	}

	public Candy getPrevItem() {

		item = backwardIterator;

		if(backwardIterator == head) {

			backwardIterator = tail;

		}

		else {

			backwardIterator = backwardIterator.getPrev();
		}

		return item;

	}

	public void find(Candy element) {

		found = false;
		location = head;

		for(int i = 0; i < numElements; i++) {

			if(location.equals(element)) {
				found = true;
				break;
			}

		}
	}

	public void find2(Candy element) {




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
