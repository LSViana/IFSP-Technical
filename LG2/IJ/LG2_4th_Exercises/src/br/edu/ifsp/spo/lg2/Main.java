package br.edu.ifsp.spo.lg2;

import br.edu.ifsp.spo.lg2.deque.Deque;
import br.edu.ifsp.spo.lg2.list.circular.CircularList;
import br.edu.ifsp.spo.lg2.list.doublylinked.DoublyLinkedList;
import br.edu.ifsp.spo.lg2.list.linked.LinkedList;
import br.edu.ifsp.spo.lg2.queue.ArrayQueue;
import br.edu.ifsp.spo.lg2.queue.LinkedQueue;
import br.edu.ifsp.spo.lg2.stack.LinkedStack;
import br.edu.ifsp.spo.lg2.vector.Vector;

public class Main {

    public static void main(String[] args) {
        //testVector();
        //testStack();
        //testLinkedQueue();
        //testArrayQueue();
        //testLinkedList();
        //testDoublyLinkedList();
        //testCircularList();
        //testDeque();
    }

    private static void testDeque() {
        Deque<String> friends = new Deque<>();
        System.out.println(friends.getTextData());
        friends.addStart("Lucas");
        System.out.println(friends.getTextData());
        friends.addStart("Roberto");
        System.out.println(friends.getTextData());
        friends.addEnd("Cecília");
        System.out.println(friends.getTextData());
        System.out.println(friends.first());
        System.out.println(friends.getTextData());
        System.out.println(friends.removeStart());
        System.out.println(friends.getTextData());
        System.out.println(friends.removeStart());
        System.out.println(friends.getTextData());
        System.out.println(friends.removeStart());
        System.out.println(friends.getTextData());
        System.out.println(friends.removeEnd());
        System.out.println(friends.getTextData());
    }

    private static void testArrayQueue() {
        ArrayQueue<String> friends = new ArrayQueue<>(4);
        System.out.println(friends.getTextData());
        friends.enqueue("Lucas");
        System.out.println(friends.getTextData());
        friends.enqueue("Roberto");
        System.out.println(friends.getTextData());
        System.out.println(friends.dequeue());
        System.out.println(friends.getTextData());
        friends.enqueue("Cecília");
        System.out.println(friends.getTextData());
        System.out.println(friends.first());
        System.out.println(friends.getTextData());
        System.out.println(friends.dequeue());
        System.out.println(friends.getTextData());
        System.out.println(friends.dequeue());
        System.out.println(friends.getTextData());
    }

    private static void testCircularList() {
        CircularList<String> friends = new CircularList<>();
        System.out.println(friends.getTextData());
        friends.addStart("Lucas");
        System.out.println(friends.getTextData());
        friends.addStart("Roberto");
        System.out.println(friends.getTextData());
        friends.addEnd("Cecília");
        System.out.println(friends.getTextData());
        friends.add("Rafaela", 2);
        System.out.println(friends.getTextData());
        System.out.println(friends.first());
        System.out.println(friends.getTextData());
        System.out.println(friends.last());
        System.out.println(friends.getTextData());
        System.out.println(friends.removeStart());
        System.out.println(friends.getTextData());
    }

    private static void testDoublyLinkedList() {
        DoublyLinkedList<String> friends = new DoublyLinkedList<>();
        System.out.println(friends.getTextData());
        friends.addStart("Lucas");
        System.out.println(friends.getTextData());
        friends.addStart("Roberto");
        System.out.println(friends.getTextData());
        friends.addEnd("Cecília");
        System.out.println(friends.getTextData());
        friends.add("Rafaela", 1);
        System.out.println(friends.getTextData());
        System.out.println(friends.elementAt(2));
        System.out.println(friends.getTextData());
        System.out.println(friends.removeStart());
        System.out.println(friends.getTextData());
        System.out.println(friends.removeStart());
        System.out.println(friends.getTextData());
        System.out.println(friends.removeStart());
        System.out.println(friends.getTextData());
        System.out.println(friends.removeEnd());
        System.out.println(friends.getTextData());
    }

    private static void testLinkedList() {
        LinkedList<String> friends = new LinkedList<>();
        System.out.println(friends.getTextData());
        friends.addEnd("Lucas");
        System.out.println(friends.getTextData());
        friends.addEnd("Roberto");
        System.out.println(friends.getTextData());
        friends.addEnd("Cecília");
        System.out.println(friends.getTextData());
        friends.add("Rafaela", 0);
        System.out.println(friends.getTextData());
        friends.add("Vitor", 0);
        System.out.println(friends.getTextData());
        System.out.println(friends.removeStart());
        System.out.println(friends.getTextData());
        System.out.println(friends.removeEnd());
        System.out.println(friends.getTextData());
        System.out.println(friends.removeEnd());
        System.out.println(friends.getTextData());
        System.out.println(friends.removeEnd());
        System.out.println(friends.getTextData());
        System.out.println(friends.removeEnd());
        System.out.println(friends.getTextData());

    }

    private static void testLinkedQueue() {
        LinkedQueue<String> friends = new LinkedQueue<>();
        System.out.println(friends.getTextData());
        friends.enqueue("Lucas");
        System.out.println(friends.getTextData());
        friends.enqueue("Roberto");
        System.out.println(friends.getTextData());
        System.out.println(friends.dequeue());
        System.out.println(friends.getTextData());
        friends.enqueue("Cecília");
        System.out.println(friends.getTextData());
        System.out.println(friends.first());
        System.out.println(friends.getTextData());
        System.out.println(friends.dequeue());
        System.out.println(friends.getTextData());
        System.out.println(friends.dequeue());
        System.out.println(friends.getTextData());
    }

    private static void testStack() {
        LinkedStack<String> friends = new LinkedStack<>();
        System.out.println(friends.getTextData());
        friends.push("Lucas");
        System.out.println(friends.getTextData());
        friends.push("Roberto");
        System.out.println(friends.getTextData());
        System.out.println(friends.pop());
        System.out.println(friends.getTextData());
        friends.push("Cecília");
        System.out.println(friends.getTextData());
        System.out.println(friends.pop());
        System.out.println(friends.getTextData());
        System.out.println(friends.pop());
        System.out.println(friends.getTextData());
    }

    private static void testVector() {
        Vector<String> friends = new Vector<>();
        System.out.println(friends.getTextData());
        friends.add("Lucas");
        System.out.println(friends.getTextData());
        friends.add("Roberto");
        System.out.println(friends.getTextData());
        friends.add("Cecília", 0);
        System.out.println(friends.getTextData());
        friends.add("Rafaela", 1);
        System.out.println(friends.getTextData());
        friends.remove(0);
        System.out.println(friends.getTextData());
        friends.remove("Lucas");
        System.out.println(friends.getTextData());
    }
}
