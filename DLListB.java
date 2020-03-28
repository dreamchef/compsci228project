package adts;

import interfaces.*;
import elements.*;

public class DLListB<E> implements ListInterface<Candy> {

	private DLLNode<E> head = null;
	private DLLNode<E> tail = null;
	private DLLNode<E> location = null;
	private DLLNode<E> forwardIterator = head;
	private DLLNode<E> backwardIterator = tail;
	private DLLNode<E> location;
	private int numElements = 0;
	private boolean found;
	private boolean changed = false; 
	private E[] findArray;
	
	@Override
	public void add(E element) {
		
		DLLNode<E> newNode = new DLLNode<E>(Element);
		
		
		if(numElements == 0) {
			tail = newNode;
			head = newNode;
		}
		else if (element.compareTo(head.getInfo()) < 0) {
			head.setPrev(newNode);
			newNode.setNext(head);
			head = newNode;
		}
		else if (element.compareTo(tail.getInfo() >= 0)){
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
		else {
			DLLNode<E> addPtr = head.getNext();
			while (addPtr.getNext() != null) {
				if (element.compareTo(addPtr.getInfo()) < 0) {
					addPtr.getPrev().setNext(newNode);
					newNode.setPrev(addPtr.getPrev());
					newNode.setNext(addPtr);
					addPtr.setPrev(newNode());
					break;
				}
			}
		}

		numElements++;
		changed = true;
		
	}

	@Override
	public boolean remove(E element) {
		
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
	public boolean contains(E element) {
		
		find2(element);
		
		return found;
		
	}

	@Override
	public E get(E element) {
		
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
	
	public void find2(Candy element) {
		if (changed){
			populateFindArray();
			changed = false;
		}
	}
	
	
	public void populateFindArray(){
		if (numElements > 0){
			DLLNode sortPtr = head;
			findArray = new E[numElements];
			int i = 0;
			for (int i = 0; i < findArray.length; i++){
				findArray[i] = sortPtr.getInfo();
				sortPtr = sortPtr.getNext();
			}
		}			
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
