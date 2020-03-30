package adts;

import interfaces.*;
import elements.*;

public class DLListB<E> implements ListInterface<E> {

	private DLLNode<E> head;
	private DLLNode<E> tail;
	private DLLNode<E> location;
	private DLLNode<E> forwardIterator;
	private DLLNode<E> backwardIterator;
	private DLLNode<E> item;
	private int numElements;
	private boolean found;
	private boolean changed;
	private E [] findArray;
	private boolean useBinarySearch;

	public DLListB(boolean useBinarySearch) {

		numElements = 0;
		head = null;
		tail = null;
		location = null;
		forwardIterator = head;
		backwardIterator = tail;
		changed = false;
		this.useBinarySearch = useBinarySearch;

	}

	@Override
	public void add(E element) {

		DLLNode<E> node = new DLLNode(element);

		if(numElements == 0) {

			node.setPrev(null);
			node.setNext(null);
			head = node;
			tail = node;
			forwardIterator = head;
			backwardIterator = tail;

		}

		else {

			DLLNode<E> ptr = head;

			for(int i = 0; i <= numElements; i++) {

				if(ptr != null) {

					if( (node.compareTo(ptr) <= 0) && (i == 0) )  {

						node.setNext(head);
						node.setPrev(null);
						head.setPrev(node);
						head = node;
						numElements++;
						changed = true;
						forwardIterator = head;
						return;
						// node.getPrev().setNext(node);

					}

					else if ( (node.compareTo(ptr) <= 0) && !(i == 0) && !(i == numElements-1) ) {

						node.setNext(ptr);
						node.setPrev(ptr.getPrev());
						ptr.setPrev(node);
						node.getPrev().setNext(node);
						numElements++;
						changed = true;
						return;

					}

					else
						ptr = ptr.getNext();
				}

				else if(ptr == null) {

					node.setNext(null);
					node.setPrev(tail);
					tail.setNext(node);
					tail = node;
					backwardIterator = node;

				}

			}
		}

		numElements++;
		changed = true;

	}

	/*
			}

			element.setPrev(tail);
			element.setNext(null);
			tail = element;

		}

		numElements++;
		changed = true;

	}
	 */

	@Override
	public boolean remove(E element) {

		find(element);

		if(!(found))

			return false;

		else if(numElements == 1) {

			head = null;
			tail = null;
			backwardIterator = null;
			forwardIterator = null;
			
		}

		else {
			
			if(location == head) {

				location.getNext().setPrev(null);
				head = location.getNext();
				forwardIterator = head;

			}

			else if(location == tail) {

				location.getPrev().setNext(null);
				tail = location.getPrev();
				backwardIterator = tail;

			}

			else {

				location.getPrev().setNext(location.getNext());
				location.getNext().setPrev(location.getPrev());

			}
		}

		changed = true;
		numElements--;

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
			return location.getInfo();

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
		
		
		if(item == null) 
			
			return null;
		
		else

			return item.getInfo();


	}

	public E getPrevItem() {

		item = backwardIterator;

		if(backwardIterator == head) {

			backwardIterator = tail;

		}

		else {

			backwardIterator = backwardIterator.getPrev();
		}

		
		if(item == null) 
			
			return null;
		
		else

			return item.getInfo();

	}

	public DLLNode<E> getBackwardIterator(){
		
		return backwardIterator;
	}
	
	public DLLNode<E> getForwardIterator(){
		
		return forwardIterator;
	}
	
	public void find(E element) {

		if (useBinarySearch) {
			find2(element);
		}

		else {

			DLLNode<E> node = new DLLNode(element);

			found = false;
			location = head;

			for(int i = 0; i < numElements; i++) {

				if (node.compareTo(location) == 0) {
					found = true;
					break;
				}

				location = location.getNext();
			}
		}
	}

	public void find2(E element) { 

		if (changed) {
			populateFindArray();
			changed = false;
		}

		found = false;
		location = head;

		int low = 0;
		int high = numElements - 1;

		DLLNode<E> node = new DLLNode(element);

		// we can use comparison counts as a proxy for execution time
		//int compCount = 0;

		while (high >= low) {

			int mid = (low + high) / 2;
			//compCount++;

			DLLNode<E> midNode = new DLLNode(findArray[mid]);

			if ( node.compareTo(midNode) == 0 ) {

				found = true;
				location = midNode;

				//System.out.println("comparison count: " + compCount);

				return;

			}
			else {

				//compCount++;

				if (node.compareTo(midNode) > 0) {

					low = mid + 1;
				}

				else {

					high = mid - 1;
				}

			}
		}

	}

	public void populateFindArray() {

		if (numElements > 0) {

			DLLNode<E> sortPtr = new DLLNode();
			sortPtr = head;

			findArray = (E[]) new Object[numElements];

			for (int i = 0; i < findArray.length; i++) {

				findArray[i] = sortPtr.getInfo();
				sortPtr = sortPtr.getNext();

			}
		}			
	}


	@Override
	public String toString() {

		String output = "";
		DLLNode<E> ptr = head;

		if(numElements == 0)

			output = null;

		else if(numElements == 1)

			output += ptr;

		else
			for(int i = 0; i < numElements; i++) {

				output += ptr + "\n";

				if(i == numElements - 1)

					ptr = null;

				else

					ptr = ptr.getNext();

			}

		return output;
	}

}
