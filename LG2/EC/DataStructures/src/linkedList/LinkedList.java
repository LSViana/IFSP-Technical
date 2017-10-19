package linkedList;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<X> implements ILinkedList<X> {

	private Node<X> head;
	private Node<X> tail;
	private long size;

	public LinkedList() {
		// Standard constructor
	}

	private class Node<X> {
		X value;
		Node<X> next;

		public Node(X value, Node<X> next) {
			this.value = value;
			this.next = next;
		}

		public X getValue() {
			return value;
		}

		public void setValue(X value) {
			this.value = value;
		}

		public Node<X> getNext() {
			return next;
		}

		public void setNext(Node<X> next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return String.format("[Node: Value = %s, Next = %s]", value.toString(), getNext());
		}
	}

	@Override
	public ILinkedList<X> union(ILinkedList<X> second) {
		LinkedList<X> _second = (LinkedList<X>) second;
		LinkedList<X> result = new LinkedList<>();
		result.add(first());
		result.tail.setNext(_second.head);
		result.tail = _second.tail;
		return result;
	}

	@Override
	public X addStart(X value) {
		Node<X> node = new Node<X>(value, head);
		if (isEmpty()) {
			head = node;
			tail = node;
		}
		size++;
		return value;
	}

	@Override
	public X addEnd(X value) {
		Node<X> node = new Node<X>(value, null);
		if (isEmpty())
			head = node;
		else
			tail.setNext(node);
		tail = node;
		size++;
		return value;
	}

	@Override
	public X removeFirst() {
		if (isEmpty())
			throw new RuntimeException("The list is empty.");
		Node<X> node = head;
		head = head.getNext();
		size--;
		return node.getValue();
	}

	@Override
	public X removeLast() {
		if (isEmpty())
			throw new RuntimeException("The list is empty.");
		Node<X> current = head;
		while (current.getNext() != tail) {
			current = current.getNext();
		}
		tail = current;
		X value = current.getNext().getValue();
		current.setNext(null);
		size--;
		return value;
	}
	
	@Override
	public X get(long position) {
		verifyPosition(position);
		Node<X> node = head;
		for (int i = 0; i < position; i++) {
			node = node.getNext();
		}
		return node.getValue(); 
	}

	@Override
	public X add(X value) {
		Node<X> node = new Node<X>(value, null);
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
		}
		tail = node;
		size++;
		return value;
	}

	@Override
	public X add(X value, long position) {
		verifyPosition(position);
		Node<X> node = new Node<X>(value, null);
		if(position == 0) {
			node.setNext(head);
			head = node;
			return value;
		}
		Node<X> searched = head;
		for (long i = 0; i < position - 1; i++) {
			searched = searched.getNext();
		}
		node.setNext(searched.getNext());
		searched.setNext(node);
		size++;
		return value;
	}

	@Override
	public X[] addRange(X[] values) {
		for (X x : values) {
			add(x);
		}
		return values;
	}

	@Override
	public X[] addRange(X[] values, long startPosition) {
		verifyPosition(startPosition);
		for (long i = 0; i < startPosition; i++) {
			add(values[(int) i], i + size);
		}
		return values;
	}

	@Override
	public X remove(X value) {
		Node<X> previous = null;
		Node<X> node = head;
		while(node.getValue() != value) {
			previous = node;
			node = node.getNext();
			//
			if(node == null)
				throw new RuntimeException("The supplied item was not found at the list");
		}
		if(previous == null) {
			head = node.getNext();
		}
		else {
			previous.setNext(node.getNext());
		}
		if(head == null) {
			tail = null;
		}
		return node.getValue();
	}

	@Override
	public X remove(long position) {
		verifyPosition(position);
		Node<X> previous = null;
		Node<X> node = head;
		for (int i = 0; i < position; i++) {
			previous = node;
			node = node.getNext();
			//
			if(node == null)
				throw new RuntimeException(String.format("Invalid position to access: %d", position));
		}
		if(previous == null) {
			head = node.getNext();
		}
		else {
			previous.setNext(node.getNext());
		}
		if(head == null) {
			tail = null;
		}
		size--;
		return node.getValue();
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public long size() {
		return size;
	}

	@Override
	public List<X> toList() {
		List<X> result = new ArrayList<X>();
		Node<X> node = head;
		while (node.getNext() != null) {
			result.add(node.getValue());
			node = node.getNext();
		}
		return result;
	}

	@Override
	public X[] toArray() {
		X[] result = (X[]) new Object[(int) size];
		Node<X> node = head;
		for (int i = 0; i < size; i++) {
			result[i] = node.getValue();
			node = node.getNext();
		}
		return result;
	}

	@Override
	public X first() {
		return head.getValue();
	}

	@Override
	public X last() {
		return tail.getValue();
	}

	// Additional implementations
	public void showElements() {
		// Node<X> current = head;
		// System.out.print("{ ");
		// while(current != null) {
		// System.out.print(current.getValue());
		// current = current.getNext();
		// if(current != null)
		// System.out.print(", ");
		// }
		// System.out.println(" }");
		System.out.println(head);
	}

	private void verifyPosition(long position) {
		if (position > size || position < 0)
			throw new RuntimeException(String.format("Invalid position to access: %d", position));
	}
	
}