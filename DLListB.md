package adts;

import interfaces.*;
import elements.*;

public class DLListB<E> implements ListInterface<Candy> {

	private static Candy head = null;
	private static Candy tail = null;
	private static Candy location = null;
	private static Candy forwardIterator = head;
	private static Candy backwardIterator = tail;
	private static Candy item;
	private static int numElements = 0;
	private static boolean found;
	private static boolean changed = false;
	
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
		changed = true;
		
	}

	@Override
	public boolean remove(Candy element) {
		
		find2(element);
		
		if(!(found))
			return false;
		else {
			
			location.getPrev().setNext(location.getNext());
			location.getNext().setPrev(location.getPrev());
			changed = true;
		
			return true;
		}
		
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
		
		find2(element);
		
		return found;
		
	}

	@Override
	public Candy get(Candy element) {
		
		find2(element);
		
		if(!(found))
			return null;
		else
			return location;
		
	}

	@Override
	public void resetIterator() {
		
		forwardIterator = head;
		
	}
	
	public void resetBackwardIterator() {
		
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
	
	public void find2(Candy element) {
		
	}
	
	@Override
	public String toString() {
		
		String output = "";
		Candy ptr = head;
		
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
