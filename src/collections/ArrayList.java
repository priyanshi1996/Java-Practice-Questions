package collections;

public class ArrayList<T> {
	
	private int size;
	private int capacity;
	private static final int MIN_CAPACITY=10;
	Object[] elementData;
	
	public ArrayList(){
		this(MIN_CAPACITY);
	}
	public ArrayList(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		elementData = new Object[capacity];
	}
	
	public void add(T data) {
		if(size == capacity)
			expand();
		elementData[size++] = data;
	}
	
//	public T get(int index) {
//		
//	}
//	
//	public T set(int index, T data) {
//		
//	}
//	
//	public T remove() {
//		
//	}
//	
	public void expand() {
		int length = elementData.length;
		length = length<<1;
		Object[] newArr = new Object[length];
		System.arraycopy(elementData, 0, newArr, 0, length);
		elementData = newArr;
		capacity = capacity<<1;
	}

}
