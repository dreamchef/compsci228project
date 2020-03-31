package adts;

import interfaces.*;
import elements.*;

public class DLList<E> implements ListInterface<E> {

	private DLLNode<E> head = null;
	private DLLNode<E> tail = null;
	private DLLNode<E> location = null;
	private DLLNode<E> forwardIterator = head;
	private DLLNode<E> backwardIterator = tail;
	private DLLNode<E> item;
	private int numElements = 0;
	private boolean found;


	@Override
	public void add(E element) {
		
		DLLNode<E> node = new DLLNode(element);
		
		if(numElements == 0) {

			node.setPrev(null);
			node.setNext(null);
			head = node;
			tail = node;

		}

		else {
			
			DLLNode<E> ptr = head;
			
			for(int i = 0; i < numElements; i++) {
				
				if(node.compareTo(ptr) < 0)
				
			}
			
			element.setPrev(tail);
			element.setNext(null);
			tail = element;

		}

		numElements++;
		changed = true;
		
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
		
		return item.getInfo();
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
