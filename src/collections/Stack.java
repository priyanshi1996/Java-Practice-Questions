package collections;

import java.util.EmptyStackException;

public class Stack<T> {
	
	private int capacity;
	public static final int CAPACITY = 4;
	public int top = -1;
	Object[] stackArr;
	
	public Stack(){
		this(CAPACITY);
	}
	
	public Stack(int cap) {
		this.capacity = cap;
		stackArr = new Object[capacity];
	}
	
	public boolean isEmpty() {
		return (top<0);
	}
	
	public int size() {
		return top+1;
	}
	
	public T peek() {
		if(top<0)
			throw new EmptyStackException();
		return (T)stackArr[top];
	}
	
	public void push(T data) {
		if(size() == capacity)
			expand();
		stackArr[++top] = data;
		
	}
	
	private void expand() {
		int length = size();
		Object[] newStack = new Object[length<<1];
		System.arraycopy(stackArr, 0, newStack, 0, length);
		stackArr = newStack;
		this.capacity = this.capacity<<1;
	}
	
	public T remove() {
		if(top<0)
			throw new EmptyStackException();
		T topElement = (T) stackArr[top];
		stackArr[top--] = null;
		return topElement;
	}
	
	public String toString() {
		String s = "";
		for(int i=0;i<size();i++) {
			s = s + stackArr[i]+" ";
		}
		return s;
	}
	
}
