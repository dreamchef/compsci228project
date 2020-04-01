package apps;

import elements.*;
import interfaces.*;
import adts.*;

public class MoreTestCases {

	public static void main(String[] args) {
		/*
		DLLNode<Candy> candy1 = new DLLNode("Milky Way");

		// System.out.println(candy1);

		DLLNode<Candy> candy2 = new DLLNode("Snickers");

		// DLLNode<Candy> candy3 = new DLLNode("Milky Way");

		Candy candy_ = new Candy("Skittles");

		// System.out.println(candy_);

		Candy candy_1  = new Candy("M&M's");

		Candy candy_2 = new Candy("Twix");

		// System.out.println();

		// System.out.println(candy_2.compareTo(candy_1));

		// Integer i_ = 12;

		/*
		System.out.println(candy1.compareTo(candy3));
		System.out.println(candy1.equals(candy3));
		System.out.println(candy1.equals(candy2));
		 */
		/*
		DLListB<Candy> list = new DLListB<Candy>(false);

		list.add(candy_);
		list.add(candy_1);
		list.add(candy_2);

		// System.out.println();

		System.out.println(list);
		System.out.println(list.size());
		System.out.println();
		//System.out.println(list.getHead());
		//System.out.println(list.getTail());

		DLLNode<Candy> ptr = list.getHead();		// M&M's

		DLLNode<Candy> node = new DLLNode<Candy>(candy_1);		// Skittles
		 */
		// System.out.println(node.compareTo(ptr));		// should be > 0

		// System.out.println(list.getHead());

		/*
		System.out.println();

		// System.out.println(candy_.compareTo(i_));

		DLListB list2 = new DLListB<Integer>(false);

		list2.add(1);
		// list2.add(2);
		// list2.add(3);

		System.out.println();

		System.out.println(list2);

		System.out.println();

		System.out.println(list2.getForwardIterator());

		System.out.println(list2.size());

		Candy skittles = new Candy("Skittles");

		DLListB<Candy> candyList = new DLListB<Candy>(true);

		candyList.add(skittles);

		System.out.println();

		System.out.println(candyList.getTail());

		System.out.println(candyList.size());

		DLLNode<Candy> node = new DLLNode<Candy>(skittles);

		DLLNode<Candy> head = node;

		System.out.println();

		System.out.println(head);

		System.out.println();

		System.out.println(candyList);

		 */

		// String Twix = "Twix";

		// String MMs = "M&M's";

		// System.out.println();

		// System.out.println(("T").compareTo("M"));
		/*
		DLListB<Integer> list2 = new DLListB<Integer>(true);

		Integer i = new Integer(45);
		Integer j = new Integer(123);
		Integer k = new Integer(73);

		list2.add(i);
		list2.add(j);
		list2.add(k);

		System.out.println(list2);
		System.out.println();

		/*
		System.out.println(k.compareTo(j));

		DLLNode<Integer> int1 = new DLLNode<Integer>(i);		//45
		DLLNode<Integer> int2 = new DLLNode<Integer>(j);		//123

		System.out.println();

		System.out.println(int2.compareTo(int1));		// should be +

		/*
		System.out.println();

		DLListB<String> list3 = new DLListB(true);

		list3.add("Twix");
		list3.add("Skittles");
		list3.add("Almond Joy");
		 */

		// System.out.println(list3);

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		DLListB<String> list3 = new DLListB<String>(true);

		String skittles = new String("Skittles");

		list3.add(skittles);
		list3.add("Kit Kat");
		list3.add("Twix");
		list3.add("Almond Joy");
		list3.add("Snickers");
		

		System.out.println(list3);
		
		System.out.println();
		
		DLLNode<String> location;
		// DLLNode<String> node = new DLLNode<String>("head");

		location = list3.getHead();

		for(int m = 0; m < 4; m++) {

			System.out.println("m: " + m);
			location = location.getNext();
			System.out.println("Location: " + location);
			

		}
	}

}
