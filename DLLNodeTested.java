package elements;

public class DLLNode<E> {

	private E info;
	private DLLNode<E> next;
	private DLLNode<E> prev;
	private boolean incomparable;

	public DLLNode (E element) {

		this.info = element;
		this.next = null;
		this.prev = null;
		this.incomparable = false;

	}
	
	public DLLNode() {
		this.info = null;
		this.next = null;
		this.prev = null;
		this.incomparable = false;
		
	}

	public E getInfo() {
		return info;
	}

	public void setInfo(E info) {
		this.info = info;
	}

	public DLLNode<E> getNext() {
		return next;
	}

	public void setNext(DLLNode<E> next) {
		this.next = next;
	}

	public DLLNode<E> getPrev() {
		return prev;
	}

	public void setPrev(DLLNode<E> prev) {
		this.prev = prev;
	}

	
	public int compareTo(DLLNode<E> element) {

		incomparable = false;

		if( (element.getInfo() instanceof String) || (element.getInfo() instanceof Integer) ) {
			if( (element.getInfo() instanceof String) && (info instanceof String) ) {
				if( ((String)(this.info)).compareToIgnoreCase((String)(element.getInfo())) < 0)
					return -1;
				else if ( ((String)(this.info)).compareToIgnoreCase((String)(element.getInfo())) > 0)
					return 1;
				else 
					return 0;
			}

			else {
				if( ((Integer)(this.info)).compareTo((Integer)(element.getInfo())) < 0)
					return -1;
				else if ( ((Integer)(this.info)).compareTo((Integer)(element.getInfo())) > 0)
					return 1;
				else 
					return 0;
			}
		}

		else {
			incomparable = true;
			return 0;
		}


	}
	
	@Override
	public String toString() {
		
		String output;
		
		if(this.info instanceof String)
		
			output = (String) (this.info);
		
		else
			output = null;
		
		return output;
	}

	/*

	@Override
	public boolean equals(Object element) {

		boolean equals;

		if(element instanceof Object) {
			if (this.name.compareToIgnoreCase(( (Candy) (element) ).getName()) == 0)
				equals = true;
			else
				equals = false;
		}

		else
			equals = false;

		return equals;

	}

	 */


}
