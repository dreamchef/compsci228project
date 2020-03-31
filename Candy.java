package elements;

public class Candy implements Comparable<Candy> {

	String name;
	double size;
	
	public Candy() {
		name = null;
		size = 0;
		// next = null;
		// prev = null;
	}
	
	public Candy(String name, double size) {
		
		name = this.name;
		size = this.size;
		// next = null;
		// prev = null;
		
	}
	
	public Candy(String name) {
		
		this.name = name;
		size = 1;
		// next = null;
		// prev = null;
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getSize() {
		return this.size;
	}
	
	public void setSize(double size) {
		this.size = size;
	}
	
	/*
	public Candy getNext() {
		return next;
	}
	
	public void setNext(Candy next) {
		this.next = next;
	}
	
	public Candy getPrev() {
		return prev;
	}
	
	public void setPrev(Candy prev) {
		this.prev = prev;
	}
	*/
	
	@Override
	public boolean equals(Object element) {
		
		boolean equals;
		
		if(element instanceof Candy) {
			if (this.name.compareToIgnoreCase(( (Candy) (element) ).getName()) == 0)
				equals = true;
			else
				equals = false;
		}
		
		else
			equals = false;
		
		return equals;
	
	}
	
	@Override
	public int compareTo(Candy element) {
		
		if(this.name.compareToIgnoreCase(element.name) < 0)
			return -1;
		else if(this.name.compareToIgnoreCase(element.name) > 0)
			return 1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	
}
