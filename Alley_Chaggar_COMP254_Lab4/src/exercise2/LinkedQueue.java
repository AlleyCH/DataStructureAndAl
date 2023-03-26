package exercise2;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import exercise1.LinkedStack;

public class LinkedQueue<E> implements Queue<E> {

	  /** The primary storage for elements of the queue */
	  private LinkedList<E> list = new LinkedList<>();   // an empty  list

	  /** Constructs an initially empty queue. */
	  public LinkedQueue() { }                  // new queue relies on the initially empty list

	  /**
	   * Returns the number of elements in the queue.
	   * @return number of elements in the queue
	   */
	  @Override
	  public int size() { return list.size(); }

	  /**
	   * Tests whether the queue is empty.
	   * @return true if the queue is empty, false otherwise
	   */
	  
	  public boolean isEmpty() { return list.isEmpty(); }

	  /**
	   * Inserts an element at the rear of the queue.
	   * @param element  the element to be inserted
	   */
	  
	  public void enqueue(E element) { list.addLast(element); }

	  /**
	   * Returns, but does not remove, the first element of the queue.
	   * @return the first element of the queue (or null if empty)
	   */
	  
	  public E first() { return list.getFirst(); }

	  /**
	   * Removes and returns the first element of the queue.
	   * @return element removed (or null if empty)
	   */
	  
	  public E dequeue() { return list.removeFirst(); }

	  /** Produces a string representation of the contents of the queue.
	   *  (from front to back). This exists for debugging purposes only.
	   */
	  public String toString() {
	    return list.toString();
	  }
	  
	  
	  public void concatenate(LinkedQueue<E> sourceQ ) {
		  while (!sourceQ.isEmpty()) {
		        enqueue(sourceQ.dequeue());	
	}
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		LinkedQueue<Integer> sourceQ = new LinkedQueue<>();
		LinkedQueue<Integer> targetQ = new LinkedQueue<>();

		    sourceQ.enqueue(1);
		    sourceQ.enqueue(2);
		    sourceQ.enqueue(3);
		    
		    targetQ.enqueue(4);
		    targetQ.enqueue(5);
		    targetQ.enqueue(6);
		    
		    System.out.print("Queue 1: " +sourceQ);
		    System.out.print("Queue 2: " +targetQ);
		    sourceQ.concatenate(targetQ);
		    System.out.print(" Concatenated queue: " + sourceQ);
		
	}
	
	
	
	
	
	
	
	
	
	

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

}
