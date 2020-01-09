package collections;

import java.util.HashSet;;

public class Queue<T> {
	
	private int size;
	private static int CAPACITY = 4;
	private int front;
	private int rear;
	Object[] queueArr;
	
	Queue(){
		this(CAPACITY);
	}
	
	Queue(int capacity){
		this.size = capacity;
		queueArr = new Object[capacity];
		size = 0;
		front = 0;
		rear = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public void add(T data) {
		if(size == CAPACITY)
			expand();
		size++;
		queueArr[rear] = data;
		rear = (rear+1)%CAPACITY;
	}
	
	public T remove() {
		if(size==0)
			throw new IllegalStateException();
		size--;
		T data = (T)queueArr[front];
		queueArr[front] = null;
		front = (front+1)%CAPACITY;
		return data;
	}
	
	public void expand() {
		int length = size();
		Object[] newQueue = new Object[length<<1];
		for(int i=0;i<size;i++)
			newQueue[i] = queueArr[(i+front)%CAPACITY]; 
		queueArr = newQueue;
		front = 0;
		rear = size;
		CAPACITY*=2;
	}
	
	public String toString() {
		String result = "";
		for(int i=0;i<size;i++)
			result += queueArr[(front+i)%CAPACITY]+ " ";
		return result;
	}
	
}
