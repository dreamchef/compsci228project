package adts;

import interfaces.*;
import elements.*;

public class DLListB<E> implements ListInterface<Candy> {

	private DLLNode<E> head;
	private DLLNode<E> tail;
	private DLLNode<E> location;
	private DLLNode<E> forwardIterator;
	private DLLNode<E> backwardIterator;
	private int numElements;
	private boolean found;
	private boolean changed;
	private E[] findArray;
	private boolean useBinarySearch;
	
	public DLLListB<E>(){
		head = null;
		tail = null;
		forwardIterator = head;
		backwardIterator = tail;
		changed = false;
		useBinarySearch = false;
		numElements = 0;
	}
	
	@Override
	public void add(E element) {
		
		DLLNode<E> newNode = new DLLNode<E>(Element);		
		
		//on an empty list, new node becomes head and tail
		if(isEmpty()) {
			tail = newNode;
			head = newNode;
		}
		
		//if element is less than current head, element becomes new head
		else if (element.compareTo(head.getInfo()) < 0) {
			head.setPrev(newNode);
			newNode.setNext(head);
			head = newNode;
		}
		
		//if element is greater than current tail, element becomes new tail
		else if (element.compareTo(tail.getInfo() >= 0)){
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
		
		//if element is in the middle, insert it at the correct place
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
	
	//allows user to switch between find and find2
	public void setBinarySearch(boolean useBinarySearch) {
		this.useBinarySearch = useBinarySearch;
	}

	
	@Override
	public boolean remove(E element) {
		if (isEmpty()) {
			return false;
		}
		
		find(element);
		
		if(!(found))
			return false;
		else {			
			location.getPrev().setNext(location.getNext());
			location.getNext().setPrev(location.getPrev());
			changed = true;
			numElements--;
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
		if (isEmpty()) {
			found = false;
			return found;
		}
		find(element);
		
		return found;
		
	}

	@Override
	public E get(E element) {
		if (isEmpty()) {
			return null;
		}
		find(element);
		
		if(!(found))
			return null;
		else
			return location.getInfo();
		
	}

	@Override
	public void resetIterator() {
		if (!isEmpty()) {
			forwardIterator = head;
		}
	}
	
	public void resetBackwardIterator() {
		if (!isEmpty()) {
			backwardIterator = tail;
		}
	}

	@Override
	public E getNextItem() {
		if (isEmpty()) {
			return null;
		}
		item = forwardIterator.getInfo();
		
		if(forwardIterator == tail) {			
			forwardIterator = head;
		}
			
		else {			
			forwardIterator = forwardIterator.getNext();
		}
		
		return item;
		
		
	}
	
	public E getPrevItem() {
		if (isEmpty()) {
			return null;
		}
		item = backwardIterator.getInfo();
		
		if(backwardIterator == head) {
			
			backwardIterator = tail;
			
		}
		
		else {
			
			backwardIterator = backwardIterator.getPrev();
		}
		
		return item;

	}
	public void find(E element) {
		if (useBinarySearch) {
			find2(element);
		}
		else {
			found = false;
			location = head;

			while (location.getNext() != null) {
				if (location.getInfo().compareTo(element) == 0) {
					found = true;
					break;
				}
				location = location.getNext();
			}
		}
	}
	
	
	//find2 needs to be completed
	public void find2(E element) { 
		if (changed){
			populateFindArray();
			changed = false;
		}
		
	}
	
	
	public void populateFindArray(){
		if (numElements > 0){
			DLLNode sortPtr = head;
			findArray = new E[numElements];
			for (int i = 0; i < findArray.length; i++){
				findArray[i] = sortPtr.getInfo();
				sortPtr = sortPtr.getNext();
			}
		}			
	}
	
	@Override
	public String toString() {
		if (numElements == 0) {
			return "empty list";
		}
		
		String output = "";
		DLLNode<E> stringPtr = head;
		
		if (numElements == 1)
		
			output = output + stringPtr.getInfo();
		
		else {
			for(int i = 0; i < numElements; i++) {
				
				output += stringPtr.getInfo() + "\t";
				ptr = stringPtr.getNext();
				
			}
		}
		
		return output;
	}
}
