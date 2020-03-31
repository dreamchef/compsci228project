package elements;

public class DLLNode<E> implements Comparable<DLLNode<E>> {

	private E info;
	private DLLNode<E> next;
	private DLLNode<E> prev;
	private boolean incomparable;

	public DLLNode(E element) {

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


	public boolean getIncomparable() {
		return incomparable;
	}


	public int compareE(E element) {
		if(((Comparable)this.info).compareTo((Comparable)element) < 0)
			return -1;
		else if (((Comparable)this.info).compareTo((Comparable)element) > 0)
			return 1;
		else {
			incomparable = false;
			return 0;
		}
	}

	/*
	public int compareTo2(DLLNode<E> node) {
		if( (node.getInfo() instanceof String) && (this.info instanceof String) ) {
				if( ((String)(this.info)).compareToIgnoreCase((String)(node.getInfo())) < 0)
					return -1;
				else if ( ((String)(this.info)).compareToIgnoreCase((String)(node.getInfo())) > 0)
					return 1;
				else 
					return 0;
			}

		else if(this.info.compareE(node.getInfo()) > 0)
			return 1;

	}
	 */

	@Override
	public int compareTo(DLLNode<E> node) {

		DLLNode<E> thisNode = new DLLNode<E>(this.info);

		// DLLNode<E> node = new DLLNode(element);

		if( ((node.getInfo() instanceof String) && (this.info instanceof String)) || ((node.getInfo() instanceof Integer) && (this.info instanceof Integer)) ) {
			if( (node.getInfo() instanceof String) && (this.info instanceof String) ) {
				if( ((String)(this.info)).compareToIgnoreCase((String)(node.getInfo())) < 0)
					return -1;
				else if ( ((String)(this.info)).compareToIgnoreCase((String)(node.getInfo())) > 0)
					return 1;
				else 
					return 0;
			}

			else  {
				if( ((Integer)(this.info)).compareTo((Integer)(node.getInfo())) < 0)
					return -1;
				else if ( ((Integer)(this.info)).compareTo((Integer)(node.getInfo())) > 0)
					return 1;
				else 
					return 0;
			}
		}

		else if(node.getInfo() instanceof Candy && this.info instanceof Candy) {
			if( ((Candy) (this.info)).compareTo((Candy)(node.getInfo())) > 0)
				return 1;
			else if( ((Candy) (this.info)).compareTo((Candy)(node.getInfo())) < 0)
				return -1;
			else
				return 0;
		}

		else {

			incomparable = true;
			return 0;
		}
	}

	// incomparable = false;

	/*
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
	 */

	@Override
	public String toString() {

		String output = "";

		output += this.info;

		/*
		if(this.info instanceof String)

			output = (String) (this.info);

		else
			output = null;
		 */

		return output;
	}

	@Override
	public boolean equals(Object item) {

		boolean equals;

		DLLNode<E> node = new DLLNode(this.info);

		if(item instanceof DLLNode) {

			if (node.compareTo((DLLNode)(item)) == 0)
				equals = true;
			else
				equals = false;

		}

		else
			equals = false;

		return equals;

	}

}
