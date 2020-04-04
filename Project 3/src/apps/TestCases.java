package apps;

import elements.*;
import interfaces.*;
import adts.*;

public class TestCases {

	public static void main(String[] args) {

		DLListB<String> list = new DLListB<String>(true);

		for(int i = 0; i < 1; i++) {

			list.add("Snickers");

			list.add("Milky Way");

			list.add("Almond Joy");

			list.add("100 Grand");

			list.add("Sour Patch Kids");

		}
		/*
		System.out.println();

		System.out.println(list.getHead());
		 */
		// System.out.println();

		System.out.println(list);


		// list.remove("Snickers");

		// System.out.println(list);

		// System.out.println(list.get("Snickers"));

		// System.out.println(list2);

		String snickers = new String("Snickers");

		long start_time = System.nanoTime();

		list.remove(snickers);

		long end_time = System.nanoTime();

		System.out.println("Time taken using binary search: " + (end_time - start_time));
		// System.out.println("Location: " + list.getLocation());
		// System.out.println("Mid: " + list.getMid());

		System.out.println();

		System.out.println(list);

		System.out.println();

		long start_time2 = System.nanoTime();

		list.remove("Milky Way");

		long end_time2 = System.nanoTime();

		System.out.println("Time taken using binary search: " + (end_time2 - start_time2));
		System.out.println();
		System.out.println(list);

		list.add("3 Musketeers");
		list.add("Jolly Rancher");
		list.add("M&M's");

		System.out.println();

		long start_time3 = System.nanoTime();

		list.remove("Milky Way");

		long end_time3 = System.nanoTime();

		System.out.println("Time taken using binary search: " + (end_time3 - start_time3));
		System.out.println();
		System.out.println(list);

		DLListB<String> list2 = new DLListB<String>(false);

		for(int i = 0; i < 1; i++) {

			list2.add("Snickers");

			list2.add("Milky Way");

			list2.add("Almond Joy");

			list2.add("100 Grand");

			list2.add("Sour Patch Kids");

		}
		
		System.out.println(list2);
		
		long start_time4 = System.nanoTime();

		list2.remove(snickers);

		long end_time4 = System.nanoTime();

		System.out.println("Time taken using linear search: " + (end_time4 - start_time4));
		
		System.out.println();

		System.out.println(list2);

		System.out.println();

		long start_time5 = System.nanoTime();

		list2.remove("Milky Way");

		long end_time5 = System.nanoTime();

		System.out.println("Time taken using linear search: " + (end_time5 - start_time5));
		System.out.println();
		System.out.println(list2);

		list2.add("3 Musketeers");
		list2.add("Jolly Rancher");
		list2.add("M&M's");

		System.out.println();

		long start_time6 = System.nanoTime();

		list2.remove("Milky Way");

		long end_time6 = System.nanoTime();

		System.out.println("Time taken using linear search: " + (end_time6 - start_time6));
		System.out.println();
		System.out.println(list2);



		// System.out.println(list.getHead());

		/*
		DLListB list2 = new DLListB<String>(true);

		for(int i = 0; i < 100; i++) {

		list2.add("Snickers");

		list2.add("Milky Way");

		list2.add("Almond Joy");

		list2.add("100 Grand");

		}

		start_time = System.nanoTime();

		list2.remove("Kit Kat");

		end_time = System.nanoTime();

		System.out.println("Time taken using binary search: " + (end_time - start_time));

		System.out.println(list2.contains("100 Grand"));
		System.out.println(list2.contains("Kit Kat"));

		/*

		DLLNode<String> node = new DLLNode("Milky Way");

		System.out.println(node);

		 */

		// System.out.println(list.getNextItem());

		/* for(int i = 0; i < 100; i++) {

			list.getPrevItem();

		}

		System.out.println(list.getBackwardIterator());

		System.out.println();

		System.out.println(list.getForwardIterator());

		 */

		/*
		for(int i = 0; i < 399; i++) {

		list.getPrevItem();

		}

		System.out.println();
		System.out.println(list.getBackwardIterator());

		// list.resetIterator();

		System.out.println();
		System.out.println(list.getPrevItem());
		System.out.println(list.getPrevItem());

		 */

		// System.out.println(list);

		/*
		DLListB list3 = new DLListB<String>(true);

		System.out.println();

		System.out.println(list3.getForwardIterator());

		System.out.println(list3.getBackwardIterator());

		System.out.println();

		list3.getNextItem();

		System.out.println(list3.getNextItem());
		System.out.println(list3.getPrevItem());

		System.out.println();

		System.out.println(list3.getForwardIterator());
		System.out.println(list3.getBackwardIterator());

		list3.resetBackwardIterator();
		list3.resetIterator();

		System.out.println();

		System.out.println(list3.getNextItem());
		System.out.println(list3.getPrevItem());

		System.out.println(list3.isEmpty());

		System.out.println(list3.size());

		list3.add("Jolly Rancher");
		list3.add("Almond Joy");

		System.out.println(list3.isEmpty());

		System.out.println(list3.size());

		DLListB list4 = new DLListB<String>(true);

		list4.add("3 Musketeers");

		System.out.println();

		System.out.println(list4.getNextItem());

		System.out.println();

		System.out.println(list4.getNextItem());

		System.out.println();

		System.out.println(list4.getPrevItem());

		System.out.println(list4.getPrevItem());

		list4.resetBackwardIterator();

		System.out.println();

		System.out.println(list4.getPrevItem());
		System.out.println(list4.getNextItem());
		System.out.println(list4.getBackwardIterator());
		System.out.println(list4.getForwardIterator());

		list4.resetIterator();

		System.out.println();

		System.out.println(list4.getPrevItem());
		System.out.println(list4.getNextItem());
		System.out.println(list4.getBackwardIterator());
		System.out.println(list4.getForwardIterator());
		 */


	}

}
