package aula3;

import java.util.ArrayList;
import java.util.LinkedList;

public class TesteArrayListVersusLinkedList {

	public static void main(String[] args) {
		
		ArrayList arrayList = new ArrayList();
		LinkedList linkedList = new LinkedList();
		
		System.out.println("-----------------------------------------");
		
		// ArrayList add
		long startTime = System.nanoTime();

		for (int i = 0; i < 100000; i++) {
			arrayList.add(i);
		}
		
		long endTime = System.nanoTime();
		
		long duration = endTime - startTime;
		System.out.println("ArrayList add:  " + duration + "\n");

		// LinkedList add
		startTime = System.nanoTime();

		for (int i = 0; i < 100000; i++) {
			linkedList.add(i);
		}
		
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList add: " + duration);
		
		System.out.println("-----------------------------------------");

		// ArrayList get
		startTime = System.nanoTime();

		for (int i = 0; i < 10000; i++) {
			arrayList.get(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList get:  " + duration + "\n");

		// LinkedList get
		startTime = System.nanoTime();

		for (int i = 0; i < 10000; i++) {
			linkedList.get(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList get: " + duration);
		
		System.out.println("-----------------------------------------");

		// ArrayList remove
		startTime = System.nanoTime();

		for (int i = 9999; i >= 0; i--) {
			arrayList.remove(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList remove:  " + duration+ "\n");

		// LinkedList remove
		startTime = System.nanoTime();

		for (int i = 9999; i >= 0; i--) {
			linkedList.remove(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList remove: " + duration);
		
		System.out.println("-----------------------------------------");

	}

}
