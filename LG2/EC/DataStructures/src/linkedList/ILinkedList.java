package linkedList;

import java.util.List;

public interface ILinkedList<X> {
	public ILinkedList<X> union(ILinkedList<X> second);
	public X first();
	public X last();
	public X addStart(X value);
	public X addEnd(X value);
	public X removeFirst();
	public X removeLast();
	public X get(long position);
	public X add(X value);
	public X add(X value, long position);
	public X[] addRange(X[] values);
	public X[] addRange(X[] values, long startPosition);
	public X remove(X value);
	public X remove(long position);
	public boolean isEmpty();
	public long size();
	public List<X> toList();
	public X[] toArray();
}
