package excersise1;

public class DoublyLinkedList<E> {
	//---------------- nested Node class ----------------
	  /**
	   * Node of a doubly linked list, which stores a reference to its
	   * element and to both the previous and next node in the list.
	   */
	  private static class Node<E> {

	    /** The element stored at this node */
	    private E element;               // reference to the element stored at this node

	    /** A reference to the preceding node in the list */
	    private Node<E> prev;            // reference to the previous node in the list

	    /** A reference to the subsequent node in the list */
	    private Node<E> next;            // reference to the subsequent node in the list

	    /**
	     * Creates a node with the given element and next node.
	     *
	     * @param e  the element to be stored
	     * @param p  reference to a node that should precede the new node
	     * @param n  reference to a node that should follow the new node
	     */
	    public Node(E e, Node<E> p, Node<E> n) {
	      element = e;
	      prev = p;
	      next = n;
	    }

	    // public accessor methods
	    /**
	     * Returns the element stored at the node.
	     * @return the element stored at the node
	     */
	    public E getElement() { return element; }

	    /**
	     * Returns the node that precedes this one (or null if no such node).
	     * @return the preceding node
	     */
	    public Node<E> getPrev() { return prev; }

	    /**
	     * Returns the node that follows this one (or null if no such node).
	     * @return the following node
	     */
	    public Node<E> getNext() { return next; }

	    // Update methods
	    /**
	     * Sets the node's previous reference to point to Node n.
	     * @param p    the node that should precede this one
	     */
	    public void setPrev(Node<E> p) { prev = p; }

	    /**
	     * Sets the node's next reference to point to Node n.
	     * @param n    the node that should follow this one
	     */
	    public void setNext(Node<E> n) { next = n; }
	    
	  } //----------- end of nested Node class -----------

	  // instance variables of the DoublyLinkedList
	  /** Sentinel node at the beginning of the list */
	  private Node<E> header;                    // header sentinel

	  /** Sentinel node at the end of the list */
	  private Node<E> trailer;                   // trailer sentinel

	  /** Number of elements in the list (not including sentinels) */
	  private int size = 0;                      // number of elements in the list

	  /** Constructs a new empty list. */
	  public DoublyLinkedList() {
	    header = new Node<>(null, null, null);      // create header
	    trailer = new Node<>(null, header, null);   // trailer is preceded by header
	    header.setNext(trailer);                    // header is followed by trailer
	  }

	  // public accessor methods
	  /**
	   * Returns the number of elements in the linked list.
	   * @return number of elements in the linked list
	   */
	  public int size() { return size; }

	  /**
	   * Tests whether the linked list is empty.
	   * @return true if the linked list is empty, false otherwise
	   */
	  public boolean isEmpty() { return size == 0; }

	  /**
	   * Returns (but does not remove) the first element of the list.
	   * @return element at the front of the list (or null if empty)
	   */
	  public E first() {
	    if (isEmpty()) return null;
	    return header.getNext().getElement();   // first element is beyond header
	  }

	  /**
	   * Returns (but does not remove) the last element of the list.
	   * @return element at the end of the list (or null if empty)
	   */
	  public E last() {
	    if (isEmpty()) return null;
	    return trailer.getPrev().getElement();    // last element is before trailer
	  }

	  // public update methods
	  /**
	   * Adds an element to the front of the list.
	   * @param e   the new element to add
	   */
	  public void addFirst(E e) {
	    addBetween(e, header, header.getNext());    // place just after the header
	  }

	  /**
	   * Adds an element to the end of the list.
	   * @param e   the new element to add
	   */
	  public void addLast(E e) {
	    addBetween(e, trailer.getPrev(), trailer);  // place just before the trailer
	  }

	  /**
	   * Removes and returns the first element of the list.
	   * @return the removed element (or null if empty)
	   */
	  public E removeFirst() {
	    if (isEmpty()) return null;                  // nothing to remove
	    return remove(header.getNext());             // first element is beyond header
	  }

	  /**
	   * Removes and returns the last element of the list.
	   * @return the removed element (or null if empty)
	   */
	  public E removeLast() {
	    if (isEmpty()) return null;                  // nothing to remove
	    return remove(trailer.getPrev());            // last element is before trailer
	  }

	  // private update methods
	  /**
	   * Adds an element to the linked list in between the given nodes.
	   * The given predecessor and successor should be neighboring each
	   * other prior to the call.
	   *
	   * @param predecessor   node just before the location where the new element is inserted
	   * @param successor     node just after the location where the new element is inserted
	   */
	  private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
	    // create and link a new node
	    Node<E> newest = new Node<>(e, predecessor, successor);
	    predecessor.setNext(newest);
	    successor.setPrev(newest);
	    size++;
	  }

	  /**
	   * Removes the given node from the list and returns its element.
	   * @param node    the node to be removed (must not be a sentinel, i.e. must be elemented node)
	   */
	  private E remove(Node<E> node) {
	    Node<E> predecessor = node.getPrev();
	    Node<E> successor = node.getNext();
	    predecessor.setNext(successor);
	    successor.setPrev(predecessor);
	    size--;
	    return node.getElement();
	  }

	  /**
	   * Produces a string representation of the contents of the list.
	   * This exists for debugging purposes only.
	   */
	  public String toString() {
	    StringBuilder sb = new StringBuilder("(");
	    Node<E> walk = header.getNext();
	    while (walk != trailer) {
	      sb.append(walk.getElement());
	      walk = walk.getNext();
	      if (walk != trailer)
	        sb.append(", ");
	    }
	    sb.append(")");
	    return sb.toString();
	  }
	  
	  public void concatenate(final DoublyLinkedList<E> other) {
	       final Node trailerL = this.trailer;
	       final Node headerM = other.header;

	       this.trailer.setNext(other.header);
	       other.header.setPrev(this.trailer);

	       this.header.setPrev(other.trailer);
	       other.trailer.setNext(this.header);

	       this.size += 2;

	       this.remove(trailerL);
	       this.remove(headerM);
	   }
	//main method
	  public static void main(String[] args)
	  {
		  
		  //create an empty (i.e. with no elemented nodes) doubly linked list, list1
		  DoublyLinkedList<String> list1 = new DoublyLinkedList<String>();
	      //populate list1 by calling addFirst
		  list1.addFirst("A"); //insert node at first (scenario-1)
		  list1.addFirst("B"); //insert node at first (scenario-2)

		  //create an empty doubly linked list, list2
		  DoublyLinkedList<String> list2 = new DoublyLinkedList<String>();
	      //populate list2 by calling addLast
		  list2.addLast("A");  //insert node at last (scenario-1)
		  list2.addLast("B");  //insert node at last (scenario-2)

		  //create an empty doubly linked list, list3
		  DoublyLinkedList<String> list3 = new DoublyLinkedList<String>();
	      //populate list3
		  list3.addLast("A"); 
	      list3.removeFirst(); //remove first node (scenario-1)

		  //create an empty doubly linked list, list4
		  DoublyLinkedList<String> list4 = new DoublyLinkedList<String>();
	      //populate list4
		  list4.addLast("A"); 
		  list4.addLast("B"); 
	      list4.removeFirst(); //remove first node (scenario-2)

		  //create an empty doubly linked list, list5
		  DoublyLinkedList<String> list5 = new DoublyLinkedList<String>();
	      //populate list3
		  list5.addLast("A"); 
	      list5.removeLast(); //remove last node (scenario-1)

		  //create an empty doubly linked list, list6
		  DoublyLinkedList<String> list6 = new DoublyLinkedList<String>();
	      //populate list4
		  list6.addLast("A"); 
		  list6.addLast("B"); 
	      list6.removeLast(); //remove last node (scenario-2)
	      
	      
	      DoublyLinkedList<String> firstList = new DoublyLinkedList<String>();
	      firstList.addFirst("A");
	      firstList.addLast("B");
	      firstList.addLast("C");
	      firstList.addLast("D");

	      
	 DoublyLinkedList<String> lastList = new DoublyLinkedList<String>();
	 lastList.addFirst("1");
	 lastList.addLast("2");
	 lastList.addLast("3");
	 lastList.addLast("4");

	      
	 firstList.concatenate(lastList);
	      
	 System.out.println(firstList);

	  }
} //----------- end of DoublyLinkedList class -----------






