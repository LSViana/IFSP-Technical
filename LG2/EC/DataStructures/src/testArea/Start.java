package testArea;

import linkedList.ILinkedList;
import linkedList.LinkedList;

public class Start {
	
	public static void main(String[] args) {
		testLinkedList();
	}

	private static void testLinkedList() {
		LinkedList<String> l1 = new LinkedList<>();
		String lucas = "Lucas";
		String cecilia = "Cecília";
		String roberto = "Roberto";
		String rafaela = "Rafaela";
		//
		l1.showElements();
		l1.addStart(lucas);
		l1.showElements();
		l1.addEnd(cecilia);
		l1.showElements();
		l1.add(rafaela);
		l1.showElements();
		l1.add(roberto, 2);
		l1.showElements();
		System.out.println(l1.get(3));
		System.out.println(l1.first());
		System.out.println(l1.last());
		l1.removeFirst();
		l1.showElements();
		l1.removeLast();
		l1.showElements();
		LinkedList<String> l2 = new LinkedList<>();
		l2.add(rafaela);
		LinkedList<String> united = (LinkedList<String>) l1.union(l2);
		united.showElements();
		l2.add(lucas);
		l2.showElements();
		l2.remove(lucas);
		l2.showElements();
		l1.showElements();
		l1.remove(0);
		l1.showElements();
	}
}
