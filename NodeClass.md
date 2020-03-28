package elements;

public class Candy {

	String name;
	Candy next;
	Candy prev;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
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
	
	
}
