package exercise1;

import java.lang.StackWalker.StackFrame;
import java.util.LinkedList;
//Java program to add the
//elements in the stack
import java.io.*;
import java.util.*;
/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * Realization of a stack as an adaptation of a SinglyLinkedList.
 * All operations are performed in constant time.
 * Adapter Pattern
 * The adapter design pattern applies to any context where we effectively want to
 * modify an existing class so that its methods match those of a related, but different,
 * class or interface. One general way to apply the adapter pattern is to define a new
 * class in such a way that it contains an instance of the existing class as a hidden
 * field, and then to implement each method of the new class using methods of this
 * hidden instance variable. By applying the adapter pattern in this way, we have
 * created a new class that performs some of the same functions as an existing class,
 * but repackaged in a more convenient way.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @see SinglyLinkedList
 */
public class LinkedStack<E> implements StackFrame {

  /** The primary storage for elements of the stack */
  private LinkedList<E> list = new LinkedList<>();   // an empty list

  /** Constructs an initially empty stack. */
  public LinkedStack() { }                   // new stack relies on the initially empty list

  /**
   * Returns the number of elements in the stack.
   * @return number of elements in the stack
   */
  public int size() { return list.size(); }

  /**
   * Tests whether the stack is empty.
   * @return true if the stack is empty, false otherwise
   */
  public boolean isEmpty() { return list.isEmpty(); }

  /**
   * Inserts an element at the top of the stack.
   * @param element   the element to be inserted
   */
  public void push(E element) { list.addFirst(element); }

  /**
   * Returns, but does not remove, the element at the top of the stack.
   * @return top element in the stack (or null if empty)
   */
  public E top() { return list.getFirst(); }

  /**
   * Removes and returns the top element from the stack.
   * @return element removed (or null if empty)
   */
  public E pop() { return list.removeFirst(); }

  /** Produces a string representation of the contents of the stack.
   *  (ordered from top to bottom)
   *
   * This exists for debugging purposes only.
   *
   * @return textual representation of the stack
   */
  public String toString() {
    return list.toString();
  }
  
  public void transfer(LinkedStack<E> targetS) {
	  while (!isEmpty()) {
	        targetS.push(pop());
	    }
  }
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 LinkedStack<Integer> sourceS = new LinkedStack<>();
		    LinkedStack<Integer> targetS = new LinkedStack<>();

		    sourceS.push(1);
		    sourceS.push(2);
		    sourceS.push(3);
		    System.out.print(sourceS);
		    sourceS.transfer(targetS);
		    System.out.print(" Added to second stack in start goes to the end" + sourceS);
		    System.out.print(targetS);
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMethodName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getDeclaringClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getByteCodeIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLineNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isNativeMethod() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StackTraceElement toStackTraceElement() {
		// TODO Auto-generated method stub
		return null;
	}
  
  
}

